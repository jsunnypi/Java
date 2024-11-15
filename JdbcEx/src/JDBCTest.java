import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		Connection conn;

		Statement stmt;
		ResultSet rs;

		String url = "jdbc:mysql://localhost:3306/Haksa";
		// localhost 대신 => 127.0.0.1 or ip주소
		String id = "root";
		String pw = "1234";

		try {
			// 1. 사용하고자 하는 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver"); // mysql driver 주소(외울것)

			// 2. url, id, pw 접속
			conn = DriverManager.getConnection(url, id, pw);

			// 3. CRUD 작업
			stmt = conn.createStatement();
			
			//stmt.executeUpdate("insert into student values(202451111,'블랙핑크', 'Music', 100)");
			
			stmt.executeLargeUpdate("delete from student where name='dol'");
			
			
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				int hakbun = rs.getInt(1);
				String name = rs.getString("name");
				String dept = rs.getString(3);
				int score = rs.getInt("score");
				System.out.println(hakbun + " " + name + " " + dept + " " + score);
			}
		} catch (Exception e) {
			System.out.println("DB 접속 불가");
		}
	}
}
