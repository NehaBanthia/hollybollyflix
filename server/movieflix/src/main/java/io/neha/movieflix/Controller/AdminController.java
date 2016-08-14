package io.neha.movieflix.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.neha.movieflix.Entity.*;
import io.neha.movieflix.Service.MovieService;

@RestController
@RequestMapping(path = "movies")
public class AdminController {
	
	@Autowired
	MovieService service;
	

@RequestMapping(method=RequestMethod.POST, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
public Movie create(@RequestBody Movie movie){
	return service.create(movie);
}
@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
public Movie update(@RequestBody Movie movie) {
	return service.update(movie);
}

@RequestMapping(method=RequestMethod.DELETE , path="{id}")
public void delete(@PathVariable("id")String movieId){
	service.delete(movieId);
}

}