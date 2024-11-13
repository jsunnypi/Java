package ch06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreamTest1 {

	public static void main(String[] args) throws IOException {
		Scanner stdin = new Scanner(System.in);
		System.out.println("출력 파일명을 입력하세요: ");
		String s = stdin.next();
		FileOutputStream fos = new FileOutputStream(s);
		for(int i =1; i<=260; i++) {
			fos.write(i);		
		}
		fos.close();
		System.out.println(s+" 파일명으로 바이트 파일을 생성하였습니다.");
}

}
