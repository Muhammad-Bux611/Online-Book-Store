package BookStore.controller;
import BookStore.DAO.*;

import java.io.IOException;
import java.util.List;


import BookStore.DAO.BookDAO;
import BookStore.DAO.CategoryDAO;
import BookStore.entity.Book;
import BookStore.entity.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String role = req.getParameter("role");
		
//		CONDITION TO FETCH THE DATA FROM THE BOOK TABLE
		
		if (action.equals("view")) {
			BookDAO dao = new BookDAO();
			List<Book> books = dao.viewBooks();
			
			if (books!=null) {
				
				HttpSession session  = req.getSession();
				session.setAttribute("role", role);
				session.setAttribute("books", books);
				resp.sendRedirect("viewBooks.jsp");
			}else {
//				ROLE == NULL MEANS THE USER IS ADMIN 
//				ROLE!=NULL MEANS THE USER IS THE CUSTOMER
				if (role==null) {
					resp.sendRedirect("alert.jsp");
				}else {
					resp.sendRedirect("noBookAvailable.jsp");
				}
				
			}
			
		}else if (action.equals("delete")) {  //CONDITION TO DELETE THE BOOK FROM THE BOOK TABLE
			
			BookDAO dao = new BookDAO();

			int id = Integer.parseInt(req.getParameter("id"));
			boolean flag = dao.deleteBook(id);
			if (flag) {
				
				BookDAO bookDAO = new BookDAO();
				List<Book> books = bookDAO.viewBooks();
				
				if (books!=null) {
					HttpSession session  = req.getSession();
					session.setAttribute("role", role);
					session.setAttribute("books", books);
					resp.sendRedirect("viewBooks.jsp");
				}else {
					BookDAO Bookdao = new BookDAO();
					CategoryDAO categoryDAO= new CategoryDAO();
					
					List<Category> DCategories = categoryDAO.viewCategories();
					
					for (Category category3 : DCategories) {
					List<Book>	book=Bookdao.searchBookByCategory(category3.title);
					if (book==null) {
						categoryDAO.deleteCategory(category3.id);
					}
					}
				}
//				IF THERE IS NO BOOK IN THE BOOK TABLE
				resp.sendRedirect("dataDeleted.jsp");
				
			}else {
//				IF THERE IS NO BOOK IN THE BOOK TABLE AND ALSO I WANT OT DELETE THEN THE ERROR OCCUR
				resp.sendRedirect("deleteFailed.jsp");
			}
		}else if(action.equals("searchByCategoryWise")) { //METHOD TO FETCH THE DATA BY CATEGORY WISE
			String category  = req.getParameter("search");
			BookDAO dao = new BookDAO();
			List<Book> books=dao.searchBookByCategory(category);
			
			
			if (books!=null) {
				HttpSession session  = req.getSession();
				session.setAttribute("books", books);
				resp.sendRedirect("viewBooks.jsp");
			}else {
				resp.getWriter().print("the data is not present in the datbase kindly store the data");
			}	
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
	    String role = req.getParameter("role");
		int id = Integer.parseInt(req.getParameter("id"));
		String title= req.getParameter("title");
		String author = req.getParameter("author");
		long price = Long.valueOf(req.getParameter("price"));
		String discription = req.getParameter("discription");
		
		HttpSession session = req.getSession();
	   Category category=(Category)	session.getAttribute("category");
	
	   Book book= new Book();
	   book.setId(id);
	   book.setTitle(title);
	   book.setPrice(price);
	   book.setAuthor(author);
	   book.setDiscription(discription);

	   book.setCategory(category);
	
	   CategoryDAO cat_dao = new CategoryDAO();
	
//	   Condition to add the book detail in the book table
	   if (action.equals("add")) {
		
		BookDAO book_dao = new BookDAO();
		boolean flag = book_dao.addBook(book);
		if (flag) {
			resp.sendRedirect("bookAdded.jsp");
		}else {
			resp.getWriter().print("the book is not added due to some reason");
		}
		
	}else if (action.equals("update")) {   //Condition to update the book data
		
		int cat = Integer.parseInt(req.getParameter("category"));
		Category category2 = new Category();
		category2.setId(cat);
		book.setCategory(category2);
		BookDAO dao = new BookDAO();
		boolean flag = 	dao.updateBook(id,book);
		
		if (flag) {
			
			BookDAO bookDAO = new BookDAO();
			List<Book> books = bookDAO.viewBooks();
			
			if (books!=null) {
				HttpSession httpSession  = req.getSession();
				httpSession.setAttribute("role", role);
				httpSession.setAttribute("books", books);
				resp.sendRedirect("viewBooks.jsp");
			}
			
			resp.getWriter().print("the data is successfully updated");
			
		}else {
			resp.getWriter().print("the data is not updated due to wrong logic kindly you have to impprove your logic");
		}
	}

	}
	
}
