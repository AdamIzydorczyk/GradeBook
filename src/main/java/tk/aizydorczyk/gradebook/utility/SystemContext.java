package tk.aizydorczyk.gradebook.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import tk.aizydorczyk.gradebook.model.entity.Account;

@Component
public class SystemContext {

	public Long getLoggedAccountId() {
		Account account = (Account) SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getPrincipal();

		return account.getId();
	}

}
