
/** Program: Exercise 7.35
* File: Exercise_7_35.java
* Summary: Chapter 7, Exercise 035. 
* (Game: hangman) Write a hangman game that randomly generates a word and
* prompts the user to guess one letter at a time, as shown in the sample run.
* Author: Aaron Fonseca
* Date: July 13, 2016
**/

import java.util.Scanner;

public class Exercise_7_35 {

	static Scanner input = new Scanner(System.in); // Create Scanner
	
	public static void main(String[] args) {
		
		String playAgain; // 'y' or 'n'
		do {
			// Generate a random word 
			char[] word = getWord();
			
			// Fill word with blank asterisks.
			char[] asterisks = new char[word.length];
			makeBlanks(asterisks);

			int missed = 0; // incorrect guesses
			
			do {
				// Prompt the user to guess one letter
				char guess = getGuess(asterisks);		
				
				// Check if is letter is correct
				if (!isCorrectGuess(word, asterisks, guess))
					missed++;
					
			} while (!isWordFinish(asterisks));
			
			// Print results
			print(word, missed);
			
			// Ask the user whether to continue to play with another word
			System.out.println("Do you want to guess another word? Enter y or n>");
			playAgain = input.next();

		} while (playAgain.charAt(0) == 'y');
	}

	/* get random word form list */
	public static char[] getWord() {
		
		String[] words = {"cookie", "bacon", "steak", "apple", "doughnut"};
		String choice = words[(int)(Math.random() * words.length)];
		char[] word = new char[choice.length()];

		for (int i = 0; i < word.length; i++) {
			word[i] = choice.charAt(i); // Convert Word into charArray
		}
		return word;
	}

	// Add Asterisks to charArray
	public static void makeBlanks(char[] list) {
		for (int i = 0; i < list.length; i++) {
			list[i] = '*';
		}
	}

	// Check if letter is in word
	public static boolean isCorrectGuess(char[] word, char[] blanks, char guess) {
		boolean correct = false;
		int message = 2;
		for (int i = 0; i < word.length; i++) {
			if (word[i] == guess) {
				correct = true;
				if (blanks[i] == guess){
					message = 1;
				}
				else { 
					blanks[i] = guess; // the actual letter is then displayed.
					message = 0;
				}
			}
		}
		if (message > 0){
			print(message, guess); // Call print message for incorrect
		}
		return correct;
	}

	// Check if word is finished
	public static boolean isWordFinish(char[] blanks) {
		for (char e: blanks) {
			if (e == '*') {
				return false;
			}
		}
		return true;
	}

	// print final results
	public static void print(char[] word, int missed) {
		System.out.print("The word is ");
		System.out.print(word);
		System.out.println(" You missed " + missed + " time");
	}

	// Print wrong Message
	public static void print(int message, char guess) {
		System.out.print("\t" + guess);
		switch (message) {
			case 1 : System.out.println(" is already in the word"); break;
			case 2 : System.out.println(" is not in the word"); break;
		}
	}

	// Prompts user to guess a letter
	public static char getGuess(char[] asterisks){
		System.out.print("(Guess) Enter a letter in word ");
		System.out.print(asterisks);
		System.out.print(" > ");
		String g = input.next();
		return g.charAt(0);
	}
}