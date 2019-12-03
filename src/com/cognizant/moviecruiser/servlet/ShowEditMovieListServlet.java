package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieListDao;
import com.cognizant.moviecruiser.dao.MovieListDaoSqlImpl;
import com.cognizant.moviecruiser.model.MovieList;

/**
 * Servlet implementation class ShowEditMovieListServlet
 */
@WebServlet("/ShowEditMovieListServlet")
public class ShowEditMovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieListServlet() {
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

		MovieListDaoSqlImpl movielistdaoSqlimpl = new MovieListDaoSqlImpl();
		MovieListDao movielistdao = movielistdaoSqlimpl;
		String movieListId = request.getParameter("movieListId");
		int movielistid = Integer.parseInt(movieListId);
		System.out.println("MovieListId: " + movielistid);
		MovieList movielist = movielistdao.getMovieList(movielistid);
		System.out.println("Movielist = " + movielist);

		request.setAttribute("movieList", movielist);
		request.getRequestDispatcher("edit-movie-list.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
