package servlet;

import java.io.IOException;
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
 * Servlet implementation class addCategory
 */
@WebServlet("/addCategory")
public class addCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher(Const.PATH_PAGE_ADDCategory).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println(MCategory.isExistcategory(Integer.parseInt(request.getParameter("position"))));
		if(MCategory.isExistcategory(Integer.parseInt(request.getParameter("position")))==1)
		{
			request.setAttribute("error", "");
			Category newcat=new Category();
			newcat.setName(request.getParameter("name"));
			newcat.setDescription(request.getParameter("description"));
			
			newcat.setorder(Integer.parseInt(request.getParameter("position")));
			if(request.getParameter("isActive")!=null)
			{
			if(request.getParameter("isActive").equals("yes"))
				newcat.setisActive(true);
			else
				newcat.setisActive(false);
			}
			else
				newcat.setisActive(false);
			MCategory.addnewCategory(newcat);
			ActionCategory.getCategories(request, response);
			request.getRequestDispatcher(Const.PATH_PAGE_CATEGORY).forward(request, response);
		}
		else {
			request.setAttribute("error", "position error");
			request.getRequestDispatcher(Const.PATH_PAGE_ADDCategory).forward(request, response);
		}
		
	}

}
