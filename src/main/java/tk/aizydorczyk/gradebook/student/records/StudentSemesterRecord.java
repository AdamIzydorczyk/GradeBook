package tk.aizydorczyk.gradebook.student.records;

public class StudentSemesterRecord {
	private Short semesterNumber;
	private Short year;

	public StudentSemesterRecord() {
	}

	public StudentSemesterRecord(Short semesterNumber, Short year) {
		this.semesterNumber = semesterNumber;
		this.year = year;
	}

	public Short getSemesterNumber() {
		return semesterNumber;
	}

	public void setSemesterNumber(Short semesterNumber) {
		this.semesterNumber = semesterNumber;
	}

	public Short getYear() {
		return year;
	}

	public void setYear(Short year) {
		this.year = year;
	}
}
