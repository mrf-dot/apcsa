
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
