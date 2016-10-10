package io.neha.movieflix.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.neha.movieflix.Service.UserService;
import io.neha.movieflix.Entity.*;

@RestController
@RequestMapping(path="user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(method=RequestMethod.POST, path="auth", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Auth authenticate(@RequestBody User user){
		return service.authenticate(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, path="create", produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public boolean create(@RequestBody User user){
		return service.create(user);
	}
	@RequestMapping(method=RequestMethod.PUT, produces=MediaType.APPLICATION_JSON_UTF8_VALUE, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User update(@RequestBody User user) {
		return service.update(user);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , path="{id}")
	public void delete(@PathVariable("id")String id){
		service.delete(id);
	}

}
