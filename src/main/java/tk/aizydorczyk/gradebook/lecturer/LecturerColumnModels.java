package tk.aizydorczyk.gradebook.lecturer;

import javafx.scene.control.TableColumn;
import tk.aizydorczyk.gradebook.infrastructure.Constants;
import tk.aizydorczyk.gradebook.infrastructure.base.ColModel;

import java.util.List;

import static org.springframework.data.util.Pair.of;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.CITY;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.DATE_OF_BIRTH;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.DEPARTMENT;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.DESCRIPTION;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.HOURS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_GRADE_COL_MODEL_DESCRIPTION;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_GRADE_COL_MODEL_GRADE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_CITY;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_DEPARTAMENT;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_DOB;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_NO;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_STUDENTS_COL_MODEL_PHONE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_SUBJECT_COL_MODEL_HOURS;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.LECTURER_SUBJECT_COL_MODEL_SUBJECT_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.PHONE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_FNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_LNAME;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.STUDENT_NO;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.SUBJECT_GRADE;
import static tk.aizydorczyk.gradebook.infrastructure.Constants.SUBJECT_NAME;
import static tk.aizydorczyk.gradebook.infrastructure.utility.WindowContext.getLocalizedTableColumns;

public enum LecturerColumnModels implements ColModel {
	GRADE {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(LECTURER_GRADE_COL_MODEL_GRADE.value(), SUBJECT_GRADE.value()),
					of(LECTURER_GRADE_COL_MODEL_DESCRIPTION.value(), DESCRIPTION.value()),
					of(LECTURER_SUBJECT_COL_MODEL_SUBJECT_NAME.value(), SUBJECT_NAME.value())
			);
		}
	}, STUDENTS {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(LECTURER_STUDENTS_COL_MODEL_NO.value(), STUDENT_NO.value()),
					of(LECTURER_STUDENTS_COL_MODEL_FNAME.value(), STUDENT_FNAME.value()),
					of(LECTURER_STUDENTS_COL_MODEL_LNAME.value(), STUDENT_LNAME.value()),
					of(LECTURER_STUDENTS_COL_MODEL_DOB.value(), DATE_OF_BIRTH.value()),
					of(LECTURER_STUDENTS_COL_MODEL_CITY.value(), CITY.value()),
					of(LECTURER_STUDENTS_COL_MODEL_PHONE.value(), PHONE.value()),
					of(LECTURER_STUDENTS_COL_MODEL_DEPARTAMENT.value(), DEPARTMENT.value())
			);
		}
	}, SUBJECT {
		@Override
		public <S, T> List<TableColumn<S, T>> getColumns() {
			return getLocalizedTableColumns(
					of(LECTURER_SUBJECT_COL_MODEL_SUBJECT_NAME.value(), SUBJECT_NAME.value()),
					of(LECTURER_SUBJECT_COL_MODEL_HOURS.value(), HOURS.value())
			);
		}
	};

	public final static String LECTURER_STUDENTS_BUTTON = "lecturerStudentsButton";
	public final static String LECTURER_SUBJECTS_BUTTON = "lecturerSubjectsButton";
	public final static String LECTURER_GRADE_BUTTON = "lecturerGradeButton";
}
