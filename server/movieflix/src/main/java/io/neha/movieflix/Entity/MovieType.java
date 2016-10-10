package io.neha.movieflix.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class MovieType {
	@Id
	@GenericGenerator(strategy="uuid2",name="CustomUUID")
	@GeneratedValue(generator="CustomUUID")
	private String Id;
	private String MovieType;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getMovieType() {
		return MovieType;
	}
	public void setMovieType(String movieType) {
		MovieType = movieType;
	}
	
	
	
}
