package tk.aizydorczyk.gradebook.student;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseController;
import tk.aizydorczyk.gradebook.infrastructure.base.MainController;
import tk.aizydorczyk.gradebook.student.records.StudentGroupRecord;
import tk.aizydorczyk.gradebook.student.records.StudentSubjectRecord;

@Component
public class StudentController extends BaseController {

	@Autowired
	private StudentService studentService;

	@FXML
	private TableView studentTableView;

	@Autowired
	private MainController mainController;

	@FXML
	private void logoutButtonClick(ActionEvent actionEvent) {
		mainController.logOut();
	}

	@FXML
	private void studentSemestersButtonClick(ActionEvent actionEvent) {
		initializeTable(studentTableView, actionEvent, studentService::getSemesters);
	}

	@FXML
	private void studentSubjectsButtonClick(ActionEvent actionEvent) {
		initializeTable(studentTableView, actionEvent, studentService::getSubjects);
	}

	@FXML
	private void studentGradesButtonClick(ActionEvent actionEvent) {
		try {
			StudentSubjectRecord selectedItem = (StudentSubjectRecord) studentTableView.getSelectionModel().getSelectedItem();
			initializeTable(studentTableView, actionEvent, () ->
					studentService.getGrades(selectedItem.getSubjectName()));
		} catch (NullPointerException ex) {
			alertUtil.noSelectedSubjectAlert();
		}
	}

	@FXML
	private void studentGroupsButtonClick(ActionEvent actionEvent) {
		initializeTable(studentTableView, actionEvent, studentService::getGroups);
	}

	@FXML
	private void studentMembersOfGroupClick(ActionEvent actionEvent) {
		try {
			final StudentGroupRecord selectedItem = (StudentGroupRecord) studentTableView.getSelectionModel().getSelectedItem();
			initializeTable(studentTableView, actionEvent, () ->
					studentService.getMembers(selectedItem.getTopic()));
		} catch (NullPointerException ex) {
			alertUtil.noSelectedSubjectAlert();
		}
	}

	@FXML
	private void studentLecturersButtonClick(ActionEvent actionEvent) {
		initializeTable(studentTableView, actionEvent, studentService::getLecturers);
	}
}
