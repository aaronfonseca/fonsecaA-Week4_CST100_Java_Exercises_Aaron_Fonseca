
/** Program: Exercise 7.09
* File: Exercise_7_09.java
* Summary: Chapter 7, Exercise 09. (Find the smallest element) 
* Write a method that finds the smallest element in an array of 
* double values using the following header:
* Author: Aaron Fonseca
* Date: July 13, 2016
**/

import java.util.Scanner;

public class Exercise_7_09 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); // Create a Scanner
		double[] numbers = new double[10]; // Create array of length 10

		// Prompt the user to enter ten numbers
		System.out.print("Enter ten numbers: ");
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = input.nextDouble();
		}
		input.close();

		// Print the smallest element
		System.out.println("The minimum number is: " + getMin(numbers));
	}

	/** Method getMin returns the smallest element in an array */
	public static double getMin(double[] array) {
		double min = array[0];	// The minimum value
		for (double i: array) {
			if (i < min)
				min = i;
		}
		return min;
	}
}
