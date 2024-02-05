/***********************************************************************************
 * @author Gabinete, Keith Ginoel S.
 * created_date 2023-02-25 20:18
 *
 * Program Description:
 * This program asks N integer inputs from a user.
 * A menu will appear once the user is able to provide N valid integer inputs.
 * The Menu contains a list of options a user can choose from to execute certain functions
 * Options include:
 * 1. Get Largest Odd Value
 * 2. Count Positive, Negative and Zero Values
 * 3. Reverse Array
 * 4. Exit
 * N is a constant integer variable that can only be changed by modifying this code file (located at the beginning section of the main method)
 * once modified, the program should still run given that N is a valid integer value and no other part of the code was modified
 ***********************************************************************************/

package mypackage;

import java.util.Scanner;	// import Scanner class from the java.util package
							// will be used to scan input/s from the user/s

public class Gabinete_Exer1 {

	// main method
	public static void main(String[] args) {
		final int N = 5; 	// will decide the number of valid integer inputs the user must enter
							// or to simply say, N will decide the size of our integer array

		// declare an integer variable that stores the user's choice from the given options in our main menu
		// we'll initialize its value to -1 as to not interfere with our main program's do-while loop later on that involves 0 as a condition
		int choice = -1;

		// create an empty array of integers with size N
		int[] inputs = new int[N];

		// declare scanner variables that will be used to scan/get inputs from the user later on
		// we'll be declaring 2 scanner variables as we have a total of 2 loops in this java code (to avoid further conflicts in the program)
		Scanner scanLoop1 = new Scanner(System.in);
		Scanner scanLoop2 = new Scanner(System.in);

		// declare an initialized integer variable that will monitor the number of valid integer inputs the user has entered for our integer array named inputs
		int inputCount = 0;

		// *****************************************************************************
		// start of the program
		System.out.println("Please enter " + N + " numbers.\n");


		// ask the user to input N integers
		// inform the user if he/she entered an invalid input (will only accept integer input)
		while (inputCount<N) {
			// perform some error-handling exceptions (will check if the user enters a valid integer input)
			try {
				System.out.print("Enter a number: ");		// ask an input from the user
				inputs[inputCount] = scanLoop1.nextInt(); 	// scans an integer input from the user
				inputCount += 1;							// increment the value of inputCount when the user enters a valid input
			} catch (Exception e){
				System.out.println("Oops! That's not an integer! :(");
				scanLoop1.nextLine(); 	// fetches what was/were left in our input stream
								  		// needed to avoid unnecessary iteration of the loop (because scanner.nextInt() only scans a token of input before a space;
								  		// therefore, anything that comes after the first space from an input of the user will still be left in our input stream)
			}
		}

		// print the contents of our integer array named inputs
		// loop through our array to access each valid integer input from the user
		System.out.println("Inputs are:");
		for (int index=0; index<N; index++) {
			System.out.print(inputs[index] + "\t");
		}
		System.out.println("\n"); 	// prints 2 new lines


		do {
			// design/create a menu for our program
			System.out.println("Menu-------------------");
			System.out.println("[1] Get Largest Odd Value");
			System.out.println("[2] Count Positive, Negative and Zero Values");
			System.out.println("[3] Reverse Array Contents");
			System.out.println("[0] Exit");
			System.out.print("Choice: ");

			// perform some error-handling exceptions (will check if the user enters a valid integer input)
			try {
				// ask an input from the user
				choice = scanLoop2.nextInt();

				// create a switch statement that takes the value of our integer variable choice to execute certain actions in our program
				// each action corresponds to each given option in our Menu
				switch (choice) {
					case 1: // display the largest odd value among the N integer inputs in the array (if there is one)
						// declare a boolean variable to check if there's an odd number inside our array named inputs
						boolean hasOdd = false;

						// declare an integer value that would store the biggest odd number stored in our array named inputs
						int largestOdd = 0;
						int tempOdd = 0; // will temporarily hold an odd number from the integer inputs

						// loop through our integer array named inputs to access its contents
						// check if there's an odd number inside
						// if there is, print the largest odd number among the integer inputs
						for (int index=0; index<N; index++) {
							if (inputs[index]%2!=0) {
								hasOdd = true;
								tempOdd = inputs[index];

								// check if the currently selected odd integer is bigger than the previously stored odd integer in the largestOdd variable
								if (tempOdd >= largestOdd) {
									largestOdd = tempOdd;
								} // end of if statement
							} // end of if statement
						} // end of for loop

						// Display the output
						if (hasOdd) {
							System.out.println("Largest odd value is " + largestOdd + ".\n");
						} else {
							System.out.println("Sorry! There's NO ODD VALUE among the integer inputs.\n");
						} // end of if-else statement
						break;
						// end of case 1

					case 2: // count the number of positive, negative and zero values in the array and display each counter

						// declare integer variables to count the total number of positive, negative and zero values inside our array and initialize each to 0
						int positiveCounter = 0, negativeCounter = 0, zeroCounter = 0;

						// loop through our integer array named inputs to access its contents
						for (int index=0; index<N; index++) {
							if (inputs[index] > 0) {
								positiveCounter += 1;
							} else if (inputs[index] < 0) {
								negativeCounter += 1;
							} else {
								zeroCounter += 1;
							}
						} // end of for loop

						// Display the output
						System.out.println("Positive numbers: " + positiveCounter);
						System.out.println("Negative numbers: " + negativeCounter);
						System.out.println("Zero numbers: " + zeroCounter + "\n");
						break;
						// end of case 2

					case 3: // display our integer array named inputs not yet reversed followed by the reversed array values
						// create an empty array of integers with size N
						// this will hold the reversed values of our array named inputs
						int[] reversedInputs = new int[N];
						int inputIndex = 0; // will serve as index for the original non-reversed array
						// loop through our integer array named reversedInputs from its last index up to its first index to store each content of our array named inputs
						for (int reversedIndex=N-1; reversedIndex>=0; reversedIndex--) {
							reversedInputs[reversedIndex] = inputs[inputIndex];
							inputIndex += 1;
						} // end of for loop

						// Display the output
						// Display the contents of our original integer array named inputs
						System.out.println("Array contents:");
						for (int index=0; index<N; index++) {
							System.out.print(inputs[index] + "\t");
						}
						System.out.println(); // prints a new line

						// Display the contents of our reversed integer array
						System.out.println("Reversed Array:");
						for (int index=0; index<N; index++) {
							System.out.print(reversedInputs[index] + "\t");
						}
						System.out.println("\n"); // prints 2 new lines
						break;
						// end of case 3

					// terminate the program if the user enters 0 as an input
					case 0:
						System.out.println("\n\nProgram Exits...Bye!\n");
						break;
						// end of case 0

					// inform the user if he/she enters a valid integer input that isn't in the given options in our Menu
					default:
						System.out.println("Please enter a valid choice.\n");
				} // end of switch statement

			} catch (Exception e) {
				System.out.println("Please enter a valid choice.\n");
				scanLoop2.nextLine(); // fetches what was/were left in our input stream
			}

		} while (choice != 0);
		// end of the program

	} // end of the main method

}
