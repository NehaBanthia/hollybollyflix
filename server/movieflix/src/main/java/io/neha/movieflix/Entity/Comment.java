package io.neha.movieflix.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Comment.FindCommentsForGivenMovie", 
			query ="SELECT C FROM Comment C WhERE C.Movie.Id = :movieid")
})
public class Comment {
	@Id
	@GenericGenerator(strategy="uuid2",name="CustomUUID")
	@GeneratedValue(generator="CustomUUID")
	private String Id;
	
	private String Comment;
	
	@ManyToOne
	private Movie Movie;
	
	@ManyToOne
	private User User;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getComment() {
		return Comment;
	}
	public void setComment(String comment) {
		Comment = comment;
	}
	
	public Movie getMovie() {
		return Movie;
	}
	public void setMovie(Movie movie) {
		Movie = movie;
	}
	public User getUser() {
		return User;
	}
	public void setUser(User user) {
		User = user;
	}
	
	
}

