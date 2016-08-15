package tk.aizydorczyk.gradebook.factory;

import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.model.column.ColModel;
import tk.aizydorczyk.gradebook.model.column.lecturer.LecturerGradeColModel;
import tk.aizydorczyk.gradebook.model.column.lecturer.LecturerStudentsColModel;
import tk.aizydorczyk.gradebook.model.column.lecturer.LecturerSubjectColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentGradeColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentGroupColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentLecturerColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentMembersColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentSemesterColModel;
import tk.aizydorczyk.gradebook.model.column.student.StudentSubjectColModel;

@Component
public class ColumnModelFactory {
	public ColModel getColumnModel(String buttonName) {
		switch (buttonName) {
			case "studentSemestersButton":
				return new StudentSemesterColModel();
			case "studentSubjectsButton":
				return new StudentSubjectColModel();
			case "studentGradesButton":
				return new StudentGradeColModel();
			case "studentGroupsButton":
				return new StudentGroupColModel();
			case "studentMembersOfGroup":
				return new StudentMembersColModel();
			case "studentLecturersButton":
				return new StudentLecturerColModel();
			case "lecturerStudentsButton":
				return new LecturerStudentsColModel();
			case "lecturerSubjectsButton":
				return new LecturerSubjectColModel();
			case "lecturerGradeButton":
				return new LecturerGradeColModel();
		}
		return null;
	}


}
