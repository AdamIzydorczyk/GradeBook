package tk.aizydorczyk.gradebook.lecturer;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseDao;
import tk.aizydorczyk.gradebook.infrastructure.entity.Department;
import tk.aizydorczyk.gradebook.infrastructure.entity.Department_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Grade;
import tk.aizydorczyk.gradebook.infrastructure.entity.Grade_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Lecturer;
import tk.aizydorczyk.gradebook.infrastructure.entity.Lecturer_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Semester;
import tk.aizydorczyk.gradebook.infrastructure.entity.Semester_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Student;
import tk.aizydorczyk.gradebook.infrastructure.entity.Student_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Subject;
import tk.aizydorczyk.gradebook.infrastructure.entity.Subject_;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerGradeRecord;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerStudentRecord;
import tk.aizydorczyk.gradebook.lecturer.records.LecturerSubjectRecord;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
class LecturerDao extends BaseDao {

	@Transactional
	public List<LecturerStudentRecord> getStudents(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<LecturerStudentRecord> query = criteriaBuilder.createQuery(LecturerStudentRecord.class);
		final Root<Student> student = query.from(Student.class);
		final ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		final Join<Semester, Department> departament = semester.join(Semester_.departament);
		final ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);

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
	public List<LecturerGradeRecord> getGrades(String studentNo, String subjectName) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<LecturerGradeRecord> query = criteriaBuilder.createQuery(LecturerGradeRecord.class);
		final Root<Grade> grade = query.from(Grade.class);
		final Join<Grade, Subject> subject = grade.join(Grade_.subject);
		final Join<Grade, Student> student = grade.join(Grade_.student);

		final Predicate equalSubjectName = criteriaBuilder.equal(subject.get(Subject_.subjectName), subjectName);
		final Predicate equalStudentNo = criteriaBuilder.equal(student.get(Student_.studentNo), studentNo);
		final Predicate andStudentNoSubjectName = criteriaBuilder.and(equalSubjectName, equalStudentNo);
		query.multiselect(
				grade.get(Grade_.grade),
				grade.get(Grade_.description),
				subject.get(Subject_.subjectName))
				.where(andStudentNoSubjectName);

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<LecturerSubjectRecord> getSubjects(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<LecturerSubjectRecord> query = criteriaBuilder.createQuery(LecturerSubjectRecord.class);
		final Root<Lecturer> lecturer = query.from(Lecturer.class);
		final ListJoin<Lecturer, Subject> subject = lecturer.join(Lecturer_.subjects);

		query.multiselect(
				subject.get(Subject_.subjectName),
				subject.get(Subject_.hours))
				.where(criteriaBuilder.equal(lecturer.get(Lecturer_.id), id));

		return entityManager.createQuery(query).getResultList();
	}
}
