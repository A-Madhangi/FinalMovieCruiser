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

import com.cognizant.moviecruiser.model.MovieList;

/**
 * @ created by madhangi 761100
 *
 */
public class MovieListDaoSqlImpl implements MovieListDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieListDao#getMovieListAdmin()
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<MovieList> getMovieListAdmin() {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MovieList> movieList = new ArrayList<MovieList>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("select movie_id,mv_title,mv_box_office,mv_active,mv_date_of_launch,mv_genre,mv_has_teaser from movies;");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int movieid = resultSet.getInt("movie_id");
					String title = resultSet.getString("mv_title");
					long boxOffice = resultSet.getLong("mv_box_office");
					String active = resultSet.getString("mv_active");
					Date dateOfLaunch = resultSet.getDate("mv_date_of_launch");
					String genre = resultSet.getString("mv_genre");
					String hasTeaser = resultSet.getString("mv_has_teaser");

					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MovieList movieList1 = new MovieList(movieid, title,
							boxOffice, activeFlag, dateOfLaunch, genre,
							hasTeaserFlag);

					System.out.println(movieList1);
					movieList.add(movieList1);
				}
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

		return movieList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieListDao#getMovieListCustomer()
	 */
	@Override
	public List<MovieList> getMovieListCustomer() {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		List<MovieList> movieList = new ArrayList<MovieList>();
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movies where mv_active='Yes' and mv_date_of_launch <= now()");
				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					int movieId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
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
					MovieList movieList1 = new MovieList(movieId, title,
							boxOffice, activeFlag, date_of_launch, genre,
							hasTeaserFlag);
					movieList.add(movieList1);
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
		return movieList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.moviecruiser.dao.MovieListDao#getMovieList(long)
	 */
	@SuppressWarnings("static-access")
	@Override
	public MovieList getMovieList(long movieListId) {
		// TODO Auto-generated method stub

		ConnectionHandler ch = new ConnectionHandler();
		@SuppressWarnings("static-access")
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MovieList movieList = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movies where movie_id=?");
				preparedStatement.setLong(1, movieListId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
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
					movieList = new MovieList(movieListId, title, boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
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
		return movieList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.moviecruiser.dao.MovieListDao#modifyMovieList(com.cognizant
	 * .moviecruiser.model.MovieList)
	 */
	@Override
	public void modifyMovieList(MovieList movieList) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		String sql = "update movies set mv_title= ?,mv_box_office=?,mv_active=?,mv_date_of_launch=?,mv_genre=?,mv_has_teaser=? where movie_id=?";
		try {
			if (connection != null) {
				PreparedStatement preparestatement = connection
						.prepareStatement(sql);
				preparestatement.setString(1, movieList.getTitle());
				preparestatement.setFloat(2, movieList.getBoxOffice());
				if (movieList.isActive()) {
					preparestatement.setString(3, "Yes");
				} else {
					preparestatement.setString(3, "No");
				}

				preparestatement.setDate(4, new java.sql.Date(movieList
						.getDate().getTime()));
				preparestatement.setString(5, movieList.getGenre());
				if (movieList.isHasTeaser()) {
					preparestatement.setString(6, "Yes");
				} else {
					preparestatement.setString(6, "No");

				}
				preparestatement.setLong(7, movieList.getId());
				preparestatement.executeUpdate();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}

		finally {
			try {
				connection.close();
			} catch (Exception e)

			{
				e.printStackTrace();
			}
		}

	}

}
