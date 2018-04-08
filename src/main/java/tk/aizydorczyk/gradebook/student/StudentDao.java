package tk.aizydorczyk.gradebook.student;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseDao;
import tk.aizydorczyk.gradebook.infrastructure.entity.Department;
import tk.aizydorczyk.gradebook.infrastructure.entity.Department_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Grade;
import tk.aizydorczyk.gradebook.infrastructure.entity.Grade_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Group;
import tk.aizydorczyk.gradebook.infrastructure.entity.Group_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Lecturer;
import tk.aizydorczyk.gradebook.infrastructure.entity.Lecturer_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Semester;
import tk.aizydorczyk.gradebook.infrastructure.entity.Semester_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Student;
import tk.aizydorczyk.gradebook.infrastructure.entity.Student_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Subject;
import tk.aizydorczyk.gradebook.infrastructure.entity.Subject_;
import tk.aizydorczyk.gradebook.infrastructure.entity.Topic;
import tk.aizydorczyk.gradebook.infrastructure.entity.Topic_;
import tk.aizydorczyk.gradebook.student.records.StudentGradeRecord;
import tk.aizydorczyk.gradebook.student.records.StudentGroupRecord;
import tk.aizydorczyk.gradebook.student.records.StudentLecturerRecord;
import tk.aizydorczyk.gradebook.student.records.StudentMembersRecord;
import tk.aizydorczyk.gradebook.student.records.StudentSemesterRecord;
import tk.aizydorczyk.gradebook.student.records.StudentSubjectRecord;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
class StudentDao extends BaseDao {

	@Transactional
	List<StudentSemesterRecord> getSemesters(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentSemesterRecord> query = criteriaBuilder.createQuery(StudentSemesterRecord.class);
		final Root<Semester> semester = query.from(Semester.class);
		final Join<Semester, Student> students = semester.join(Semester_.students);

		query.multiselect(semester.get(Semester_.semesterNumber), semester.get(Semester_.year))
				.where(criteriaBuilder.equal(students.get(Student_.id), id));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	List<StudentSubjectRecord> getSubjects(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentSubjectRecord> query = criteriaBuilder.createQuery(StudentSubjectRecord.class);
		final Root<Student> student = query.from(Student.class);
		final ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		final Join<Semester, Department> departament = semester.join(Semester_.departament);
		final ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);
		final ListJoin<Lecturer, Subject> subject = lecturer.join(Lecturer_.subjects);
		final ListJoin<Subject, Grade> grade = subject.join(Subject_.grades);

		final Expression<String> lecturerFname = criteriaBuilder.concat(lecturer.get(Lecturer_.lecturerFName), " ");
		final Expression<String> lecturerFullName = criteriaBuilder.concat(lecturerFname, lecturer.get(Lecturer_.lecturerLName));

		query.multiselect(
				subject.get(Subject_.subjectName),
				subject.get(Subject_.hours),
				lecturerFullName,
				criteriaBuilder.avg(grade.get(Grade_.grade)))
				.where(criteriaBuilder.equal(student.get(Student_.id), id))
				.groupBy(subject.get(Subject_.subjectName));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	List<StudentGradeRecord> getGrades(long id, String subjectName) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentGradeRecord> query = criteriaBuilder.createQuery(StudentGradeRecord.class);
		final Root<Grade> grade = query.from(Grade.class);
		final Join<Grade, Subject> subject = grade.join(Grade_.subject);
		query.multiselect(
				grade.get(Grade_.grade),
				grade.get(Grade_.description))
				.where(criteriaBuilder.equal(subject.get(Subject_.subjectName), subjectName));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	List<StudentGroupRecord> getGroups(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentGroupRecord> query = criteriaBuilder.createQuery(StudentGroupRecord.class);

		final Root<Student> student = query.from(Student.class);
		final ListJoin<Student, Group> group = student.join(Student_.groups);
		final Join<Group, Subject> subject = group.join(Group_.subject);
		final Join<Group, Topic> topic = group.join(Group_.topic);

		final ListJoin<Group, Student> students2 = group.join(Group_.students);
		query.multiselect(
				subject.get(Subject_.subjectName),
				topic.get(Topic_.topicName),
				criteriaBuilder.count(students2.get(Student_.id)))
				.where(criteriaBuilder.equal(student.get(Student_.id), id));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	List<StudentMembersRecord> getMembers(long id, String topicName) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentMembersRecord> query = criteriaBuilder.createQuery(StudentMembersRecord.class);

		final Root<Student> student = query.from(Student.class);
		final ListJoin<Student, Group> group = student.join(Student_.groups);
		final Join<Group, Topic> topic = group.join(Group_.topic);
		final Predicate topicNameEqual = criteriaBuilder.equal(topic.get(Topic_.topicName), topicName);
		query.multiselect(
				student.get(Student_.studentFName),
				student.get(Student_.studentLName))
				.where(topicNameEqual);

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	List<StudentLecturerRecord> getLecturers(long id) {
		final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		final CriteriaQuery<StudentLecturerRecord> query = criteriaBuilder.createQuery(StudentLecturerRecord.class);

		final Root<Student> student = query.from(Student.class);
		final ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		final Join<Semester, Department> departament = semester.join(Semester_.departament);
		final ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);

		query.multiselect(
				lecturer.get(Lecturer_.lecturerFName),
				lecturer.get(Lecturer_.lecturerLName),
				lecturer.get(Lecturer_.degree))
				.where(criteriaBuilder.equal(student.get(Student_.id), id))
				.distinct(true);

		return entityManager.createQuery(query).getResultList();
	}


}
