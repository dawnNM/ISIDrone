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

@WebServlet(name = "AddProductController", urlPatterns = { "/addaproduct" })
public class AddProductController extends HttpServlet{
	
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
		request.getRequestDispatcher(Const.PATH_PAGE_NEWPRODUCT).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int pcategory = Integer.parseInt(request.getParameter("productCategory"));
		String pname = request.getParameter("productName");
		String pdescription = request.getParameter("productDescription");
		float pprice = Float.parseFloat(request.getParameter("productPrice"));
		String pserialNumber = request.getParameter("serialNumber");
		String pimgName = request.getParameter("imageName");
		int pstockQty = Integer.parseInt(request.getParameter("stockQty"));
		boolean pisActive = Boolean.parseBoolean(request.getParameter("isActive"));
		
		ProductDao dao = new ProductDao();
		int returnInt = dao.addProduct(pcategory, pname, pdescription, pprice, pserialNumber, pimgName, pstockQty, pisActive);
		request.setAttribute("returnIntAfterAddingProduct", returnInt);
		request.getRequestDispatcher(Const.PATH_PAGE_NEWPRODUCT_COMPLETE).forward(request, response);
	}
}
