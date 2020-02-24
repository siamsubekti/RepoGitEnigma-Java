package com.enigmacamp.servlet.person;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.repositories.PersonRepository;

/**
 * Servlet implementation class personId
 */
@WebServlet("/personId")
public class personById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public personById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonRepository prepo = new PersonRepository();
		String id = request.getParameter("id");
		
		
		Person ini = prepo.find(Integer.parseInt(id));
		
		request.setAttribute("persons", ini);
		request
			.getRequestDispatcher("WEB-INF/views/persons/personId.jsp")
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
