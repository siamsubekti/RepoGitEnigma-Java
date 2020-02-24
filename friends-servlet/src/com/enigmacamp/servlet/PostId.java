package com.enigmacamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.PersonRepository;

/**
 * Servlet implementation class PostId
 */
@WebServlet("/PostId")
public class PostId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostId() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonRepository prepo = new PersonRepository();
		String id = request.getParameter("personId");
		Person ini = prepo.find(Integer.parseInt(id));
		List<Post> nama = ini.getPost();
				
		request.setAttribute("post", nama);
		List<Post> list = (List<Post>) request.getAttribute("post");
		
		request
			.getRequestDispatcher("WEB-INF/views/persons/postId.jsp")
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
