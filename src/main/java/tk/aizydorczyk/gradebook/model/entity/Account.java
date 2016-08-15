package tk.aizydorczyk.gradebook.model.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import tk.aizydorczyk.gradebook.enums.RoleType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Collection;

@Entity(name = "ACCOUNTS")
public class Account implements UserDetails {
	@Id
	@Column(name = "ACCOUNT_ID")
	private Long id;

	@Column(name = "ACCOUNT_LOGIN")
	private String login;

	@Column(name = "ACCOUNT_PASSWORD")
	private String password;

	@OneToOne
	@JoinColumn(name = "STUDENT_ID")
	private Student student;

	@OneToOne
	@JoinColumn(name = "LECTURER_ID")
	private Lecturer lecturer;

	public Account() {
	}

	public Account(Long id, String login, String password, Student student, Lecturer lecturer) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.student = student;
		this.lecturer = lecturer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (getLecturer() != null) {
			return AuthorityUtils.createAuthorityList(RoleType.LECTURER.getRole());
		} else if (getStudent() != null) {
			return AuthorityUtils.createAuthorityList(RoleType.STUDENT.getRole());
		} else {
			return AuthorityUtils.NO_AUTHORITIES;
		}
	}

	@Override
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getUsername() {
		return getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	private Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
}
