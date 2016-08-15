package tk.aizydorczyk.gradebook.model.dto.lecturer;

import java.util.Date;

public class LecturerStudentDto {

	private String studentNo;
	private String studentFName;
	private String studentLName;
	private Date dateOfBirth;
	private String city;
	private Integer phone;
	private String departament;

	public LecturerStudentDto() {
	}

	public LecturerStudentDto(String studentNo, String studentFName, String studentLName, Date dateOfBirth, String city, Integer phone, String departament) {
		this.studentNo = studentNo;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.phone = phone;
		this.departament = departament;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentFName() {
		return studentFName;
	}

	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}

	public String getStudentLName() {
		return studentLName;
	}

	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}
}
