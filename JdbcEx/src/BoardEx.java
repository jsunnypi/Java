import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BoardEx {

	private Scanner sc = new Scanner(System.in);
	private Connection conn;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;

	public BoardEx() {
		// JDBC Driver 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/Haksa";
			String id = "root";
			String pw = "1234";

			conn = DriverManager.getConnection(url, id, pw);
			// System.out.println("DB 접속 성공");

		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
	}

	public void list() {
		// 타이틀과 컬럼명 출력
		System.out.println();
		System.out.println("[게시판 목록]");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");

		// board 테이블에서 게시물 정보 가져와서 출력하기

		try {
			String sql = "" + "select bno, btitle, bcontent, bwriter, bdate from boards order by bno desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Board board = new Board();

				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.printf("%-6s%-12s%-16s%-40s \n", 
						board.getBno(), board.getBwriter(), 
						board.getBdate(), board.getBtitle()
						);
			}

			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
		mainMenu();
	}

	public void mainMenu() {
		System.out.println("");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("메인메뉴 : 1. Create | 2. Read | 3. Clear | 4. Exit ");
		System.out.println("메뉴 선택 : ");
		String menuNo = sc.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1":
			create();
			break;
		case "2":
			read();
			break;
		case "3":
			clear();
			break;
		case "4":
			exit();
			break;
		}
	}

	public void create() {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목 : ");
		board.setBtitle(sc.nextLine());
		System.out.print("내용 : ");
		board.setBcontent(sc.nextLine());
		System.out.print("글쓴이 : ");
		board.setBwriter(sc.nextLine());

		// 보조 메뉴 출력
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("보조 메뉴 : 1. OK 2. Cancel");
		System.out.print("메뉴 선택 : ");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "insert into boards(btitle, bcontent, bwriter, bdate) values (?, ?, ?, now())";

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void read() {
		System.out.println("[게시물 읽기]");
		System.out.println("bno : ");
		int bno = Integer.parseInt(sc.nextLine());
		// 해당 테이블에서 해당 게시물을 가져와 출력
		try {
			String sql = "select bno, btitle, bcontent, bwriter, bdate from boards where bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));

				System.out.println("#############################");
				System.out.println("번호 : " + board.getBno());
				System.out.println("제목 : " + board.getBtitle());
				System.out.println("내용 : " + board.getBcontent());
				System.out.println("글쓴이 : " + board.getBwriter());
				System.out.println("날짜 : " + board.getBdate());

				// 보조 메뉴 출력
				System.out.println(
						"-------------------------------------------------------------------------------------------------");
				System.out.println("보조 메뉴 : 1. Update | 2. Delete | 3. List");
				System.out.print("메뉴 선택 : ");
				String menuNo = sc.nextLine();
				System.out.println();
				if (menuNo.equals("1"))
					update(board);
				else if (menuNo.equals("2")) {
					delete(board);
				}
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	public void update(Board board) {
		// 수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.println("제목: ");
		board.setBtitle(sc.nextLine());
		System.out.println("내용: ");
		board.setBcontent(sc.nextLine());
		System.out.println("글쓴이: ");
		board.setBwriter(sc.nextLine());

		// 보조 메뉴 출력
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1. OK || 2. Cancel ");
		System.out.println("메뉴 선택: ");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "update boards set btitle=?, bcontent=?, bwriter=? where bno=?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.setInt(4, board.getBno());
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}

	public void delete(Board board) {
		try {
			String sql = "delete from boards where bno=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}

	public void clear() {
		System.out.println("[게시물 전체 삭제]");
		System.out.println(
				"-------------------------------------------------------------------------------------------------");
		System.out.println("보조 메뉴: 1. OK | 2. Cancel");
		String menuNo = sc.nextLine();
		if (menuNo.equals("1")) {
			try {
				String sql = "truncate table boards";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.executeUpdate();
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
	

	public void exit() {
		if(conn != null) {
			try {
				conn.close();
			}
			catch(SQLException e) {				
			}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);	
	}

	public static void main(String[] args) {
		BoardEx boardExample = new BoardEx();
		boardExample.list();

	}

}