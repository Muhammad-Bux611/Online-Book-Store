package BookStore.DAO;

import BookStore.entity.Category;
import BookStore.entity.Admin;
import BookStore.entity.Book;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.servlet.http.HttpSession;

public class BookDAO {
	
	Configuration cfg = new Configuration().addAnnotatedClass(Book.class).configure().addAnnotatedClass(Category.class);
	SessionFactory sf = cfg.buildSessionFactory();
	
//	**************************ADD BOOK METHOD***************************
	
	public boolean addBook(Book book) {
		
		boolean flag=false;
		Book b = null;
		Session session = sf.openSession();
		session.beginTransaction();
		b = session.get(Book.class, book.id); // CHECK IF BOOK EXSIT WITH THIS ID
		
		if (b!=null) {
		System.out.println("the book is alredy exists of the same id kindly store another book");
			flag = false;
		}else {
			// CHECK THE EXISTING BOOK TITLE IS SAME AS THE TITLE I WANT TO STORE
			List<Book> books = viewBooks();
			if (books!=null) {
			
			for (Book book2 : books) {
				if (book2.title.equalsIgnoreCase(book.title)) {

					System.out.println("this book is already exists");
					return false;
					
				}
			}
			
			}
		}	
//			THE BOOK IS NOT STORED OF  ID AND TITLE THEN STORE THAT BOOK DATA
			session.save(book);
			session.getTransaction().commit();
			session.close();
			flag= true;
			return flag;
			
	}
	
//	***********************METHOD TO VIEW THE BOOK ********************************
	
	public List<Book> viewBooks(){
		List<Book> books= null;
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query hql=session.createQuery("from Book");
		books=	hql.list();

		session.getTransaction().commit();
		session.close();
		if (books.size()!=0 && books!=null) {
			System.out.println("books are present in the database");
			return books;
		}else {
			return null;
		}
	}
	
	
//	****************************** METHOD TO UPDATE THE EXSITING BOOK DETAIL********************
	public boolean updateBook(int id, Book b) {
		Session session = sf.openSession();
		Book book = session.get(Book.class, id);
		session.beginTransaction();
		if (book!=null) {
			book.id=b.id;
			book.author=b.author;
			book.discription=b.discription;
			book.price=b.price;
			book.category=b.category;
			book.title= b.title;
			session.save(book);
			session.getTransaction().commit();
			session.close();
			return true;
		}else {
			return false;
		}
	}
	
//	*************************************METHOD TO DELETE THE BOOK BY ID***************
	
	public boolean deleteBook(int id) {
		Session session = sf.openSession();
		session.beginTransaction();
		Book book = session.get(Book.class, id);
		if (book!=null) {
			session.remove(book);
			session.getTransaction().commit();
			session.close();
			return true;
		}else {
			return false;
		}
		
	}
	
//	**************************** METHOD TO FETCH THE BOOK BY CATEGORY WISE *******************
	
public	List<Book> searchBookByCategory(String category){
		List<Book> books= null;
		Session session = sf.openSession();
		session.beginTransaction();
//		THIS QUERY IS USED FOR , TO FETCH THE CATEGORY ID
		Query hql = session.createQuery("from Category where title=:title",Category.class);
		hql.setParameter("title", category);
		
		Category c = (Category)hql.uniqueResult();
		if (c!=null) {
			Query getBooks = session.createQuery("from Book as b  where category.id=:catId");
			getBooks.setParameter("catId", c.id);
			books= (List<Book>)getBooks.getResultList();

			session.getTransaction().commit();
			session.close();
			if (books.size()!=0) {
				return books;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}	
}
