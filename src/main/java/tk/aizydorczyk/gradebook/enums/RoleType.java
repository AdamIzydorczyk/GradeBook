package tk.aizydorczyk.gradebook.enums;

import org.springframework.security.core.Authentication;

import java.util.stream.Stream;

public enum RoleType {
	STUDENT("ROLE_STUDENT"), LECTURER("ROLE_LECTURER"), NONE("NONE");

	private final String role;

	RoleType(String role) {
		this.role = role;
	}

	public static RoleType getRoleByAuthenticate(Authentication authenticate) {
		return authenticate
				.getAuthorities()
				.stream().map(o ->
						Stream.of(values())
								.filter(roleType -> roleType.role.equals(o.getAuthority()))
								.findFirst()
								.orElse(RoleType.NONE)).
						findFirst()
				.orElse(RoleType.NONE);
	}

	public String getRole() {
		return role;
	}
}
