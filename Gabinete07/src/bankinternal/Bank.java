//package declaration
package bankinternal;

// import statement
import java.util.ArrayList;

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
public class Bank {
	// attribute(s)
	private ArrayList<Client> clientList;			// keep a list of all client accounts, regardless of type
	private static int numberOfAccounts;			// counter for the number of accounts a bank contains

	// constructor
	public Bank(){
		clientList = new ArrayList<Client>();
	}

	// method(s)

	// method to instantiate a StoreClient object
	// returns the name of the created store
	public String createStoreClient(String storeName, int storeBalance) {

		BankAccount account = new BankAccount(storeName, ++Bank.numberOfAccounts, storeBalance, this);
		StoreClient store = new StoreClient(this, account, storeName);
		clientList.add(store); 		// add the newly created store to the list of bank's clients

		return storeName;
	}

	// method to instantiate a SupplierClient object
	public void createSupplierClient(String supplierName, int supplierBalance, String storeName) {

		BankAccount account = new BankAccount(supplierName, ++Bank.numberOfAccounts, supplierBalance, this);
		SupplierClient supplier = new SupplierClient(this, account, supplierName, storeName);
		clientList.add(supplier);
	}

	// getter for the size of the array clientList
	public int getNumberofClients() {
		return this.clientList.size();
	}

	// getter for the private attribute clientList
	public ArrayList<Client> getClientThreads() {
		return clientList;
	}

	// method to find a client in the list of bank's clients
	Client findClient(String name) {
		for (Client c: clientList) {
			if (c.getClientName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	// method to process deposit
	public void processDeposit(StoreClient store, int amountToDeposit) {
		/****
		 * TO DO:
		 * process deposit
		 */
		store.account.deposit(amountToDeposit);
	}

	// method to process withdraw
	public void processWithdraw(StoreClient store, int amountToWithdraw) {
		/****
		 * TO DO:
		 * process withdraw request
		 */
		store.account.withdraw(amountToWithdraw);
	}

	// supplier client will request payment from the store client
	public void requestPayment(SupplierClient supplier, int amountToPay, String storeName) {
		/****
		 * TO DO:
		 * process request of supplier for payment from store
		 */
		Client storeClient = this.findClient(storeName);

		if (storeClient.account.getEndOfCycle() == false) {
			System.out.println(supplier.getClientName() + " is requesting payment from " + storeName);

			if (storeClient.account.pay(amountToPay, supplier)) {
				System.out.println("Payment completed: " + amountToPay + " from " + storeName + " to " + supplier.getClientName());
			} else {
				System.out.println("Waiting, will try paying: " + amountToPay + " from " + storeName + " to " + supplier.getClientName() + "; Has only " + storeClient.getBalance());
			}
		}
	}

	public void completePayment(int amountToPay, SupplierClient supplier) {
		/****
		 * TO DO:
		 * this is called from BankAccount class, remit money to supplier
		 */
		supplier.account.remit(amountToPay);
	}

	public void printBalance() {

		/****
		 * TO DO:
		 * Display all account balance
		 */
		System.out.println("============================");
		System.out.println("Bank account information:\n");
		// loop through the elements of the clientList
		for (Client client : clientList) {
			client.printBalance();
		}
		System.out.println("============================");
	}

//	Will need this method to do the bonus
	public void endCycle() {
		for (Client c : clientList) {
			c.getAccount().notifyThreads();
		}
	}
}
