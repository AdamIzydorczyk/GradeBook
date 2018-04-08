package tk.aizydorczyk.gradebook.infrastructure.base;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.WindowsProperties;
import tk.aizydorczyk.gradebook.infrastructure.utility.WindowContext;

import java.net.URL;
import java.util.ResourceBundle;

import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_WINDOW;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LOGIN_WINDOW;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_WINDOW;

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
				LOGIN_WINDOW.value());
		studentLayout.setVisible(false);
		teacherLayout.setVisible(false);
		loginLayout.setVisible(true);
	}

	public void changeToStudentLayout() {
		WindowContext.setWindowProperties(WindowsProperties.STUDENT_LAYOUT_SCALE,
				STUDENT_WINDOW.value());
		loginLayout.setVisible(false);
		studentLayout.setVisible(true);
	}

	public void changeToLecturerLayout() {
		WindowContext.setWindowProperties(WindowsProperties.TEACHER_LAYOUT_SCALE,
				LECTURER_WINDOW.value());
		loginLayout.setVisible(false);
		teacherLayout.setVisible(true);
	}
}
