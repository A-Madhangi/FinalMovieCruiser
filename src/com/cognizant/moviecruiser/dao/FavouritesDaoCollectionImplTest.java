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
public class FavouritesDaoCollectionImplTest {

	public static void main(String[] args) throws FavouriteEmptyException {
		// TODO Auto-generated method stub

		testAddFavouriteList();

		testRemoveFavouriteList();
		testGetAllFavouriteList();

	}

	static void testAddFavouriteList() throws FavouriteEmptyException {

		FavouritesDaoCollectionImpl favouriteDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouriteDao = favouriteDaoCollectionImpl;
		favouriteDao.addFavouriteList(2, 4);
		favouriteDao.addFavouriteList(2, 3);
		List<MovieList> movieList = favouriteDao.getAllFavouriteList(2);
		System.out.println("FAVOURITES LIST :" + movieList);

	}

	static void testGetAllFavouriteList() throws FavouriteEmptyException {
		FavouritesDaoCollectionImpl favouriteDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouriteDao = favouriteDaoCollectionImpl;

		List<MovieList> movieList = favouriteDao.getAllFavouriteList(2);
		System.out.println("ALL FAVOURITES :" + movieList);
	}

	static void testRemoveFavouriteList() throws FavouriteEmptyException {
		FavouritesDaoCollectionImpl favouriteDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouriteDao = favouriteDaoCollectionImpl;

		try {
			favouriteDao.removeFavouriteList(2, 4);
			List<MovieList> movieList = favouriteDao.getAllFavouriteList(2);
			System.out.println("FAVOURITES LIST AFTER REMOVED:" + movieList);
		} catch (Exception e) {
			throw new FavouriteEmptyException("Cart is empty");
		}

	}
}
