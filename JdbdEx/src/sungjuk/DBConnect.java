package sungjuk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnect {
	public static Connection getConnection() {
		Connection con=null;
		Statement stmt;
		ResultSet rs;
		String url = "jdbc:mysql://localhost:3306/Haksa";
		String id = "root";
		String pw = "1234";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pw);
		} catch (Exception e) {
			System.out.println("SQLException: " + e.getMessage());
		}
		finally {
		}
		
		return con;
	}
	
	public static void close(Connection con, PreparedStatement pstmt) {
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}catch(Exception e) {}
		
		try {
			if(con != null) {
				con.close();
			}
		}
			catch(Exception e) {}
		}
	

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
		}
		catch(Exception e) {
		}
		
		try {
			if(pstmt != null) {
				pstmt.close();
			}
		}
		catch(Exception e) {
			
		}
		
		try {
			if(con != null) {
				con.close();
			}
		}
		catch(Exception e) {}
		
	}
}





















