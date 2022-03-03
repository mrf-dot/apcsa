public class Tests {
	public static void main(String[] args) {
		double[][] table = new double[5][6];
		System.out.println(checkIndexes(table, 4, 5));
	}

	public static boolean checkIndexes(double[][] data, int row, int col) {
		int numRows = data.length;
		if (row < numRows) {
			int numCols = data[0].length;
			return col < numCols;
		} else {
			return false;
		}
	}
}
