package tk.aizydorczyk.gradebook.infrastructure;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import tk.aizydorczyk.gradebook.infrastructure.config.MySpringFXMLLoader;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({"tk.aizydorczyk.gradebook"})
@EntityScan(basePackages = {"tk.aizydorczyk.gradebook.infrastructure.entity"})
public class GradeBookApplication extends Application {

	private static Parent root;
	private static ResourceBundle languageBundle;
	private static Stage primaryStage;
	private static ConfigurableApplicationContext applicationContext;

	public GradeBookApplication() {
		languageBundle = ResourceBundle.getBundle("languages.strings", new Locale("en"));
	}

	public static void reload() {
		try {
			final MySpringFXMLLoader loader = applicationContext.getBean(MySpringFXMLLoader.class);
			root = loader.load(languageBundle);
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(GradeBookApplication.class, args);
		launch(args);
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static ResourceBundle getLanguageBundle() {
		return languageBundle;
	}

	public static void setLanguageBundle(ResourceBundle languageBundle) {
		GradeBookApplication.languageBundle = languageBundle;
	}

	public void start(Stage primaryStage) throws Exception {
		GradeBookApplication.primaryStage = primaryStage;
		final MySpringFXMLLoader loader = applicationContext.getBean(MySpringFXMLLoader.class);
		root = loader.load(languageBundle);
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();

	}

	@Override
	public void stop() {
		applicationContext.stop();
	}
}

