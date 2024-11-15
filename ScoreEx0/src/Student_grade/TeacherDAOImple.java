package Student_grade;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class TeacherDAOImple {

	public static TeacherDAO getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

	public int insert(TeacherVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, ID, PW);
			System.out.println("DB연결 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getTeacherid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getEmail());
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삽입됐습니다.");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}return result;
	}
	
	
	

}




















