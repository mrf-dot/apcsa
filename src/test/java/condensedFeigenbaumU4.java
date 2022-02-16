import java.util.Calendar;
import java.util.Scanner;
public class condensedFeigenbaumU4 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		int todaymonth = today.get(Calendar.MONTH) + 1, todayday = today.get(Calendar.DAY_OF_MONTH);
		Scanner scanNum = new Scanner(System.in);
		int birthMonth, birthDay;
		do {
			System.out.print("What month were you born in? (number): ");
			birthMonth = scanNum.nextInt();
			System.out.print("What day (number): ");
			birthDay = scanNum.nextInt();
			if (!checkDate(birthMonth, birthDay))
				System.err.println("Error: date does not exist.");
		} while (!checkDate(birthMonth, birthDay));
		System.out.printf("Your birthday is:\t%s\t%s%n%s", birthdate(birthMonth, birthDay), birthMonth == todaymonth && birthDay == todayday ? "Happy Birthday to you!" : "", sign(birthMonth, birthDay));
	}
	public static String birthdate(int m, int d) {
		String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return String.format("%s %s", months[m - 1], toOrdinal(d));
	}
	public static String sign(int m, int d) {
		return (m == 1 && d >= 20) || (m == 2 && d <= 18) ? "Your sign is:\t\tAquarius\nHoroscope:\t\tYou must hold back your desires and temptations." : (m == 2 && d >= 19) || (m == 3 && d <= 20) ? "Your sign is:\t\tPisces\nHoroscope:\t\tSoon you will make amends with all you have wronged." : (m == 3 && d >= 21) || (m == 4 && d <= 19) ? "Your sign is:\t\tAries\nHoroscope:\t\tYour home planet will be destroyed." : (m == 4 && d >= 20) || (m == 5 && d <= 20) ? "Your sign is:\t\tTaurus\nHoroscope:\t\tHave faith in the plan." : (m == 5 && d >= 21) || (m == 6 && d <= 20) ? "Your sign is:\t\tGemini\nHoroscope:\t\tThe best days of your life are already over." : (m == 6 && d >= 21) || (m == 7 && d <= 22) ? "Your sign is:\t\tCancer\nHoroscope:\t\tYou will hold back your own success." : (m == 7 && d >= 23) || (m == 8 && d <= 22) ? "Your sign is:\t\tLeo\nHoroscope:\t\tYou will achieve great success in the textile industry." : (m == 8 && d >= 23) || (m == 9 && d <= 22) ? "Your sign is:\t\tVirgo\nHoroscope:\t\tThere is light at the end of your sorrow." : (m == 9 && d >= 23) || (m == 10 && d <= 22) ? "Your sign is:\t\tLibra\nHoroscope:\t\tTerrible things are going to happen." : (m == 10 && d >= 23) || (m == 11 && d <= 21) ? "Your sign is:\t\tScorpio\nHoroscope:\t\tYour days are numbered. Keep watch of all enemies." : (m == 11 && d >= 22) || (m == 12 && d <= 21) ? "Your sign is:\t\tSagittarius\nHoroscope:\t\tSomeday you will travel into the multiverse." : (m == 12 && d >= 22) || (m == 1 && d <= 19) ? "Your sign is:\t\tCapricorn\nHoroscope:\t\tYou will achieve inner peace." : null;
	}
	public static String toOrdinal(int d) {
		String[] singleDays = {"first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth"}, teens = {"eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth", "sixteenth", "seventeenth", "eighteenth", "nineteenth"}, tenths = {"tenth", "twentieth", "thirtieth"}, tens = { "twenty", "thirty"};
		return (d < 10) ? singleDays[d - 1] : (d > 10 && d < 20) ? teens[d - 11] : (d % 10 == 0) ? tenths[d / 10 - 1] : String.format("%s-%s", tens[d / 10 - 2], singleDays[d % 10 - 1]);
	}
	public static boolean checkDate(int m, int d) {
		return !(m < 1 || m > 12 || d < 1 || d > 31 || ((m == 4 || m == 6 || m == 9 || m == 11) && d > 30) || (m == 2 && d > 29));
	}
}
