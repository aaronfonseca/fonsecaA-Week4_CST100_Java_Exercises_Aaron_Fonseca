/** Program: Exercise 8.09
* File: Exercise_8_09.java
* Summary: Chapter 8, Exercise 09. 
* 
* 	(Game: play a tic-tac-toe game) In a game of tic-tac-toe, two players take turns
* 	marking an available cell in a 3 * 3 grid with their respective tokens (either
* 	X or O). When one player has placed three tokens in a horizontal, vertical, or
* 	diagonal row on the grid, the game is over and that player has won. A draw (no
* 	winner) occurs when all the cells on the grid have been filled with tokens and
* 	neither player has achieved a win. Create a program for playing tic-tac-toe.
* 	The program prompts two players to enter an X token and O token alternately.
* 	Whenever a token is entered, the program redisplays the board on the
* 	console and determines the status of the game (win, draw, or continue).
* 
* Author: Aaron Fonseca
* Date: July 15, 2016
**/

import java.util.Scanner;

public class Exercise_8_09 {

	static Scanner input = new Scanner(System.in); // Create Scanner
	
	static public String Player = "X";
	static int playerRow = 0;
	static int playerColumn = 0;
	static public String [][] game = new String[3][3]; 
	static public boolean winner = false;
	static public String winingPlayer = "";
	
	public static void main(String[] args) {
		
		System.out.println("Let's Play Tic-Tac-Toe");
		
		createGameBoard(game); // Create Blank Game
		
		do{
			printGameBoard(game); // Print Out Game
			
			// Prompt User for Row
			System.out.print("Enter a row (0, 1, or 2) for player " + Player + ": ");
			playerRow = input.nextInt();
			
			// Prompt User for Column
			System.out.print("Enter a column (0, 1, or 2) for player " + Player + ": ");
			playerColumn = input.nextInt();
			
			// Place X/O on board
			placeMarker(playerRow, playerColumn);
						
			if(Player == "X" && !winner){Player = "O";}else{Player = "X";};// Switch Player
			
		}while(!winner);
		
		System.out.print(winingPlayer + " Player Won");
	}
	
	// Check for winner
	public static void isWinner(String[][] game, String Player) {
		if((checkColumn(game, Player) || checkColumn(game, Player) || checkDiagonal(game, Player))){
			printGameBoard(game);
			winingPlayer = Player;
			winner = true;
		}
	
	}
	
	// Place X/O on board
	public static void placeMarker(int row, int column){
		if(game[row][column] != " "){
			System.out.println("That space is taken, please choose another.");
		}else{
			game[row][column] = Player;
			// Check for winner
			isWinner(game, Player);
		}
	}

	// Print Out Game
	 public static void printGameBoard(String[][] game) {
		 for(int i = 0; i < game.length; i++){
			 System.out.println("-------------");
			 System.out.print("|");
			 for (int j = 0; j < game[i].length; j++) {
				 System.out.print(" " + game[i][j] + " |");
			 	}
			 System.out.println();
		 	}
		 System.out.println("-------------");
		 }
	 
	// Create Blank Game
	 public static void createGameBoard(String[][] game) {
		 for(int i = 0; i < game.length; i++){
			 for (int j = 0; j < game[i].length; j++) {
				 game[i][j] = " ";
			 	}
		 	}
		 }
	 
	 // Check Column
	 public static boolean checkColumn(String[][] game, String player) {
		 	
		 for (int i = 0; i < game.length; i++) {
				int count = 0;
				for (int j = 0; j < game[i].length; j++) {
					if (game[j][i] == player)
						count++;
				}
				if (count == 3)
					return true;
			}
			return false;
	    }
	 
	 //Check Row
	 public static boolean checkRow(String[][] game, String player) {

		 for (int i = 0; i < game.length; i++) {
				int count = 0;
				for (int j = 0; j < game[i].length; j++) {
					if (game[i][j] == player)
						count++;
				}
				if (count == 3)
					return true;
			}
			return false;
	    }
		 
	//Check Diagonal
	 public static boolean checkDiagonal(String[][] game, String player) {

		 int count = 0;
			for (int i = 0; i < game.length; i++) {
				if (game[i][i] == player)
					count++;
				if (count == 3)
					return true;
			}

			count = 0;
			for (int i = 0, j = game[i].length - 1; j >= 0 ; j--, i++) {
				if (game[i][j] == player)
					count++;
				if (count == 3)
					return true;
			}
			return false;
	    }
}
	
