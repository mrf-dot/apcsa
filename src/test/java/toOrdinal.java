public class toOrdinal {
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
	public static String ordinal(int d) {
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
}
