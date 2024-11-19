package Student_grade;

public interface StudentDAO {
	
	public abstract int insert(StudentVO vo);
	
	public abstract boolean login(String id, String pw);
	
	public abstract StudentVO select(String email);
	
	public abstract int update(String email, StudentVO vo);
	
	public abstract int delete(String email);
	
}
