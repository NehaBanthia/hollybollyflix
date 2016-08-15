package io.neha.movieflix.Entity;

public class Auth {
	private boolean IsAuthorized;
	private String AuthToken;
	private User user;
	public boolean isAuthorized() {
		return IsAuthorized;
	}
	public void setIsAuthorized(boolean isAuthorized) {
		IsAuthorized = isAuthorized;
	}
	public String getAuthToken() {
		return AuthToken;
	}
	public void setAuthToken(String authToken) {
		AuthToken = authToken;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
