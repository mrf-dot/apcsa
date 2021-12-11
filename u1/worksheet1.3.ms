.TL
Worksheet 1.3: Primitive Variables, Number Calculations
.NH
Which of the following is a legal variable name in Java?
.LP
\m[red]ltest, value, initial_amount.\m[]
.NH
Given the following lines appear IN THIS ORDER in a java program
.TS
allbox;
c	c	c.
Code	Will it compile?	If no, why?
int x = 7;	yes
int y = 8.2;	no	The variable is definded as an int and given a double
int z = 9.0;	no	The variable is defined as an int and given a double
int myNum = 0;	yes
int 1stNum = 1;	no	Variables cannot start with a number
int FAVENUM = 18;	yes
double a = 17;	yes
double b = 18.5;	yes
double b = -9.2;	no	A variable cannot be redefined
x = 29;	yes
35 = x;	no	A value cannot be assigned to a raw integer
newNum = 12;	yes
char one = 'g';	yes
char two = '9';	yes
char three = '%';	yes
char four = 'abc';	no	A char must be only on character
int div = 10/myNum;	no	The program cannot divide by 0
.TE
.NH
What is the value of x after \f[B]all the code\f[] is executed?
.LP
\m[red]x = -10\m[]
.NH
What type of variable would you use to:
.NH 2
hold the number of students in a school?
.LP
\m[red]Integer\m[]
.NH 2
hold the exact average number of students per class?
.LP
\m[red]Double\m[]
.NH 2
hold a student's letter grade A, B, C? What if letter grade is A-,C+?
.LP
\m[red]Character to hold A,B, or C. String to hold A- or C+.\m[]
.NH
Given the following code segment, show what prints out after each System.out.println:
.LP
int num1 = 3;

int num2 = num1;

num1 = 7 + 2;

System.out.println(num1); \m[red]// 9\m[]

System.out.println(num2); \m[red]// 3\m[]

num2 += 10;

System.out.println(num1); \m[red]// 9\m[]

System.out.println(num2); \m[red]// 13\m[]
.NH
What is stored in each variable after the following computations are done:
.LP
int var1 = 2 + 3 * 12 / 4 - 1 + 6; var1 = \m[red]16\m[]

int var2 = 13 - 3 * 6 + 10 / 2; var2 = \m[red]0\m[]

int var3 = (21-5) / 4 * 2; var3= \m[red]8\m[]
.NH
Write the code to declare three variables: an int named number, a double named amount and a char named c. Then separately initialize those variables with an appropriate value.
.LP
.`` java
public class declareVariables
{
	public static void main(String args)
	{
		int number; // int named number
		double amount; // double named amount
		char c; // character named c
		number = 2; // initializes number
		amount = 3.5; // initializes amount
		char c = 'c' // initializes c
	}
}
.``
.NH
Write the code to ask the user for their birth year. Then write the code that will calculate how old they are (or will be) this calendar year.
.LP
.`` java
// Imports the scanner library
import java.util.Scanner;

public class calculateYear
{
	public static void main(String[] args)
	{
		// Initializes the scanner
		Scanner scan = new Scanner(System.in);
		// Prompts client to enter their birthyear
		System.out.print("What is your birth year?\n=> ");
		// Initializes birthYear as the integer the client inputted
		int birthYear = scan.nextInt();
		int currentYear = 2021;
		// Calculates how old the client is
		int age = currentYear - birthYear;
	}
}
.``
\m[black]
.NH
Write the code to ask the user for three test grades then use those to calculate the average of their tests.\m[]
.`` java
// Imports the scanner library
import java.util.Scanner;

public class testScores
{
	public static void main(String[] args)
	{
		// Opens a scanner
		Scanner scanDouble = new Scanner();
		// Prompts the user to enter their first test grade
		System.out.print("Enter a test grade\n=> ");
		// Logs user input as variable firstGrade
		double firstGrade = scanDouble.nextDouble();
		// Prompts the user to enter a second grade
		System.out.print("Enter a second grade\n=> ");
		// Logs user input as variable secondGrade
		double secondGrade = scanDouble.nextDouble();
		// Prompts the user to enter a third grade
		System.out.print("Enter a third grade\n=> ");
		// Logs user input as variable thirdGrade
		double thirdGrade = scanDouble.nextDouble();
		// Averages the grades together to produce an averageGrade variable
		double averageGrade = (firstGrade + secondGrade + thirdGrade) / 3;
	}
}
.``
