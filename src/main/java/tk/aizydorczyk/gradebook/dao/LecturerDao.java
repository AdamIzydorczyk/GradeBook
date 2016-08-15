package tk.aizydorczyk.gradebook.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerGradeDto;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerStudentDto;
import tk.aizydorczyk.gradebook.model.dto.lecturer.LecturerSubjectDto;
import tk.aizydorczyk.gradebook.model.entity.Department;
import tk.aizydorczyk.gradebook.model.entity.Department_;
import tk.aizydorczyk.gradebook.model.entity.Grade;
import tk.aizydorczyk.gradebook.model.entity.Grade_;
import tk.aizydorczyk.gradebook.model.entity.Lecturer;
import tk.aizydorczyk.gradebook.model.entity.Lecturer_;
import tk.aizydorczyk.gradebook.model.entity.Semester;
import tk.aizydorczyk.gradebook.model.entity.Semester_;
import tk.aizydorczyk.gradebook.model.entity.Student;
import tk.aizydorczyk.gradebook.model.entity.Student_;
import tk.aizydorczyk.gradebook.model.entity.Subject;
import tk.aizydorczyk.gradebook.model.entity.Subject_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class LecturerDao extends BaseDao {

	@Transactional
	public List<LecturerStudentDto> getStudents(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LecturerStudentDto> query = criteriaBuilder.createQuery(LecturerStudentDto.class);
		Root<Student> student = query.from(Student.class);
		ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		Join<Semester, Department> departament = semester.join(Semester_.departament);
		ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);

		query.multiselect(
				student.get(Student_.studentNo),
				student.get(Student_.studentFName),
				student.get(Student_.studentLName),
				student.get(Student_.dateOfBirth),
				student.get(Student_.city),
				student.get(Student_.phone),
				departament.get(Department_.departamentName))
				.where(criteriaBuilder.equal(lecturer.get(Lecturer_.id), id))
				.distinct(true);

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<LecturerGradeDto> getGrades(String studentNo, String subjectName) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LecturerGradeDto> query = criteriaBuilder.createQuery(LecturerGradeDto.class);
		Root<Grade> grade = query.from(Grade.class);
		Join<Grade, Subject> subject = grade.join(Grade_.subject);
		Join<Grade, Student> student = grade.join(Grade_.student);

		Predicate equalSubjectName = criteriaBuilder.equal(subject.get(Subject_.subjectName), subjectName);
		Predicate equalStudentNo = criteriaBuilder.equal(student.get(Student_.studentNo), studentNo);
		Predicate andStudentNoSubjectName = criteriaBuilder.and(equalSubjectName, equalStudentNo);
		query.multiselect(
				grade.get(Grade_.grade),
				grade.get(Grade_.description),
				subject.get(Subject_.subjectName))
				.where(andStudentNoSubjectName);

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<LecturerSubjectDto> getSubjects(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<LecturerSubjectDto> query = criteriaBuilder.createQuery(LecturerSubjectDto.class);
		Root<Lecturer> lecturer = query.from(Lecturer.class);
		ListJoin<Lecturer, Subject> subject = lecturer.join(Lecturer_.subjects);

		query.multiselect(
				subject.get(Subject_.subjectName),
				subject.get(Subject_.hours))
				.where(criteriaBuilder.equal(lecturer.get(Lecturer_.id), id));

		return entityManager.createQuery(query).getResultList();
	}
}
