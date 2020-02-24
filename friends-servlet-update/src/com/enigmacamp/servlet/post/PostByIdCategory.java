package com.enigmacamp.servlet.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Category;
import com.enigmacamp.friends.db.entities.Person;
import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.CategoryRepository;
import com.enigmacamp.friends.db.repositories.PersonRepository;
import com.enigmacamp.friends.db.repositories.PostRepository;

/**
 * Servlet implementation class PostById
 */
@WebServlet("/PostById")
public class PostByIdCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostByIdCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		PostRepository prepo = new PostRepository();
		CategoryRepository crepo = new CategoryRepository();
		String id = request.getParameter("catId");
		Category ini = crepo.find(Integer.parseInt(id));
		
		List<Post> nama = ini.getPosts();
		
//		response.getWriter().print(nama);
		
		request.setAttribute("postcat", nama);
		request
			.getRequestDispatcher("WEB-INF/views/post/postCategory.jsp")
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
