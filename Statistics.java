/*
 * Simon Basescu CS201 A
 * This program prompts user to enter a set of integers, asks if 
 * the user wants to compute statistics on those integers (such as average, maximum, minimum,
 * range, and mode), and then executes methods to calculate those statistics requested by the user.
 */

import java.util.Scanner;
public class Statistics {
	static int [] ref; //allows me to reference the array in all methods

	public static void main(String[] args) {
		boolean go = true;  //is the condition for the outer while loop. Go is set to false when 
						   //the user wants to quit.
		Scanner kb = new Scanner(System.in);		

		while (go == true) { 	

			System.out.println("Enter positive integers(1) or quit(0)?");
			int play = kb.nextInt();

			if (play == 1) {
				ref = getIntegers(); 		   
			}		

			else if (play == 0)
				go = false;	  //makes neither while loop conditions satisfied so program breaks out 
							  //of both loops and goes to statement afterwards

			else 
				System.out.println("Invalid response. Try again."); //prompts user to try again if
																//they did not understand instructions
			while (play == 1) { 
				System.out.println("Please choose an option:");
				System.out.println("(1) average");
				System.out.println("(2) maximum");
				System.out.println("(3) minimum");
				System.out.println("(4) range");
				System.out.println("(5) mode");
				System.out.println("(0) quit");
				int method = kb.nextInt();

				if (method == 1) {
					System.out.println("Average is: "+ getAverage());
				}

				else if (method == 2) {
					System.out.println("Maximum is: "+ getMax());
				}

				else if (method == 3) {
					System.out.println("Minimum is: "+ getMin());
				}

				else if (method == 4) {

					System.out.println("Range is: "+ getRange());
				}

				else if (method == 5) {
					System.out.println("Mode is: "+ getMode());
				}

				else if (method == 0) 
					play = 0; //makes inner while loop not satisfy its condition
				
				else 
					System.out.println("Invalid response. Try again.");      
				    //prompts user to try again if they did not understand instruction   	           
			}
		}
		System.out.println("Goodbye!");
	}	

	/*
	 * getIntegers() prompts the user to enter a number of integers of their choosing and
	 * returns an array of those integers
	 */
	public static int[] getIntegers() {  

		Scanner loc = new Scanner(System.in);
		System.out.println("How many positive integers would you like to enter?");
		int length = loc.nextInt();
		int [] game = new int[length];		

		/*  For loop starts at i = 0 so we can use game[i] to set the elements. 
		    The print statement uses i + 1 so the first integer in the print statement is:
		    "Please enter integer 1" rather than, "Please enter integer 0."	 
		 */
		for (int i = 0; i < length; i++) { 
			System.out.println("Please enter integer " + (i + 1) + ": ");
			game[i] = loc.nextInt();
		}
		return game;			
	}

	/*
	 * getAverage() adds all the values in the array and then divides that by the total
	 * number of elements
	 */

	public static double getAverage() { 
		double sum = 0;
		for (int i = 0; i < ref.length; i++) {
			sum += ref[i]; //gets sum of all values in the array
		}
		double avg = sum/(ref.length); //divides sum by the number of values
		return avg;
	}

	/*
	 * getMax() sets maximum at first value in array and then loops through the rest of the array. 
	 * If any value in the array is greater than the current maximum, it sets the maximum to 
	 * that value and continues until all values have been checked.
	 */

	public static int getMax() {

		int max = ref[0];
		for (int i = 1; i < ref.length; i++) { 
			if (ref[i] > max)
				max = ref[i]; //continues to set max to new maximum until all elements are checked
		}
		return max;
	}

	/*
	 * getMin() does the same thing as getMax() except it checks if the values are less than 
	 * the current minimum
	 */

	public static int getMin() {
		int min = ref[0];
		for (int i = 1; i < ref.length; i++) { 
			if (ref[i] < min)
				min = ref[i];
		}
		return min;
	}			
	
	/*
	 * getRange() returns the range of values in the array
	 */

	public static int getRange() {
		int maximum = getMax();
		int minimum = getMin();
		return maximum - minimum;
	}

	/*
	 * getMode() returns the mode for the values in the array. If all values are different it
	 * returns the first value in the array. If there is a tie, it returns the first mode 
	 * that it found in the tie. 
	 */

	public static int getMode() {
		int mode = ref[0]; //sets initial mode to ref[0] 
		int modeCount = 0; //keeps track of number of values of the mode
		for (int i = 0; i < ref.length; i++) {
			int check = 0; //counts the number of elements in the array
						   //that match the value of the current element (ref[i]) being checked

			for (int j = 0; j < ref.length; j++) { 
				if (ref[i] == ref[j])
					check++;	 //increments check if another element has the same value as ref[i]

				if (check > modeCount) { //if statement is satisfied if a new mode is found
					modeCount = check; //sets modeCount to the number of times that the new mode appears
					mode = ref[i]; //sets mode to the value of the element with the highest check count
				}
			}				
		}
		return mode;		 
	}	
}












