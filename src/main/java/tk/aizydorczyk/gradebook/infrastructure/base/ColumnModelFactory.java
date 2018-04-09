package tk.aizydorczyk.gradebook.infrastructure.base;

import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.lecturer.LecturerColumnModels;
import tk.aizydorczyk.gradebook.student.StudentColumnModels;

import java.util.stream.Stream;

@Component
class ColumnModelFactory {
	ColModel getColumnModel(String buttonName) {
		final Stream<ColModel> lecturerColModels = Stream.of(LecturerColumnModels.values());
		final Stream<ColModel> studentColModels = Stream.of(StudentColumnModels.values());

		return Stream.concat(lecturerColModels, studentColModels)
				.filter(colModel -> colModel.getButtonName().equals(buttonName))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
