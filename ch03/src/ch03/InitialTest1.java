package ch03;

class Initial{
	int number;
	double rate;
	String name;
	int[] score;
	public void aMethod() {
		int count;
		System.out.println(number);
	}
}

public class InitialTest1 {

	public static void main(String[] args) {
		int var1;
		double var2;
		Initial ob1 = new Initial();
		
		System.out.println("객체 변수 number의 값은 : "+ ob1.number);
		System.out.println("객체 변수 rate의 값은 : "+ ob1.rate);
		System.out.println("객체 변수 name의 값은 : "+ ob1.name);
		System.out.println("객체 변수 score의 값은 : "+ ob1.score);
		
		ob1.aMethod();
	}

}
