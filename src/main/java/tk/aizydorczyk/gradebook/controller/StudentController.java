package tk.aizydorczyk.gradebook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGroupDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSubjectDto;
import tk.aizydorczyk.gradebook.service.StudentService;

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
			StudentSubjectDto selectedItem = (StudentSubjectDto) studentTableView.getSelectionModel().getSelectedItem();
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
			StudentGroupDto selectedItem = (StudentGroupDto) studentTableView.getSelectionModel().getSelectedItem();
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
