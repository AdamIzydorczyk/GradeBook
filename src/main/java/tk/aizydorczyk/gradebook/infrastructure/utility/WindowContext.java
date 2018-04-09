package tk.aizydorczyk.gradebook.infrastructure.utility;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.springframework.data.util.Pair;
import tk.aizydorczyk.gradebook.infrastructure.GradeBookApplication;
import tk.aizydorczyk.gradebook.infrastructure.WindowsProperties;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WindowContext {

	public static void setWindowProperties(WindowsProperties properties, String languageBundleKey) {
		final Stage primaryStage = GradeBookApplication.getPrimaryStage();

		primaryStage.setWidth(properties.getWidth());
		primaryStage.setHeight(properties.getHeight());

		String title = getLocalizedText(languageBundleKey);
		primaryStage.setTitle(title);
	}


	public static void setLanguageBundleLocale(String lng) {
		final ResourceBundle languageBundle = ResourceBundle.getBundle("languages.strings", new Locale(lng));
		GradeBookApplication.setLanguageBundle(languageBundle);
	}

	@SafeVarargs
	public static <S, T> List<TableColumn<S, T>> getLocalizedTableColumns(Pair<String, String>... bundleKeyAndColumnNamesPairs) {
		return Stream.of(bundleKeyAndColumnNamesPairs).map(pair -> {
			final TableColumn<S, T> localizedTableColumn = getLocalizedTableColumn(pair.getFirst());
			localizedTableColumn.setCellValueFactory(new PropertyValueFactory<>(pair.getSecond()));
			return localizedTableColumn;
		}).collect(Collectors.toList());
	}

	private static String getLocalizedText(String languageBundleKey) {
		return GradeBookApplication.getLanguageBundle().getString(languageBundleKey);
	}

	private static <S, T> TableColumn<S, T> getLocalizedTableColumn(String languageBundleKey) {
		return new TableColumn<>(WindowContext.getLocalizedText(languageBundleKey));
	}

	public static void reload() {
		GradeBookApplication.reload();
	}
}
