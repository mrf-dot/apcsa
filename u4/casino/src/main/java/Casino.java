public class Casino {
	public static void main(String[] args) {
		Player player = new Player("Gambler");
		int spins = 0;
		SlotMachine machine;
		// Automatically select the cost of the machine
		if (Math.random() < .5) {
			machine = new SlotMachine(5);
			System.out.println("Welcome, " + player.getName());
			System.out.println("You will be using the original machine today, which costs 5 coins");
		} else {
			machine = new SlotMachine(10);
			System.out.println("Welcome, " + player.getName());
			System.out.println("You will be using the modded machine today, which costs 10 coins");
		}
		// Keep playing while the player has enough money
		while (player.getMoney() >= machine.getCost()) {
			spins++;
			machine.pull();
			System.out.println(machine);
			player.setMoney(player.getMoney() - machine.getCost());
			int winnings = machine.calculate();
			if (winnings > 0) {
				System.out.println("HIT!!! You win " + winnings + " coins!");
				player.setMoney(player.getMoney() + winnings);
			} else {
				System.out.println("Too bad! No win on this pull.");
			}
			System.out.println(player + "\n\n");
		}
		System.out.println("GAME OVER! You were able to pull " + spins + " times before going broke!");
	}
}
