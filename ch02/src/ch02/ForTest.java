package ch02;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
	
		Scanner stdin = new Scanner(System.in);
		System.out.print("원하는 정수 입력(짝수의 합) : ");
		int num = stdin.nextInt();
		int i, sum=0;
		for(i=1; i<=num; i++) {
			if(i%2 ==1) continue;
			sum += i;
		}
		System.out.println("1부터 "+num+"까지 짝수의 합 = "+ sum);
		
		
		/*
		int i, j;
		for(i=1; i<10; i++) {
			for(j=1; j<i; j++) {
				if(j>6) break;
				System.out.print("*");
			}
			System.out.println();
		}
	*/	
		
		/*
		Scanner stdin = new Scanner(System.in);
		System.out.print("합계를 원하는 정수 입력: ");
		int num = stdin.nextInt();
		int sum=0, i=1;
		while(true) {
			sum += i;
			if(i==num) break;
			i++;
		}
		System.out.println(num+"까지의 함계는 "+sum);
		*/
/*		Scanner stdin = new Scanner(System.in);
		System.out.println("원하는 숫자 입력: ");
		int num = stdin.nextInt();
		int i =1;
		while(i<=num) {
			int j=1;
			while(j<=i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
		
		*/
//		int i =2;
//		while (i<=9) {
//			System.out.println("*** "+i+"단 ***");
//			for(int j=1; j<=9; j++) {
//				System.out.println(i+"*"+j+" = "+ i*j);
//			}
//			System.out.println();
//			i++;
//		}
//		
		
//		Scanner stdin = new Scanner(System.in);
//		System.out.println("정수 입력: ");
//		int num = stdin.nextInt();
//		System.out.println(num +"의 약수 : ");
//		for(int i=1; i<=num; i++) {
//			if(num % i == 0)
//				System.out.println(i +" ");
//		}
//		
		
		
//		int i, sum=0;
//		for(i=1; i<=10; i++)
//		{
//			sum += i;
//		}
//		
//		System.out.println("1부터 10까지의 합은 "+sum+"입니다.");
//		
		
	}

}
