package io.neha.movieflix.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import io.neha.movieflix.Entity.Review;

@Repository
public class ReviewRepositoryImp implements ReviewRepository {
@PersistenceContext
private EntityManager em;

	@Override
	public double FindOne(String movieId) {
		TypedQuery<Double> query = em.createNamedQuery("Review.findMovieRatingAvg",Double.class);
		query.setParameter("movieid", movieId);
		return query.getSingleResult();
		
	}

	@Override
	public Review create(Review review) {
		em.persist(review);
		return review;
	}

	@Override
	public Review update(Review review) {
		return em.merge(review);
	 
	}
	
	
}
