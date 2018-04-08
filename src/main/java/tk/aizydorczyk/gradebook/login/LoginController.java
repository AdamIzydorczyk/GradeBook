package tk.aizydorczyk.gradebook.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.WindowsProperties;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseController;
import tk.aizydorczyk.gradebook.infrastructure.utility.WindowContext;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class LoginController extends BaseController implements Initializable {

	@FXML
	private PasswordField passwordTextField;

	@FXML
	private TextField loginTextField;

	@FXML
	private ComboBox<Locale> languageComboBox;

	@Autowired
	private LoginService loginService;

	@FXML
	private void signInButtonClicked(ActionEvent actionEvent) {
		loginService.login(loginTextField.getText(), passwordTextField.getText());
	}

	@FXML
	private void changeLanguage(ActionEvent actionEvent) {
		final String lng = languageComboBox.getSelectionModel().getSelectedItem().toString();
		WindowContext.setLanguageBundleLocale(lng);
		WindowContext.reload();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		languageComboBox.setValue(resources.getLocale());

		WindowContext.setWindowProperties(
				WindowsProperties.LOGIN_LAYOUT_SCALE, "loginWindow");
	}
}

