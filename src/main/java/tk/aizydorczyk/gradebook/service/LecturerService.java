package tk.aizydorczyk.gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.aizydorczyk.gradebook.dao.LecturerDao;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerGradeDto;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerStudentDto;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerSubjectDto;

import java.util.List;

@Service
public class LecturerService extends BaseService {

	@Autowired
	private LecturerDao lecturerDao;

	public List<LecturerStudentDto> getStudents() {
		return lecturerDao.getStudents(systemContext.getLoggedAccountId());
	}

	public List<LecturerGradeDto> getGrades(String studentNo, String subjectName) {
		return lecturerDao.getGrades(studentNo, subjectName);
	}

	public List<LecturerSubjectDto> getSubjects() {
		return lecturerDao.getSubjects(systemContext.getLoggedAccountId());
	}
}
