package io.neha.movieflix.Controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.neha.movieflix.Service.*;
import io.neha.movieflix.Entity.Comment;


@RestController
@RequestMapping(path="comment")
public class CommentController {
	@Autowired
	CommentService service;
	
	@RequestMapping(method=RequestMethod.GET, path="findMovieComments/{movieId}",produces=MediaType.APPLICATION_JSON_UTF8_VALUE )
	public List<Comment>findAll(@PathVariable("movieId")String movieId){
		return service.findAllCommentsForGivenMovie(movieId);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="create", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment comment){
		return service.create(comment);
	}
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment update(@RequestBody Comment comment) {
		return service.update(comment);
		
	}
}
