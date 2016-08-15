package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGroupDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public final class StudentGroupColModel implements ColModel {

	private final TableColumn subject;
	private final TableColumn topic;
	private final TableColumn numberOfMembers;

	public StudentGroupColModel() {
		this.subject = new TableColumn(WindowContext.getLocalizedText("StudentGroupColModelSubject"));
		this.topic = new TableColumn(WindowContext.getLocalizedText("StudentGroupColModelTopic"));
		this.numberOfMembers = new TableColumn(WindowContext.getLocalizedText("StudentGroupColModelGradeNumberOfMembers"));

		subject.setCellValueFactory(
				new PropertyValueFactory<StudentGroupDto, String>("subject"));
		topic.setCellValueFactory(
				new PropertyValueFactory<StudentGroupDto, String>("topic"));
		numberOfMembers.setCellValueFactory(
				new PropertyValueFactory<StudentGroupDto, Long>("numberOfMembers"));

	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(subject, topic, numberOfMembers);
	}

}
