package Student_grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDAOImple implements StudentDAO{
	
	private static StudentDAOImple instance = null;
	
	private String URL = "jdbc:mysql://localhost:3306/haksa";
	private String USER = "root";
	private String PASSWORD = "1234";
	
	private StudentDAOImple() {
		
	}
	
	
	public static StudentDAO getInstance() {
		if(instance == null) {
			instance = new StudentDAOImple();
		}
		return instance;
	}

	public int insert(StudentVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			String SQL_INSERT = "insert into student(id,pw,name,class_year,email) values(?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getClassyear());
			pstmt.setString(5, vo.getEmail());
			
			try {
			result = pstmt.executeUpdate();
			}
			catch(Exception e) {
				System.out.println("id 중복");
			}
			System.out.println(result + "행이 삽입됐습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	public boolean login(String id, String pw)  {
		boolean loggedIn = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			
			String SQL_LOGIN = "select * from student where id=? and pw=?";
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
		}
		return loggedIn;
	}
	
	@Override
	public StudentVO select(String email) {
		StudentVO vo = new StudentVO();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			String sql = "select * from student where email=?";
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, email);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String pw = rs.getString(2);
				String name = rs.getString(3);
				int classyear = rs.getInt(4);
				String studentemail = rs.getString(5);
				vo = new StudentVO(id, pw, name, classyear, studentemail);
				
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

	public int update(String email, StudentVO vo) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			System.out.println("정보 수정 중");
			String SQL_UPDATE = "update student set id=?, pw=?, name=?, class_year =? where email=?";
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getName());
			pstmt.setInt(4, vo.getClassyear());
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
	
	public int delete(String email) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			String SQL_DELETE = "delete from student where email =?";
			
			pstmt = conn.prepareStatement(SQL_DELETE);
			
			pstmt.setString(1, email);
			
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




























