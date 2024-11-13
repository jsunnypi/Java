package Student_grade;

import java.util.ArrayList;

public interface GradeDAO {
	public abstract int insert(GradeVO vo);
	
	public abstract ArrayList<GradeVO> select();
	
	public abstract GradeVO select(int studentId);

	public abstract int update(int studentId, GradeVO vo);
	
	public abstract int delete(int studentId);
}


