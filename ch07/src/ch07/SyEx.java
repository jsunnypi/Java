package ch07;

class Counter extends Thread{
	int count = 0;
	
	public void increment() {
		count++;
	}
	public void decrement() {
		count--;
	}
	public int getCount() {
		return count;
	}
	
	@Override
	public void run() {
		for(int i=0; i<50; i++) {
		increment();
		decrement();
		System.out.println(getCount());
		}
	}
}

public class SyEx {
	
	public static void main(String[] args) {
		
		Counter cnt = new Counter();
		Counter cnt1 = new Counter();
		Counter cnt2 = new Counter();
		cnt.start();
		cnt1.start();
		cnt2.start();
	}

}
