package com.enigmacamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Gender;
import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.GenderRepository;
import com.enigmacamp.friends.db.repositories.PostRepository;

/**
 * Servlet implementation class ListAllGenders
 */
@WebServlet("/ListAllGenders")
public class ListAllGenders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllGenders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GenderRepository genRepo = new GenderRepository();
		List<Gender> gender = genRepo.findAll();
		
		request.setAttribute("gender", gender);
		request
			.getRequestDispatcher("WEB-INF/views/persons/listGender.jsp")
			.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
