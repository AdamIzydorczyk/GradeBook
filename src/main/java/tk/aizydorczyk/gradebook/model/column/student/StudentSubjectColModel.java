package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSubjectDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public final class StudentSubjectColModel implements ColModel {

	private final TableColumn subjectName;
	private final TableColumn hours;
	private final TableColumn lecturerFullName;
	private final TableColumn average;

	public StudentSubjectColModel() {
		this.subjectName = new TableColumn(WindowContext.getLocalizedText("StudentSubjectColModelSubjectName"));
		this.hours = new TableColumn(WindowContext.getLocalizedText("StudentSubjectColModelHours"));
		this.lecturerFullName = new TableColumn(WindowContext.getLocalizedText("StudentSubjectColModelLecturerName"));
		this.average = new TableColumn(WindowContext.getLocalizedText("StudentSubjectColModelAverage"));

		subjectName.setCellValueFactory(
				new PropertyValueFactory<StudentSubjectDto, String>("subjectName"));
		hours.setCellValueFactory(
				new PropertyValueFactory<StudentSubjectDto, Short>("hours"));
		lecturerFullName.setCellValueFactory(
				new PropertyValueFactory<StudentSubjectDto, String>("lecturerName"));
		average.setCellValueFactory(
				new PropertyValueFactory<StudentSubjectDto, String>("average"));

	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(subjectName, hours, lecturerFullName, average);
	}

}
