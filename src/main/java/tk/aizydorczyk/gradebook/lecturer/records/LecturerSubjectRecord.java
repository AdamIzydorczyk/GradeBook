package tk.aizydorczyk.gradebook.lecturer.records;

public class LecturerSubjectRecord {

	private String subjectName;
	private Short hours;

	public LecturerSubjectRecord() {
	}

	public LecturerSubjectRecord(String subjectName, Short hours) {
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
