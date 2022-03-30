/*
 * Mitch Feigenbaum
 * Period 5
 * On my honor, I pledge that I have neither given nor received unauthorized assistance on this assignment or test.
 */

/**
 * This class is a temperature object. Within it contains constructors which
 * take in the temperature, unit of that temperature, and the increment by
 * which that temperature can be changed. There are functions to get the
 * temperature; print the temperature in context with its unit and increment;
 * convert the temperature to any of the four widely used temperature formats;
 * increase and decrease the temperature; display The temperature in a random
 * unit.
 */
public class FeigenbaumU5 {
	private double temperature;
	private char unit;
	private int increment;

	/**
	 * Initializes the temperature object at zero degrees Celsius with an
	 * increment of one
	 */
	public FeigenbaumU5() {
		this(0d, 'c', 1);
	}

	/**
	 * Initializes the temperature object with a raw temperature, unit, and
	 * an increment. The unit will default to Celsius (c) if the unit
	 * entered is not valid. The valid units are:
	 * <ul>
	 * <li>c (Celsius)</li>
	 * <li>f (Fahrenheit)</li>
	 * <li>k (Kelvin)</li>
	 * <li>r (Rankine)</li>
	 * </ul>
	 *
	 * @param temperature the raw temperature
	 * @param unit lowercase first letter of the temperature format
	 * @param increment quantity by which the temperature can change
	 */
	public FeigenbaumU5(double temperature, char unit, int increment) {
		this.temperature = temperature;
		this.unit = "cfkr".indexOf(unit) == -1 ? 'c' : unit;
		this.unit = unit;
		this.increment = increment;
	}

	/**
	 * @return the raw temperature
	 */
	public double getTemperature() {
		return temperature;
	}

	/**
	 * @return the lowercase first letter of the temperature format
	 */
	public char getUnit() {
		return unit;
	}

	/**
	 * @return The temperature converted to Fahrenheit
	 */
	public double getFahrenheit() {
		return getCelsius() * (9 / 5) + 32;
	}

	/**
	 * @return The temperature converted to Kelvin
	 */
	public double getKelvin() {
		return getCelsius() + 273.15;
	}

	/**
	 * @return The temperature converted to Rankine
	 */
	public double getRankine() {
		return getCelsius() * (9 / 5) + 491.67;
	}

	/**
	 * Calculates the current temperature in Celsius and returns it. This
	 * Method's main purpose is to act as a pivot for the other temperature
	 * methods. By first converting the temperature to Celsius first, a
	 * method only needs to consider the temperature rather than the unit
	 * and therefore only needs to calculate a conversion from the given
	 * temperature in one format. This method calculates the temperature
	 * in Celsius of the initialized object for all four format scenarios.
	 * If the format is invalid, null is returned.
	 *
	 * @return The temperature converted to Celsius
	 */
	public double getCelsius() {
		return unit == 'c'
			? temperature
			: unit == 'f'
			? (temperature - 32) * (5 / 9)
			: unit == 'k'
			? temperature - 273.15
			: unit == 'r'
			? (temperature - 491.67) * (5 / 9)
			: null;
	}

	/**
	 * @return the increment of the initialized object
	 */
	public int getIncrement() {
		return increment;
	}

	/**
	 * Decrease the temperature by the increment
	 */
	public void decreaseTemperature() {
		temperature -= increment;
	}

	/**
	 * Increase the temperature by the increment
	 */
	public void increaseTemperature() {
		temperature += increment;
	}

	/**
	 * Convert the temperature to Celsius and change the unit to c
	 */
	public void toCelsius() {
		temperature = getCelsius();
		unit = 'c';
	}

	/**
	 * Convert the temperature to Fahrenheit and change the unit to f
	 */
	public void toFahrenheit() {
		temperature = getFahrenheit();
		unit = 'f';
	}

	/**
	 * Convert the temperature to Kelvin and change the unit to k
	 */
	public void toKelvin() {
		temperature = getKelvin();
		unit = 'k';
	}

	/**
	 * Convert the temperature to Rankine and change the unit to r
	 */
	public void toRankine() {
		temperature = getRankine();
		unit = 'r';
	}

	/**
	 * Set the quantity by which the temperature may be increased or decreased
	 *
	 * @param increment the quantity of the new increment
	 * @see decreaseTemperature
	 * @see increaseTemperature
	 */
	public void setIncrement(int increment) {
		this.increment = increment;
	}

	/**
	 * Formats the three variables of the class (temperature, unit, and increment)
	 * into a format which is user friendly. The string is not made to be parsed
	 * by regex but is meant to be displayed directly to the user.
	 *
	 * @return a formatted string containing the temperature, unit, and increment
	 */
	public String toString() {
		return String.format("The temperature is %.2f %c and may change by %d.",
				temperature, 'A' - 'a' + unit, increment);
	}
	/**
	 * Displays the temperature of the class randomly in one of the four
	 * temperature formats. This function is mainly for fun and serves little
	 * practical purpose. In almost all instances it is better to either
	 * convert the object to a specific temperature format with one of the
	 * to&lt;Temperature&gt; methods or receive a converted temperature with one of the
	 * get&lt;Temperature&gt; methods
	 *
	 * @see getCelsius
	 * @see getFahrenheit
	 * @see getKelvin
	 * @see getRankine
	 * @see toCelsius
	 * @see toFahrenheit
	 * @see toKelvin
	 * @see toRankine
	 */
	public void randUnit() {
		double rand = Math.random();
		if (rand > 0.75)
			System.out.printf("The temperature in Celsius is %.2f%n", getCelsius());
		else if (rand > 0.5)
			System.out.printf("The temperature in Fahrenheit is %.2f%n", getFahrenheit());
		else if (rand > 0.25)
			System.out.printf("The temperature in Kelvin is %.2f%n", getKelvin());
		else
			System.out.printf("The temperature in Rankine is %.2f%n", getRankine());
	}
}
