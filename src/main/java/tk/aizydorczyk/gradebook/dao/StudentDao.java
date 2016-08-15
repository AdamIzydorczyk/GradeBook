package tk.aizydorczyk.gradebook.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGradeDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentGroupDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentLecturerDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentMembersDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSemesterDto;
import tk.aizydorczyk.gradebook.model.dto.student.StudentSubjectDto;
import tk.aizydorczyk.gradebook.model.entity.Department;
import tk.aizydorczyk.gradebook.model.entity.Department_;
import tk.aizydorczyk.gradebook.model.entity.Grade;
import tk.aizydorczyk.gradebook.model.entity.Grade_;
import tk.aizydorczyk.gradebook.model.entity.Group;
import tk.aizydorczyk.gradebook.model.entity.Group_;
import tk.aizydorczyk.gradebook.model.entity.Lecturer;
import tk.aizydorczyk.gradebook.model.entity.Lecturer_;
import tk.aizydorczyk.gradebook.model.entity.Semester;
import tk.aizydorczyk.gradebook.model.entity.Semester_;
import tk.aizydorczyk.gradebook.model.entity.Student;
import tk.aizydorczyk.gradebook.model.entity.Student_;
import tk.aizydorczyk.gradebook.model.entity.Subject;
import tk.aizydorczyk.gradebook.model.entity.Subject_;
import tk.aizydorczyk.gradebook.model.entity.Topic;
import tk.aizydorczyk.gradebook.model.entity.Topic_;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentDao extends BaseDao {

	@Transactional
	public List<StudentSemesterDto> getSemesters(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentSemesterDto> query = criteriaBuilder.createQuery(StudentSemesterDto.class);
		Root<Semester> semester = query.from(Semester.class);
		Join<Semester, Student> students = semester.join(Semester_.students);

		query.multiselect(semester.get(Semester_.semestrNumber), semester.get(Semester_.year))
				.where(criteriaBuilder.equal(students.get(Student_.id), id));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<StudentSubjectDto> getSubjects(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentSubjectDto> query = criteriaBuilder.createQuery(StudentSubjectDto.class);
		Root<Student> student = query.from(Student.class);
		ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		Join<Semester, Department> departament = semester.join(Semester_.departament);
		ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);
		ListJoin<Lecturer, Subject> subject = lecturer.join(Lecturer_.subjects);
		ListJoin<Subject, Grade> grade = subject.join(Subject_.grades);

		Expression<String> lecturerFname = criteriaBuilder.concat(lecturer.get(Lecturer_.lecturerFName), " ");
		Expression<String> lecturerFullName = criteriaBuilder.concat(lecturerFname, lecturer.get(Lecturer_.lecturerLName));

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
	public List<StudentGradeDto> getGrades(long id, String subjectName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentGradeDto> query = criteriaBuilder.createQuery(StudentGradeDto.class);
		Root<Grade> grade = query.from(Grade.class);
		Join<Grade, Subject> subject = grade.join(Grade_.subject);
		query.multiselect(
				grade.get(Grade_.grade),
				grade.get(Grade_.description))
				.where(criteriaBuilder.equal(subject.get(Subject_.subjectName), subjectName));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<StudentGroupDto> getGroups(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentGroupDto> query = criteriaBuilder.createQuery(StudentGroupDto.class);

		Root<Student> student = query.from(Student.class);
		ListJoin<Student, Group> group = student.join(Student_.groups);
		Join<Group, Subject> subject = group.join(Group_.subject);
		Join<Group, Topic> topic = group.join(Group_.topic);

		ListJoin<Group, Student> students2 = group.join(Group_.students);
		query.multiselect(
				subject.get(Subject_.subjectName),
				topic.get(Topic_.topicName),
				criteriaBuilder.count(students2.get(Student_.id)))
				.where(criteriaBuilder.equal(student.get(Student_.id), id));

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<StudentMembersDto> getMembers(long id, String topicName) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentMembersDto> query = criteriaBuilder.createQuery(StudentMembersDto.class);

		Root<Student> student = query.from(Student.class);
		ListJoin<Student, Group> group = student.join(Student_.groups);
		Join<Group, Topic> topic = group.join(Group_.topic);
		Predicate topicNameEqual = criteriaBuilder.equal(topic.get(Topic_.topicName), topicName);
		query.multiselect(
				student.get(Student_.studentFName),
				student.get(Student_.studentLName))
				.where(topicNameEqual);

		return entityManager.createQuery(query).getResultList();
	}

	@Transactional
	public List<StudentLecturerDto> getLecturers(long id) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<StudentLecturerDto> query = criteriaBuilder.createQuery(StudentLecturerDto.class);

		Root<Student> student = query.from(Student.class);
		ListJoin<Student, Semester> semester = student.join(Student_.semesters);
		Join<Semester, Department> departament = semester.join(Semester_.departament);
		ListJoin<Department, Lecturer> lecturer = departament.join(Department_.lecturers);

		query.multiselect(
				lecturer.get(Lecturer_.lecturerFName),
				lecturer.get(Lecturer_.lecturerLName),
				lecturer.get(Lecturer_.degree))
				.where(criteriaBuilder.equal(student.get(Student_.id), id))
				.distinct(true);

		return entityManager.createQuery(query).getResultList();
	}


}
