package tk.aizydorczyk.gradebook.model.column.lecturer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public class LecturerSubjectColModel implements ColModel {

	private final TableColumn subjectName;
	private final TableColumn hours;


	public LecturerSubjectColModel() {
		this.subjectName = new TableColumn(WindowContext.getLocalizedText("LecturerSubjectColModelSubjectName"));
		this.hours = new TableColumn(WindowContext.getLocalizedText("LecturerSubjectColModelHours"));

		subjectName.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("subjectName"));
		hours.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("hours"));
	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(subjectName, hours);
	}
}
