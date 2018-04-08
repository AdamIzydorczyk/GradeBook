package tk.aizydorczyk.gradebook.infrastructure.base;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.infrastructure.utility.AlertUtil;

import java.util.List;
import java.util.function.Supplier;

@Component
public abstract class BaseController {

	@Autowired
	protected AlertUtil alertUtil;

	@Autowired
	private ColumnModelFactory modelFactory;

	protected <T> void initializeTable(TableView<T> tableView, ActionEvent actionEvent, Supplier<List<T>> serviceSupplier) {
		clearTable(tableView);
		final List<T> response = serviceSupplier.get();
		final ObservableList<T> data = FXCollections.observableArrayList(response);
		final String buttonId = getButtonId(actionEvent);
		tableView.setItems(data);
		tableView.getColumns().addAll(modelFactory.getColumnModel(buttonId).getColumns());
	}

	private String getButtonId(ActionEvent actionEvent) {
		return ((Button) actionEvent.getTarget()).getId();
	}

	private void clearTable(TableView tableView) {
		tableView.getItems().clear();
		tableView.getColumns().clear();
	}

}
