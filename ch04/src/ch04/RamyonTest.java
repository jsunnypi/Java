package ch04;

import java.util.Scanner;

class Ramyon{
	String ramyon = "라면";
	String water = "물";
	String onion = "파";
	void boilwater() {
		System.out.println(water + "을 끓인다");
	}
	void cooking() {
		System.out.println(ramyon + "과 " + onion + "를 넣고 끓여 요리 완성. 맛있게 드세요!!!");
	}
}

class RiceRamyon extends Ramyon{
	String topp = "떡";
	void topping() {
		System.out.println(topp + "을 넣는다");
	}
}

class CheeseRamyon extends Ramyon{
	String topp = "치츠";
	void topping() {
		System.out.println(topp + "을 넣는다");
	}
}


public class RamyonTest {

	public static void main(String[] args) {
		int s;
		do {
			System.out.print("만들고 싶은 요리를 입력하세요(1: 일반라면, 2: 떡라면, 3: 치츠라면, 99: 종료 : ");
			Scanner stdin = new Scanner(System.in);
			s = stdin.nextInt();
			if(s==1) {
				Ramyon r = new Ramyon();
				r.boilwater();
				r.cooking();
				}
			else if(s==2) {
				RiceRamyon rr = new RiceRamyon();
				rr.boilwater();
				rr.topping();
				rr.cooking();
			}
			else if(s==3) {
				CheeseRamyon cr = new CheeseRamyon();
				cr.boilwater();
				cr.topping();
				cr.cooking();
			}
		}
		while(s!=99);
		System.out.println("감사합니다");
	}

}
