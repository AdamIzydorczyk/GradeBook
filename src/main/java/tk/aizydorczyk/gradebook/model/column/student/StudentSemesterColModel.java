package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSemesterDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public final class StudentSemesterColModel implements ColModel {

	private final TableColumn semestrNumber;
	private final TableColumn year;


	public StudentSemesterColModel() {
		this.semestrNumber = new TableColumn(WindowContext.getLocalizedText("StudentSemesterColModelSemestrNumber"));
		this.year = new TableColumn(WindowContext.getLocalizedText("StudentSemesterColModelYear"));

		semestrNumber.setCellValueFactory(
				new PropertyValueFactory<StudentSemesterDto, Short>("semestrNumber"));
		year.setCellValueFactory(
				new PropertyValueFactory<StudentSemesterDto, Short>("year"));
	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(semestrNumber, year);
	}

}
