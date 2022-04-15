public class Fib {
	private static final double pPHI = 1 + Math.sqrt(5);
	private static final double nPHI = 1 - Math.sqrt(5);
	public static void main(String[] args) {
		System.out.println(fib(1));
		System.out.println(fib(10));
		System.out.println(fib(100));
		System.out.println(fib(1000));
		System.out.println(fib(10000));
	}

	public static long fib(int n) {
		return (long) ((Math.pow(pPHI, n) - Math.pow(nPHI, n)) / Math.sqrt(5));
	}
}