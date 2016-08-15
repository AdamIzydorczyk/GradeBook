package tk.aizydorczyk.gradebook.dao;

import org.springframework.stereotype.Repository;
import tk.aizydorczyk.gradebook.model.entity.Account;

@Repository
public class LoginDao extends BaseDao {
	public Account getAccountByUsername(String username) {
		Account account = entityManager.createQuery("select a from tk.aizydorczyk.gradebook.model.entity.Account a where a.login = :login ", Account.class)
				.setParameter("login", username)
				.getSingleResult();
		return account;
	}
}
