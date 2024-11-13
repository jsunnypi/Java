package ch02;

import java.util.Random;
import java.util.Scanner;

public class GameTest {

	public static void main(String[] args) {
		
		Random ran = new Random();
		
		int count=1, min=1, max=99, input=0;
		
		int ans = ran.nextInt(99)+1;
		
		Scanner stdin = new Scanner(System.in);
		
		System.out.println(count+"번째 "+ min +"-"+max +"사이의 값을 입력하세요:");
		do {
			input = stdin.nextInt();
			
			if(input < ans) {
				min = input;
				count++;
				System.out.println(count+"번째 "+ min +"-"+max+"사이의 값을 입력하세요:");
				
			}
			else if(input > ans) {
				max = input;
				count++;
				System.out.println(count+"번째 "+ min +"-"+max+"사이의 값을 입력하세요:");

			}
					
		}
		while(input!=ans); {
		System.out.println("정답입니다!!");
		System.out.println(count+"번 만에 맞추셨습니다");
		};
		}
}









