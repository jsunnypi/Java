package ch04;



public class SampleTest {
	int count =10;
	static int num =20;
	public int sum(int x, int y) {
		return x+y;
	}
	static int mul(int x, int y) {
		return x*y;
	}

	public static void main(String[] args) {
		SampleTest s = new SampleTest(); 
		int same = s.count;
		same = s.num;
		same = s.sum(5,5);
		same = s.mul(5,5);
	}

}
