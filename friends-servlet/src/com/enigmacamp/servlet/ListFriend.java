package com.enigmacamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.repositories.PersonRepository;

/**
 * Servlet implementation class ListFriend
 */
@WebServlet("/ListFriend")
public class ListFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonRepository repo = new PersonRepository();
		String id = request.getParameter("id");
		Person ini = repo.find(Integer.parseInt(id));
		
		List<Person> persons = repo.getFriends(ini);
		
		request.setAttribute("friend", persons);
		request
			.getRequestDispatcher("WEB-INF/views/persons/friend.jsp")
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
