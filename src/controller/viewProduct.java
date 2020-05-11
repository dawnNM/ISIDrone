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
 * Servlet implementation class viewProduct
 */
@WebServlet("/viewProduct")
public class viewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher(Const.PATH_PAGE_VIEWPRODUCT).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		/*
		int pid = Integer.parseInt(request.getParameter("productId"));
		int pcategory = Integer.parseInt(request.getParameter("productCategory"));
		String pname = request.getParameter("productName");
		String pdescription = request.getParameter("productDescription");
		float pprice = Float.parseFloat(request.getParameter("productPrice"));
		String pserialNumber = request.getParameter("serialNumber");
		String pimgName = request.getParameter("imageName");
		int pstockQty = Integer.parseInt(request.getParameter("stockQty"));
		boolean pisActive = Boolean.parseBoolean(request.getParameter("isActive"));
		
		ProductDao dao = new ProductDao();
		int returnInt = dao.modifyProduct(pid, pcategory, pname, pdescription, pprice, pserialNumber, pimgName, pstockQty, pisActive);
		request.setAttribute("returnIntAfterModifyingProduct", returnInt);
		request.getRequestDispatcher(Const.PATH_PAGE_MODIFYPRODUCT_COMPLETE).forward(request, response);
		*/
	}

}
