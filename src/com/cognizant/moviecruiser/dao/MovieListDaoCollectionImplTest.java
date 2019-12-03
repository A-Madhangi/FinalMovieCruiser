/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.MovieList;
import com.cognizant.moviecruiser.util.DateUtil;

/**
 * @ created by madhangi 761100
 *
 */
public class MovieListDaoCollectionImplTest {

	public static void main(String args[]) throws ParseException {
		testGetMovieListAdmin();
		testGetMovieListCustomer();
		testModifyMovieList();
	}

	public static void testGetMovieListAdmin() {
		MovieListDaoCollectionImpl movie = new MovieListDaoCollectionImpl();
		System.out.println("MENU ITEM LIST: ");

		List<MovieList> movieList = movie.getMovieListAdmin();
		for (MovieList movie_list : movieList) {
			System.out.println(movie_list.toString());
		}
	}

	public static void testGetMovieListCustomer() {
		MovieListDaoCollectionImpl movie = new MovieListDaoCollectionImpl();
		System.out.println("CUSTOMER MENU ITEM LIST: ");

		List<MovieList> movielist1 = movie.getMovieListCustomer();
		for (MovieList movie_list1 : movielist1) {
			System.out.println(movie_list1.toString());
		}
	}

	public static void testModifyMovieList() throws ParseException {

		MovieList movielist = new MovieList(0000005, "ARUVAM", 30000000, true,
				DateUtil.convertToDate("22/11/2012"), "Starters", false);
		MovieListDaoCollectionImpl movielistcollectionimpl = new MovieListDaoCollectionImpl();
		System.out.println("MODIFY MENU ITEM LIST");
		MovieListDao movielistdao = movielistcollectionimpl;
		movielistdao.modifyMovieList(movielist);
		System.out.println(movielistdao.getMovieList(0000005));

	}

	public void testGetMenuItem() {

	}

}
