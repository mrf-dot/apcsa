```java
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

public class feigenbaumSoccer
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
```
