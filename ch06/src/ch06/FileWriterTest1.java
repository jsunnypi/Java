package ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriterTest1 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String source = "비어 있어야 비로소 가득해지는 사랑\n"+"영원히 사랑한다는 것은\n"+"평온한 마음으로 아침을 맞는다는 것입니다.\n";
		System.out.println("저장할 파일명을 입력하세요 : ");
		String s = sc.next();
		FileWriter fw = new FileWriter(s);
		fw.write(source);
		fw.close();
		System.out.println(s + "파일 생성되었습니다"); 
		
	}

}
