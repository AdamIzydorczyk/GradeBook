package tk.aizydorczyk.gradebook.model.column.student;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public class StudentMembersColModel implements ColModel {

	private final TableColumn fname;
	private final TableColumn lname;


	public StudentMembersColModel() {
		this.fname = new TableColumn(WindowContext.getLocalizedText("StudentMembersColModelFname"));
		this.lname = new TableColumn(WindowContext.getLocalizedText("StudentMembersColModelLname"));

		fname.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("fname"));
		lname.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("lname"));
	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(fname, lname);
	}

}
