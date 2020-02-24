package com.enigmacamp.servlet.person;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.repositories.GenderRepository;
import com.enigmacamp.friends.db.repositories.PersonRepository;

/**
 * Servlet implementation class AddPerson
 */
@WebServlet("/AddPerson")
public class AddPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("WEB-INF/views/persons/addperson.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		
		PersonRepository perRepo = new PersonRepository();
		GenderRepository genRepo = new GenderRepository();
		
	
		Person baru = new Person();
		baru.setName(request.getParameter("name"));
		try {
			baru.setBirthdate(date.parse(request.getParameter("Birthdate")));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		baru.setGender(genRepo.find(Integer.parseInt(request.getParameter("Gender"))));
		

		Person person = perRepo.create(baru);
		request
		.getRequestDispatcher("WEB-INF/views/persons/addperson.jsp")
		.forward(request, response);
		response.sendRedirect("webiste");
		

	}

}
