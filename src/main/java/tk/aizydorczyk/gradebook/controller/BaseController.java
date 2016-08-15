package tk.aizydorczyk.gradebook.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.factory.ColumnModelFactory;
import tk.aizydorczyk.gradebook.service.LoginService;
import tk.aizydorczyk.gradebook.utility.AlertUtil;

import java.util.List;
import java.util.function.Supplier;

@Component
public abstract class BaseController {

	@Autowired
	private ColumnModelFactory modelFactory;

	@Autowired
	protected LoginService loginService;

	@Autowired
	protected AlertUtil alertUtil;

	protected <T> void initializeTable(TableView tableView, ActionEvent actionEvent, Supplier<List<T>> serviceSupplier) {
		clearTable(tableView);
		List<T> response = serviceSupplier.get();
		ObservableList<T> data = FXCollections.observableArrayList(response);
		tableView.setItems(data);
		tableView.getColumns().addAll(modelFactory.getColumnModel(((Button) actionEvent.getTarget()).getId()).getColumns());
	}

	private void clearTable(TableView tableView) {
		tableView.getItems().clear();
		tableView.getColumns().clear();
	}

}
