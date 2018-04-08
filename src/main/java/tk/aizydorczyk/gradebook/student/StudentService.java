package tk.aizydorczyk.gradebook.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseService;
import tk.aizydorczyk.gradebook.student.records.StudentGradeRecord;
import tk.aizydorczyk.gradebook.student.records.StudentGroupRecord;
import tk.aizydorczyk.gradebook.student.records.StudentLecturerRecord;
import tk.aizydorczyk.gradebook.student.records.StudentMembersRecord;
import tk.aizydorczyk.gradebook.student.records.StudentSemesterRecord;
import tk.aizydorczyk.gradebook.student.records.StudentSubjectRecord;

import java.util.List;

@Service
class StudentService extends BaseService {

	@Autowired
	private StudentDao studentDao;

	List<StudentSemesterRecord> getSemesters() {
		return studentDao.getSemesters(systemContext.getLoggedAccountId());
	}

	List<StudentSubjectRecord> getSubjects() {
		return studentDao.getSubjects(systemContext.getLoggedAccountId());
	}

	List<StudentGradeRecord> getGrades(String subjectName) {
		return studentDao.getGrades(systemContext.getLoggedAccountId(), subjectName);
	}

	List<StudentGroupRecord> getGroups() {
		return studentDao.getGroups(systemContext.getLoggedAccountId());
	}

	List<StudentMembersRecord> getMembers(String topic) {
		return studentDao.getMembers(systemContext.getLoggedAccountId(), topic);
	}

	List<StudentLecturerRecord> getLecturers() {
		return studentDao.getLecturers(systemContext.getLoggedAccountId());
	}
}
