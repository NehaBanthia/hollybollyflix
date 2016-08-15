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
	public Review FindOne(String movieId) {
		TypedQuery<Review> query = em.createNamedQuery("Review.findMovieRatingAvg",Review.class);
		query.setParameter("movieid", movieId);
		Review ReviewDetails=query.getSingleResult();
		return ReviewDetails;
		
		
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
