package Student_grade;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GradeDAOImple implements GradeDAO {

	private static GradeDAOImple instance = null;

	private String URL = "jdbc:mysql://localhost:3306/haksa";
	private String USER = "root";
	private String PASSWORD = "1234";

	private GradeDAOImple() {

	}

	public static GradeDAOImple getInstance() {
		if (instance == null) {
			instance = new GradeDAOImple();
		}
		return instance;
	}

	public int getSize() {
		return select().size();
	}

	@Override
	public int insert(GradeVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			String SQL_INSERT = "inser into grade(student_id, student_name, class_year, korean, english, math, avg) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(SQL_INSERT);

			double avg = (vo.getKor() + vo.getEng() + vo.getMath()) / 3.0;
			vo.setAvg(avg);

			pstmt.setInt(1, vo.getStudentId());
			pstmt.setString(2, vo.getStudentName());
			pstmt.setInt(3, vo.getClassYear());
			pstmt.setInt(4, vo.getKor());
			pstmt.setInt(5, vo.getEng());
			pstmt.setInt(6, vo.getMath());
			pstmt.setDouble(7, vo.getAvg());

			try {
				result = pstmt.executeUpdate();
			} catch (Exception e) {
				System.out.println("id 중목");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return result; // 0: 실패, 1: 성공
	}

	@Override
	public ArrayList<GradeVO> select() {
		ArrayList<GradeVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			String SQL_SELECT_ALL = "select * from grade";
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				int studentid = rs.getInt(1);
				String studentname = rs.getString(2);
				int classyear = rs.getInt(3);
				int kor = rs.getInt(4);
				int eng = rs.getInt(5);
				int math = rs.getInt(6);
				double avg = rs.getDouble(7);

				GradeVO vo = new GradeVO(studentid, studentname, classyear, kor, eng, math);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public GradeVO select(int studentId) {
		GradeVO vo = new GradeVO();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");

			String SQL_SELECT_BY_STUDENT_ID = "select * from grade where student_id=?";
			pstmt = conn.prepareStatement(SQL_SELECT_BY_STUDENT_ID);
			pstmt.setInt(1, studentId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				int stdentid = rs.getInt(1);
				String studentname = rs.getString(2);
				int classyear = rs.getInt(3);
				int kor = rs.getInt(4);
				int eng = rs.getInt(5);
				int math = rs.getInt(6);

				vo = new GradeVO(studentId, studentname, classyear, kor, eng, math);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}

	@Override
	public int update(int studentId, GradeVO vo) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			System.out.println("정보 수정 중");
			
			String SQL_UPDATE = "update grade set student_name=?, class_year=?, korean=?, english=?, math=?, avg=? where student_id=? ";
			pstmt = conn.prepareStatement(SQL_UPDATE);

			double avg = (vo.getKor() + vo.getEng() + vo.getMath()) / 3.0;
			vo.setAvg(avg);

			pstmt.setString(1, vo.getStudentName());
			pstmt.setInt(2, vo.getClassYear());
			pstmt.setInt(3, vo.getKor());
			pstmt.setInt(4, vo.getEng());
			pstmt.setInt(5, vo.getMath());
			pstmt.setDouble(6, vo.getAvg());
			pstmt.setInt(7, studentId);

			result = pstmt.executeUpdate();

			System.out.println(result + "행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public int delete(int studentId) {
		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
			
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB 연결 성공");
			
			String SQL_DELETE = "delete from grade where student_id=?";
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, studentId);

			result = pstmt.executeUpdate();

			System.out.println(result + "행이 삭제됐습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result; // 성공: 1, 실패: 0
	}

}
