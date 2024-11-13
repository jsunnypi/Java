package ch06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileReaderTest1 {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("읽어 들일 파일명을 입력하세요 : ");
		String s = in.next();
		FileReader fr = new FileReader(s);
		int i;
		while((i = fr.read()) != -1) {
			System.out.print((char)i);
		}
		fr.close();
		
	}

}
