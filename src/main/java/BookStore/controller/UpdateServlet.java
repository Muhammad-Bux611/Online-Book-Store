package BookStore.controller;
import BookStore.DAO.*;

import java.io.IOException;

import BookStore.DAO.OrderDAO;
import BookStore.entity.OrderEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateOrderServlet")
public class UpdateServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int orderId = Integer.parseInt(req.getParameter("Orderid"));
	
	OrderDAO dao = new OrderDAO();
   OrderEntity order=	dao.viewById(orderId);
   
   if (order!=null) {
	HttpSession httpSession = req.getSession();
	httpSession.setAttribute("order", order);
	resp.sendRedirect("updateOrderDetail.jsp");
   		}else {
		resp.getWriter().print("the data is not present in the  database");
   			}
	
	}
}
