package BookStore.controller;

import java.io.IOException;
import BookStore.DAO.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import BookStore.DAO.OrderDAO;
import BookStore.entity.Book;
import BookStore.entity.OrderEntity;
import BookStore.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
   
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String action = req.getParameter("action");	
		// Condition  to view All Order by User
		if (action.equals("viewAllOrder")) {  
			List<OrderEntity> orders = null;
			OrderDAO dao = new OrderDAO();
			orders= dao.viewOrder();
			if (orders!=null) {
			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("orders", orders);
			resp.sendRedirect("viewOrders.jsp");
			}else {
			resp.getWriter().print("there is no order is place upto now");
			}
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		
		String email = req.getParameter("email");
		int id = Integer.parseInt(req.getParameter("id"));
		int Bid= Integer.parseInt(req.getParameter("Bid"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		long price = (long)Integer.parseInt(req.getParameter("price"));
		
		String address = req.getParameter("address");
//		Quantity is always greater then zero
		if (quantity<=0) {
			resp.sendRedirect("viewBooks.jsp");
		}else {

			OrderDAO dao = new OrderDAO();
			User user = dao.getUserbyEmail(email);
			if (user==null) {
				resp.getWriter().print("this user is not stored in the database");
			}else {
				
				Book book = new Book();
				book.setId(Bid);
				OrderEntity order = new OrderEntity();
				order.setOrder_Date((LocalDate.now()));
				order.setQuantity(quantity);
				order.setId(id);
				order.setTotalPrice(quantity*price);
				order.setUser(user);

				order.setBook(book);
				order.setAddress(address);
				
				
//				Condition to place the order
				if (action.equals("placeOrder")) {
					dao.placeOrder(order);
				resp.sendRedirect("Orderdetail.jsp");
				}else if (action.equals("update")) {
				dao.updateOrder(id, order);
				
				resp.sendRedirect("viewAllOrders?userEmail="+order.getUser().email+"&action=view");
				}
			}
		}
	}
	
}
