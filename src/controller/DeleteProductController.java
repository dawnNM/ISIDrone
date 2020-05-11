package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDao;
/*import model.Product;
*/import util.Const;

@WebServlet(name = "DeleteProductController", urlPatterns = { "/deleteaproduct" })
public class DeleteProductController extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * int pid = Integer.parseInt(request.getParameter("pid")); ProductDao dao = new
		 * ProductDao(); Product p1 = dao.getProduct(pid);
		 * request.setAttribute("product", p1);
		 */
		request.getRequestDispatcher(Const.PATH_PAGE_DELETEPRODUCTID).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pid = Integer.parseInt(request.getParameter("pid"));
		
		ProductDao dao = new ProductDao();
		int returnInt = dao.deleteProduct(pid);
		request.setAttribute("returnIntAfterDeletingProduct", returnInt);
		request.getRequestDispatcher(Const.PATH_PAGE_DELETEPRODUCT_COMPLETE).forward(request, response);
	}
}
