package tk.aizydorczyk.gradebook.model.column.lecturer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class LecturerGradeColModel implements ColModel {

	private final TableColumn grade;
	private final TableColumn description;
	private final TableColumn subjectName;

	public LecturerGradeColModel() {
		this.grade = new TableColumn(WindowContext.getLocalizedText("LecturerGradeColModelGrade"));
		this.description = new TableColumn(WindowContext.getLocalizedText("LecturerGradeColModelDescription"));
		this.subjectName = new TableColumn(WindowContext.getLocalizedText("LecturerSubjectColModelSubjectName"));

		grade.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, BigDecimal>("grade"));
		description.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, Short>("description"));
		subjectName.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("subjectName"));
	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(grade, description, subjectName);
	}
}
