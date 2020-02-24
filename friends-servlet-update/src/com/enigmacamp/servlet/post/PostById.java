package com.enigmacamp.servlet.post;

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
public class PostById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostById() {
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
		List<Post> post = ini.getPost();
				
		request.setAttribute("post", post);
		List<Post> list = (List<Post>) request.getAttribute("post");    
		
		request
			.getRequestDispatcher("WEB-INF/views/persons/personPost.jsp")
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
