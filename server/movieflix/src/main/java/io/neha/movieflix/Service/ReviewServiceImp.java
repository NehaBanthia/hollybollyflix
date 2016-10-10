package io.neha.movieflix.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Review;
import io.neha.movieflix.Repository.ReviewRepository;

@Service
public class ReviewServiceImp implements ReviewService {

	@Autowired
	ReviewRepository repository;
	
	@Override
	@Transactional
	public double FindOne(String movieId) {
		return repository.FindOne(movieId) ;
	}

	@Override
	@Transactional
	public Review create(Review review) {
		return repository.create(review);
	}

	@Override
	@Transactional
	public Review update(Review review) {
		return repository.update(review);
	}

}
