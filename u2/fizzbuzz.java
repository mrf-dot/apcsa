public class fizzbuzz {
	public static void main(String[] args) {
		String fizzString;
		for (int x = 1; x < 101; x++) {
			fizzString = "";
			fizzString += (x % 3 == 0) ? "Fizz" : "";
			fizzString += (x % 5 == 0) ? "Buzz" : "";
			fizzString += (x % 7 == 0) ? "Foo" : "";
			fizzString += (x % 11 == 0) ? "Bar" : "";
			System.out.println((fizzString.equals("")) ? x : fizzString);
		}
	}
}
