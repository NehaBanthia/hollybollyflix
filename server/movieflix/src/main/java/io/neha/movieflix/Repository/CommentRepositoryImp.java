package io.neha.movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.neha.movieflix.Entity.Comment;


@Repository
public class CommentRepositoryImp implements CommentRepository {
@PersistenceContext
private EntityManager em;

	@Override
	public List<Comment> findAllCommentsForGivenMovie(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.FindCommentsForGivenMovie", Comment.class);
		query.setParameter("movieid", movieId);
		return query.getResultList();
	}

	@Override
	public Comment create(Comment comment) {
		 em.persist(comment);
		 return(comment);
	}

	@Override
	public Comment update(Comment comment) {
		return em.merge(comment);
	}
	

}
