package tk.aizydorczyk.gradebook.student.records;

public class StudentGroupRecord {
	private String subject;
	private String topic;
	private Long numberOfMembers;

	public StudentGroupRecord() {
	}

	public StudentGroupRecord(String subject, String topic, Long numberOfMembers) {
		this.subject = subject;
		this.topic = topic;
		this.numberOfMembers = numberOfMembers;
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
