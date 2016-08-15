package tk.aizydorczyk.gradebook.model.column.lecturer;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.util.Arrays;
import java.util.List;

public class LecturerStudentsColModel implements ColModel {

	private final TableColumn studentNo;
	private final TableColumn studentFName;
	private final TableColumn studentLName;
	private final TableColumn dateOfBirth;
	private final TableColumn city;
	private final TableColumn phone;
	private final TableColumn departament;


	public LecturerStudentsColModel() {
		this.studentNo = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelNo"));
		this.studentFName = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelFname"));
		this.studentLName = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelLname"));
		this.dateOfBirth = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelDob"));
		this.city = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelCity"));
		this.phone = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelPhone"));
		this.departament = new TableColumn(WindowContext.getLocalizedText("LecturerStudentsColModelDepartament"));

		studentNo.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("studentNo"));
		studentFName.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("studentFName"));
		studentLName.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("studentLName"));
		dateOfBirth.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("dateOfBirth"));
		city.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("city"));
		phone.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("phone"));
		departament.setCellValueFactory(
				new PropertyValueFactory<StudentMembersDto, String>("departament"));

	}

	@Override
	public List<TableColumn> getColumns() {
		return Arrays.asList(studentNo, studentFName, studentLName, dateOfBirth, city, phone, departament);
	}
}
