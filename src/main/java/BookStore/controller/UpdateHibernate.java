package BookStore.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import BookStore.entity.Book;
import BookStore.entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/updateHibernate")
public class UpdateHibernate extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id  = Integer.parseInt(req.getParameter("id"));
		int cat = Integer.parseInt(req.getParameter("category"));
		Configuration cfg = new Configuration().addAnnotatedClass(Book.class).addAnnotatedClass(Category.class).configure();
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		Book book = session.get(Book.class, id);
		HttpSession httpSession = req.getSession();
		httpSession.setAttribute("book", book);
		resp.sendRedirect("update.jsp");
		session.getTransaction().commit();
		session.close();
		
	
	}
	
	
}
