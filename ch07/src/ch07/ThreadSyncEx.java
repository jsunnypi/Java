package ch07;


public class ThreadSyncEx {

	public static void main(String[] args) {
		Runnable thread = new CreateThread();
		Thread t1 = new Thread(thread);
		Thread t2 = new Thread(thread);
		
		t1.setName("스레드 1");
		t2.setName("스레드 2");
		
		t1.start();
		t2.start();
	}

}

class Money{
	// 현재 가지고 있는 금액
	private int myMoney = 10000;
	
	public int getMyMoney() {
		return myMoney;
	}
	
	public synchronized boolean withdraw(int money) {
		// 가지고 있는 금액이 출금할 금액보다 크거나 같을때만 출금
		if(myMoney >= money) {
			try {
				Thread.sleep(1000);
			}
			catch(Exception e){
				System.out.println(e);
			}
			// 출금
			myMoney -= money;
			return true;
		}
		return false;
	}
}

class CreateThread implements Runnable{
	
	Money myMoney = new Money();
	
	@Override
	public void run() {
		while(myMoney.getMyMoney() > 0) {
			// 1000 ~ 5000원 사이 값을 출금
			int money = (int)(Math.random()*5 +1)*1000;
			
			// 출금 실행 코드 실패시 true 반환
			boolean denied = !myMoney.withdraw(money);
			
			// 출금 과정 출력
			if(denied) {
				System.out.println("출금 거부");
			}
			else {
				System.out.printf("스레드 : %s 출금 : %d원 남은 금액 : %d원\n",
						Thread.currentThread().getName(), money, myMoney.getMyMoney());
				}
		}
	}
	
}