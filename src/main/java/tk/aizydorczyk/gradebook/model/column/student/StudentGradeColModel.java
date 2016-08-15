package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGradeDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public final class StudentGradeColModel implements ColModel {

	private final TableColumn grade;
	private final TableColumn description;

	public StudentGradeColModel() {
		this.grade = new TableColumn(WindowContext.getLocalizedText("StudentGradeColModelGrade"));
		this.description = new TableColumn(WindowContext.getLocalizedText("StudentGradeColModelDescription"));

		grade.setCellValueFactory(
				new PropertyValueFactory<StudentGradeDto, BigDecimal>("grade"));
		description.setCellValueFactory(
				new PropertyValueFactory<StudentGradeDto, String>("description"));

	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(grade, description);
	}

}
