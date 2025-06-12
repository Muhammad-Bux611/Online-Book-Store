package BookStore.controller;

import java.io.IOException;

import BookStore.DAO.CategoryDAO;
import BookStore.entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("cat_id"));
		String title = req.getParameter("cat_title");
		String discription = req.getParameter("cat_discription");
		
		Category category = new Category();
		category.setId(id);
		category.setTitle(title);
		category.setDiscription(discription);
		
		HttpSession session = req.getSession();
		session.setAttribute("category", category);
		
		CategoryDAO cat_dao = new CategoryDAO();
		boolean cat_flag =	cat_dao.addCategory(category);
				
			if (cat_flag) {
				resp.getWriter().print("the data is successfully added");

				resp.sendRedirect("addBook.jsp");
			}else {
				resp.sendRedirect("categories.jsp");
			}
	}
	
}
