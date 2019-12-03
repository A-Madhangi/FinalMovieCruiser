package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class EditMovieListServlet
 */
@WebServlet("/EditMovieListServlet")
public class EditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String id = request.getParameter("movielistid");
		System.out.println("ID: " + id);
		String title = request.getParameter("mname");
		System.out.println("name: " + title);
		Long boxOffice = Long.parseLong(request.getParameter("boxoffice"));
		System.out.println("price: " + boxOffice);
		boolean active = request.getParameter("available") != null;
		System.out.println("Active: " + active);
		String launchDate = request.getParameter("launch");
		System.out.println("launch date: " + launchDate);
		String genre = request.getParameter("genre");
		System.out.println("Genre: " + genre);
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		System.out.println("hasTeaser: " + hasTeaser);

		MovieList movieList = new MovieList();
		movieList.setActive(active);
		movieList.setGenre(genre);
		movieList.setHasTeaser(hasTeaser);
		movieList.setId(Long.parseLong(id));
		movieList.setTitle(title);
		movieList.setBoxOffice(boxOffice);

		Date d = null;

		SimpleDateFormat sdp = new SimpleDateFormat("dd/MM/yyyy");
		try {

			d = sdp.parse(launchDate);
			movieList.setDate(d);

			MovieListDaoSqlImpl movielistDaoSqlImpl = new MovieListDaoSqlImpl();
			MovieListDao movieListDao = movielistDaoSqlImpl;
			movieListDao.modifyMovieList(movieList);
			System.out.println("Menuitem after updated is: "
					+ movieListDao.getMovieListAdmin());
			request.getRequestDispatcher("edit-movie-status.jsp").forward(
					request, response);
		} catch (Exception ex) {
			ex.printStackTrace();// String empid=request.getParameter("id");
		}

	}

}
