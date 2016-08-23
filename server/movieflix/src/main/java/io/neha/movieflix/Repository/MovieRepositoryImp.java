package io.neha.movieflix.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.neha.movieflix.Entity.Movie;


@Repository
public class MovieRepositoryImp implements MovieRepository{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public Movie findById(String id) {
		return em.find(Movie.class, id);
	}

	@Override
	public List<Movie> findByTitle(String title) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FindByTitle",Movie.class);
		query.setParameter("searchText", "%"+title+"%");
		return query.getResultList();
	}

	/*@Override
	public Movie findByActors(String actors) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FindByActor",Movie.class);
		query.setParameter("mactor", actors);
		List<Movie> movies = query.getResultList();
		if (movies !=null && movies.size() == 1){
			return movies.get(0);
		}
		return null;
	}*/

	/*@Override  
	public Movie findByGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FindByGenre",Movie.class);
		query.setParameter("mgenre", genre);
		List<Movie> movies = query.getResultList();
		if (movies !=null && movies.size() == 1){
			return movies.get(0);
		}
		return null;
	}*/

	@Override
	public List<Movie> findAllByType(String type) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FindByType",Movie.class);
		query.setParameter("mtype", type);
		return query.getResultList();
	}

	@Override
	public List<Movie> findAllByYear(int year) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.FindByYear",Movie.class);
		query.setParameter("myear", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> sortAllByYear() {
		
		TypedQuery<Movie> query = em.createNamedQuery("Movie.SortByYear",Movie.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public Movie create(Movie mov) {
		em.persist(mov);
		return mov;
	}

	@Override
	@Transactional
	public Movie update(Movie mov) {
		return em.merge(mov);
		
	}

	@Override
	@Transactional
	public void delete(Movie mov) {
		em.remove(mov);
		
	}

	@Override
	public List<Movie> getTopRatedMovieType(String movieType,int isTopTen) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.GetTopRatedMovieType",Movie.class);
		if(isTopTen==1){
			query.setParameter("mType", movieType).setMaxResults(10);
		}
		else{
			query.setParameter("mType", movieType);
		}
		
		return query.getResultList();
	}

	@Override
	public List<Movie> getTopLatestMovieType(String movieType, int isTopTen) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.GetTopLatestMovieType",Movie.class);
		if(isTopTen==1){
			query.setParameter("mType", movieType).setMaxResults(10);
		}
		else{
			query.setParameter("mType", movieType);
		}
		return query.getResultList();
	}
	
	@Override
	public List<Movie> getMovieForGivenGenre(String genre) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.GetMovieByGenre",Movie.class);
		query.setParameter("mGenre", genre).setMaxResults(10);
		return query.getResultList();
	}
}
