import java.util.Scanner;

public class Test
{
	public static void main(String[] args)
	{
		/* Opens scanner for numerical input */
		Scanner scanNum = new Scanner(System.in);
		/* Prompts the user to enter two numbers */
		System.out.print(
				"Enter two numbers (separated by spaces)\n" +
				"=> "
				);
		/* Collects user inputted numbers into variables */
		int num1 = scanNum.nextInt(), num2 = scanNum.nextInt();
		/* While loop to display all even numbers between num1 and num2 */
		while (num1 <= num2)
		{
			/* Prints num1 to console if it is divisible by two (even) */
			if (num1 % 2 == 0)
			{
				System.out.printf("%d ", num1);
			}
			/* Increments num1 */
			num1++;
		}
	}
}

// Chad version with a for loop
class BetterProgram {
	public static void main(String[] args) {
		Scanner scanNum = new Scanner(System.in);
		System.out.print("Enter two numbers (separated by spaces\n"
				+ "=> ");
		int num1 = scanNum.nextInt(), num2 = scanNum.nextInt();
		for (int i = num1; i < num2; i++)
			if (i % 2 == 0)
				System.out.printf("%d ", i);
		scanNum.close();
	}
}
