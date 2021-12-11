public class Player {
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
