package sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Update {
	public void Update() {
		String name = "";
		int kuk = 0;
		int eng = 0;
		int mat = 0;
		int tot = kuk+eng+mat;
		int avg = tot/3;
		String etc = "";

		Scanner in = new Scanner(System.in);
		Scanner in2 = new Scanner(System.in);
		Scanner in3 = new Scanner(System.in);

		System.out.println("수정할 이름을 입력하세요: ");
		name = in.nextLine();
		System.out.println("변경할 국어: ");
		kuk = in.nextInt();
		System.out.println("변경할 영어: ");
		eng = in.nextInt();
		System.out.println("변경할 수학: ");
		mat = in.nextInt();
		System.out.println("변경할 기타: ");
		etc = in3.nextLine();

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBConnect.getConnection();
			String sql = "update sungjuk set kuk=?, eng=?, mat=?, tot=kuk+eng+mat, avg=(tot/3), etc=?";
			sql = sql + "where name=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, kuk);
			pstmt.setInt(2, eng);
			pstmt.setInt(3, mat);
			pstmt.setString(4, etc);
			pstmt.setString(5, name);

			int ret = pstmt.executeUpdate();
			if (ret < 1) {
				System.out.println("수정할 대상이 없습니다.");
			} else {
				System.out.println("레코드" + ret + "개가 수정되었습니다.");
			}

		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		} finally {
			DBConnect.close(con, pstmt);
		}
	}
}
