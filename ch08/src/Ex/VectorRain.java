package Ex;

import java.util.*;

public class VectorRain {

	public static void main(String[] args) {
		Vector<Integer> v = new Vector<Integer>();
		Scanner sc = new Scanner(System.in);
		
		int n, sum=0;
		
		while(true) {
			System.out.println("강수량 입력 (0 입력 시 종료) >>");
			n = sc.nextInt();
			if(n==0)
				break;
			v.add(n);
			
			for(int i=0;i<v.size();i++) {
				int m = v.get(i);
				sum += m;
				System.out.print(m+" ");
			}
			System.out.println("현재 평균"+sum/v.size());
			sum = 0;
			}
		
	}

}
