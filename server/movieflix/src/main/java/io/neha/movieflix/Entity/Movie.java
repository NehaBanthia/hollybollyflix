package io.neha.movieflix.Entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query ="SELECT m FROM Movie m"),
	@NamedQuery(name="Movie.FindByTitle", query ="SELECT m FROM Movie m where title like :searchText"),
	@NamedQuery(name="Movie.FindByYear", query ="SELECT m FROM Movie m where Year = :myear"),
	@NamedQuery(name="Movie.SortByYear", query ="SELECT m FROM Movie m Order By Year Desc")
})
public class Movie {
	
	@Id
	@GenericGenerator(strategy="uuid2",name="CustomUUID")
	@GeneratedValue(generator="CustomUUID")
	private String Id;
	
	private String Title;
	private String Year;
	private Date Released;
	private int Rating;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Awards;
	private String Poster;
	private double Metascore;
	private double ImdbRating;
	private Number ImdbVotes;
	
	@Column(unique=true)
	String ImdbID;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Genre> Genres;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Country> Country;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	private MovieType Type;
	
	@ManyToOne
	@LazyCollection(LazyCollectionOption.FALSE)
	private Rated Rated;
	
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Language> Language;
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public Date getReleased() {
		return Released;
	}
	public void setReleased(Date released) {
		Released = released;
	}
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		Poster = poster;
	}
	public double getMetascore() {
		return Metascore;
	}
	public void setMetascore(double metascore) {
		Metascore = metascore;
	}
	public double getImdbRating() {
		return ImdbRating;
	}
	public void setImdbRating(double imdbRating) {
		ImdbRating = imdbRating;
	}
	public Number getImdbVotes() {
		return ImdbVotes;
	}
	public void setImdbVotes(Number imdbVotes) {
		ImdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return ImdbID;
	}
	public void setImdbID(String imdbID) {
		ImdbID = imdbID;
	}
	public List<Genre> getGenres() {
		return Genres;
	}
	public void setGenres(List<Genre> genres) {
		Genres = genres;
	}
	public List<Country> getCountry() {
		return Country;
	}
	public void setCountry(List<Country> country) {
		Country = country;
	}
	public Rated getRated() {
		return Rated;
	}
	public void setRated(Rated rated) {
		Rated = rated;
	}
	public List<Language> getLanguage() {
		return Language;
	}
	public void setLanguage(List<Language> language) {
		Language = language;
	}
	public MovieType getType() {
		return Type;
	}
	public void setType(MovieType type) {
		Type = type;
	}
}
