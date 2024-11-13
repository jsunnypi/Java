package ch06;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {

	public static void main(String[] args) {
		byte b[] = {7,51,3,4,-1,24};
		try {
			FileOutputStream fout = new FileOutputStream("test.out");
			for(int i=0; i<b.length; i++)
				fout.write(b[i]);
			fout.close();
		}
		catch(IOException e) {
			System.out.println("경로명 확인해주세요");
			 return;
		}
		System.out.println("저장했습니다.");
	}

}
