// package declaration
package bankinternal;

// import statement
import java.util.Random;

/*************************************************************************************************************************
 *
 * CMSC 22 Object-Oriented Programming
 * Multithreading exercise
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 *
 *************************************************************************************************************************/
// class definition
public class StoreClient extends Client {
	// attribute(s)
	private int bankDepositAmount = 350;
	private int bankWithdrawAmount = 350;

	public static final int CYCLE_COUNT = 50;

	// constructor
	StoreClient(Bank b, BankAccount account, String name){
		this.bank = b;
		this.account = account;
		this.name = name;
	}

	public void run(){
		/**
		 * TO DO
		 * deposit-withdraw cycle
		 * Do this 50 times:
		 * get a random number (0 or 1);
		 * -if 0, request for deposit of money; use variable this.bankDepositAmount
		 * -if 1, request to process withdrawal; use variable this.bankWithdrawAmount
		 * put interval (or sleep) of 100 ms
		 *
		 * Bonus:
		 * Do you need to do anything at the end of the cycle? What if there are pending
		 * payments, do you need to notify waiting threads?  Hint: You need to send notification
		 * via bank and through bank account.
		 *
		 */
		Random r = new Random();

		for (int i=0; i<StoreClient.CYCLE_COUNT; i++) {
			int randNum = r.nextInt(2);
			if (randNum == 0) {
				this.bank.processDeposit(this, this.bankDepositAmount);
			} else if (randNum == 1) {
				this.bank.processWithdraw(this, this.bankWithdrawAmount);
			}
//			System.out.println("Balance: " + this.account.getBalance()); // to check if the program's working the way we intended to
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}

		System.out.println("\nStore account's deposit-withdraw cycle has ended.\n");
		this.account.setEndOfCycle(true);
		this.bank.endCycle();
	}

}

