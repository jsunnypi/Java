package ch06;

import java.io.IOException;
import java.util.Scanner;

public class Ex14 {

	public static void main(String[] args) throws IOException  {
		String course[] = { "Java", "C++", "HTML5", "컴퓨터구조", "안드로이드" };
		int score[] = { 95, 88, 76, 62, 55 };

		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.printf("과목 이름 >> ");
			String name = sc.next();

			for (int i = 0; i < course.length; i++) {
				if (course[i].equals(name)) {
					int n = score[i];
					System.out.println(n + "점입니다");
					}
			}	
			
			if (name.equals("그만"))
				break; 
			
			}
		
		}
		
	}


