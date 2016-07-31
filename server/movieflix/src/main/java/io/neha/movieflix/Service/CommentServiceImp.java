package io.neha.movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Comment;
import io.neha.movieflix.Repository.CommentRepository;

@Service
public class CommentServiceImp implements CommentService {
	
	@Autowired
	CommentRepository repository;
	
	@Override
	@Transactional
	public List<Comment>findAllCommentsForGivenMovie(String movieId) {
		return repository.findAllCommentsForGivenMovie(movieId);
	}

	@Override
	@Transactional
	public Comment create(Comment comment) {
		return repository.create(comment);
	}

	@Override
	@Transactional
	public Comment update(Comment comment) {
		return repository.update(comment);
	}

	

}
