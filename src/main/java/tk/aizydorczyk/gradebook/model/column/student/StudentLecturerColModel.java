package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentLecturerDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public class StudentLecturerColModel implements ColModel {

	private final TableColumn fname;
	private final TableColumn lname;
	private final TableColumn degree;


	public StudentLecturerColModel() {
		this.fname = new TableColumn(WindowContext.getLocalizedText("StudentLecturerColModelFname"));
		this.lname = new TableColumn(WindowContext.getLocalizedText("StudentLecturerColModelLname"));
		this.degree = new TableColumn(WindowContext.getLocalizedText("StudentLecturerColModelDegree"));

		fname.setCellValueFactory(
				new PropertyValueFactory<StudentLecturerDto, String>("lecturerFName"));
		lname.setCellValueFactory(
				new PropertyValueFactory<StudentLecturerDto, String>("lecturerLName"));
		degree.setCellValueFactory(
				new PropertyValueFactory<StudentLecturerDto, String>("degree"));
	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(fname, lname, degree);
	}
}
