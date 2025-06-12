package BookStore.controller;
import BookStore.DAO.*;


import java.io.IOException;
import java.util.List;

import BookStore.DAO.OrderDAO;
import BookStore.entity.OrderEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/viewAllOrders")
public class viewAllOrderServlet extends HttpServlet {
  
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		String userEmail = req.getParameter("userEmail");
		OrderDAO dao = new  OrderDAO();
		if (action.equals("view")) {
		
	 List<OrderEntity> orders = dao.viewOrdersByUser(userEmail);
		if (orders==null) {
			resp.sendRedirect("Orderdetail.jsp");
		}else {
			HttpSession session = req.getSession();
			session.setAttribute("orders", orders);
			resp.sendRedirect("viewAllOrderbyUser.jsp");
		}
		}else if (action.equals("delete")) {
			int  orderId = Integer.parseInt(req.getParameter("Orderid"));
			dao.deleteOrderbyId(orderId);

			 List<OrderEntity> orderAfterDelete = dao.viewOrdersByUser(userEmail);
				if (orderAfterDelete==null) {
					resp.sendRedirect("Orderdetail.jsp");
				}else {
					HttpSession session = req.getSession();
					session.setAttribute("orders", orderAfterDelete);
					resp.sendRedirect("viewAllOrderbyUser.jsp");
				}	
		}
	}
	
	
}
