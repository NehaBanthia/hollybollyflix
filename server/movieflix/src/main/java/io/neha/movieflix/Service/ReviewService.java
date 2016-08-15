package io.neha.movieflix.Service;

import io.neha.movieflix.Entity.Review;

public interface ReviewService {

	public Review FindOne(String movieId);
	public Review create(Review review);
	public Review update(Review review);
}
