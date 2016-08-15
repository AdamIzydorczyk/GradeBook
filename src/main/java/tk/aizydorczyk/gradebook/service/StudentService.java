package tk.aizydorczyk.gradebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.aizydorczyk.gradebook.dao.StudentDao;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGradeDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGroupDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentLecturerDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSemesterDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSubjectDto;

import java.util.List;

@Service
public class StudentService extends BaseService {

	@Autowired
	private StudentDao studentDao;

	public List<StudentSemesterDto> getSemesters() {
		return studentDao.getSemesters(systemContext.getLoggedAccountId());
	}

	public List<StudentSubjectDto> getSubjects() {
		return studentDao.getSubjects(systemContext.getLoggedAccountId());
	}

	public List<StudentGradeDto> getGrades(String subjectName) {
		return studentDao.getGrades(systemContext.getLoggedAccountId(), subjectName);
	}

	public List<StudentGroupDto> getGroups() {
		return studentDao.getGroups(systemContext.getLoggedAccountId());
	}

	public List<StudentMembersDto> getMembers(String topic) {
		return studentDao.getMembers(systemContext.getLoggedAccountId(), topic);
	}

	public List<StudentLecturerDto> getLecturers() {
		return studentDao.getLecturers(systemContext.getLoggedAccountId());
	}
}
