import java.util.ArrayList;

public class FlightOrganizer {
	public static void main(String[] args) {
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		for (int i = 0; i < 15; i++) {
			tickets.add(new Ticket());
		}
		for (int i = 1; i < 6; i++) {
			System.out.printf("%nBoarding Group %d:%n", i);
			for (Ticket t : tickets) {
				if (t.getBoardingGroup() == i)
					System.out.println(t);
			}
		}
		System.out.println("\nPassengers that may board together:");
		Ticket ticket;
		Ticket nextTicket;
		for (int i = 0; i < tickets.size() - 1; i++) {
			ticket = tickets.get(i);
			nextTicket = tickets.get(i+1);
			if (ticket.getBoardingGroup() == nextTicket.getBoardingGroup()
					&& ticket.getRow() == nextTicket.getRow()) {
				System.out.printf("%s and%n%s%n", ticket, nextTicket);
					}
		}
	}
}
