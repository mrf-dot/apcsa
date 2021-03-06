class Casino {
	public static void main(String[] args) {
		Player player = new Player("Gambler");
		SlotMachine machine = new SlotMachine((Math.random() < 0.5) ? 5 : 10);
		System.out.printf("Welcome, %s%n", player.getName());
		System.out.printf("You will be using the %s machine today, which costs %d coins.%n",
				(machine.getCost() == 10) ? "original" : "modded", machine.getCost());
		int totalSpins = 0;
		for (int spins = 0; player.getMoney() >= machine.getCost(); totalSpins = ++spins) {
			machine.pull();
			System.out.println(machine);
			player.setMoney(player.getMoney() - machine.getCost() + machine.calculate());
			if (machine.calculate() > 0)
				System.out.printf("HIT!!! You win %d coins!%n", machine.calculate());
			else
				System.out.println("Too bad! No win on this pull.");
			System.out.printf("%s%n%n", player);
		}
		System.out.printf("GAME OVER! You were able to pull %d times before going broke",
				totalSpins);
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
	private SlotReel sr1, sr2, sr3;

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
		return sr1.equals(sr2) && sr2.equals(sr3) && !(sr1.toString().equals("horseshoe") || sr1.toString().equals("star") || sr2.toString().equals("horseshoe") || sr2.toString().equals("star") || sr3.toString().equals("horseshoe") || sr3.toString().equals("star"));
	}

	private boolean hit2() {
		return sr1.toString().equals("horseshoe") && sr2.toString().equals("horseshoe");
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
