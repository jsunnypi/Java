package Ex;

import java.util.*;

public class CountryEx {

	public static void main(String[] args) {
		HashMap<String, Integer> nations = new HashMap<String, Integer>();
			
		Scanner sc = new Scanner(System.in);
		
		System.out.println("나라 이름과 인구를 입력하세요. (예: Korea 5000)");
		
		while(true) {
			System.out.println("나라 이름, 인구 >> ");
			
			String nation = sc.next();
			if(nation.equals("그만")) 
				break;
			int population = sc.nextInt();

			nations.put(nation, population);			
		}
	
		
		while(true) {
			System.out.println("인구 검색할 나라는 >> ");
			String nation = sc.next();
			if(nation.equals("그만"))
				break;
			Integer n = nations.get(nation);
			if(n==null)
				System.out.println(nation+"은 찾을 수 없는 나라입니다.");
			else
				System.out.println(nation + "의 인구는 "+ n +"\n");
		}
		
		
		
		
		
		
	
	}

}
