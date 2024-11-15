package Ex;

import java.util.*;

class Phone {
	private String name;
	private String tel;

	public Phone(String name, String tel) {
		this.name = name;
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}

public class PhoneBook {
	Scanner sc = new Scanner(System.in);
	Phone[] pArray;

	void read() {
		System.out.println("인원수 >> ");
		int n = sc.nextInt();

		pArray = new Phone[n];

		for (int i = 0; i < pArray.length; i++) {
			System.out.println("이름과 전화번호를 입력하세요(이름과 전화번호는 빈칸없이 입력) >> ");
			String name = sc.next();
			String tel = sc.next();
			pArray[i] = new Phone(name, tel);
		}
		System.out.println("저장 완료");
	}

	String search(String name) {
		for (int i = 0; i < pArray.length; i++) {
			if (pArray[i].getName().equals(name)) {
				return pArray[i].getTel();
			}
		}
		return null;
	}

	void run() {
		read();
		while (true) {
			System.out.println("검색할 이름 >> ");
			String name = sc.next();
			if (name.equals("그만"))
				break;
			String tel = search(name);
			if (tel == null)
				System.out.println(name + "이 없습니다.");
			else
				System.out.println(name + "번호는 " + tel + "입니다.");
		}
	}

	public static void main(String[] args) {
		new PhoneBook().run();
	}

}
