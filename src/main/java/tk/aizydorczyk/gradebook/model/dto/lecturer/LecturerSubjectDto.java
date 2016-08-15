package tk.aizydorczyk.gradebook.model.dto.lecturer;

public class LecturerSubjectDto {

	private String subjectName;
	private Short hours;

	public LecturerSubjectDto() {
	}

	public LecturerSubjectDto(String subjectName, Short hours) {
		this.subjectName = subjectName;
		this.hours = hours;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Short getHours() {
		return hours;
	}

	public void setHours(Short hours) {
		this.hours = hours;
	}
}
