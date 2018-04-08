package tk.aizydorczyk.gradebook.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "GRADES")
public class Grade {

	@Column(name = "GRADE_ID")
	@Id
	private Long id;

	@Column(name = "GRADE")
	private BigDecimal grade;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	public Grade() {
	}

	public Grade(Long id, BigDecimal grade, String description, Subject subject, Student student) {
		this.id = id;
		this.grade = grade;
		this.description = description;
		this.subject = subject;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
