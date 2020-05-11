package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import model.Order2;
import util.Const;

@WebServlet(name = "GetAllOrdersController", urlPatterns = { "/getAllOrders" })
public class GetAllOrdersController extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		ArrayList<Order2> orderList = dao.getAllOrders2();
		// System.out.println(orderList.get(0).getId());
		request.setAttribute("orderList2", orderList);
		request.getRequestDispatcher(Const.PATH_PAGE_LISTALLORDERS).forward(request, response);

		/*
		 * RequestDispatcher rd = request.getRequestDispatcher("listProducts.jsp");
		 * rd.forward(request, response);
		 */
	}

}
