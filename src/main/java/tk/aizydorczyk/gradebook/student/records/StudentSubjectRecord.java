package tk.aizydorczyk.gradebook.student.records;

public class StudentSubjectRecord {

	private String subjectName;
	private Short hours;
	private String lecturerName;
	private Double average;

	public StudentSubjectRecord() {
	}

	public StudentSubjectRecord(String subjectName, Short hours, String lecturerName, Double average) {
		this.subjectName = subjectName;
		this.hours = hours;
		this.lecturerName = lecturerName;
		this.average = average;
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

	public String getLecturerName() {
		return lecturerName;
	}

	public void setLecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public Double getAverage() {
		return average;
	}

	public void setAverage(Double average) {
		this.average = average;
	}
}
