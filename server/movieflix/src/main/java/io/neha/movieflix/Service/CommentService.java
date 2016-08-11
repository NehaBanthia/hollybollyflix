package io.neha.movieflix.Service;

import java.util.List;

import io.neha.movieflix.Entity.Comment;

public interface CommentService {

	public List<Comment>findAllCommentsForGivenMovie(String movieId);
	public Comment create(Comment comment);
	public Comment update(Comment comment);
}
