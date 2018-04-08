package tk.aizydorczyk.gradebook.infrastructure.base;

import javafx.scene.control.TableColumn;

import java.util.List;

@FunctionalInterface
public interface ColModel {
	<S, T> List<TableColumn<S, T>> getColumns();
}
