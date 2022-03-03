/*
 * Mitch Feigenbaum
 * Period 5
 * On my honor, I pledge that I have neither given nor received unauthorized assistance on this assignment or test.
 */
import java.util.ArrayList;
public class FeigenbaumU5Runner {
	public static void main(String[] args) {
		// Creates Arraylist of class type
		ArrayList<FeigenbaumU5> temperatures = new ArrayList<FeigenbaumU5>();
		// Creates four of class type in ArrayList
		for (int i = 0; i < 4; i++)
			temperatures.add(new FeigenbaumU5(i * i, "cfkr".charAt(i), i));
		// Uses set to change one item
		temperatures.set(0, new FeigenbaumU5(9, 'k', 2));
		// uses remove to remove one item
		temperatures.remove(3);
		// prints out each item
		for (FeigenbaumU5 temperature: temperatures)
			System.out.println(temperature);
		// Resets two variables
		temperatures.get(1).setIncrement(3);
		temperatures.get(1).toRankine();
		// Shows the values of the changed variables
		System.out.println(temperatures.get(1).getTemperature());
		System.out.println(temperatures.get(1).getUnit());
		// Displays the temperatures of two objects in a random unit
		temperatures.get(0).randUnit();
		temperatures.get(2).randUnit();
	}
}
