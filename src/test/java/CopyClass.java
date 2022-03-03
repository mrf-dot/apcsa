public class CopyClass {
	public static void main(String[] args) {
		SampleClass sample = new SampleClass(5);
		SampleClass sample2 = new SampleClass(sample);
		sample2.increaseVal();
		System.out.printf("sample:\t\t%d%nsample2:\t%d",
				sample.getVal(), sample2.getVal());
	}
}

class SampleClass {
	private int val;

	public SampleClass(int val) {
		this.val = val;
	}

	public SampleClass(SampleClass sample) {
		this(sample.getVal());
	}

	public int getVal() {
		return val;
	}

	public void increaseVal() {
		val++;
	}
}
