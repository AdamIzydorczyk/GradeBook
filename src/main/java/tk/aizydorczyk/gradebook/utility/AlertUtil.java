package tk.aizydorczyk.gradebook.utility;

import javafx.scene.control.Alert;
import org.springframework.stereotype.Component;

@Component
public class AlertUtil {

	public void authorizationFailAlert() {
		showAlert("Information Dialog", "Bad login or password");
	}

	public void noSelectedSubjectAlert() {
		showAlert("Information Dialog", "not selected subject");
	}

	private void showAlert(String title, String contentText) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(contentText);
		alert.showAndWait();
	}
}
