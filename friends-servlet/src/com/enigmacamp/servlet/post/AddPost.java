package com.enigmacamp.servlet.post;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.PersonRepository;
import com.enigmacamp.friends.db.repositories.PostRepository;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/addpost")
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request
		.getRequestDispatcher("WEB-INF/views/post/addpost.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateFormat date = new SimpleDateFormat("dd-MM-yyyy");
		
		PostRepository posRepo = new PostRepository();
		PersonRepository perRepo = new PersonRepository();
		
		Post post = new Post();
		post.setTitle(request.getParameter("title"));
		post.setContent(request.getParameter("content"));
		try {
			post.setPost_date(date.parse(request.getParameter("postDate")));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		post.setPerson_id(perRepo.find(Integer.parseInt(request.getParameter("person"))));
		
		Post create = posRepo.create(post);
//		request
//		.getRequestDispatcher("WEB-INF/views/persons/addpost.jsp")
//		.forward(request, response);
		
		response.sendRedirect("/friends-servlet/ListAllPost");
	}

}
