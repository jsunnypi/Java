package ch06;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {
		int [] unit = {50000,10000,1000,500,100,50,10,1};
		Scanner stdin = new Scanner(System.in);
		System.out.print("금액을 입력하세요 >>");
		int money = stdin.nextInt();
		
		for(int i=0;i<unit.length;i++) {
			int a = money/unit[i];
			if(a>0)
				System.out.println(unit[i]+"원 짜리 : "+ a+"개");
			money = money%unit[i]; 
			
		}
	}
}


