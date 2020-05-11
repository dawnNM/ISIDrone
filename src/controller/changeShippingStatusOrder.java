package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import util.Const;

/**
 * Servlet implementation class changeShippingStatusOrder
 */
@WebServlet("/changeShippingStatusOrder")
public class changeShippingStatusOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeShippingStatusOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		int oid = Integer.parseInt(request.getParameter("oid"));
		boolean isShipped = Boolean.parseBoolean(request.getParameter("isShipped"));

		System.out.println("Order id is : " + oid);
		System.out.println("IsShipped status is : " + isShipped);
		
		ProductDao dao = new ProductDao();
		int returnInt = dao.changeOrderShipping(oid, isShipped);
		request.setAttribute("returnIntAfterChangingIsShipped", returnInt);
		request.getRequestDispatcher(Const.PATH_PAGE_CHANGEISSHIPPEDORDER_COMPLETE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
