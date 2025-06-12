package BookStore.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import BookStore.DAO.UserDAO;
import BookStore.entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/user")
public class UserCheck  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("mail");
		String password = req.getParameter("pin");
		String role = req.getParameter("role");
		Configuration cfg = new Configuration().configure().addAnnotatedClass(User.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
	
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
	
		UserDAO dao = new UserDAO();
		boolean present =dao.checkUser(user); 
		
		if (present) {

			HttpSession httpSession = req.getSession();
			httpSession.setAttribute("user", user);
			resp.sendRedirect("Orderdetail.jsp");
			
		}else {
			resp.sendRedirect("LoginUser.jsp");
			}
	}
}
