
/** Program: Exercise 5.21
* File: Exercise_5_21.java
* Summary: Chapter 5, Exercise 21. (Financial application: compare loans with various interest rates) 
* Author: Aaron Fonseca
* Date: July 13, 2016
**/

import java.util.Scanner;

public class Exercise_5_21 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in); 
		
		System.out.print("Loan Amount:  ");
		double Loan = input.nextDouble();
		
		System.out.print("Number of Years:  ");
		double Years = input.nextDouble();
		
		input.close();
		
		System.out.printf("%-15s%-15s%s\n","Interest Rate","Monthly Payment","Total Payment");
		
		double interest = 5.000;
		while(interest <= 8){
			double monthlyInterestRate = interest / 1200;
			double monthlyPayment = Loan * monthlyInterestRate / (1
				- 1 / Math.pow(1 + monthlyInterestRate, Years * 12));
			System.out.printf("%-15.4f%-15.2f%.2f\n",interest,monthlyPayment,(monthlyPayment * 12) * Years);
			interest += 0.125;
		}

	}

}
