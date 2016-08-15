package tk.aizydorczyk.gradebook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;
import java.util.Date;
import java.util.List;

@Entity(name = "STUDENTS")
public class Student {
	@Column(name = "STUDENT_ID")
	@Id
	private Long id;

	@Column(name = "STUDENT_F_NAME")
	private String studentFName;

	@Column(name = "STUDENT_L_NAME")
	private String studentLName;

	@Column(name = "STUDENT_DOB")
	private Date dateOfBirth;

	@Column(name = "STUDENT_CITY")
	private String city;

	@Column(name = "STUDENT_PHONE")
	private Integer phone;

	@Column(name = "STUDENT_NO", unique = true)
	private String studentNo;

	@OneToOne(mappedBy = "student")
	private Account account;

	@ManyToMany(mappedBy = "students")
	private List<Semester> semesters;

	@OneToMany(mappedBy = "student")
	private List<Grade> grades;

	@ManyToMany
	@JoinTable(name = "STUDENTS_GROUPS", uniqueConstraints = {@UniqueConstraint(
			columnNames = {"STUDENT_ID", "GROUP_ID"})}, joinColumns = {@JoinColumn(name = "STUDENT_ID")},
			inverseJoinColumns = {@JoinColumn(name = "GROUP_ID")})
	private List<Group> groups;

	public Student() {
	}

	public Student(Long id, String studentFName, String studentLName, Date dateOfBirth, String city, Integer phone, String studentNo, Account account, List<Semester> semesters, List<Grade> grades, List<Group> groups) {
		this.id = id;
		this.studentFName = studentFName;
		this.studentLName = studentLName;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.phone = phone;
		this.studentNo = studentNo;
		this.account = account;
		this.semesters = semesters;
		this.grades = grades;
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
