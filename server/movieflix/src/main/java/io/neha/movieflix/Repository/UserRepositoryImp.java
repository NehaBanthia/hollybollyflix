package io.neha.movieflix.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public User create(User user) {
		//em.getTransaction().begin();
		em.persist(user);
		//em.getTransaction().commit();
		return user;
	}

	@Override
	public User authenticate(User user) {
		TypedQuery<User> query = em.createNamedQuery("User.authenticate",User.class);
		query.setParameter("uemail", user.getEmailId());
		query.setParameter("upassword", user.getPassword());
		User userDetails=query.getSingleResult();
		return userDetails;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
		em.remove(user);
	}

	@Override
	public User FindUserById(String userId) {
		TypedQuery<User> query = em.createNamedQuery("User.FindOneById",User.class);
		query.setParameter("userId", userId);
		User userDetails=query.getSingleResult();
		return userDetails;
	}
}
