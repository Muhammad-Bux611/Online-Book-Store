package BookStore.controller;

import java.io.IOException;

import BookStore.DAO.UserDAO;
import BookStore.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String userId = req.getParameter("id");
		String name = req.getParameter("name");
		String email  = req.getParameter("email");
		String password = req.getParameter("password");
		
		User user = new User();
		user.setId(userId);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDAO  dao = new UserDAO();
	boolean flag=	dao.addUser(user);
		if (flag) {
			resp.sendRedirect("LoginUser.jsp");
		}else {
			resp.sendRedirect("Registration.jsp");
		}
	}
	
}
