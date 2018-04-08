package tk.aizydorczyk.gradebook.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "SUBJECTS")
public class Subject {

	@Column(name = "SUBJECT_ID")
	@Id
	private Long id;

	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@Column(name = "SUBJECT_HOURS")
	private Short hours;

	@ManyToOne
	@JoinColumn(name = "LECTURER_ID")
	private Lecturer lecturer;

	@OneToMany(mappedBy = "subject")
	private List<Grade> grades;

	@OneToMany(mappedBy = "subject")
	private List<Group> groups;

	public Subject() {
	}

	public Subject(Long id, String subjectName, Short hours, Lecturer lecturer, List<Grade> grades, List<Group> groups) {
		this.id = id;
		this.subjectName = subjectName;
		this.hours = hours;
		this.lecturer = lecturer;
		this.grades = grades;
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
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
