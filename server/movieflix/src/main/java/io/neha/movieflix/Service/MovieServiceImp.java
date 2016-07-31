package io.neha.movieflix.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Movie;
import io.neha.movieflix.Exception.MovieNotFoundException;
import io.neha.movieflix.Repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Override
	@Transactional
	public List<Movie> findAll() {
		
		return repository.findAll();
	}
	@Override
	@Transactional
	public Movie findById(String id) {
		return repository.findById(id);
	}
	@Override
	@Transactional
	public List<Movie> findByTitle(String title) {
		return repository.findByTitle(title);
	}
	@Override
	@Transactional
	public List<Movie> findAllByType(String type) {
		return repository.findAllByType(type);
	}
	@Override
	@Transactional
	public List<Movie> findAllByYear(int year) {
		return repository.findAllByYear(year);
	}
	@Override
	@Transactional
	public List<Movie> sortAllByYear() {
		return repository.sortAllByYear();
	}
	@Override
	@Transactional
	public Movie create(Movie mov) {
		return repository.create(mov);
	}
	@Override
	@Transactional
	public Movie update(Movie mov) {
		Movie existing=repository.findById(mov.getId());
		if(existing==null){
			throw new MovieNotFoundException("Update Failed. Movie "+mov.getTitle()+" not fount");
		}
		return repository.update(mov);
	}
	@Override
	@Transactional
	public void delete(String movId) {
		Movie movie=repository.findById(movId);
		if(movie==null){
			throw new MovieNotFoundException("Delete Failed. Movie not fount");
		}
		repository.delete(movie);	
	}
}
