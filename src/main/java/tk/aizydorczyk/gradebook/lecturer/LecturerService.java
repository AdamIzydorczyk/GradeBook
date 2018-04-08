package tk.aizydorczyk.gradebook.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseService;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerGradeRecord;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerStudentRecord;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerSubjectRecord;

import java.util.List;

@Service
class LecturerService extends BaseService {

	@Autowired
	private LecturerDao lecturerDao;

	List<LecturerStudentRecord> getStudents() {
		return lecturerDao.getStudents(systemContext.getLoggedAccountId());
	}

	List<LecturerGradeRecord> getGrades(String studentNo, String subjectName) {
		return lecturerDao.getGrades(studentNo, subjectName);
	}

	List<LecturerSubjectRecord> getSubjects() {
		return lecturerDao.getSubjects(systemContext.getLoggedAccountId());
	}
}
