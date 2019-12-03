/**
 * 
 */
package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.moviecruiser.model.Favourites;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * @ created by madhangi 761100
 *
 */
public class FavouriteDaoSqlImpl implements FavouritesDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.FavouritesDao#addFavouriteList(long,
	 * long)
	 */
	@Override
	public void addFavouriteList(long userId, long movieListId) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		System.out.println("userId" + userId + "movielistid:" + movieListId);

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into favourite values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieListId);
				preparedStatement.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavouritesDao#getAllFavouriteList(long)
	 */
	@Override
	public List<MovieList> getAllFavouriteList(long userId)
			throws FavouriteEmptyException {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<MovieList> movieList = new ArrayList<MovieList>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;

		MovieList movielist = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favourites favourites = new Favourites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT movies.movie_id, movies.mv_title  , movies.mv_box_office ,movies.mv_active,movies.mv_date_of_launch,movies.mv_genre, movies.mv_has_teaser FROM movies ")
						.append("INNER JOIN favourite ON movies.movie_id = favourite.fv_mv_id WHERE favourite.fv_us_id = ?");
				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());

				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int movieListId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movielist = new MovieList(movieListId, title, boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
					movieList.add(movielist);
				}
				favourites.setMovieList(movieList);
				favourites.setNoOfFavourites(getNoOfFavourites(userId,
						connection));
				System.out.println("Records fetched successfully");
			}

			if (movieList.size() == 0) {
				throw new FavouriteEmptyException("Favourites is Empty");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return movieList;

	}

	private int getNoOfFavourites(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		int total = 0;
		List<MovieList> movieList = new ArrayList<MovieList>();
		try {
			if (conn != null) {
				Favourites favorite = new Favourites(movieList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("select count(f.fv_id) as tot_no_fav from movies m inner join favourite f on m.movie_id=f.fv_id");

				System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = (PreparedStatement) conn
						.prepareStatement(sqlBuffer.toString());

				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					total = resultSet.getInt(1);
				}
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return total;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.FavouritesDao#removeFavouriteList(long,
	 * long)
	 */
	@Override
	public void removeFavouriteList(long userId, long movieListId) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favourite where fv_us_id=? and  fv_mv_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieListId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
