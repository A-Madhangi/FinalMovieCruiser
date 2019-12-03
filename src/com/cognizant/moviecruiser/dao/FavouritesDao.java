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
public interface FavouritesDao {

	void addFavouriteList(long userId, long movieListId);

	List<MovieList> getAllFavouriteList(long userId)
			throws FavouriteEmptyException;

	void removeFavouriteList(long userId, long movieListId);

}
