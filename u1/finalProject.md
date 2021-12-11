```java
/* This program calculates the winning baseball team
 * Baseball:
 * Based on input of 2 baseball team names and 3 baseball players per team (6 total)
 * Statistics:
 * 	First Baseman can score 10 runs exclusive
 * 	Second Baseman can score 15 runs exclusive
 * 	Third Baseman can score 20 runs exclusive
 * The runs scored by each player are totaled up into the full score
 * Soccer:
 * Based on input of 2 soccer teams and 3 soccer players per team
 * Statistics:
 * 	Striker can score 3 goals exclusive
 * 	Left Winger can score 5 goals exclusive
 * 	Right Winger can score 7 goals exclusive
 * The goals of each player are totaled up into the full score
 */

import java.util.Scanner; // Imports the Scanner module
import java.util.Random; // Imports random number generation

public class finalProject
{
	public static void main(String[] args)
	{
		// Tells the client about the program
		System.out.print("This program outputs fantasy baseball and soccer statistics.\n");
		System.out.print("The score of a team is calculated based on the scores of the three inputted players.\n");
		System.out.print("The scores of the three players are totaled up to create the overall team score.\n");
		System.out.print("The team with the highest total score wins the simulation.\n\n");

		//Opens Scanner to collect client input
		Scanner scanString = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);

		// defines the formatted select screen
		String selectScreen =
			"Which sport would you like to evaluate?\n" +
			"  1. Baseball\n" +
			"  2. Soccer\n" +
			"=> ";

		// Collects user input regarding selection of sport
		System.out.print(selectScreen);
		int sportSelection = scanInt.nextInt();

		//Initialize sport specific variables
		String sport;
		String position1;
		String position2;
		String position3;
		String scoreUnit;

		// Conditional to set sport specific variables
		if(sportSelection == 1)
		{
			sport = "baseball";
			position1 = "first baseman";
			position2 = "second baseman";
			position3 = "third baseman";
			scoreUnit = "run";
		}
		else
		{
			sport = "soccer";
			position1 = "striker";
			position2 = "left winger";
			position3 = "right winger";
			scoreUnit = "goal";
		}

		// Collects user input for teamA
		System.out.printf("What is the name of your %s team?\n=> ", sport);
		String teamA = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position1);
		String playerA1 = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position2);
		String playerA2 = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position3);
		String playerA3 = scanString.nextLine();

		// Creates random number generator
		Random generator = new Random();

		// Declares score variables for team A
		int playerA1Score;
		int playerA2Score;
		int playerA3Score;
		int teamAScore;

		// Conditional to determine player score
		if(sport == "baseball")
		{
			playerA1Score = generator.nextInt(10);
			playerA2Score = generator.nextInt(15);
			playerA3Score = generator.nextInt(20);
		}
		else
		{
			playerA1Score = generator.nextInt(3);
			playerA2Score = generator.nextInt(5);
			playerA3Score = generator.nextInt(7);
		}
		teamAScore = playerA1Score + playerA2Score + playerA3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamA);
		System.out.printf("%s (%s): %s %ss\n", playerA1, position1, playerA1Score, scoreUnit);
		System.out.printf("%s (%s): %s %ss\n", playerA2, position2, playerA2Score, scoreUnit);
		System.out.printf("%s (%s): %s %ss\n", playerA3, position3, playerA3Score, scoreUnit);
		System.out.printf("The %s have %s %ss in total.\n\n", teamA, teamAScore, scoreUnit);

		// Collects user input for teamB
		System.out.printf("What team would you like to compare to the %s?\n=> ", teamA);
		String teamB = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position1);
		String playerB1 = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position2);
		String playerB2 = scanString.nextLine();
		System.out.printf("What is the name of the %s?\n=> ", position3);
		String playerB3 = scanString.nextLine();

		// Closes scanners to prevent resource leak
		scanString.close();
		scanInt.close();

		/// Declares score variables for team B
		int playerB1Score;
		int playerB2Score;
		int playerB3Score;
		int teamBScore;

		// Conditional to determine player score
		if(sport == "baseball")
		{
			playerB1Score = generator.nextInt(10);
			playerB2Score = generator.nextInt(15);
			playerB3Score = generator.nextInt(20);
		}
		else
		{
			playerB1Score = generator.nextInt(3);
			playerB2Score = generator.nextInt(5);
			playerB3Score = generator.nextInt(7);
		}
		teamBScore = playerB1Score + playerB2Score + playerB3Score;

		// Prints team statistics to standard output
		System.out.printf("\nStatistics for the %s:\n", teamB);
		System.out.printf("%s (%s): %s %ss\n", playerB1, position1, playerB1Score, scoreUnit);
		System.out.printf("%s (%s): %s %ss\n", playerB2, position2, playerB2Score, scoreUnit);
		System.out.printf("%s (%s): %s %ss\n", playerB3, position3, playerB3Score, scoreUnit);
		System.out.printf("The %s have %s %ss in total.\n\n", teamB, teamBScore, scoreUnit);

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
			System.out.printf("The %s won by %s %ss!\n\n", teamA, scoreWonDifference, scoreUnit);
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
			System.out.printf("The %s won by %s %ss!\n\n", teamB, scoreWonDifference, scoreUnit);
			System.out.print(teamBGraphic);
		}
	}
}
