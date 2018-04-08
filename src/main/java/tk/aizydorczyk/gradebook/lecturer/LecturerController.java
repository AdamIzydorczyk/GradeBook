package tk.aizydorczyk.gradebook.lecturer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseController;
import tk.aizydorczyk.gradebook.infrastructure.base.MainController;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerStudentRecord;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerSubjectRecord;

@Component
class LecturerController extends BaseController {

	@FXML
	private TableView lecturerTableView;

	@FXML
	private TextField selectedSubjectTextField;

	@FXML
	private TextField selectedNoTextField;

	@Autowired
	private MainController mainController;

	@Autowired
	private LecturerService lecturerService;

	@FXML
	private void logoutButtonClick(ActionEvent actionEvent) {
		mainController.logOut();
	}

	@FXML
	private void lecturerStudentsClick(ActionEvent actionEvent) {
		initializeTable(lecturerTableView, actionEvent, lecturerService::getStudents);
	}

	@FXML
	private void lecturerGradeClick(ActionEvent actionEvent) {
		initializeTable(lecturerTableView, actionEvent, () -> lecturerService.getGrades(selectedNoTextField.getText(), selectedSubjectTextField.getText()));
	}

	@FXML
	private void lecturerSubjectsClick(ActionEvent actionEvent) {
		initializeTable(lecturerTableView, actionEvent, () -> lecturerService.getSubjects());
	}

	@FXML
	private void lecturerTableViewClick(MouseEvent e) {
		final Object selectedItem = lecturerTableView.getSelectionModel().getSelectedItem();

		if (selectedItem != null)
			switch (selectedItem.getClass().getSimpleName()) {
				case "LecturerStudentRecord":
					selectedNoTextField.setText(((LecturerStudentRecord) selectedItem).getStudentNo());
					break;
				case "LecturerSubjectRecord":
					selectedSubjectTextField.setText(((LecturerSubjectRecord) selectedItem).getSubjectName());
					break;
			}
	}

	@FXML
	private void lecturerDepartamentsClick(ActionEvent actionEvent) {

	}

	@FXML
	private void projectTopicsClick(ActionEvent actionEvent) {

	}

	@FXML
	private void lecturerGroupsClick(ActionEvent actionEvent) {

	}

	@FXML
	private void memberOfGroupClick(ActionEvent actionEvent) {

	}
}
