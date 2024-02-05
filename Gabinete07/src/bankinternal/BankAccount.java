// package declaration
package bankinternal;

/*************************************************************************************************************************
 *
 * CMSC 22 Object-Oriented Programming
 * Multithreading exercise
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 *
 *************************************************************************************************************************/

/**
 * TO DO:
 * - Check relevant methods and see which will need the 'synchronized' keyword;
 *
 * - (bonus): which method will need to notify threads?
 */

// class definition
class BankAccount {
	// attribute(s)
	private int balance;
	private int accountNum;
	private String name;
	private Bank bank;

	private boolean hasPending = false;	// to prevent withdrawing when there's pending payment
	private boolean endOfCycle = false; // bonus: to prevent supplier thread from waiting when store is finished with its cycle

	// constructor
	BankAccount(String name, int accountNum, int balance, Bank b){
		this.name = name;
		this.accountNum = accountNum;
		this.balance = balance;
		System.out.println(this.name + " Initial bank account balance: " + this.balance);
		this.bank = b;
	}

	// method(s)
	// getter(s) and setter(s)
	// getter for this account's balance attribute
	int getBalance(){
		return this.balance;
	}

	// setter this bank account's endOfCycle attribute
	public void setEndOfCycle(boolean bool) {
		this.endOfCycle = bool;
	}

	// getter this bank account's endOfCycle attribute
	public boolean getEndOfCycle() {
		return this.endOfCycle;
	}

	// getter for this bank account's accountNum attribute
	public int getAccountNum () {
		return accountNum;
	}

	// getter for this bank account's bank attribute
	public Bank getBank() {
		return bank;
	}

	// other method(s)
	// method to withdraw money from a bank account
	// need to lock this method to prevent two or more accounts from altering this bank account's balance at the same time
	synchronized boolean withdraw(int amount){
		/**
		 * TO DO:
		 * Withdraw:
		 * Check first if there is sufficient amount
		 * If there is sufficient amount, make sure there is no pending payment to make
		 */
		if (this.getBalance() >= amount) {
			if (this.hasPending) {
				System.out.println("Cannot withdraw from " + this.name + ", has pending payment.");
				return false;
			} else {
				this.balance-=amount;
				System.out.println(amount + " withdrawn from " + this.name);
				return true;
			}

		} else {
			System.out.println("Cannot withdraw from " + this.name + ", insufficient balance.");
			return false;
		}
	}

	// need to lock this method to prevent two or more accounts from altering this bank account's balance at the same time
	synchronized boolean pay(int amountToPay, SupplierClient supplier) {

		/**
		 * TO DO:
		 *
		 * Check first if there is sufficient balance to pay
		 * If insufficient amount
		 * - change pending indicator to true and print necessary message
		 *
		 * - (bonus) make the thread wait
		 * - (bonus) You will need a while loop here that checks until balance is sufficient to pay
		 */
		while (this.getBalance() < amountToPay) {
			System.out.println("Waiting, will try paying: " + amountToPay + " from " + this.name + " to " + supplier.getClientName() + "; Has only " + this.getBalance());
			this.hasPending = true;
			// invoke the wait method from the Object class
			try {
				this.wait();
			} catch (Exception e) {}

			if (this.endOfCycle) {
				return false;
			}
			// when this thread resumes and the current balance is already greater than or equal to the amount needed to be paid, inform the user that payment will be allowed then
			if (this.getBalance() >= amountToPay) {
				System.out.println("Payment allowed: " + amountToPay + " from " + this.name + " to " + supplier.getClientName() + "; Now has " + this.getBalance());
			}
		}

		if (this.getBalance() >= amountToPay) {
//			System.out.println("Payment allowed: " + amountToPay + " from " + this.name + " to " + supplier.getClientName() + "; Now has " + this.getBalance());
			this.balance-=amountToPay; 										// decrement this bank account's balance
			System.out.println(amountToPay + " paid from " + this.name);
			supplier.bank.completePayment(amountToPay, supplier);			// transfer the money decremented from this bank account's balance to another bank account
			this.hasPending = false;
			return true;
		} else {
			this.hasPending = true; // this bank account has pending payment
			return false;
		}
	}

	// method to deposit money to the bank
	// need to lock this method to prevent two or more accounts from altering this bank account's balance at the same time
	synchronized void deposit(int amount){
		this.balance+=amount; 	// increment this bank account's balance
		System.out.println(amount + " deposited to " + this.name);
		try {
			notify(); // notify a thread that is waiting whenever the deposit function is being called
		} catch (Exception e) {}
	}

	// method to remit/deposit money to someone's bank account
	// need to lock this method to prevent two or more accounts from altering this bank account's balance at the same time
	synchronized void remit(int amount){
		this.balance+=amount;
		System.out.println(amount + " remitted to " + this.name);
	}

	// method to print the current balance of the currently selected bank account
	void printBalance(){
		System.out.println(this.name + " has " + this.getBalance());
	}

	// notify all waiting threads
	public void notifyThreads() {
		if (this.endOfCycle) {
			try {
				notifyAll();
			} catch (Exception e) {}
		}
	}

}
