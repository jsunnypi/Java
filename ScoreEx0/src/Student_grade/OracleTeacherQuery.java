package Student_grade;

public interface OracleTeacherQuery {
	
	public static final String TABLE_NAME = "TEACHER";
	public static final String COL_TEACHERID = "TEACHERID";
	public static final String COL_PW = "PW";
	public static final String COL_NAME = "NAME";
	public static final String COL_SUBJECT = "SUBJECT";
	public static final String COL_EMAIL = "EMAIL";
	
	public static final String SQL_INSERT =
			"INSERT INTO " + TABLE_NAME + " VALUES (?,?,?,?,?)";
	
	public static final String SQL_SELECT = 
			"SELECT * FROM " + TABLE_NAME;
	
	public static final String SQL_TEACHER_LOGIN = 
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_TEACHERID 
			+ " = ? AND " + COL_PW + " = ? AND " + COL_SUBJECT + " = ?";
	
	public static final String SQL_SELECT_BY_EMAIL = 
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_EMAIL + " = ?";
	
	public static final String SQL_UPDATE =
			"UPDATE " + TABLE_NAME + " SET " + COL_TEACHERID + " = ?, " +
					COL_PW + " = ?, " + COL_NAME + " = ?, " +
					COL_SUBJECT + " = ? " + " WHERE " + COL_EMAIL + " = ?";
	
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " + COL_EMAIL + " = ?";
	
	
	
	
}
