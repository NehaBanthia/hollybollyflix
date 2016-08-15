package io.neha.movieflix.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Auth;
import io.neha.movieflix.Entity.User;
import io.neha.movieflix.Exception.UserNotFoundException;
import io.neha.movieflix.Repository.UserRepository;

@Service
public class UserServiceImp implements UserService
{
	@Autowired
	UserRepository repository;

	@Override
	public boolean create(User user) {
		User userDetails=repository.create(user);
		if(userDetails!=null){
			return true;
		}
		return false;
	}

	@Override
	public Auth authenticate(User user) {
		Auth authObj=new Auth();
		try {
			User userDetails=repository.authenticate(user);
			
			if(userDetails!=null){
				authObj.setIsAuthorized(true);
				userDetails.setPassword("");
				authObj.setUser(userDetails);
				return authObj;
			}
			authObj.setIsAuthorized(false);
			return authObj;
		} catch (Exception e) {
			authObj.setIsAuthorized(false);
			return authObj;
		}
	}

	@Override
	@Transactional
	public User update(User user) {
		User existing=repository.FindUserById(user.getUserId());
		if(existing==null){
			throw new UserNotFoundException("Update Failed. User "+user.getUserId()+" not found.");
		}
		return repository.update(user);
	}

	@Override
	@Transactional
	public void delete(String id) {
		User existing = repository.FindUserById(id);
		if (existing == null){
			throw new UserNotFoundException("Update Failed. User not found.");
		}		
		repository.delete(existing);;
	}

	@Override
	public User FindUserById(String userId) {
		return repository.FindUserById(userId);
	}
}
