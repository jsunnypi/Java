package ch03;

class Cons1{
	
	public Cons1() {
		System.out.println("생성자입니다.");
	}
	
	public Cons1(String a, int b) {
		
	}
	
	public int num;
}
public class ConsTest1 {

	public static void main(String[] args) {
		
		Cons1 co = new Cons1(); 
		
		Cons1 cons = new Cons1("첫번째", 5);

	}

}
