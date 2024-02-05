/*************************************************************************************************************************
 * CMSC 22: Introduction to Object-Oriented Programming
 * Laboratory exercise (Multithreading)
 * Topic: Concurrency
 *
 * This program simulates a bank account (being accessed by multiple people at the same time)
 *
 * A bank has store and supplier clients with their respective bank accounts. These bank accounts are used to store money,
 * collect, and pay.  Both bank accounts have an initial balance of P3,000.
 *
 * 		>> The store client goes through a deposit-withdraw cycle where P350 is (randomly) deposited and withdrawn
 *  	>> (50 times, with a sleep interval of 100 ms).
 *
 *  	>> Concurrently, the supplier requests two payments of P1800 each from store (the two payment requests of supplier
 *  	>> are made 3 seconds apart)
 *
 * It is the bank that processes bank deposits/withdrawals and payment requests. A withdrawal fails when there is not enough
 * money in the store’s account. When the supplier requests payment and there is not enough money in the store’s account,
 * payment fails (no further withdrawals can be done since there is a pending payment). At the end of the application, the
 * amount of money available in each of the accounts should be displayed.
 *
 * Bonus: Ability of the supplier to wait until the store client’s account has sufficient balance to cover the payment.
 *
 * (c) Institute of Computer Science, CAS, UPLB
 *
 * @author Keith Ginoel S. Gabinete
 * @date 2023-04-28 23:26
 *
 *************************************************************************************************************************/
// package declaration
package main;

// import statement(s)
import bankinternal.Bank;

import bankinternal.Client;

// class definition
public class Main {
	// start of the main program
	public static void main(String[] args){

		Bank bank = new Bank();

		String storeName = bank.createStoreClient("Store #1", 3000);
		bank.createSupplierClient("Supplier #1", 3000, storeName);


		/****
		 * TO DO:
		 * Get bank threads; start each thread
		 */
		for (Client client : bank.getClientThreads()) {
			client.start();
		}

		/****
		 * TO DO:
		 * Make sure all threads have finished before printing bank accounts' balance
		 */
		try {
			for (Client client : bank.getClientThreads()) {
				client.join();
			}
		} catch (InterruptedException e) {}



		bank.printBalance();

	}
}
