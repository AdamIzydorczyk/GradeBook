package tk.aizydorczyk.gradebook.model.dto.student;


import java.math.BigDecimal;

public class StudentGradeDto {
	private BigDecimal grade;
	private String description;

	public StudentGradeDto() {
	}

	public StudentGradeDto(BigDecimal grade, String description) {
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
