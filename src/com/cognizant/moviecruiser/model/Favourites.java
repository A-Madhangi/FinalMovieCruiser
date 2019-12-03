/**
 * 
 */
package com.cognizant.moviecruiser.model;

import java.util.List;

/**
 * @ created by madhangi 761100
 *
 */
public class Favourites {

	private List<MovieList> movieList;

	private int noOfFavourites;

	/**
	 * @return the movieList
	 */
	public List<MovieList> getMovieList() {
		return movieList;
	}

	/**
	 * @param movieList
	 *            the movieList to set
	 */
	public void setMovieList(List<MovieList> movieList) {
		this.movieList = movieList;
	}

	/**
	 * @return the noOfFavourites
	 */
	public int getNoOfFavourites() {
		return noOfFavourites;
	}

	/**
	 * @param noOfFavourites
	 *            the noOfFavourites to set
	 */
	public void setNoOfFavourites(int noOfFavourites) {
		this.noOfFavourites = noOfFavourites;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Favourites [movieList=" + movieList + ", noOfFavourites="
				+ noOfFavourites + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((movieList == null) ? 0 : movieList.hashCode());
		result = prime * result + noOfFavourites;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourites other = (Favourites) obj;
		if (movieList == null) {
			if (other.movieList != null)
				return false;
		} else if (!movieList.equals(other.movieList))
			return false;
		if (noOfFavourites != other.noOfFavourites)
			return false;
		return true;
	}

	/**
	 * @param movieList
	 * @param noOfFavourites
	 */
	public Favourites(List<MovieList> movieList, int noOfFavourites) {
		super();
		this.movieList = movieList;
		this.noOfFavourites = noOfFavourites;
	}

}
