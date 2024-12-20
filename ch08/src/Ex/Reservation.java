package Ex;

import java.io.IOException;
import java.util.Scanner;

class ShowReserve{
	Scanner sc = new Scanner(System.in);
	String[][] seats = new String[3][10];
	
	public ShowReserve() {
		for(int i=0; i<3; i++)
			for(int j=0; j<10; j++)
				this.seats[i][j] = "---";
	}
	
	void seat_watch(int seat) {
		switch(seat) {
		case 1:
			System.out.println("S >> ");
			break;
		case 2:
			System.out.println("A >> ");
			break;
		case 3: 
			System.out.println("B >> ");
			break;
		}
		for(int i=0; i<10; i++)
			System.out.println(this.seats[seat-1][i]+" ");
		System.out.println();
	}
	
	void seat_reserve() {
		int seat;
		String name = null;
		int seat_number;
		while(true) {
			System.out.println("좌석 구분 S(1) A(2) B(3)");
			seat = sc.nextInt();
			
			try {
				seat_watch(seat);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("다시 선택해주세요");
				continue;
			}
		}
	}
	
}




public class Reservation {
	
	public static void main(String[] args) {
		ShowReserve sr = new ShowReserve();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("예약(1), 조회(2), 취소(3), 끝내기(4)");
			int select = sc.nextInt();
			switch(select) {
			case 1: 
				sr.seat_reserve();
				break;
			case 2:
				
				break;
			case 3:
				
			case 4:
			}
		}
	}

}
