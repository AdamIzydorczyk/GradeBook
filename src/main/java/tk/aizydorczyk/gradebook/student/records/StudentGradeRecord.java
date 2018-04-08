package tk.aizydorczyk.gradebook.student.records;


import java.math.BigDecimal;

public class StudentGradeRecord {
	private BigDecimal grade;
	private String description;

	public StudentGradeRecord() {
	}

	public StudentGradeRecord(BigDecimal grade, String description) {
		this.grade = grade;
		this.description = description;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
