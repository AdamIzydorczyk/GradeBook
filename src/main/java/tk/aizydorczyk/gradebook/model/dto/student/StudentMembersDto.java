package tk.aizydorczyk.gradebook.model.dto.student;

public class StudentMembersDto {
	private String fname;
	private String lname;

	public StudentMembersDto() {
	}

	public StudentMembersDto(String fname, String lname) {
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
		return "StudentMembersDto{" +
				"fname='" + fname + '\'' +
				", lname='" + lname + '\'' +
				'}';
	}
}
