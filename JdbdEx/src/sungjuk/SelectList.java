package sungjuk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectList {
	public void SelectList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs;
		
		try {
			con = DBConnect.getConnection();
			String sql = "select * from sungjuk order by name ASC";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			System.out.println("출력 결과 ------------------------");
			
			while(rs.next()) {
				System.out.println("이름: " + rs.getString("name"));
				System.out.println("국어: " + rs.getInt("kuk"));
				System.out.println("영어: " + rs.getInt("eng"));
				System.out.println("수학: " + rs.getInt("mat"));
				System.out.println("총점: " + rs.getInt("tot"));
				System.out.println("평균: " + rs.getInt("avg"));
				System.out.println("etc: " + rs.getShort("etc"));
				System.out.println("------------------------");
			
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
