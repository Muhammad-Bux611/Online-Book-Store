package BookStore.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import BookStore.entity.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Admincheck")
public class AdminCheck  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email = req.getParameter("mail");
		String password = req.getParameter("pin");
		
		Configuration cfg = new Configuration().configure().addAnnotatedClass(Admin.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Admin a =new Admin();
		Query  hql= session.createQuery("from Admin");
		a=	(Admin)hql.uniqueResult();

		session.getTransaction().commit();
		session.close();
		if (a!=null) {
		System.out.println(a.getEmail()+":"+a.getPassword());
		System.out.println(email +" "+password);
		
		if (a.getEmail().trim().equals(email) && a.getPassword().trim().equals(password)) {
			resp.sendRedirect("Home.jsp");
		}
		else {
			resp.sendRedirect("Login.jsp");
		}
	}else {
		System.out.println("the data is not present in the database");
	}
	
		}
	
}
