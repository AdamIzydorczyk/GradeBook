package tk.aizydorczyk.gradebook.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public abstract class BaseDao {

	@PersistenceContext
	protected EntityManager entityManager;

}
