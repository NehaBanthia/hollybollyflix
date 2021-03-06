package io.neha.movieflix.Repository;

import java.util.List;

import io.neha.movieflix.Entity.Comment;

public interface CommentRepository {
	
	public List<Comment> findAllCommentsForGivenMovie(String movieId);
	public Comment create(Comment comment);
	public Comment update(Comment comment);

}
