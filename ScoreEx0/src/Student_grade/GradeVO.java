package Student_grade;

public class GradeVO {
	private int studentId;
	private String studentName;
	private int classyear;
	private int kor;
	private int eng;
	private int math;
	private double avg;
	private int rank;

public GradeVO() {
	super();
}

public GradeVO(int studentId, String studentName, int classyear, int kor, int eng, int math) {
	super();
	this.studentId = studentId;
	this.studentName = studentName;
	this.classyear = classyear;
	this.kor = kor;
	this.eng = eng;
	this.math = math;
	Double Avg = (kor + eng + math) / 3.0;
	this.avg = Avg;
}

public int getStudentId() {
	return studentId;
}

public void setStudentId(int studentId) {
	this.studentId = studentId;
}

public String getStudentName() {
	return studentName;
}

public void setStudentName(String student) {
	this.studentName = studentName;
}
public int getClassYear() {
	return classyear;
}

public void setClassYear(int classyear) {
	this.classyear = classyear;
}

public int getKor() {
	return kor;
}

public void setKor(int kor) {
	this.kor = kor;
}

public int getEng() {
	return eng;
}

public void setEng(int eng) {
	this.eng = eng;
}

public int getMath() {
	return math;
}

public void setMath(int math) {
	this.math = math;
}

public double getAvg() {
	return avg;
}

public void setAvg(double avg) {
	this.avg = avg;
}

public int getRank() {
	return rank;
}

public void setRank(int rank) {
	this.rank = rank;
}

public String toString() {
	return "GradeVO [studentId = " + studentId + ", studentName= " + studentName+ ", classyear= " + classyear
			+ ", kor = " + kor + "eng = " + eng + ", math = " + math + ", avg = " + avg + ", rank = "+ rank + "]";
}



}


