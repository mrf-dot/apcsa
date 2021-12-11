public class SlotMachine {
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
		return String.format("%d: %s|%s|%s", this.cost, this.sr1.toString(), this.sr2.toString(), this.sr3.toString());
	}
}
