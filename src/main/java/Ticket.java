public class Ticket {
	private int name;
	private char row;
	private int seat;
	private int boardingGroup;
	private static int nPassengers = 0;

	public Ticket() {
		name = ++nPassengers;
		row = "ABCDEF".charAt((int) (Math.random() * 6));
		seat = (int) (Math.random() * 8 + 1);
		boardingGroup = (int) (Math.random() * 5 + 1);
	}

	public char getRow() {
		return row;
	}

	public int getBoardingGroup() {
		return boardingGroup;
	}

	public String toString() {
		return String.format("Passenger #%d: Row %c, seat %d, Boarding Group %d",
				name, row, seat, boardingGroup);
	}
}
