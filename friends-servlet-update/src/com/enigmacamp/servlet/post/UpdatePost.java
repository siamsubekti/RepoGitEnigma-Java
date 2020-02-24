package com.enigmacamp.servlet.post;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.PostRepository;

/**
 * Servlet implementation class UpdatePost
 */
@WebServlet("/UpdatePost")
public class UpdatePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PostRepository postRepo = new PostRepository();
		String id = request.getParameter("id");
		Post update = postRepo.find(Integer.parseInt(id));
		
		request.setAttribute("update", update);
		request.getRequestDispatcher("WEB-INF/views/post/updatepost.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		
		PostRepository posRepo = new PostRepository();
		
		Post update = posRepo.find(Integer.parseInt(request.getParameter("id")));
		update.setTitle(request.getParameter("title"));
		update.setContent(request.getParameter("content"));
		try {
			update.setPost_date(date.parse(request.getParameter("postdate")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Post post = posRepo.update(update);
		request.getRequestDispatcher("WEB-INF/views/post/updatepost.jsp").forward(request, response);
		
		response.sendRedirect("ListAllPost");
	}

}
