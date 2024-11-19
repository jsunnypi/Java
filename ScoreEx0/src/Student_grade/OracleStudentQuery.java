package Student_grade;

public interface OracleStudentQuery {
	
	public static final String TABLE_NAME = "STUDENT";
	public static final String COL_ID = "ID";
	public static final String COL_PW = "PW";
	public static final String COL_NAME = "NAME";
	public static final String COL_CLASS_YEAR = "CLASS_YEAR";
	public static final String COL_EMAIL = "EMAIL";
	
	public static final String SQL_INSERT = 
			"INSERT INTO " + TABLE_NAME + " VALUES (?,?,?,?,?)";
	
	public static final String SQL_LOGIN = 
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_ID + " = ? AND " + COL_PW + " = ?";

	public static final String SQL_SELECT_ALL = 
			"SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_ID;
	
	public static final String SQL_SELECT_BY_EMAIL = 
			"SELECT * FROM " + TABLE_NAME + " WHERE " + COL_EMAIL + " = ?"; 
	
	public static final String SQL_UPDATE = 
			"UPDATE " + TABLE_NAME + " SET " + COL_ID + " = ?, " 
					+ COL_PW + " = ?, " + COL_NAME + " = ?, " +
					COL_CLASS_YEAR + " = ? " + "WHERE " + COL_EMAIL + " = ?";
	
	public static final String SQL_DELETE = 
			"DELETE " + TABLE_NAME + " WHERE " + COL_EMAIL + " = ?";


















}
