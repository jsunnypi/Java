package Student_grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface TeacherDAO {

	public boolean teacherlogin(String id, String pw, String subject);
	boolean loggedIn = false;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try {
		conn = DriverManager.getConnection(URL, ID, PW);
		System.out.println("DB 연결 성공");
		
		pstmt = conn.prepareStatement(SQL_TEACHER_LOGIN);
		
		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, subject);
		
		rs = pstmt.executeQuery();
		loggedIn = rs.next();
	
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			rs.close();
			pstmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	return loggedIn;
	
}
