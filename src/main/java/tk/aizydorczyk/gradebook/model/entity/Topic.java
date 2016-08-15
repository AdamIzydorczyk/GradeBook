package tk.aizydorczyk.gradebook.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "TOPICS")
public class Topic {
	@Column(name = "TOPIC_ID")
	@Id
	private Long id;

	@Column(name = "TOPIC_NAME")
	private String topicName;

	@OneToMany(mappedBy = "topic")
	private List<Group> groups;

	public Topic() {
	}

	public Topic(Long id, String topicName, List<Group> groups) {
		this.id = id;
		this.topicName = topicName;
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
}
