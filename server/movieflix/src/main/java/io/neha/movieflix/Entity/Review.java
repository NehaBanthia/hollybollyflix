package io.neha.movieflix.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Review.findMovieRatingAvg", 
			query ="SELECT AVG(R.Review) as Review FROM Review R WHERE R.Movie.Id = :movieid GROUP BY R.Movie.Id")
})
public class Review {
	
	@Id
	@GenericGenerator(strategy="uuid2",name="CustomUUID")
	@GeneratedValue(generator="CustomUUID")
	private String Id;
	
	private double Review;
	
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
	
	public double getReview() {
		return Review;
	}
	public void setReview(double review) {
		Review = review;
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
