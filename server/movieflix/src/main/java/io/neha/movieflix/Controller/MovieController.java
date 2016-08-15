package io.neha.movieflix.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.neha.movieflix.Entity.Movie;
import io.neha.movieflix.Service.*;

@RestController
@RequestMapping(path = "movies")
public class MovieController {

	@Autowired
	MovieService service;

	@RequestMapping(method = RequestMethod.GET,path="findAll", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET,path="findById/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findById(@PathVariable("id")String movieId){
		return service.findById(movieId);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="findByTitle/{title}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findByTitle(@PathVariable("title")String title){
		return service.findByTitle(title);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="findByType/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByType(@PathVariable("type")String type){
		return service.findAllByType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="findByYear/{year}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAllByYear(@PathVariable("year")int year){
		return service.findAllByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET,path="sortByYear", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> sortAllByYear(){
	return service.sortAllByYear();
	}
	
	
	
		
}
