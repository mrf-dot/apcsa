/** This program is designed to simulate a cashier
 * The program executes the following steps:
 * 	1. Greets the user with a description of the program
 * 	2. Opens 2 scanners for numerical and string input
 * 	3. Prompts the user to enter how many items they
 * 	bought which is used to define a for loop
 * 	4. A for loop loops for the number of items
 * 	and prompts the user to enter the name and
 * 	price of each item which are added to
 * 	itemListFormatted and moneyTotal
 * 	5. The tax is determined by multiplying the money
 * 	by 6% (the tax rate)
 * 	6. The tax is added to moneyTotal to create
 * 	moneyTotalWithTax
 * 	7. The receipt is printed to the user with their total
 * 	8. The user is asked to enter their payment
 * 	is asked to enter a satisfactory payment with a while loop
 * 	9. Change is calculated into variables for their respective unit
 * 	of currency
 * 	10. The amount of change owed is presented to the user
 */

/* Imports scanner module */
import java.util.Scanner;

public class feigenbaumCodingAssignment2 {
	public static void main(String[] args) {
		/* Displays program instructions (welcome message) */
		System.out.print("Welcome to the magnificent Java powered store.\n"
				+ "This program takes your purchased items as input and will output your total price (with tax).\n"
				+ "The program will then prompt you to give your money to the register.\n"
				+ "The Java Cashier will then return you your change and confirm your purchase went successfully.\n");

		/* Opens scanner for string input */
		Scanner scanString = new Scanner(System.in);
		/* Opens scanner for numerical input */
		Scanner scanNum = new Scanner(System.in);

		/* Prompts user to enter how many items they plan on checking out */
		System.out.print("How many items do you plan on checking out? \n" + "=> ");
		/* Collects user input for number of items */
		int numberOfItems = scanNum.nextInt();

		/* Creates string to format item names and prices */
		String itemListFormatted = "\nYou purchased:\n";
		/* Creates integer for item prices in pennies */
		int moneyTotal = 0;
		/* Creates string to store current input */
		String tempItemName;
		/* Creates double to store current item price */
		double tempItemPrice;
		/* For loop for user to enter all their items */
		for (int itemNumber = 0; itemNumber < numberOfItems; itemNumber++) {
			/* Prompts user each time they enter an item */
			System.out.print("Please enter the name of your item\n" + "=> ");
			/* Adds item name to tempItemName */
			tempItemName = scanString.nextLine();
			/* Prompts user to enter price of that item */
			System.out.print("Please enter the price of your item\n" + "=> ");
			/* Adds item price to tempItemPrice */
			tempItemPrice = scanNum.nextDouble();
			/* Adds item and price to itemListFormatted */
			itemListFormatted += String.format("%s: $%.2f\n", tempItemName, tempItemPrice);
			/* Adds item price to moneyTotal */
			moneyTotal += (int) (tempItemPrice * 100);
		}

		/* Computates tax in pennies */
		double taxrate = 0.06;
		int tax = (int) (moneyTotal * taxrate);
		int moneyTotalWithTax = moneyTotal + tax;

		/* Adds subtotal, tax and total to itemListFormatted */
		itemListFormatted += String.format("Subtotal: $%.2f\n" + "Tax: $%.2f\n" + "Total: $%.2f\n\n",
				((double) (moneyTotal)) / 100, ((double) (tax)) / 100, ((double) (moneyTotalWithTax)) / 100);

		/* Prints out purchased items with prices */
		System.out.print(itemListFormatted);

		/*
		 * Asks user to submit payment and collects that payment in pennies into
		 * variable "payment"
		 */
		int payment = 0;
		System.out.println("Please submit your payment");

		/* Loops until user submits payment equal to or above moneyTotalWithTax */
		do {
			System.out.print("=> ");
			payment = (int) (scanNum.nextDouble() * 100);
			if (payment < moneyTotalWithTax)
				System.out.printf("You still owe $%.2f%n", ((double)  (moneyTotalWithTax - payment)) / 100);
		} while (payment < moneyTotalWithTax);

		/* Determine how much change of each type is required */
		int totalChange = payment - moneyTotalWithTax;
		int changeLeft = totalChange;
		int dollars = changeLeft / 100;
		changeLeft %= 100;
		int quarters = changeLeft / 25;
		changeLeft %= 25;
		int dimes = changeLeft / 10;
		changeLeft %= 10;
		int nickels = changeLeft / 5;
		changeLeft %= 5;
		int pennies = changeLeft;

		/*
		 * Outputs amount of change owed and sections it into dollars, quarters, dimes,
		 * nickels, and pennies
		 */
		System.out.printf("Thank you for your payment!\n"
				+ "Your change owed is $%.2f.\n"
				+ "Your change is %d dollars, %d quarters, %d dimes, %d nickels, and %d pennies.",
				((double) (totalChange)) / 100, dollars, quarters, dimes, nickels, pennies);
	}
}
