package tk.aizydorczyk.gradebook.model.dto.student;

public class StudentLecturerDto {
	private String lecturerFName;
	private String lecturerLName;
	private String degree;

	public StudentLecturerDto() {
	}

	public StudentLecturerDto(String lecturerFName, String lecturerLName, String degree) {
		this.lecturerFName = lecturerFName;
		this.lecturerLName = lecturerLName;
		this.degree = degree;
	}

	public String getLecturerFName() {
		return lecturerFName;
	}

	public void setLecturerFName(String lecturerFName) {
		this.lecturerFName = lecturerFName;
	}

	public String getLecturerLName() {
		return lecturerLName;
	}

	public void setLecturerLName(String lecturerLName) {
		this.lecturerLName = lecturerLName;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
}
