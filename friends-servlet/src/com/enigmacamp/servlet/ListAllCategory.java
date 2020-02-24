package com.enigmacamp.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Category;
import com.enigmacamp.friends.db.entities.Post;
import com.enigmacamp.friends.db.repositories.CategoryRepository;
import com.enigmacamp.friends.db.repositories.PostRepository;

/**
 * Servlet implementation class ListAllCategory
 */
@WebServlet("/ListAllCategory")
public class ListAllCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListAllCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryRepository catRepo = new CategoryRepository();
		List<Category> liscategory = catRepo.findAll();
		
		request.setAttribute("category", liscategory);
		request
			.getRequestDispatcher("WEB-INF/views/persons/listCategory.jsp")
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
