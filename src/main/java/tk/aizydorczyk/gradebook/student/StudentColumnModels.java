package tk.aizydorczyk.gradebook.student;

import javafx.scene.control.TableColumn;
import tk.aizydorczyk.gradebook.infrastructure.Constants;
import tk.aizydorczyk.gradebook.infrastructure.base.ColModel;

import java.util.List;

import static org.springframework.data.util.Pair.of;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.AVERAGE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.DEGREE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.HOURS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.NUMBER_OF_MEMBERS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.SEMESTER_NUMBER;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENTGROUPCOLMODELTOPIC;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_GRADES_BUTTON;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_GRADE_COL_MODEL_DESCRIPTION;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_GRADE_COL_MODEL_GRADE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_GROUPS_BUTTON;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_GROUP_COL_MODEL_GRADE_NUMBER_OF_MEMBERS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_LECTURERS_BUTTON;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_LECTURER_COL_MODEL_DEGREE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_LECTURER_COL_MODEL_FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_LECTURER_COL_MODEL_LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_MEMBERS_COL_MODEL_FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_MEMBERS_COL_MODEL_LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_MEMBERS_OF_GROUP;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SEMESTERS_BUTTON;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SEMESTER_COL_MODEL_SEMESTR_NUMBER;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SEMESTER_COL_MODEL_YEAR;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SUBJECTS_BUTTON;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SUBJECT_COL_MODEL_AVERAGE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SUBJECT_COL_MODEL_HOURS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SUBJECT_COL_MODEL_LECTURER_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_SUBJECT_COL_MODEL_SUBJECT_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.SUBJECT_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.SUBJECT_TEXT;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.TOPIC;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.YEAR;
import static tk.aizydorczyk.gradebook.infrastructure.utility.WindowContext.getLocalizedTableColumns;

@SuppressWarnings("unchecked")
public enum StudentColumnModels implements ColModel {
	GRADE {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {

			return getLocalizedTableColumns(
					of(STUDENT_GRADE_COL_MODEL_GRADE.value(), Constants.SUBJECT_GRADE.value()),
					of(STUDENT_GRADE_COL_MODEL_DESCRIPTION.value(), Constants.DESCRIPTION.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_GRADES_BUTTON.value();
		}
	}, GROUP {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(STUDENT_GRADE_COL_MODEL_GRADE.value(), SUBJECT_TEXT.value()),
					of(STUDENTGROUPCOLMODELTOPIC.value(), TOPIC.value()),
					of(STUDENT_GROUP_COL_MODEL_GRADE_NUMBER_OF_MEMBERS.value(), NUMBER_OF_MEMBERS.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_GROUPS_BUTTON.value();
		}
	}, LECTURER {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {

			return getLocalizedTableColumns(
					of(STUDENT_LECTURER_COL_MODEL_FNAME.value(), LECTURER_FNAME.value()),
					of(STUDENT_LECTURER_COL_MODEL_LNAME.value(), LECTURER_LNAME.value()),
					of(STUDENT_LECTURER_COL_MODEL_DEGREE.value(), DEGREE.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_LECTURERS_BUTTON.value();
		}
	}, MEMBERS {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(STUDENT_MEMBERS_COL_MODEL_FNAME.value(), FNAME.value()),
					of(STUDENT_MEMBERS_COL_MODEL_LNAME.value(), LNAME.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_MEMBERS_OF_GROUP.value();
		}
	}, SEMESTER {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(STUDENT_SEMESTER_COL_MODEL_SEMESTR_NUMBER.value(), SEMESTER_NUMBER.value()),
					of(STUDENT_SEMESTER_COL_MODEL_YEAR.value(), YEAR.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_SEMESTERS_BUTTON.value();
		}
	}, SUBJECT {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(STUDENT_SUBJECT_COL_MODEL_SUBJECT_NAME.value(), SUBJECT_NAME.value()),
					of(STUDENT_SUBJECT_COL_MODEL_HOURS.value(), HOURS.value()),
					of(STUDENT_SUBJECT_COL_MODEL_LECTURER_NAME.value(), LECTURER_NAME.value()),
					of(STUDENT_SUBJECT_COL_MODEL_AVERAGE.value(), AVERAGE.value())
			);
		}

		@Override
		public String getButtonName() {
			return STUDENT_SUBJECTS_BUTTON.value();
		}
	}

}
