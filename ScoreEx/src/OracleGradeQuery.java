
public interface OracleGradeQuery {
	public static final String URL ="jdbc:mysql://localhost:3306/haksa";
	public static final String USER = "scott";
	public static final String PASSWORD = "tiger";
	
	public static final String TABLE_NAME = "GRADE";
	public static final String COL_STUDENT_ID = "STUDENT_ID";
	public static final String COL_STUDENT_NAME = "STUDENT_NAME";
	public static final String COL_CLASS_YEAR = "CLASS_YEAR";
	public static final String COL_KOREAN = "KOREAN";
	public static final String COL_ENGLISH = "ENGLISH";
	public static final String COL_MATH = "MATH";
	public static final String COL_AVG = "AVG";
	
	// 학생 성적 등록
    // INSERT INTO GRADE
//INSERT INTO GRADE(STUDENT_ID, CLASS_YEAR, STUDENT_NAME, KOREAN, ENGLISH, MATH)
//	VALUES ((SELECT STUDENT_ID FROM STUDENT WHERE STUDENT_NAME = 'FDFD'),0,
//			'FPLLPDFD' , 30, 30, 30);
	public static final String SQL_INSERT = "INSERT INTO " + TABLE_NAME +
			"(STUDENT_ID, STUDENT_NAME, CLASS_YEAR, KOREAN, ENGLISH, MATH, AVG)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?)";
	

    // 학생 성적 전체 검색
    public static final String SQL_SELECT_ALL =
            "SELECT * FROM " + TABLE_NAME + " ORDER BY " + COL_STUDENT_ID;

    
    // 학생 성적 인덱스 검색
    // SELECT * FROM GRADE WHERE GRADE_ID = ?
    public static final String SQL_SELECT_BY_STUDENT_ID =
            "SELECT * FROM " + TABLE_NAME +
                    " WHERE " + COL_STUDENT_ID + " = ?";

    // 학생 성적 정보 수정
    // UPDATE GRADE
    // SET NAME = ?, CLASS = ?, SUBJECT_NAME = ?, KOREAN = ?, ENGLISH = ?, MATH = ?, AVG = ?, RANK = ?
    // WHERE GRADE_ID = ?
    public static final String SQL_UPDATE =
            "UPDATE " + TABLE_NAME + " SET " +
                    COL_STUDENT_NAME + " = ?, " +
                    COL_CLASS_YEAR + " = ?, " +
                    COL_KOREAN + " = ?, " +
                    COL_ENGLISH + " = ?, " +
                    COL_MATH + " = ?, " +
                    COL_AVG + " = ? " +
                    "WHERE " + COL_STUDENT_ID + " = ?";

    // 학생 성적 삭제
    // DELETE GRADE WHERE GRADE_ID = ?
    public static final String SQL_DELETE =
            "DELETE " + TABLE_NAME + " WHERE " +
            		COL_STUDENT_ID + " = ?";
}
	

