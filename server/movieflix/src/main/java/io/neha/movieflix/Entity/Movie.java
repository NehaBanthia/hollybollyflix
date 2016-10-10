package io.neha.movieflix.Entity;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.MAX;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
@NamedQueries({
	@NamedQuery(name="Movie.findAll", query ="SELECT m FROM Movie m"),
	@NamedQuery(name="Movie.FindByTitle", query ="SELECT m FROM Movie m where lower(title) like lower(:searchText)"),
	@NamedQuery(name="Movie.FindByYear", query ="SELECT m FROM Movie m where Year = :myear"),
	@NamedQuery(name="Movie.SortByYear", query ="SELECT m FROM Movie m Order By Released Desc"),
	@NamedQuery(name="Movie.SortByRating", query ="SELECT m FROM Movie m Order By ImdbRating Desc"),
	@NamedQuery(name="Movie.GetTopLatestMovieType", query="SELECT m FROM Movie m inner join MovieType mt on m.Type.Id=mt.Id where mt.MovieType = :mType Order By m.Released Desc"),
	@NamedQuery(name="Movie.GetTopRatedMovieType", query="SELECT m FROM Movie m inner join MovieType mt on m.Type.Id=mt.Id where mt.MovieType = :mType Order By m.ImdbRating Desc"),
	@NamedQuery(name="Movie.GetMovieByGenre", query="SELECT m FROM Movie m inner join m.Genres g where lower(g.GenreName) = lower(:mGenre) Order By m.Released Desc")
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
	private String Runtime;
	@Column(length = 4000)
	private String Director;
	@Column(length = 4000)
	private String Writer;
	@Column(length = 4000)
	private String Actors;
	@Column(length = 4000)

	private String Plot;
	@Column(length = 4000)
	private String Awards;
	@Column(length = 4000)
	private String Poster;
	private String Metascore;
	private String ImdbRating;
	private String ImdbVotes;
	
	@Column(unique=true)
	String ImdbID;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Genre> Genres;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Country> Country;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private MovieType Type;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private Rated Rated;
	
	@ManyToMany(cascade=CascadeType.ALL)
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
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getImdbRating() {
		return ImdbRating;
	}
	public void setImdbRating(String imdbRating) {
		ImdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return ImdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		ImdbVotes = imdbVotes;
	}
	
}
