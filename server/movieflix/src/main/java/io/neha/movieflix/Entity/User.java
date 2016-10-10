package io.neha.movieflix.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries({
	@NamedQuery(name="User.authenticate", 
			query ="SELECT u FROM User u Where u.EmailId=:uemail and u.Password=:upassword"),
	@NamedQuery(name="User.FindOneById", 
	query ="SELECT u FROM User u Where u.UserId=:userId")
})
public class User {

	@Id
	@GenericGenerator(name="CustomUUID", strategy="uuid2")
	@GeneratedValue(generator="CustomUUID")
	private String UserId;
	
	private String FirstName;
	private String LastName;
	
	@Column(unique=true)
	private String EmailId;
	
	private String Password;
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	
	
}

