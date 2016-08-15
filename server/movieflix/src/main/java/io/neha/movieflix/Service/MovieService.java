package io.neha.movieflix.Service;

import java.util.List;

import io.neha.movieflix.Entity.ImdbMovie;
import io.neha.movieflix.Entity.Movie;

public interface MovieService {
	
	public List<Movie> findAll();
	public Movie findById(String id);
	public List<Movie> findByTitle(String title);
	//public Movie findByActors(String actors);
	//public Movie findByGenre(String genre);
	public List<Movie> findAllByType(String type);
	public List<Movie> findAllByYear(int year);
	public List<Movie> sortAllByYear();
	public Movie create(Movie mov);
	public Movie update(Movie mov);
	public void delete(String movId);
	public void createImdbMovies(List<ImdbMovie> moviesList);

}
