package tk.aizydorczyk.gradebook.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.enums.WindowsProperties;
import tk.aizydorczyk.gradebook.utility.WindowContext;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

	@FXML
	private AnchorPane loginLayout;

	@FXML
	private BorderPane studentLayout;

	@FXML
	private BorderPane teacherLayout;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginLayout.setVisible(true);
		studentLayout.setVisible(false);
		teacherLayout.setVisible(false);
	}

	public void logOut() {
		WindowContext.setWindowProperties(WindowsProperties.LOGIN_LAYOUT_SCALE,
				"loginWindow");
		studentLayout.setVisible(false);
		teacherLayout.setVisible(false);
		loginLayout.setVisible(true);
	}

	public void changeToStudentLayout() {
		WindowContext.setWindowProperties(WindowsProperties.STUDENT_LAYOUT_SCALE,
				"studentWindow");
		loginLayout.setVisible(false);
		studentLayout.setVisible(true);
	}

	public void changeToLecturerLayout() {
		WindowContext.setWindowProperties(WindowsProperties.TEACHER_LAYOUT_SCALE,
				"lecturerWindow");
		loginLayout.setVisible(false);
		teacherLayout.setVisible(true);
	}
}
