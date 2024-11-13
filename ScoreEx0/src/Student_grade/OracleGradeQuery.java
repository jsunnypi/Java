package Student_grade;

public interface OracleGradeQuery {
	public static final String URL = "jdbc:mysql://localhost:3306/Haksa";
	public static final String ID = "root";
	public static final String PW = "1234";
	
	public static final String TABLE_NAME = "GRADE";
	public static final String COL_STUDENT_ID = "STUDENT_ID";
	public static final String COL_STUDENT_NAME = "STUDENT_NAME";
	public static final String COL_CLASS_YEAR = "CLASS_YEAR";
	public static final String COL_KOREAN = "KOREAN";
	public static final String COL_ENGLISH = "ENGLISH";
	public static final String COL_MATH = "MATH";
	public static final String COL_AVG = "AVG";
	
	public static final String SQL_INSERT = "INSERT INTO "+ TABLE_NAME +
			"(STUDENT_ID, STUDENT_NAME, CLASS_YEAR, KOREAN, ENGLISH, MATH, AVG)"
			+ " VALUES(?,?,?,?,?,?,?)";
	
	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_STUDENT_ID;
	
	public static final String SQL_SELECT_BY_STUDENT_ID =
			"SELECT * FROM " + TABLE_NAME + 
			" WHERE " + COL_STUDENT_ID + " = ?";
	
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " +
					COL_STUDENT_NAME + " =?, " +
					COL_CLASS_YEAR + " =?, " +
					COL_KOREAN + " =?, " +
					COL_ENGLISH + " =?, " +
					COL_MATH + " =?, " +
					COL_AVG + " =? " +
					"WHERE " + COL_STUDENT_ID + " =?";
	
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " + 
					COL_STUDENT_ID + " =?";
}
