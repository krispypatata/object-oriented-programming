/******************************************************************************************************
 * This a simple program that stores and manages books in a library
 * Here, you can:
 * (1) print all the books in "My Personal Library"
 * (2) perform a keyword search on each book title of the library
 * (3) replace a book title in the library
 *
 * @author Keith Ginoel Gabinete
 * @created_date 2023-03-11 12:28
 *
 ******************************************************************************************************/
package mypackage;

import java.util.Scanner;

public class Gabinete_Exer2 {
	// start of the main program
	public static void main(String[] args) {

		int choice = -1;	// will store the user's choice from the given options in our main menu

		// declare scanner variables that will be used later to get inputs from the user
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);

		// declaration and initialization of the string array named "books"
		String[] books	 = {
				"Sherlock Holmes",
				"The Fault in our Stars",
				"Stay where you are and then leave",
				"Pride and Prejudice",
				"The Fellowship of the Ring"
				// uncomment the string below for testing (to check if the program still works properly even with an addition of a new element in the string array)
				//,"Harry Potter and the Chamber of Secrets"
		};

		// Loop our program until the users chooses to terminate it (by entering 0 as an input)
		do {
			//display the main Menu
			// only show it after a successful run of an operation choice in the menu
			if (choice==-1) {
				displayMenu();
			}

			// performing some error handling exceptions
			try {
				choice = scan1.nextInt();

				// create a switch statement to execute certain actions that correspond to the given options in our menu
				switch (choice) {
					case 1:
						// if the user enters 1 as an input then print the contents of the string array named "books"
						Gabinete_Exer2.printBooks(books);
						choice = -1;
						break;

					case 2:
						// if the user enters 2 as an input then search for a keyword (entered by the user) in the books list
						// inform the user if the keyword entered by him/her matches one of the words in a books list item

						String keyword;	// will hold the keyword (string input) entered by the user

						// ask the user for a keyword input
						// loop it until the user finally enters a one word input
						// 2 or more word inputs isn't allowed
						// empty input isn't allowed
						System.out.println("\n>> Enter 1 keyword to search");
						do {
							keyword = scan2.nextLine();

							// inform the user if he/she enters an empty input / 2 or more words input
							if ( (keyword.split(" ").length!=1) || (keyword.split(" ")[0].length() ==0) ) {
								System.out.println("\n>> Please enter only 1 keyword to search");
							} else {
								// if the user finally enters a 1 word input then:
								// search each content of the books list for a match with our user-specified keyword
								// inform the user if there's a match or not
								// if there's a match, display the Title of the book
								int indexFound = Gabinete_Exer2.searchKeyword(books, keyword);
								if (indexFound != -1) {
									System.out.println("\n>> Found one item:");
									System.out.println("("+ (indexFound+1) + ") " + books[indexFound] + "\n\n");
								} else {
									System.out.println("\n>> No item found with that keyword\n\n");
								} // end of an if-else statement
							} // end of an if-else statement

						} while ( (keyword.split(" ").length!=1) || (keyword.split(" ")[0].length() ==0) );
						// end of the loop
						choice = -1;	// resets the value of choice (for the if statement at the start of the main loop)
						break;

					case 3:
						// if the user enters 3 as an input then replace a book title in the books list as per the user's desires
						System.out.println("\n>> Replace which book?");

						// prints the contents of the books list
						Gabinete_Exer2.printBooks(books);

						// ask the user which book title he/she wants to replace
						System.out.println(">> Select a book from the list [1-" + books.length + "]");

						int indexToReplace = - 1;	// will store an integer input from the user that will dictate which book title will be replaced

						String newBooks;	// will store the input string from the user that will replace a certain book title in the books list

						// loop until the user provides a valid input
						do {
							// perform some error handling exceptions
							try {
								// ask an integer input from the user (which book title will be replaced)
								indexToReplace = scan1.nextInt();

								// inform the user if he/she enters an invalid input (out of range)
								if (indexToReplace<0 || indexToReplace>books.length) {
									System.out.println("\n\n>> Please enter a valid choice! [1-" + books.length + "]");
								} else {
									// ask the user for a string input that will replace a specific book title from the books list
									System.out.println("\n>> What do you want to replace it with?");
									newBooks = scan2.nextLine();

									// call the replaceTitle method and update the books list (string array)
									books = Gabinete_Exer2.replaceTitle(books, indexToReplace, newBooks);
									System.out.println("\n>> Replaced title #"+ indexToReplace + "\n\n");
								} // end of if-else statement
							} catch (Exception e) {
								// inform the user if he/she enters an invalid input (not an integer)
								System.out.println("\n\n>> Please enter a valid choice! [1-" + books.length + "]");
								scan1.nextLine();	// fetches what was/were left in our input stream
							}
						} while (indexToReplace<0 || indexToReplace>books.length);
						// end of the loop
						choice = -1; 	// resets the value of choice (for the if statement at the start of the main loop)
						break;

					// terminate the program if the user enters 0 as an input
					case 0:
						System.out.println("\n\n>> Program Exits...Bye!");

						// close the scanner objects used in our program
						scan1.close();
						scan2.close();
						break;

					// Inform the user if he/she enters an integer value that was not in the given range
					default: System.out.println("\n>> Please select a number from the menu");
				}

			} catch (Exception e) {
				System.out.println("\n>> Please select a number from the menu");
				scan1.nextLine();	// fetches what was/were left in our input stream
				choice = 2;		// to not display the main menu
			}

		} while (choice !=0);
		// end of the loop
	} // end of the main program
	// ******************************************************************************************************

	// create a method to print a menu of operations
	public static void displayMenu() {
		System.out.println("====== My Personal Library ======");
		System.out.println("[1] Print all books");
		System.out.println("[2] Keyword search");
		System.out.println("[3] Replace a book title");
		System.out.println("[0] Exit");
		System.out.println("=================================");
		System.out.println("\n\n>> What do you want to do? ");
	} // end of the method
	// ******************************************************************************************************

	// create a method to print the contents of an string array
	// pass the books array to this method
	public static void printBooks(String[] books) {
		System.out.println("\n");
		for (int index=0; index<books.length; index++ ) {
			System.out.println("[" + (index+1) + "] " + books[index]);
		}
		System.out.println("\n");
	} // end of the method
	// ******************************************************************************************************

	// create a method that will search for a keyword in the contents of an string array
	// pass the books array and the keyword (provided by the user) to this method
	// return the index of the first books item that contains that keyword. if not found then return -1
	public static int searchKeyword(String[] books, String searchKeyword) {
		String[] splitItem; // declare a variable that will hold the resulting array returned by the split method

		// loop through each item inside the books list to check if there's a match within them
		for (int indexArray=0; indexArray<books.length; indexArray++) {
			splitItem = books[indexArray].split(" ");
			// loop through the current books item and check if there's a match
			for (int indexItem=0; indexItem<splitItem.length; indexItem++) {
				if (splitItem[indexItem].toLowerCase().equals(searchKeyword.toLowerCase())) {
					return indexArray;	// return the index of the first books item that contains the keyword
				}
			}
		}
		return -1;	// return -1 if there's not a single match from any of the contents of the books list
	} // end of the method
	// ******************************************************************************************************

	// create a method that will replace an item inside a string array
	// pass the books array, index to replace, and the new books array to this method
	// return the updated books list
	public static String[] replaceTitle (String[] books, int indexToReplace, String newBooks) {
		books[indexToReplace-1] = newBooks;
		return books;
	} // end of the method
	// ******************************************************************************************************

} // end of the class
