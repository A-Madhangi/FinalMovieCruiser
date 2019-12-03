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
public class MovieListDaoSqlImplTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MovieListDaoSqlImpl movieListDaoSqlImpl = new MovieListDaoSqlImpl();
		List<MovieList> movieList = movieListDaoSqlImpl.getMovieListAdmin();
		for (MovieList movieList1 : movieList) {
			System.out.println("MenuItem:" + movieList1);
		}

	}

}
