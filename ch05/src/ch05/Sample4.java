package ch05;

class Item {
	public int price;
}

class Noodle extends Item{
	public Noodle() {
		price = 2500;
	}
	public String toString() {
		return "국수";
	}
}

class MixNoodle extends Item{
	public MixNoodle() {
		price = 3000;
	}
	public String toString() {
		return "비빔국수";
	}
}

class Wodong extends Item{
	public Wodong() {
		price = 2500;
	}
	public String toString() {
		return "우동";
	}
}

class Buyer{
	private int money;
	
	public Buyer(int money) {
		this.money = money;
	}
	
	public void buy(Item it, int count) {
		System.out.println(it + "을(를) "+ count +"개 맛있게 먹었습니다." );
		money = money - it.price*count;
		System.out.println("현재 남은 돈 : "+money);
	}
	
//	public void buy(Wodong it, int count) {
//		System.out.println(it + "을 "+ count +"개 맛있게 먹었습니다." );
//		money = money - it.price*count;
//		System.out.println("현재 남은 돈 : "+money);
//	}
//	public void buy(MixNoodle it, int count) {
//		System.out.println(it + "을 "+ count +"개 맛있게 먹었습니다." );
//		money = money - it.price*count;
//		System.out.println("현재 남은 돈 : "+money);
//	}
//	public void buy(Noodle it, int count) {
//		System.out.println(it + "을 "+ count +"개 맛있게 먹었습니다." );
//		money = money - it.price*count;
//		System.out.println("현재 남은 돈 : "+money);
//	}
}

public class Sample4 {

	public static void main(String[] args) {
		Buyer me = new Buyer(20000);
		me.buy(new Wodong(), 2);
		me.buy(new MixNoodle(), 2);
		me.buy(new Noodle(), 3);
	}

}












