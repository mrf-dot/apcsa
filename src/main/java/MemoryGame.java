import java.util.Scanner;

/**
 * MemoryGame simulates a console-based game of memory in which the player
 * reveals two cards at a time with the
 * goal of matching them. Gameplay continues until the player matches all cards.
 *
 * @author kabaram
 * @version 1.0
 */

public class MemoryGame {

	private MemoryCard[][] cards = new MemoryCard[2][4]; // feel free to change these dimensions and card setup

	/**
	 * Instantiates all cards. After all cards are instantiated they are shuffled,
	 * and then shown.
	 */
	public MemoryGame() {
		/**
		 * Write this constructor
		 */
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[0].length; j++) {
				cards[i][j] = new MemoryCard();
			}
		}
		shuffle();
		setCardIDs();
	}

	/**
	 * Sets each card's id instance variable
	 */
	public void setCardIDs() {
		for (int i = 0; i < cards.length; i++) {
			for (int j = 0; j < cards[0].length; j++) {
				cards[i][j].setID();
			}
		}
	}
	/**
	 * Shuffles all cards. After shuffling, calls the setCardIDs method above.
	 */
	public void shuffle() {
		/**
		 * Write this method
		 */
		MemoryCard[] flattenedCards = new MemoryCard[cards.length * cards[0].length];
		// Instance variables
		int i = 0;
		int j;
		// Adds the cards to the flattened array
		for (MemoryCard[] row : cards) {
			for (MemoryCard card : row) {
				flattenedCards[i] = card;
				i++;
			}
		}
		// Randomizes the cards and shows the shuffling
		for (i = flattenedCards.length - 1; i > 0; i--) {
			// Randomizes an element in the list
			j = (int) (Math.random() * (i + 1));
			MemoryCard tmp = flattenedCards[i];
			flattenedCards[i] = flattenedCards[j];
			flattenedCards[j] = tmp;
		}
		int fI = 0;
		// translates the flattened array into the 2d array
		for (i = 0; i < cards.length; i++) {
			for (j = 0; j < cards[0].length - 1; j++) {
				cards[i][j] = flattenedCards[fI++];
			}
		}
	}

	/**
	 * Prints the top or bottom outline of each card of row
	 *
	 * @param row the row of cards to be printed
	 */
	public void printTopOrBottom(MemoryCard[] row) {
		for (MemoryCard card : row) {
			card.printTopOrBottom();
		}
	}

	/**
	 * Prints a "blank" middle edge outline for each card of row
	 *
	 * @param row the row of cards to be printed
	 */
	public void printMiddleBlank(MemoryCard[] row) {
		for (MemoryCard card : row) {
			card.printMiddleBlank();
		}
	}

	/**
	 * Prints the center row outline for each card of row
	 *
	 * @param row the row of cards to be printed
	 */
	public void printCenter(MemoryCard[] row) {
		for (MemoryCard card : row) {
			card.printCenter();
		}
	}

	/**
	 * Prints the center row outline and id for each card of row
	 *
	 * @param row the row of cards to be printed
	 */
	public void printIDs(MemoryCard[] row) {
		for (MemoryCard card : row) {
			card.printID();
		}
	}

	/**
	 *
	 * @return true if all cards are paired, false otherwise
	 */
	public boolean won() {
		/**
		 * Write this method
		 */
		for (MemoryCard[] row: cards) {
			for (MemoryCard card: row) {
				if (!card.revealed()) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Displays all cards
	 */
	public void showCards() {
		for (MemoryCard[] row : cards) {
			printTopOrBottom(row);
			System.out.println();
			printMiddleBlank(row);
			System.out.println();
			printCenter(row);
			System.out.println();
			printMiddleBlank(row);
			System.out.println();
			printTopOrBottom(row);
			System.out.println();
			printIDs(row);
			System.out.println("\n\n");
		}
	}

	/**
	 * Locates the card with the matching id. If the card is neither paired or
	 * revealed, flip the card
	 * and then return it
	 *
	 * @param id The ID number of the card to search
	 * @return The card with the matching ID if it is not already paired or
	 *         revealed, null otherwise
	 */
	public MemoryCard revealCard(int id) {
		/**
		 * Write this method
		 */
		for (MemoryCard[] row: cards) {
			for (MemoryCard card: row) {
				if (card.getID() == id) {
					card.flip();
					return card;
				}
			}
		}
	return null;
	}

	/**
	 * Controls the computer-user interface to play the game
	 *
	 * @param args not used
	 */
	public static void main(String[] args) {
		MemoryGame game = new MemoryGame();
		Scanner input = new Scanner(System.in);
		System.out.println("\n\n Welcome to Memory!");

		while (!game.won()) { // keep flipping cards until all cards are paired

			System.out.println("Enter first card number to reveal");
			int id = input.nextInt();
			MemoryCard first = game.revealCard(id);

			while (first == null) { // error check for an available card
				System.out.println("Choose a non-revealed card");
				id = input.nextInt();
				first = game.revealCard(id);
			}
			game.showCards();

			System.out.println("Enter second card number to reveal");
			id = input.nextInt();
			MemoryCard second = game.revealCard(id);

			while (second == null) { // error check for an available card
				System.out.println("Choose a non-revealed card");
				id = input.nextInt();
				second = game.revealCard(id);
			}
			game.showCards();

			if (first.equals(second)) { // check for a match
				System.out.println("Congratulations, you paired two cards!");
			} else {
				System.out.println("Sorry, no pair made");
			}
			System.out.println("Enter any key to continue.");
			input.next();

			// flip both chosen cards face down
			first.flip();
			second.flip();

			game.showCards();
		}
		System.out.println("Congratulations, you win!");

	}
}
