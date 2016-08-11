package io.neha.movieflix.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
public class Genre {
	@Id
	@GenericGenerator(strategy="uuid2",name="CustomUUID")
	@GeneratedValue(generator="CustomUUID")
	private String Id;
	private String GenreName;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getGenreName() {
		return GenreName;
	}
	public void setGenreName(String genreName) {
		GenreName = genreName;
	}
	
}
