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

class Player {
	private String name;
	private int money;

	public Player(String name) {
		this.name = name;
		this.money = 100;
	}

	public String getName() {
		return this.name;
	}

	public int getMoney() {
		return this.money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String toString() {
		return String.format("%s has $%d", this.name, this.money);
	}
}

class SlotMachine {
	private int cost, multiplier;
	private SlotReel sr1;
	private SlotReel sr2;
	private SlotReel sr3;

	public SlotMachine(int cost) {
		this.cost = cost;
		this.multiplier = cost / 5;
		this.sr1 = new SlotReel();
		this.sr2 = new SlotReel();
		this.sr3 = new SlotReel();
	}

	public void pull() {
		this.sr1.spin();
		this.sr2.spin();
		this.sr3.spin();
	}

	public int getCost() {
		return this.cost;
	}

	private boolean hit3() {
		if (this.sr1.toString().equals("horseshoe")
				|| this.sr1.toString().equals("star")
				|| this.sr2.toString().equals("horseshoe")
				|| this.sr2.toString().equals("star")
				|| this.sr3.toString().equals("horseshoe")
				|| this.sr3.toString().equals("star"))
			return false;
		if (this.sr1.equals(sr2) && this.sr2.equals(sr3))
			return true;
		return false;
	}

	private boolean hit2() {
		if (this.sr1.toString().equals("horseshoe") && this.sr2.toString().equals("horseshoe"))
			return true;
		return false;
	}

	public int calculate() {
		if (hit3()) {
			switch (this.sr1.toString()) {
				case "spade":
					return this.multiplier * 20;
				case "diamond":
					return this.multiplier * 30;
				case "heart":
					return this.multiplier * 40;
				case "Liberty Bell":
					return this.multiplier * 50;
				default:
					break;
			}
		}
		if (hit2() && this.sr3.toString().equals("star"))
			return this.multiplier * 10;
		if (hit2())
			return this.multiplier * 5;
		return 0;
	}

	public String toString() {
		return String.format("%d: %s|%s|%s", this.cost, this.sr1.toString(), this.sr2.toString(),
				this.sr3.toString());
	}
}

class SlotReel {
	private int value;

	public void spin() {
		this.value = (int) (Math.random() * 6) + 1;
	}

	public boolean equals(SlotReel reel) {
		return this.value == reel.getValue();
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		switch (this.value) {
			case 1:
				return "diamond";
			case 2:
				return "heart";
			case 3:
				return "spade";
			case 4:
				return "horseshoe";
			case 5:
				return "star";
			case 6:
				return "Liberty Bell";
			default:
				return "";
		}
	}
}
