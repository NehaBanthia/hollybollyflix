package io.neha.movieflix.Repository;

import io.neha.movieflix.Entity.Review;

public interface ReviewRepository {

	public double FindOne(String movieId);
	public Review create(Review review);
	public Review update(Review review);

}
