package tk.aizydorczyk.gradebook.login;

import org.springframework.stereotype.Repository;
import tk.aizydorczyk.gradebook.infrastructure.base.BaseDao;
import tk.aizydorczyk.gradebook.infrastructure.entity.Account;

@Repository
class LoginDao extends BaseDao {
	Account getAccountByUsername(String username) {
		return entityManager.createQuery("select a from Account a where a.login = :login ", Account.class)
				.setParameter("login", username)
				.getSingleResult();
	}
}
