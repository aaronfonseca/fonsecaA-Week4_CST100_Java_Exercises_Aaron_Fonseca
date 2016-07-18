
/** Program: Exercise 10.07
* File: Exercise_10_07.java
* Summary: Chapter 10, Exercise 07. 
*
*	(Game: ATM machine) Use the Account class created in Programming Exercise
*	9.7 to simulate an ATM machine. Create ten accounts in an array with id
*	0, 1, . . . , 9, and initial balance $100. The system prompts the user to enter an
*	id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id
*	is accepted, the main menu is displayed as shown in the sample run. You can
*	enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for
*	depositing money, and 4 for exiting the main menu. Once you exit, the system
*	will prompt for an id again. Thus, once the system starts, it will not stop.
*
* Author: Aaron Fonseca
* Date: July 17, 2016
**/

import java.util.Scanner;

public class Exercise_10_07 {

	public static void main(String[] args) {

		// Create Scanner
        Scanner input = new Scanner(System.in);
        
        // Create Accounts Array lenght 10
        Account[] accounts = new Account[10];

        // Create 10 New Account Objs
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(i, 100);
        }

        int choice = 0;
        int id = userID(accounts);
        while (choice != 4) {
            Account user = getAccount(accounts, id);
            System.out.print(
                    "\nMain menu\n" +
                            "1: check balance\n" +
                            "2: withdraw\n" +
                            "3: deposit\n" +
                            "4: exit\n" +
                            "Enter a choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("The balance is $" + user.getBalance() + ".\n");
                    break;
                case 2:
                    System.out.print("Enter an amount to withdraw: ");
                    user.withdraw(input.nextDouble());
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    user.deposit(input.nextDouble());
                    break;
                case 4:
                    System.out.println("");
                    id = userID(accounts);
                    choice = 0; // To Return Choice ID
                    break;
                    default:
                        System.out.println("Invalid, Enter a number 1-4");
            }

        }

    }

    public static int userID(Account[] accounts) {

        Scanner input = new Scanner(System.in);

        int id = 0;
        boolean isValidID = false;

        while (!isValidID) {
            System.out.print("Enter an ID: ");
            id = input.nextInt();

            if (!hasID(accounts, id)) {
                System.out.println("INVALID ID: Please Try again.");

            } else {
                isValidID = true;
            }
        }

        return id;
    }

    
    public static Account getAccount(Account[] accounts, int id) {

    	// for each Account
        for (Account account : accounts) {
            if (id == account.getId()) {
                return account;
            }
        }
        return null;
    }
    
    // Check if ID exists
    public static boolean hasID(Account[] accounts, int id) {

    	// for each Account
        for (Account account : accounts) {
            if (id == account.getId()) {
                return true;
            }
        }

        return false;
    }


}

