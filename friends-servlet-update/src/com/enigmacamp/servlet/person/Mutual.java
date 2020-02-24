package com.enigmacamp.servlet.person;

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
 * Servlet implementation class Mutual
 */
@WebServlet("/mutual")
public class Mutual extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mutual() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonRepository perRepo = new PersonRepository();
		String name1 = request.getParameter("id1");
		String name2 = request.getParameter("id2");
		Person baru1 = perRepo.find(Integer.parseInt(name1));
		Person baru2 = perRepo.find(Integer.parseInt(name2));
		List<Person> ab = perRepo.mutual(baru1, baru2);
		request.setAttribute("mutuals",ab);
//		request.setAttribute("id1",name1);
//		request.setAttribute("id2",name2);
		request.getRequestDispatcher("/WEB-INF/views/persons/mutual.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
