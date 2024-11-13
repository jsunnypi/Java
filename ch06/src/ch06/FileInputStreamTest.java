package ch06;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Scanner;

public class FileInputStreamTest {

	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 파일명을 입력하세요 : ");
		String s = sc.next();
		FileInputStream fis = new FileInputStream(s);
		int i;
		while((i=fis.read())!= -1) {	// -1 == EOF(End Of File)
			System.out.print(i+" ");
		}
		fis.close();
		System.out.println(s+" 파일을 전부 읽었습니다");
		
	}

}
