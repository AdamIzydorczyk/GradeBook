package tk.aizydorczyk.gradebook.infrastructure.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "GROUPS")
public class Group {

	@Column(name = "GROUP_ID")
	@Id
	private Long id;

	@ManyToMany(mappedBy = "groups")
	private List<Student> students;

	@ManyToOne
	@JoinColumn(name = "TOPIC_ID")
	private Topic topic;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private Subject subject;

	public Group() {
	}

	public Group(Long id, List<Student> students, Topic topic, Subject subject) {
		this.id = id;
		this.students = students;
		this.topic = topic;
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
