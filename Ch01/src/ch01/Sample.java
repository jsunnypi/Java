package ch01;

import java.util.Scanner;

public class Sample {

	public static void main(String[] args) 
	{
	
		Scanner stdin = new Scanner(System.in);
		System.out.print("월을 입력하세요:");
		int month = stdin.nextInt();
		String MtoS;
		switch(month)
		{
		case 12:
		case 1:
		case 2:
			MtoS = "겨울입니다.";
			break;
		case 3:
		case 4:
		case 5:
			MtoS = "봄입니다.";
			break;
		case 6:
		case 7:
		case 8:
			MtoS = "여름입니다.";
			break;
		case 9:
			System.out.print("멋진 9월과 ");
		case 10:
			System.out.print("아름다운 10월과 ");
		case 11:
			System.out.print("낙엽의 11월은 ");
			MtoS = "가을입니다.";
			break;			
		default:
			MtoS = "1~12월을 벗어난 달입니다.";
			break;
		}
		System.out.println(MtoS);
		
		
		
		
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("월을 입력하세요 : ");
//		int month = stdin.nextInt();
//		if(3 <= month && month <= 5)
//			System.out.println("봄입니다");
//		else if(6<= month && month <=8)
//			System.out.println("여름입니다");
//		else if(9<= month && month <=11)
//			System.out.println("가을입니다");
//		else if(1 == month || month ==2 || month ==12)
//			System.out.println("겨울입니다");
//		else
//			System.out.println("해당되는 계절이 없습니다.");
		
	
		
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("한 개의 숫자를 입력: ");
//		int a = stdin.nextInt();
//		boolean flag;
//		flag = (a%2 ==0) ? true: false;
//		System.out.print(a + "이(가) 짝수입니까? : ");
//		System.out.println(flag);
//		
		
//		Scanner stdin = new Scanner(System.in);
//		System.out.print("첫번째 정수를 입력: ");
//		int first = stdin.nextInt();
//		System.out.println("두번째 정수를 입력: ");
//		int second = stdin.nextInt();
//		double avg1 = (first + second) /2;
//		System.out.println("정수 연산 : 평균은 (" + first +"+"+ second +")/2 = "+ avg1 + "입니다.");
//		
//		double avg2 = (first +second) / 2.0;
//		System.out.println("실수 연산 : 평균은 (" + first + "+" +second+")/2.0 = "+avg2+ "입니다." );
//		
		
//		Scanner stdIn = new Scanner(System.in);
//		System.out.println("이름과 나이, 몸무게를 공간(space)으로 구분하여 입력 : ");
//		String name = stdIn.next();
//		int i = stdIn.nextInt();
//		double d = stdIn.nextDouble();
//		System.out.println(name + "씨의 나이는 " + i + "세이고");
//		System.out.println("몸무게는 "+ d + "kg입니다");
	}

}
