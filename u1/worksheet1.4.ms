.TL
APCSA-Strings
.NH
What is wrong with the following code?
.LP
.`` java
String s;
System.out.println(s);
.``
\m[red]c. You cannot print a String without setting its value.\m[]
.NH
What is wrong with the following code?
.LP
.`` java
String s = nextLine();
.``
\m[red]c. Should be: String s = scan.nextLine();\m[]
.NH
Which is correct?
.LP
.`` java
String n = scan.nextLine();
.``
\m[red]c. System.out.println("Hi there " + n);\m[]
.NH
To output:

Hi There

With 2 print statements, you would need to use:
.LP
.`` java
System.out.print("Hi ");
System.out.println("There");
.``
.NH
Given the following code segment, show what prints out after each System.out.println:
.LP
.`` java
String one = "car";
String two = one;
one = one + " beep beep";
System.out.println(one); // car beep beep
System.out.println(two); // car
two = "truck";
System.out.println(one); // car beep beep
System.out.println(two); // truck
.``
.NH
Write the code to ask the user to enter their name and print:

	What is your name?

	Hi (the user's name), nice to meet you.
.`` java
import java.util.Scanner;

public class nameAsk
{
	public static void main(String[] args)
	{
		// Opens the scanner
		Scanner scanString = new Scanner(System.in);
		// Prompts the user to enter their name
		System.out.print("What is your name?\n=> ");
		// Stores the user input as the variable "name"
		String name = scanString.nextLine();
		// Prints the users name within a message to standard output
		System.out.printf("Hi %s, nice to meet you.\n", name);
		// Closes scanner to prevent memleak
		scanString.close();
	}
}
.``
\m[black]
.NH
Now create a variable snack and ask the user what their favorite snack is. Then print:

	(the user's name from above), what is your favorite snack?

	(favorite snack) sounds delicious.\m[]
.`` java
import java.util.Scanner;

public class nameAsk
{
	public static void main(String[] args)
	{
		// Opens the scanner
		Scanner scanString = new Scanner(System.in);
		// Prompts the user to enter their name
		System.out.print("What is your name?\n=> ");
		// Stores the user input as the variable "name"
		String name = scanString.nextLine();
		// Prints the users name within a message to standard output
		System.out.printf("Hi %s, nice to meet you.\n", name);
		// Prompts the user to enter their snack
		System.out.print("%s, what is your favorite snack?\n=> ", name);
		// Stores the users snack as a variable
		String snack = scanString.nextLine();
		// Prints the users favorite snack within a message to standard output
		System.out.printf("%s sounds delicious.\n");
		// Closes scanner to prevent memleak
		scanString.close();
	}
}
.``
\m[black]
.NH
Write the code to ask the user to enter 3 names, then print them one line (with spaces between) in reverse order of what they entered. (it should work for any 3 names)\m[]
.`` java
// Imports the scanner module
import java.util.Scanner;

public class threeNames
{
	public static void main(String[] args)
	{
		// Opens a scanner
		Scanner scanString = new Scanner(System.in);
		// Prompts user to enter a name
		System.out.print("Enter a name.\n=> ");
		// Collects user input into string
		String name1 = scanString.nextLine();
		// Prompts user to enter a name
		System.out.print("Enter another name.\n=> ");
		// Collects user input into string
		String name2 = scanString.nextLine();
		// Prompts user to enter a name
		System.out.print("Enter a third name.\n=> ");
		// Prompts user to enter a name
		String name3 = scanString.nextLine();
		// Prints names in reverse order to standard output
		System.out.printf("%s %s %s%n", name3, name2, name1)
	}
}
.``
