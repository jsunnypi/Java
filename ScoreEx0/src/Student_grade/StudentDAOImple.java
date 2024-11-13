package Student_grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class StudentDAOImple {

	public static StudentDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean login(String id, String pw) {
		boolean loggedIn = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_LOGIN);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			loggedIn = rs.next();
			boolean result = loggedIn;
			
			if(result == true) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("로그인 실패");
			}
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
	

	
	public int insert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getClassyear());
			pstmt.setString(5, vo.getEmail());
		
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삽입됐습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}




























