package io.neha.movieflix.Repository;

import java.util.List;

import io.neha.movieflix.Entity.Movie;

public interface MovieRepository {
	public List<Movie> findAll();
	public Movie findById(String id);
	public List<Movie> findByTitle(String title);
	public List<Movie> findAllByType(String type);
	public List<Movie> findAllByYear(int year);
	public List<Movie> sortAllByYear();
	public Movie create(Movie mov);
	public Movie update(Movie mov);
	public void delete(Movie mov);
	public List<Movie> getTopRatedMovieType(String movieType,int isTopTen);
	public List<Movie> getTopLatestMovieType(String movieType, int isTopTen);
	public List<Movie> getMovieForGivenGenre(String genre);
}
