package io.neha.movieflix.Repository;

import io.neha.movieflix.Entity.*;

public interface UserRepository {
	
	public User authenticate(User user);
	public User create(User user);
	public User update(User user);
	public void delete(User user);
	public User FindUserById(String userId);
	

}
