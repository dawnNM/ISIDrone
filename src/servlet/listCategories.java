package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.ActionCategory;
import entities.Category;
import manager.MCategory;
import util.Const;

/**
 * Servlet implementation class listCategories
 */
@WebServlet("/listCategories")
public class listCategories extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listCategories() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		ActionCategory.getCategories(request, response);
		request.getRequestDispatcher(Const.PATH_PAGE_CATEGORY).forward(request, response);
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
