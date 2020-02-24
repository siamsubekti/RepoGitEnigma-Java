package com.enigmacamp.servlet.category;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enigmacamp.friends.db.entities.Category;
import com.enigmacamp.friends.db.repositories.CategoryRepository;

/**
 * Servlet implementation class UpdateCategory
 */
@WebServlet("/UpdateCategory")
public class UpdateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryRepository catRepo = new CategoryRepository();
		
		Category update = catRepo.find(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("updatecate", update);
		request.getRequestDispatcher("WEB-INF/views/category/updateCategory.jsp")
		.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryRepository cate = new CategoryRepository();
		
		Category cateupdate = cate.find(Integer.parseInt(request.getParameter("id")));
		cateupdate.setName(request.getParameter("name"));
		
		Category update = cate.update(cateupdate);
		
		response.sendRedirect("ListAllCategory");
	}

}
