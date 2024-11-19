package Student_grade;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherDAOImple implements TeacherDAO, OracleTeacherQuery {

	private static TeacherDAOImple instance = null;

	private TeacherDAOImple() {

	}

	private String URL = "jdbc:mysql://localhost:3306/haksa";
	private String USER = "root";
	private String PASSWORD = "1234";

	public static TeacherDAOImple getInstance() {
		if (instance == null) {
			instance = new TeacherDAOImple();
		}
		return instance;
	}

	public int insert(TeacherVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB연결 성공");

			pstmt = conn.prepareStatement(SQL_INSERT);

			pstmt.setString(1, vo.getTeacherid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, vo.getEmail());

			try {
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("id 중복");
			}
			System.out.println(result + "행이 삽입됐습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public boolean teacherlogin(String id, String pw, String subject) {
		boolean loggedIn = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공"); 
			
			pstmt = conn.prepareStatement(SQL_TEACHER_LOGIN);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, subject);
			
			rs = pstmt.executeQuery();
			loggedIn = rs.next();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		} return loggedIn;
	}

	public ArrayList<TeacherVO> select(){
		return null;
	}
	
	public TeacherVO selectteacher(String email) {
		TeacherVO vo = new TeacherVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_SELECT_BY_EMAIL);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String teacherid = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				String subject = rs.getString(4);
				String teacheremail = rs.getString(5);
				vo = new TeacherVO(teacherid, pw, name, subject, teacheremail);
			}
			
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					conn.close();
					rs.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		
		return vo;
		
	}
	
	public int updateteacher(String email, TeacherVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			System.out.println("정보 수정 중");
			
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getTeacherid());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getSubject());
			pstmt.setString(5, email);
			
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정됐습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int deleteteacher(String email) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(2, email);
			
			result = pstmt.executeUpdate();
			
			System.out.println(result + "행이 삭제됐습니다.");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}



























