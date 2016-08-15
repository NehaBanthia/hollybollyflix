package io.neha.movieflix.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Country;
import io.neha.movieflix.Entity.Genre;
import io.neha.movieflix.Entity.ImdbMovie;
import io.neha.movieflix.Entity.Language;
import io.neha.movieflix.Entity.Movie;
import io.neha.movieflix.Entity.MovieType;
import io.neha.movieflix.Entity.Rated;
import io.neha.movieflix.Exception.MovieNotFoundException;
import io.neha.movieflix.Repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {
	
	@Autowired
	MovieRepository repository;
	
	@Override
	@Transactional
	public List<Movie> findAll() {
		
		return repository.findAll();
	}
	@Override
	@Transactional
	public Movie findById(String id) {
		return repository.findById(id);
	}
	@Override
	@Transactional
	public List<Movie> findByTitle(String title) {
		return repository.findByTitle(title);
	}
	@Override
	@Transactional
	public List<Movie> findAllByType(String type) {
		return repository.findAllByType(type);
	}
	@Override
	@Transactional
	public List<Movie> findAllByYear(int year) {
		return repository.findAllByYear(year);
	}
	@Override
	@Transactional
	public List<Movie> sortAllByYear() {
		return repository.sortAllByYear();
	}
	@Override
	@Transactional
	public Movie create(Movie mov) {
		return repository.create(mov);
	}
	@Override
	@Transactional
	public Movie update(Movie mov) {
		Movie existing=repository.findById(mov.getId());
		if(existing==null){
			throw new MovieNotFoundException("Update Failed. Movie "+mov.getTitle()+" not fount");
		}
		return repository.update(mov);
	}
	@Override
	@Transactional
	public void delete(String movId) {
		Movie movie=repository.findById(movId);
		if(movie==null){
			throw new MovieNotFoundException("Delete Failed. Movie not fount");
		}
		repository.delete(movie);	
	}
	@Override
	@Transactional
	public void createImdbMovies(List<ImdbMovie> moviesList){
		try {
			for (ImdbMovie imdbMovie : moviesList) {
				Movie movie=new Movie();
				movie.setTitle(imdbMovie.getTitle());
				movie.setYear(imdbMovie.getYear());
				DateFormat format = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
				Date date = format.parse(imdbMovie.getReleased());
				movie.setReleased(date);
				movie.setRuntime(imdbMovie.getRuntime());
				movie.setDirector(imdbMovie.getDirector());
				movie.setWriter(imdbMovie.getWriter());
				movie.setActors(imdbMovie.getActors());
				movie.setPlot(imdbMovie.getPlot());
				movie.setAwards(imdbMovie.getAwards());
				movie.setPoster(imdbMovie.getPoster());
				movie.setMetascore(imdbMovie.getMetascore());
				movie.setImdbRating(imdbMovie.getImdbRating());
				movie.setImdbVotes(imdbMovie.getImdbVotes());
				movie.setImdbID(imdbMovie.getImdbID());
				
				StringTokenizer genreList=new StringTokenizer(imdbMovie.getGenre(), ",");
				List<Genre> genres=new ArrayList<Genre>();
				while(genreList.hasMoreTokens()){
					Genre genre=new Genre();
					genre.setGenreName(genreList.nextToken().trim());
					genres.add(genre);
				}
				movie.setGenres(genres);
				
				StringTokenizer languageList=new StringTokenizer(imdbMovie.getLanguage(), ",");
				List<Language> languages=new ArrayList<Language>();
				while(languageList.hasMoreTokens()){
					Language language=new Language();
					language.setLanguage(languageList.nextToken().trim());
					languages.add(language);
				}
				movie.setLanguage(languages);
				
				StringTokenizer countryList=new StringTokenizer(imdbMovie.getCountry(), ",");
				List<Country> countries=new ArrayList<Country>();
				while(countryList.hasMoreTokens()){
					Country country=new Country();
					country.setCountry(countryList.nextToken().trim());
					countries.add(country);
				}
				movie.setCountry(countries);
				
				MovieType movieType=new MovieType();
				movieType.setMovieType(imdbMovie.getType());
				movie.setType(movieType);
				
				Rated rated=new Rated();
				rated.setRated(imdbMovie.getRated());
				movie.setRated(rated);
				
				repository.create(movie);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
