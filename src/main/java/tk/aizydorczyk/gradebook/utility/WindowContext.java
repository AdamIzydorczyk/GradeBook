package tk.aizydorczyk.gradebook.utility;

import javafx.stage.Stage;
import tk.aizydorczyk.gradebook.app.GradeBookApplication;
import tk.aizydorczyk.gradebook.enums.WindowsProperties;

import java.util.Locale;
import java.util.ResourceBundle;

public class WindowContext {

	public static void setWindowProperties(WindowsProperties properties, String languageBundleKey) {
		Stage primaryStage = GradeBookApplication.getPrimaryStage();

		primaryStage.setWidth(properties.getWidth());
		primaryStage.setHeight(properties.getHeight());

		String title = getLocalizedText(languageBundleKey);
		primaryStage.setTitle(title);
	}


	public static void setLanguageBundleLocale(String lng) {
		ResourceBundle languageBundle = ResourceBundle.getBundle("languages.strings", new Locale(lng));
		GradeBookApplication.setLanguageBundle(languageBundle);
	}

	public static String getLocalizedText(String languageBundleKey) {
		return GradeBookApplication.getLanguageBundle().getString(languageBundleKey);
	}

	public static void reload() {
		GradeBookApplication.reload();
	}
}
