package Student_grade;

public interface StudentDAO {

	boolean login(String id, String pw);

	int insert(StudentVO vo);

}
