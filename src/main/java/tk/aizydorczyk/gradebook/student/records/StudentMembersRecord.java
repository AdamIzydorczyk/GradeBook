package tk.aizydorczyk.gradebook.student.records;

public class StudentMembersRecord {
	private String fname;
	private String lname;

	public StudentMembersRecord() {
	}

	public StudentMembersRecord(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "StudentMembersRecord{" +
				"fname='" + fname + '\'' +
				", lname='" + lname + '\'' +
				'}';
	}
}
