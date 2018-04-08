package tk.aizydorczyk.gradebook.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DEPARTAMENTS")
public class Department {

	@Column(name = "DEPARTAMENT_ID")
	@Id
	private Long id;
	@Column(name = "DEPARTAMENT_NAME")
	private String departamentName;

	@OneToMany(mappedBy = "departament")
	private List<Semester> semesters;

	@OneToMany(mappedBy = "departament")
	private List<Lecturer> lecturers;

	public Department() {
	}

	public Department(Long id, String departamentName, List<Semester> semesters, List<Lecturer> lecturers) {
		this.id = id;
		this.departamentName = departamentName;
		this.semesters = semesters;
		this.lecturers = lecturers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartamentName() {
		return departamentName;
	}

	public void setDepartamentName(String departamentName) {
		this.departamentName = departamentName;
	}

	public List<Semester> getSemesters() {
		return semesters;
	}

	public void setSemesters(List<Semester> semesters) {
		this.semesters = semesters;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(List<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}
}
