.TL
APCSA - Mixing numeric and string output
.AU
Mitch Feigenbaum
.AI
Lake Braddock Secondary School
.NH
What is the output after running the following code?
.LP
.`` java
double x = 5.5;
int y = 2;
System.out.println(x/y);
.``
\m[red]2.75\m[]
\m[black]
.NH
What is the output after running the following code?\m[]
.`` java
int x = 6, y = 3;
System.out.println(x + y + "bunny");
// Outputs 9bunny
System.out.println("bunny" + x + y);
// Outputs bunny63
System.out.println("bunny" + (x+y));
// Outputs bunny9
.``
\m[black]
.NH
What is the output after running the following code?
.`` java
int x = 8;
x = x/5;
x++;
x/=3;
System.out.println("The answer is: " + x + 3);
.``
.LP
\m[red]The answer is: 03\m[]
\m[black]
.NH
Write the code to ask the user their name and age and print out how many years until they are 100. Make age an int, not a double. (it should work for any name and age)\m[]
.LP
.`` java
import java.util.Scanner;

public class tillHundred
{
	public static void main(String[] args)
	{
		// Opens scanner for string input
		Scanner scanString = new Scanner(System.in);
		// Opens scanner for integer input
		Scanner scanInt = new Scanner(System.in);
		// Prompts user to input their name
		System.out.print("Hello, what is your name?\n=> ");
		// Saves user input to variable "name"
		String name = scanString.nextLine();
		// Prompts user to enter their age
		System.out.printf("Hello %s, how old are you?\n=> ", name);
		// Saves user input to variable age
		int age = scanInt.nextInt();
		// Creates variable "until100", which stores 100 subtracted by client age
		int until100 = 100 - age;
		// Prints the users name and time untill they turn 100
		System.out.printf("%s, you will be 100 in %s years.\n", name, until100);
	}
}
.``
\m[black]
.NH
Which of the following outputs:

j

	a

		v

			a\m[]
.LP
\m[red]d. System.out.println("j\\n\\ta\\n\\t\\tv\\n\\t\\t\\ta")\m[]
