/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.cognizant.moviecruiser.model.Favourites;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * @ created by madhangi 761100
 *
 */
public class FavouritesDaoCollectionImpl implements FavouritesDao {

	private static HashMap<Long, Favourites> userFavourites;

	public FavouritesDaoCollectionImpl() {

		if (userFavourites == null) {
			userFavourites = new HashMap<Long, Favourites>();
			try {

				List<MovieList> movieList = new ArrayList<MovieList>();

				Favourites favourite = new Favourites(movieList, 0);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public void addFavouriteList(long userid, long movieListId) {
		// TODO Auto-generated method stub
		List<MovieList> movieList;
		MovieListDaoCollectionImpl movieListDaoCollectionImpl = new MovieListDaoCollectionImpl();
		MovieListDao movieListDao = movieListDaoCollectionImpl;
		// MenuItem mitem = menuItemDao.getMenuItem(menuItemId);
		Long userId = new Long(userid);
		MovieList movieList1 = movieListDao.getMovieList(movieListId);
		if (userFavourites.containsKey(userId)) {
			Favourites favourite = userFavourites.get(userId);
			movieList = favourite.getMovieList();
			movieList.add(movieList1);
			favourite.setMovieList(movieList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userFavourites.put(userId, favourite);

		} else {
			movieList = new CopyOnWriteArrayList<MovieList>();
			movieList.add(movieList1);

			Favourites favourite = new Favourites(movieList,
					(int) movieList1.getId());
			userFavourites.put(userId, favourite);

		}

	}

	@Override
	public List<MovieList> getAllFavouriteList(long userid)
			throws FavouriteEmptyException {

		Favourites favourite = userFavourites.get(new Long(userid));
		List<MovieList> movieList = favourite.getMovieList();
		if (movieList == null || movieList.size() == 0) {
			throw new FavouriteEmptyException("Favourites list is empty");
		}
		int count = 0;
		for (MovieList movieList1 : movieList) {

			count = count + 1;

		}
		favourite.setNoOfFavourites(count);
		System.out.println("NO OF FAVOURITES:" + count);
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public void removeFavouriteList(long userId, long movieListId) {
		// TODO Auto-generated method stub

		if (userFavourites.containsKey(userId)) {
			Favourites favourite = userFavourites.get(userId);
			List<MovieList> movieList = favourite.getMovieList();
			for (MovieList movieList1 : movieList) {
				if (movieList1.getId() == movieListId) {
					movieList.remove(movieList1);
				}
			}
			favourite.setMovieList(movieList);
			userFavourites.put(userId, favourite);

		}

	}

}
