package io.neha.movieflix.Service;

import io.neha.movieflix.Entity.User;

public interface UserService {
	
	public User authenticate(User user);
	public User create(User user);
	public User update(User user);
	public void delete(String id);
	public User FindUserById(String userId);
	
	

}
