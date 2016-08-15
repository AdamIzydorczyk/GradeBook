package tk.aizydorczyk.gradebook.model.dto.student;

public class StudentSemesterDto {
	private Short semestrNumber;
	private Short year;

	public StudentSemesterDto() {
	}

	public StudentSemesterDto(Short semestrNumber, Short year) {
		this.semestrNumber = semestrNumber;
		this.year = year;
	}

	public Short getSemestrNumber() {
		return semestrNumber;
	}

	public void setSemestrNumber(Short semestrNumber) {
		this.semestrNumber = semestrNumber;
	}

	public Short getYear() {
		return year;
	}

	public void setYear(Short year) {
		this.year = year;
	}
}
