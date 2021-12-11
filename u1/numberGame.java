/* Picks a number at random and has the user try to guess that number
 * Program steps:
 * 	Generate random number
 * 	Ask the user to try and guess that number
 * 	Evaluate whether the users guess was too high, too low, or correct
 * 	display to the user result of their guess
 * 	If the user wins, tell them how many tries it took and give congratulations
 * 	If the user tries more than 100 times, tell the user they lost
 */

/* Defines import statements */
import java.util.Scanner;

public class numberGame
{
	public static boolean evalGuess(int potentialNumber, int realNumber)
		/* Evaluates whether guess is right and prints result to user */
		{
			boolean correctGuess;

			if(potentialNumber < realNumber)
			{
				System.out.print("Your guess is too low.\n");
				correctGuess = false;
			}
			else if(potentialNumber > realNumber)
			{
				System.out.print("Your guess is too high.\n");
				correctGuess = false;
			}
			else
			{
				System.out.print("\n");
				correctGuess = true;
			}
			return correctGuess;
		}

	public static void main(String[] args)
	{
		/* Outputs introductary message */
		System.out.print(
				"This game is designed to test your number guessing skills.\n" +
				"You will have 100 tries to guess the number I am thinking of.\n\n" +
				"Try to guess the number I am thinking of!\n"
				);

		/* Defines number variables for program */
		int correctNumber = (int) (Math.random() * 10000 + 1);
		int guesses = 0;
		boolean correct = false;
		int currentGuess;

		/* Opens Scanner */
		Scanner scanInt = new Scanner(System.in);

		/* Main guessing section */
		while(guesses < 100 && !correct)
		{
			System.out.print("=> ");
		  currentGuess = scanInt.nextInt();
			correct = evalGuess(currentGuess, correctNumber);
			guesses += 1;
		}

		/* Closes scanner to prevent memleak */
		scanInt.close();

		/* Evaluates whether the person won or lost */
		if(correct == true)
		{
			System.out.printf("Congratulations! You won in %d tries\n", guesses);
		}
		else
		{
			System.out.printf("You lost! The correct answer was %d\n", correctNumber);
		}
	}
}
