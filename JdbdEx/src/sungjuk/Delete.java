package sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
	public void Delete(){
		String name = "";
		Scanner in = new Scanner(System.in);
		System.out.println("삭제할 이름을 입력하세요: ");
		name = in.nextLine();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DBConnect.getConnection();
			String sql = "delete from sungjuk where name=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			int ret = pstmt.executeUpdate();
			if(ret<1) {
				System.out.println("삭제할 대상이 없습니다.");
			}
			else {
				System.out.println("레코드 " + ret + "개가 삭제 되었습니다.");
			}
		}
		catch(Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		finally {
			DBConnect.close(con, pstmt);
		}
	}
}
