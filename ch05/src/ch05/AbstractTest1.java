package ch05;

abstract class Shape{
	abstract void draw();
	abstract void computArea(double a, double b);
}

class Rectangle1 extends Shape{

	@Override
	void draw() {
		System.out.println("사각형을 그리는 기능");
	}

	@Override
	void computArea(double h, double v) {
		System.out.println("사각형의 넓이 : "+(h*v));
	}

}

class Triangle1 extends Shape{

	@Override
	void draw() {
		System.out.println("삼각형을 그리는 기능");
	}

	@Override
	void computArea(double a, double h) {
		System.out.println("삼각형의 넓이 : "+(a*h/2));
	}
	
}


public class AbstractTest1 {

	public static void main(String[] args) {
		System.out.println("==추상 메소드를 이용한 다형성==");
		Shape s = new Rectangle1();
		s.draw();
		s.computArea(5.0, 10.0);

		s = new Triangle1();
		s.draw();
		s.computArea(5.0, 10.0);
	}

}
