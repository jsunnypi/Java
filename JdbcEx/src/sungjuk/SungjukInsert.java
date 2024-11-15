package sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SungjukInsert {
	public void SungjukInsert() {
		String name = "";
		int kuk = 0;
		int eng = 0;
		int mat = 0;
		int tot = kuk + eng + mat;
		int avg = tot/3;
		String etc = "";

		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);

		System.out.println("이름을 입력하시오 : ");
		name = in.nextLine();
		System.out.println("국어 점수를 입력하시오 : ");
		kuk = in2.nextInt();
		System.out.println("영어 점수를 입력하시오 : ");
		eng = in2.nextInt();
		System.out.println("수학 점수를 입력하시오 : ");
		mat = in2.nextInt();
		System.out.println("기타: ");
		etc = in3.nextLine();
		
		

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBConnect.getConnection();
			String sql = "insert into sungjuk values(?, ?, ?, ?, tot, avg, ?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setInt(2, kuk);
			pstmt.setInt(3, eng);
			pstmt.setInt(4, mat);
			pstmt.setString(5, etc);

			int ret = pstmt.executeUpdate();
			if (ret < 1) {
				System.out.println("추가 실패");
			} else {
				System.out.println("레코드" + ret + "개가 추가 되었습니다.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		finally {
			DBConnect.close(con, pstmt);
		}
	}
}
