package ch04;

class OIa1{
	public void show(String str) {
		System.out.println("상위 클래스의 메소드 show(String str)수행 "+str);
	}
}

class OIb1 extends OIa1{
	@Override public void show(String str) {
		System.out.println("하위 클래스의 메소드 show(String str)수행 " + str);
	}
}


public class OverridingTest3 {

	public static void main(String[] args) {
		OIb1 oib = new OIb1();
		oib.show("처음 시작하는 자바");
	
	}

}
