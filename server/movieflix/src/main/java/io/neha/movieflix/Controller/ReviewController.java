package io.neha.movieflix.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.neha.movieflix.Entity.*;
import io.neha.movieflix.Service.ReviewService;

@RestController
@RequestMapping(path="review")
public class ReviewController {
	
	@Autowired
	ReviewService service;
	
	@RequestMapping(method = RequestMethod.GET,path = "{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public double FindOne(@PathVariable("movieId")String movieId) {
		return service.FindOne(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="create", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review create(@RequestBody Review review){
		return service.create(review);
	}
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Review update(@RequestBody Review review) {
		return service.update(review);
		
	}
	}

