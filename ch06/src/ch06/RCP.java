package ch06;

import java.util.Scanner;

public class RCP {

	public static void main(String[] args) {
		Scanner rcp = new Scanner(System.in);
		System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요");
		
		System.out.printf("철수 >> ");
		String cs = rcp.next();
		
		System.out.printf("영희 >> ");
		String yh = rcp.next();
		
		if(cs.equals("가위")) {
			if(yh.equals("가위"))
				System.out.println("비겼습니다");
			else if(yh.equals("바위"))
					System.out.println("영희가 이겼습니다.");
			else 
				System.out.println("철수가 이겼습니다.");
		}
		else if(cs.equals("바위")) {
			if(yh.equals("가위"))
				System.out.println("철수가 이겼습니다");
			else if(yh.equals("바위"))
					System.out.println("비겼습니다.");
			else 
				System.out.println("영희가 이겼습니다.");
		}
		else if(cs.equals("보")) {
			if(yh.equals("가위"))
				System.out.println("영희가 이겼습니다");
			else if(yh.equals("바위"))
					System.out.println("철수가 이겼습니다.");
			else 
				System.out.println("비겼습니다.");
		}
		
	}

}
