package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Product;
import util.Const;

@WebServlet(name = "GetAllProductsController", urlPatterns = { "/getAllProducts" })
public class GetAllProductsController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		ArrayList<Product> productList = dao.getAllProducts();
		request.setAttribute("productList", productList);
		request.getRequestDispatcher(Const.PATH_PAGE_LISTALLPRODUCTS).forward(request, response);

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("listProducts.jsp");
		 * rd.forward(request, response);
		 */
	}

}
