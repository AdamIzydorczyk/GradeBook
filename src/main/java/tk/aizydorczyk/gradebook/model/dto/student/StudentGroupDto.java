package tk.aizydorczyk.gradebook.model.dto.student;

public class StudentGroupDto {
	private String subject;
	private String topic;
	private Long numberOfMembers;

	public StudentGroupDto() {
	}

	public StudentGroupDto(String subject, String topic, Long numberOfMsembers) {
		this.subject = subject;
		this.topic = topic;
		this.numberOfMembers = numberOfMsembers;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Long getNumberOfMembers() {
		return numberOfMembers;
	}

	public void setNumberOfMembers(Long numberOfMembers) {
		this.numberOfMembers = numberOfMembers;
	}
}
