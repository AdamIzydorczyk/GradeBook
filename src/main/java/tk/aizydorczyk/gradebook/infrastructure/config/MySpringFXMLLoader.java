package tk.aizydorczyk.gradebook.infrastructure.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.Constants;
import tk.aizydorczyk.gradebook.infrastructure.GradeBookApplication;

import java.io.IOException;
import java.util.ResourceBundle;

@Component
public class MySpringFXMLLoader {

	@Autowired
	private ApplicationContext context;

	public Parent load(ResourceBundle languageBundle) throws IOException {
		final FXMLLoader loader = new FXMLLoader(GradeBookApplication.class.getClassLoader().getResource(Constants.MAIN_VIEW_PATCH.value()), languageBundle);
		loader.setControllerFactory(this.context::getBean);
		return loader.load(MySpringFXMLLoader.class.getClassLoader().getResourceAsStream(Constants.MAIN_VIEW_PATCH.value()));
	}
}
