package tk.aizydorczyk.gradebook.infrastructure;

public enum Constants {
	MAIN_VIEW_PATCH("view/mainLayout.fxml"),
	LECTURER_GRADE_COL_MODEL_GRADE("LecturerGradeColModelGrade"),
	LECTURER_GRADE_COL_MODEL_DESCRIPTION("LecturerGradeColModelDescription"),
	LECTURER_SUBJECT_COL_MODEL_SUBJECT_NAME("LecturerSubjectColModelSubjectName"),
	LECTURER_STUDENTS_COL_MODEL_NO("LecturerStudentsColModelNo"),
	LECTURER_STUDENTS_COL_MODEL_FNAME("LecturerStudentsColModelFname"),
	LECTURER_STUDENTS_COL_MODEL_LNAME("LecturerStudentsColModelLname"),
	LECTURER_STUDENTS_COL_MODEL_DOB("LecturerStudentsColModelDob"),
	LECTURER_STUDENTS_COL_MODEL_CITY("LecturerStudentsColModelCity"),
	LECTURER_STUDENTS_COL_MODEL_PHONE("LecturerStudentsColModelPhone"),
	LECTURER_STUDENTS_COL_MODEL_DEPARTAMENT("LecturerStudentsColModelDepartament"),
	LECTURER_SUBJECT_COL_MODEL_HOURS("LecturerSubjectColModelHours"),
	STUDENT_GRADE_COL_MODEL_GRADE("StudentGradeColModelGrade"),
	STUDENT_GRADE_COL_MODEL_DESCRIPTION("StudentGradeColModelDescription"),
	STUDENTGROUPCOLMODELTOPIC("StudentGroupColModelTopic"),
	STUDENT_GROUP_COL_MODEL_GRADE_NUMBER_OF_MEMBERS("StudentGroupColModelGradeNumberOfMembers"),
	STUDENT_LECTURER_COL_MODEL_FNAME("StudentLecturerColModelFname"),
	STUDENT_LECTURER_COL_MODEL_LNAME("StudentLecturerColModelLname"),
	STUDENT_LECTURER_COL_MODEL_DEGREE("StudentLecturerColModelDegree"),
	STUDENT_MEMBERS_COL_MODEL_FNAME("StudentMembersColModelFname"),
	STUDENT_MEMBERS_COL_MODEL_LNAME("StudentMembersColModelLname"),
	STUDENT_SEMESTER_COL_MODEL_SEMESTR_NUMBER("StudentSemesterColModelSemestrNumber"),
	STUDENT_SEMESTER_COL_MODEL_YEAR("StudentSemesterColModelYear"),
	STUDENT_SUBJECT_COL_MODEL_SUBJECT_NAME("StudentSubjectColModelSubjectName"),
	STUDENT_SUBJECT_COL_MODEL_HOURS("StudentSubjectColModelHours"),
	STUDENT_SUBJECT_COL_MODEL_LECTURER_NAME("StudentSubjectColModelLecturerName"),
	STUDENT_SUBJECT_COL_MODEL_AVERAGE("StudentSubjectColModelAverage"),
	SUBJECT_GRADE("grade"),
	DESCRIPTION("description"),
	SUBJECT_NAME("subjectName"),
	STUDENT_NO("studentNo"),
	STUDENT_FNAME("studentFName"),
	STUDENT_LNAME("studentLName"),
	DATE_OF_BIRTH("dateOfBirth"),
	CITY("city"),
	PHONE("phone"),
	DEPARTMENT("department"),
	HOURS("hours"),
	SUBJECT_TEXT("subject"),
	TOPIC("topic"),
	NUMBER_OF_MEMBERS("numberOfMembers"),
	LECTURER_FNAME("lecturerFName"),
	LECTURER_LNAME("lecturerLName"),
	FNAME("fname"),
	LNAME("lname"),
	SEMESTER_NUMBER("semesterNumber"),
	YEAR("year"),
	LECTURER_NAME("lecturerName"),
	AVERAGE("average"),
	DEGREE("degree"),
	LOGIN_WINDOW("loginWindow"),
	STUDENT_WINDOW("studentWindow"),
	LECTURER_WINDOW("lecturerWindow"),
	LECTURER_STUDENTS_BUTTON("lecturerStudentsButton"),
	LECTURER_SUBJECTS_BUTTON("lecturerSubjectsButton"),
	LECTURER_GRADE_BUTTON("lecturerGradeButton"),
	STUDENT_SEMESTERS_BUTTON("studentSemestersButton"),
	STUDENT_SUBJECTS_BUTTON("studentSubjectsButton"),
	STUDENT_GRADES_BUTTON("studentGradesButton"),
	STUDENT_GROUPS_BUTTON("studentGroupsButton"),
	STUDENT_MEMBERS_OF_GROUP("studentMembersOfGroup"),
	STUDENT_LECTURERS_BUTTON("studentLecturersButton");

	private final String constant;

	Constants(String constant) {
		this.constant = constant;
	}

	public String value() {
		return constant;
	}
}
