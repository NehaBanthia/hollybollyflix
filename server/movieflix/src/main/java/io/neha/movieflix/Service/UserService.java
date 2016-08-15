package io.neha.movieflix.Service;

import io.neha.movieflix.Entity.Auth;
import io.neha.movieflix.Entity.User;

public interface UserService {
	
	public Auth authenticate(User user);
	public boolean create(User user);
	public User update(User user);
	public void delete(String id);
	public User FindUserById(String userId);
	
	

}
