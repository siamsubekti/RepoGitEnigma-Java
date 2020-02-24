package com.enigmacamp.servlet.person;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.GenderRepository;
import com.enigmacamp.friends.db.repositories.PersonRepository;

/**
 * Servlet implementation class UpdatePerson
 */
@WebServlet("/UpdatePerson")
public class UpdatePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonRepository perRepo = new PersonRepository();
		String id = request.getParameter("id");
		Person person = perRepo.find(Integer.parseInt(id));
		
		request.setAttribute("person", person);
		Person find = (Person) request.getAttribute("person");
		
		request
		.getRequestDispatcher("WEB-INF/views/persons/updateperson.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		PersonRepository perRepo = new PersonRepository();
		GenderRepository genRepo = new GenderRepository();
		
		Person update = perRepo.find(Integer.parseInt(request.getParameter("id")));
		update.setName(request.getParameter("name"));
		try {
			update.setBirthdate(date.parse(request.getParameter("Birthdate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		update.setGender(genRepo.find(Integer.parseInt(request.getParameter("Gender"))));
		
		Person person = perRepo.create(update);
		request
		.getRequestDispatcher("WEB-INF/views/persons/updateperson.jsp")
		.forward(request, response);
		response.sendRedirect("/friends-servlet/webiste");
		
	}

}
