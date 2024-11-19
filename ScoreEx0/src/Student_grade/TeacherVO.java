package Student_grade;

public class TeacherVO {
	private String teacherid;
	private String pw;
	private String subject;
	private String email;
	public TeacherVO(String teacherid, String pw, String name, String subject, String teacheremail) {
		// TODO Auto-generated constructor stub
	}
	public TeacherVO() {
		// TODO Auto-generated constructor stub
	}
	public String getTeacherid() {
		return teacherid;
	}
	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String toString() {
		return "TeacherVO [teacherid=" + teacherid + ", pw=" + pw + ", subject=" + subject + ", email=" + email + "]";
	}
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
