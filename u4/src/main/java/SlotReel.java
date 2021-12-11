public class SlotReel {
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
