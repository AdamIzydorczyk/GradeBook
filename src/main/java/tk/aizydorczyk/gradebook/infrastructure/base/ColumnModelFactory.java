package tk.aizydorczyk.gradebook.infrastructure.base;

import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.lecturer.LecturerColumnModels;
import tk.aizydorczyk.gradebook.student.StudentColumnModels;

import static tk.aizydorczyk.gradebook.lecturer.LecturerColumnModels.LECTURER_GRADE_BUTTON;
import static tk.aizydorczyk.gradebook.lecturer.LecturerColumnModels.LECTURER_STUDENTS_BUTTON;
import static tk.aizydorczyk.gradebook.lecturer.LecturerColumnModels.LECTURER_SUBJECTS_BUTTON;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_GRADES_BUTTON;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_GROUPS_BUTTON;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_LECTURERS_BUTTON;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_MEMBERS_OF_GROUP;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_SEMESTERS_BUTTON;
import static tk.aizydorczyk.gradebook.student.StudentColumnModels.STUDENT_SUBJECTS_BUTTON;

@Component
class ColumnModelFactory {
	ColModel getColumnModel(String buttonName) {
		switch (buttonName) {
			case STUDENT_SEMESTERS_BUTTON:
				return StudentColumnModels.SEMESTER;
			case STUDENT_SUBJECTS_BUTTON:
				return StudentColumnModels.SUBJECT;
			case STUDENT_GRADES_BUTTON:
				return StudentColumnModels.GRADE;
			case STUDENT_GROUPS_BUTTON:
				return StudentColumnModels.GROUP;
			case STUDENT_MEMBERS_OF_GROUP:
				return StudentColumnModels.MEMBERS;
			case STUDENT_LECTURERS_BUTTON:
				return StudentColumnModels.LECTURER;
			case LECTURER_STUDENTS_BUTTON:
				return LecturerColumnModels.STUDENTS;
			case LECTURER_SUBJECTS_BUTTON:
				return LecturerColumnModels.SUBJECT;
			case LECTURER_GRADE_BUTTON:
				return LecturerColumnModels.GRADE;
		}
		throw new IllegalArgumentException();
	}


}
