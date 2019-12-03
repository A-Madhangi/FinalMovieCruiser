/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;

/**
 * @ created by madhangi 761100
 *
 */
public interface MovieListDao {

	List<MovieList> getMovieListAdmin();

	List<MovieList> getMovieListCustomer();

	MovieList getMovieList(long movieListId);

	/**
	 * @param movieList2
	 */
	void modifyMovieList(MovieList movieList);

}
