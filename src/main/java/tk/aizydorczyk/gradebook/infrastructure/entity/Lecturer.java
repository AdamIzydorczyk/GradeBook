package tk.aizydorczyk.gradebook.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "LECTURERS")
public class Lecturer {

	@Column(name = "LECTURER_ID")
	@Id
	private Long id;

	@Column(name = "LECTURER_F_NAME")
	private String lecturerFName;

	@Column(name = "LECTURER_L_NAME")
	private String lecturerLName;

	@Column(name = "LECTURER_DEGREE")
	private String degree;

	@ManyToOne
	@JoinColumn(name = "DEPARTAMENT_ID")
	private Department departament;

	@OneToMany(mappedBy = "lecturer")
	private List<Subject> subjects;

	@OneToOne(mappedBy = "lecturer")
	private Account account;

	public Lecturer() {
	}

	public Lecturer(Long id, String lecturerFName, String lecturerLName, String degree, Department departament, List<Subject> subjects, Account account) {
		this.id = id;
		this.lecturerFName = lecturerFName;
		this.lecturerLName = lecturerLName;
		this.degree = degree;
		this.departament = departament;
		this.subjects = subjects;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Department getDepartament() {
		return departament;
	}

	public void setDepartament(Department departament) {
		this.departament = departament;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
