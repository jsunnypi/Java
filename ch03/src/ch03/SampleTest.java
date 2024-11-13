package ch03;

class Sample3{
	void methodA() {
		System.out.println("B 메소드 호출 전");
			methodB();
		System.out.println("B 메소드 호출 후");
	}
	void methodB() {
		System.out.println("C 메소드 호출 전");
		methodC();
		System.out.println("C 메소드 호출 후");
	}
	void methodC() {
		System.out.println("C 메소드 수행 완료");
	}
}

public class SampleTest {

	public static void main(String[] args) {
		Sample3 s = new Sample3();
		s.methodA();

	}

}
