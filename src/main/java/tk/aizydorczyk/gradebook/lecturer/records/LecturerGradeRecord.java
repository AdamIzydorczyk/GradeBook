package tk.aizydorczyk.gradebook.lecturer.records;

public class LecturerGradeRecord {

	private Float grade;
	private String description;
	private String subjectName;

	public LecturerGradeRecord() {
	}

	public LecturerGradeRecord(Float grade, String description, String subjectName) {
		this.grade = grade;
		this.description = description;
		this.subjectName = subjectName;
	}

	public Float getGrade() {
		return grade;
	}

	public void setGrade(Float grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
}
