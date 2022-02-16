class Casino {
	public static void main(String[] args) {
		Player player = new Player("Gambler");
		SlotMachine machine = new SlotMachine((Math.random() < 0.5) ? 5 : 10);
		System.out.printf("Welcome, %s%n", player.getName());
		System.out.printf("You will be using the %s machine today, which costs %d coins.%n",
				(machine.getCost() == 10) ? "original" : "modded", machine.getCost());
		int totalSpins = 0;
		for (int spins = 0; player.getMoney() >= machine.getCost(); totalSpins = ++spins) {
			machine.pull();
			System.out.println(machine);
			player.setMoney(player.getMoney() - machine.getCost() + machine.calculate());
			if (machine.calculate() > 0)
				System.out.printf("HIT!!! You win %d coins!%n", machine.calculate());
			else
				System.out.println("Too bad! No win on this pull.");
			System.out.printf("%s%n%n", player);
		}
		System.out.printf("GAME OVER! You were able to pull %d times before going broke",
				totalSpins);
	}

}

class Player {
	private String name;
	private int money;

	public Player(String name) {
		this.name = name;
		this.money = 100;
	}

	public String getName() {
		return this.name;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String toString() {
		return String.format("%s has $%d", this.name, this.money);
	}
}

class SlotMachine {
	private int cost, multiplier;
	private SlotReel sr1, sr2, sr3;

	public SlotMachine(int cost) {
		this.cost = cost;
		this.multiplier = cost / 5;
		this.sr1 = new SlotReel();
		this.sr2 = new SlotReel();
		this.sr3 = new SlotReel();
	}

	public void pull() {
		this.sr1.spin();
		this.sr2.spin();
		this.sr3.spin();
	}

	public int getCost() {
		return this.cost;
	}

	private boolean hit3() {
		if (this.sr1.toString().equals("horseshoe")
				|| this.sr1.toString().equals("star")
				|| this.sr2.toString().equals("horseshoe")
				|| this.sr2.toString().equals("star")
				|| this.sr3.toString().equals("horseshoe")
				|| this.sr3.toString().equals("star"))
			return false;
		if (this.sr1.equals(sr2) && this.sr2.equals(sr3))
			return true;
		return false;
	}

	private boolean hit2() {
		if (this.sr1.toString().equals("horseshoe") && this.sr2.toString().equals("horseshoe"))
			return true;
		return false;
	}

	public int calculate() {
		if (hit3()) {
			switch (this.sr1.toString()) {
				case "spade":
					return this.multiplier * 20;
				case "diamond":
					return this.multiplier * 30;
				case "heart":
					return this.multiplier * 40;
				case "Liberty Bell":
					return this.multiplier * 50;
				default:
					break;
			}
		}
		if (hit2() && this.sr3.toString().equals("star"))
			return this.multiplier * 10;
		if (hit2())
			return this.multiplier * 5;
		return 0;
	}

	public String toString() {
		return String.format("%d: %s|%s|%s", this.cost, this.sr1.toString(), this.sr2.toString(),
				this.sr3.toString());
	}
}

class SlotReel {
	private int value;

	public void spin() {
		this.value = (int) (Math.random() * 6) + 1;
	}

	public boolean equals(SlotReel reel) {
		return this.value == reel.getValue();
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		switch (this.value) {
			case 1:
				return "diamond";
			case 2:
				return "heart";
			case 3:
				return "spade";
			case 4:
				return "horseshoe";
			case 5:
				return "star";
			case 6:
				return "Liberty Bell";
			default:
				return "";
		}
	}
}

/* This program calculates the winning baseball team
 * Baseball:
 * Based on input of 2 baseball team names and 3 baseball players per team (6 total)
 * Statistics:
 * 	First baseman can score 10 runs exclusive
 * 	Second baseman can score 15 runs exclusive
 * 	Third baseman can score 20 runs exclusive
 * The runs scored by each player are totaled up into the full score
 */

/* Imports the scanner module */
import java.util.Scanner; /* dd */

public class FeigenbaumBaseball
{
	public static void main(String[] args)
	{
		// Tells the client about the program
		System.out.print("This program outputs fantasy baseball satistics\n");
		System.out.print("The score of a team is calculated based on the scores of the three inputted players.\n");
		System.out.print("The scores of the three players are totaled up to create the overall team score.\n");
		System.out.print("The team with the highest total score wins the simulation.\n\n");

		//Opens Scanner to collect client input
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);

		// Collects user input for teamA
		System.out.print("What is the name of your baseball team?\n=> ");
		String teamA = scanString.nextLine();
		System.out.print("What is the name of the first baseman?\n=> ");
		String playerA1 = scanString.nextLine();
		System.out.print("What is the name of the second baseman?\n=> ");
		String playerA2 = scanString.nextLine();
		System.out.print("What is the name of the third baseman?\n=> ");
		String playerA3 = scanString.nextLine();

		// Declares player score variables for team A
		int playerA1Score = (int) (Math.random() * 10) ;
		int playerA2Score = (int) (Math.random() * 15);
		int playerA3Score = (int) (Math.random() * 20);
		int teamAScore = playerA1Score + playerA2Score + playerA3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamA);
		System.out.printf("%s (first baseman): %s runs\n", playerA1, playerA1Score);
		System.out.printf("%s (second baseman): %s runs\n", playerA2, playerA2Score);
		System.out.printf("%s (third baseman): %s runs\n", playerA3, playerA3Score);
		System.out.printf("the %s has %s runs in total.\n\n", teamA, teamAScore);

		// Collects user input for teamB
		System.out.printf("What team would you like to compare to the %s?\n=> ", teamA);
		String teamB = scanString.nextLine();
		System.out.print("What is the name of the first baseman?\n=> ");
		String playerB1 = scanString.nextLine();
		System.out.print("What is the name of the second baseman?\n=> ");
		String playerB2 = scanString.nextLine();
		System.out.print("What is the name of the third baseman?\n=> ");
		String playerB3 = scanString.nextLine();

		// Closes scanners to prevent resource leak
		scanString.close();
		scanInt.close();

		// Declares player score variables for team A
		int playerB1Score = (int) (Math.random() * 10);
		int playerB2Score = (int) (Math.random() * 15);
		int playerB3Score = (int) (Math.random() * 20);
		int teamBScore = playerB1Score + playerB2Score + playerB3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamB);
		System.out.printf("%s (first baseman): %s runs\n", playerB1, playerB1Score);
		System.out.printf("%s (second baseman): %s runs\n", playerB2, playerB2Score);
		System.out.printf("%s (third baseman): %s runs\n", playerB3, playerB3Score);
		System.out.printf("the %s has %s runs in total.\n\n", teamB, teamBScore);

		// Defines the graphics as variables
		String teamAGraphic =
			"     ---\n" +
			"   =======\n" +
			"   | X X |\n" +
			"   |  /  |\n" +
			"   |(---)|\n" +
			"   |-----|\n" +
			"---|     |---\n" +
			"   -------\n";

		String teamBGraphic =
			"     (())\n" +
			"   (((())))\n" +
			"     (())\n" +
			"     |  |\n" +
			"  ---|  |\n" +
			"     |  |----\n" +
			"=====|  |\n" +
			"     |  |\n";

		String neutralGraphic =
			"o:;::loc::c:..\n" +
			"xo:x0000Oo:::;'\n" +
			";;d0KK0O0Kx::::\n" +
			"' d0XXX00KXc:::\n" +
			". c000OOOOo::::\n" +
			"...c0OOO0O;.;::\n" +
			" .;l0000o...,::\n" +
			".:oooxkxo:;;:::\n" +
			"llllloooolc':''\n";

		// Conditional to decide who won the contest
		int scoreWonDifference; // Variable shows how much the winning team won by
		if(teamAScore > teamBScore) // Scenario in which teamA wins
		{
			scoreWonDifference = teamAScore - teamBScore;
			System.out.printf("The %s won by %s runs!\n\n", teamA, scoreWonDifference);
			System.out.print(teamAGraphic);
		}
		else if(teamAScore == teamBScore) // Scenario in which there is a tie
		{
			System.out.print("I have no strong feelings one way or the other.\n\n");
			System.out.print(neutralGraphic);
		}
		else // Scenario in which teamB wins
		{
			scoreWonDifference = teamBScore - teamAScore;
			System.out.printf("The %s won by %s runs!\n\n", teamB, scoreWonDifference);
			System.out.print(teamBGraphic);
		}
	}
}
/* This program calculates the winning soccer team
 * Baseball:
 * Based on input of 2 soccer team names and 3 soccer players per team (6 total)
 * Statistics:
 * 	Striker can score 3 goals exclusive
 * 	Left winger can score 5 goals exclusive
 * 	Right winger can score 7 goals exclusive
 * The goals scored by each player are totaled up into the full score
 */

import java.util.Scanner; // Imports the Scanner module

public class FeigenbaumSoccer
{
	public static void main(String[] args)
	{
		// Tells the client about the program
		System.out.print("This program outputs fantasy soccer satistics\n");
		System.out.print("The score of a team is calculated based on the scores of the three inputted players.\n");
		System.out.print("The scores of the three players are totaled up to create the overall team score.\n");
		System.out.print("The team with the highest total score wins the simulation.\n\n");

		//Opens Scanner to collect client input
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);

		// Collects user input for teamA
		System.out.print("What is the name of your soccer team?\n=> ");
		String teamA = scanString.nextLine();
		System.out.print("What is the name of the striker?\n=> ");
		String playerA1 = scanString.nextLine();
		System.out.print("What is the name of the left winger?\n=> ");
		String playerA2 = scanString.nextLine();
		System.out.print("What is the name of the right winger?\n=> ");
		String playerA3 = scanString.nextLine();

		// Declares player score variables for team A
		int playerA1Score = (int) (Math.random() * 3) ;
		int playerA2Score = (int) (Math.random() * 5);
		int playerA3Score = (int) (Math.random() * 7);
		int teamAScore = playerA1Score + playerA2Score + playerA3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamA);
		System.out.printf("%s (striker): %s goals\n", playerA1, playerA1Score);
		System.out.printf("%s (left winger): %s goals\n", playerA2, playerA2Score);
		System.out.printf("%s (right winger): %s goals\n", playerA3, playerA3Score);
		System.out.printf("the %s has %s goals in total.\n\n", teamA, teamAScore);

		// Collects user input for teamB
		System.out.printf("What team would you like to compare to the %s?\n=> ", teamA);
		String teamB = scanString.nextLine();
		System.out.print("What is the name of the striker?\n=> ");
		String playerB1 = scanString.nextLine();
		System.out.print("What is the name of the left winger?\n=> ");
		String playerB2 = scanString.nextLine();
		System.out.print("What is the name of the right winger?\n=> ");
		String playerB3 = scanString.nextLine();

		// Closes scanners to prevent resource leak
		scanString.close();
		scanInt.close();

			// Declares player score variables for team A
		int playerB1Score = (int) (Math.random() * 3);
		int playerB2Score = (int) (Math.random() * 5);
		int playerB3Score = (int) (Math.random() * 7);
		int teamBScore = playerB1Score + playerB2Score + playerB3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamB);
		System.out.printf("%s (striker): %s goals\n", playerB1, playerB1Score);
		System.out.printf("%s (left winger): %s goals\n", playerB2, playerB2Score);
		System.out.printf("%s (right winger): %s goals\n", playerB3, playerB3Score);
		System.out.printf("the %s has %s goals in total.\n\n", teamB, teamBScore);

		// Defines the graphics as variables
		String teamAGraphic =
			"     ---\n" +
			"   =======\n" +
			"   | X X |\n" +
			"   |  /  |\n" +
			"   |(---)|\n" +
			"   |-----|\n" +
			"---|     |---\n" +
			"   -------\n";

		String teamBGraphic =
			"     (())\n" +
			"   (((())))\n" +
			"     (())\n" +
			"     |  |\n" +
			"  ---|  |\n" +
			"     |  |----\n" +
			"=====|  |\n" +
			"     |  |\n";

		String neutralGraphic =
			"o:;::loc::c:..\n" +
			"xo:x0000Oo:::;'\n" +
			";;d0KK0O0Kx::::\n" +
			"' d0XXX00KXc:::\n" +
			". c000OOOOo::::\n" +
			"...c0OOO0O;.;::\n" +
			" .;l0000o...,::\n" +
			".:oooxkxo:;;:::\n" +
			"llllloooolc':''\n";

		// Conditional to decide who won the contest
		int scoreWonDifference; // Variable shows how much the winning team won by
		if(teamAScore > teamBScore) // Scenario in which teamA wins
		{
			scoreWonDifference = teamAScore - teamBScore;
			System.out.printf("The %s won by %s goals!\n\n", teamA, scoreWonDifference);
			System.out.print(teamAGraphic);
		}
		else if(teamAScore == teamBScore) // Scenario in which there is a tie
		{
			System.out.print("I have no strong feelings one way or the other.\n\n");
			System.out.print(neutralGraphic);
		}
		else // Scenario in which teamB wins
		{
			scoreWonDifference = teamBScore - teamAScore;
			System.out.printf("The %s won by %s goals!\n\n", teamB, scoreWonDifference);
			System.out.print(teamBGraphic);
		}
	}
}
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

public class FeigenbaumU2 {
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

public class FeigenbaumU2 {
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

/*
 * Mitch Feigenbaum
 * Period 5
 * November 30, 2021
 * On my honor, I pledge that I have neither given nor received unauthorized assistance on this assignment or test.
 */
import java.util.Scanner;

/**
 * This class contains methods to encrypt and decrypt strings as well as a main
 * method which enables a user to encrypt and decrypt strings through a cli.
 */
public class FeigenbaumU3 {
	/* Defines alphabet */
	private static String alphabetLower = "abcdefghijklmnopqrstuvwxyz";
	private static String alphabetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	/**
	 * Creates a cli interface for encrypting or decrypting strings based on user
	 * defined parameters. This method first opens scanners to collect user input.
	 * The program then offers documentation of the program to the user with a
	 * description briefly describing program input and output. The method then
	 * proceeds to collect parameters from the user.
	 * <p>
	 * The program proceeds the ask the user to enter a message and shift. The shift
	 * is immediately moded by 26 and will prompt the user to re-enter their shift
	 * if it is 0 or a multiple of 26. Then the user will be prompted to decide
	 * whether they wish to encrypt or decrypt the string. The program will then
	 * enter a do-while loop in which the user may decide whether to encrypt or
	 * decrypt their string and will be returned their tranformed string. If the
	 * user did not enter a valid option then the loop will prompt the user again to
	 * enter a valid option.
	 *
	 * @param args added for semantics
	 * @see encrypt
	 * @see decrypt
	 */
	public static void main(String[] args) {
		Scanner scanChar = new Scanner(System.in);
		Scanner scanNum = new Scanner(System.in);
		System.out.println("Program input: A string, a shift, encrypt/decrypt option");
		System.out.println("Program output: Either a decrypted or encrypted string based on user input");
		System.out.print("Enter a string: ");
		String message = scanChar.nextLine();
		System.out.print("Enter a shift: ");
		int key;
		do {
			key = scanNum.nextInt() % 26;
			if (key == 0)
				System.out.print("Please enter a number which is not a multiple of 26: ");
		} while (key == 0);
		String mode = "";
		do {
			System.out.print("Type 'e' to encrypt the string or 'd' to decrypt the string: ");
			mode = scanChar.nextLine().toLowerCase();
			if (mode.equals("e"))
				System.out.printf("Your encrypted string is: %s%n", encrypt(message, key));
			else if (mode.equals("d"))
				System.out.printf("Your decrypted string is: %s%n", decrypt(message, key));
			else
				System.out.print("Please enter your choice again: ");
		} while (!mode.equals("e") && !mode.equals("d"));
	}

	/**
	 * Returns an encrypted string based on a shift and unencrypted message. The
	 * method encrypts the string by looping through the string, finding the index
	 * at which the current character of the string is at in the alphabet and then
	 * adds a shift to this index to find the letter which corresponds to the proper
	 * shift. This letter is then added to a string which is returned to the user
	 * once the string has been iterated through.
	 * <p>
	 * This method also contains support for lowercase and uppercase letters, which
	 * allows for the passage of case-sensitive strings. In the event that a
	 * non-alphabetical character is iterated upon the character is simply added to
	 * the encrypted string. This method can also be used to decrypt strings by
	 * passing 26 minus the shift to the key parameter. This is what the decrypt
	 * method does behind the scenes.
	 *
	 * @param message an unencrypted string
	 * @param key     a shift by which to encrypt the string
	 * @return a string encrypted by a shift of key
	 * @see decrypt
	 */
	public static String encrypt(String message, int key) {
		String encryptedString = "";
		char currentChar;
		for (int i = 0; i < message.length(); i++) {
			currentChar = message.charAt(i);
			if (alphabetLower.indexOf(currentChar) != -1)
				encryptedString += alphabetLower
						.charAt((alphabetLower.indexOf(currentChar) + key) % 26);
			else if (alphabetUpper.indexOf(currentChar) != -1)
				encryptedString += alphabetUpper
						.charAt((alphabetUpper.indexOf(currentChar) + key) % 26);
			else
				encryptedString += currentChar;
		}
		return encryptedString;
	}

	/**
	 * Returns a decrypted string based on a shift and encrypted message. The method
	 * uses the encrypt method to decrypt the string by using a shift of 26 minus
	 * the shift used to encrypt the string.
	 *
	 * @param message an encrypted string
	 * @param key     a shift to decrypt the string with
	 * @return a string decrypted by a shift of key
	 * @see encrypt
	 */
	public static String decrypt(String message, int key) {
		return encrypt(message, 26 - key);
	}
}

/*
 * Mitch Feigenbaum
 * Period 5
 * February 1, 2022
 * On my honor, I pledge that I have neither given nor received unauthorized assistance on this assignment or test.
 */
import java.util.Calendar;
import java.util.Scanner;

/**
 * The FeigenbaumU4 class is a class that provides methods for checking if a
 * given month and date are valid, getting a calendar date in ordinal form,
 * getting an astrological sign with a message, and a CLI in which a client
 * can run the program (the main method).
 */
public class FeigenbaumU4 {
	/**
	 * The main method is a CLI that allows a client to interactively
	 * input their birthdate to get an output of their astrological sign
	 * with a unique message. The method first creates a Calendar object.
	 * This calendar object is used to store the current month and
	 * date into the todaymonth and todayday variables. A scanner is
	 * opened to collect the clients input. Then the program enters
	 * a do while loop that prompts the client to enter their birthdate,
	 * checks that the date is valid with the checkDate method, and stores
	 * The client's birthmonth and birthdate into separate integer
	 * variables. After the client's birthmonth and birthday are defined,
	 * the program checks if it is the client's birthday and if so
	 * initializes a birthday message. Finally a print format statement is
	 * created that displays the client's age in ordinal form (using the
	 * birthdate method), a birthday message in the event that the current
	 * date is their birthday, their astrological sign, and a unique
	 * message (using the sign method)
	 * <p>
	 *
	 * @param args added for semantics
	 * @see checkDate
	 * @see birthdate
	 * @see sign
	 */
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		int todaymonth = today.get(Calendar.MONTH) + 1;
		int todayday = today.get(Calendar.DAY_OF_MONTH);
		Scanner scanNum = new Scanner(System.in);
		int birthMonth;
		int birthDay;
		do {
			System.out.print("What month were you born in? (number): ");
			birthMonth = scanNum.nextInt();
			System.out.print("What day (number): ");
			birthDay = scanNum.nextInt();
			if (!checkDate(birthMonth, birthDay))
				System.err.println("Error: date does not exist.");
		} while (!checkDate(birthMonth, birthDay));
		String birthDayMessage = "";
		if (birthMonth == todaymonth && birthDay == todayday)
			birthDayMessage = "Happy Birthday to you!";
		System.out.printf("Your birthday is:\t%s\t%s%n%s",
				birthdate(birthMonth, birthDay), birthDayMessage, sign(birthMonth, birthDay));
	}

	/**
	 * The birthdate method is used to return a textual version of a date
	 * based on an integer representation of the month and date. First an
	 * array of all 12 calendar months is initialized. then a String
	 * format statement is returned that contains a textual representation
	 * of the month, and an ordinal representation of the date. (using the
	 * toOrdinal method)
	 * <p>
	 *
	 * @param m An integer representation of the month
	 * @param d An integer representation of the date
	 * @return a formatted string containing the month and date
	 * @see toOrdinal
	 */
	public static String birthdate(int m, int d) {
		String[] months = {
				"January",
				"February",
				"March",
				"April",
				"May",
				"June",
				"July",
				"August",
				"September",
				"October",
				"November",
				"December",
		};
		return String.format("%s %s", months[m - 1], toOrdinal(d));
	}

	/**
	 * The method sign provides an astrological sign and horoscope based
	 * on a provided month and date. The method iterates through a list of
	 * if statements that return the astrological sign and horoscope of a
	 * certain character (eg Aquarius) provided that the month and date
	 * are within a certain range of dates in which the character is
	 * valid. If the criteria of an if statement is fulfilled the method
	 * returns a string with an astrological sign and horoscope formatted
	 * with tabs for alignment. The tabstops are meant to be used in
	 * conjunction with the main method's print format statement which
	 * also displays the users birthday and a happy birthday message.
	 * <p>
	 *
	 * @param m An integer representation of the month
	 * @param d An integer representation of the date
	 * @return A string with the astrological sign and horoscope for the
	 *         provided month and day
	 * @see main
	 */
	public static String sign(int m, int d) {
		return (m == 1 && d >= 20) || (m == 2 && d <= 18)
			? "Your sign is:\t\tAquarius\n" + "Horoscope:\t\tYou must hold back your desires and temptations."
			: (m == 2 && d >= 19) || (m == 3 && d <= 20)
			? "Your sign is:\t\tPisces\n" + "Horoscope:\t\tSoon you will make amends with all you have wronged."
			: (m == 3 && d >= 21) || (m == 4 && d <= 19)
			? "Your sign is:\t\tAries\n" + "Horoscope:\t\tYour home planet will be destroyed."
			: (m == 4 && d >= 20) || (m == 5 && d <= 20)
			? "Your sign is:\t\tTaurus\n" + "Horoscope:\t\tHave faith in the plan."
			: (m == 5 && d >= 21) || (m == 6 && d <= 20)
			? "Your sign is:\t\tGemini\n" + "Horoscope:\t\tThe best days of your life are already over."
			: (m == 6 && d >= 21) || (m == 7 && d <= 22)
			? "Your sign is:\t\tCancer\n" + "Horoscope:\t\tYou will hold back your own success."
			: (m == 7 && d >= 23) || (m == 8 && d <= 22)
			? "Your sign is:\t\tLeo\n" + "Horoscope:\t\tYou will achieve great success in the textile industry."
			: (m == 8 && d >= 23) || (m == 9 && d <= 22)
			? "Your sign is:\t\tVirgo\n" + "Horoscope:\t\tThere is light at the end of your sorrow."
			: (m == 9 && d >= 23) || (m == 10 && d <= 22)
			? "Your sign is:\t\tLibra\n" + "Horoscope:\t\tTerrible things are going to happen."
			: (m == 10 && d >= 23) || (m == 11 && d <= 21)
			? "Your sign is:\t\tScorpio\n" + "Horoscope:\t\tYour days are numbered. Keep watch of all enemies."
			: (m == 11 && d >= 22) || (m == 12 && d <= 21)
			? "Your sign is:\t\tSagittarius\n" + "Horoscope:\t\tSomeday you will travel into the multiverse."
			: (m == 12 && d >= 22) || (m == 1 && d <= 19)
			? "Your sign is:\t\tCapricorn\n" + "Horoscope:\t\tYou will achieve inner peace."
			: null;
	}

	/**
	 * The toOrdinal method can convert a number (from 1 to 39) from
	 * integer form into ordinal form. Based on a number's position in a
	 * certain range (eg 11-19), an element is chosen from an array which
	 * represents a number's ordinal form. If a number is not composed of
	 * only one word (eg twenty-sixth), a format string is returned
	 * containing the numbers tenth place, a dash, and the singular
	 * number that represents the digit in its ones place.
	 * <p>
	 *
	 * @param d a digit 1-39
	 * @return an ordinal number
	 */
	public static String toOrdinal(int d) {
		String[] singleDays = {
				"first",
				"second",
				"third",
				"fourth",
				"fifth",
				"sixth",
				"seventh",
				"eighth",
				"ninth",
		};
		String[] teens = {
				"eleventh",
				"twelfth",
				"thirteenth",
				"fourteenth",
				"fifteenth",
				"sixteenth",
				"seventeenth",
				"eighteenth",
				"nineteenth",
		};
		String[] tenths = {
				"tenth",
				"twentieth",
				"thirtieth",
		};
		String[] tens = {
				"twenty",
				"thirty",
		};
		return (d < 10)
			? singleDays[d - 1]
			: (d > 10 && d < 20)
			? teens[d - 11]
			: (d % 10 == 0)
			? tenths[d / 10 - 1]
			: String.format("%s-%s", tens[d / 10 - 2], singleDays[d % 10 - 1]);
	}

	/**
	 * The checkDate method verifies whether a current month and date are
	 * possible calendar positions. It iterates through a series of
	 * impossible criteria that will return false if they are applicable
	 * to the provided month and day. The date is first checked that
	 * the month is between 1 and 12 and that the date is at least one.
	 * Then the date is checked to verify that it is not too large for the
	 * current calendar month. If none of the unverifiable criteria are
	 * met, the method will return true
	 * <p>
	 *
	 * @param m the current month in integer form
	 * @param d the current day in integer form
	 * @return true if the provided month and day are valid
	 */
	public static boolean checkDate(int m, int d) {
		return !(m < 1
				|| m > 12
				|| d < 1
				|| d > 31
				|| ((m == 4
						|| m == 6
						|| m == 9
						|| m == 11)
						&& d > 30)
				|| (m == 2
						&& d > 29));
	}
}
/*
*Name: Mitch Feigenbaum
*Date: 8/27/2021
*Period: 5
*
*Program Description:
*
*Algorithm:
*
*On my honor, by submitting this code I am claiming that it was written
and tested by me.
*Any help I received was in the form of asking questions for clarification
and no direct copying was done.
*
*/
import java.io.*;
public class HelloWorld
{
   public static void main(String[] args)
   {
      System.out.println("Hello, world!"); // Prints hello world to standard output
   }
}
