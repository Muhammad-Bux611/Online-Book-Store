package BookStore.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import BookStore.entity.Admin;
import BookStore.entity.Book;
import BookStore.entity.Category;

public class CategoryDAO {
		Configuration cfg = new Configuration().addAnnotatedClass(Category.class)
				.addAnnotatedClass(Book.class).addAnnotatedClass(Admin.class).configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
//		************** Method to store the category of Books *************
		
		public boolean addCategory(Category c) {
		Category category = null;
		Session session = sf.openSession();
		session.beginTransaction();
		
		category = session.get(Category.class, c.id);
		if (category!=null) {
			System.out.println("the categories is already present in the database");
			return true;
		}else {
			Query hql= session.createQuery("from Category where title=:title");
			hql.setParameter("title", c.title);
			Category cat= (Category)hql.uniqueResult();
		if (cat==null) {
	 		session.save(c);	
			session.getTransaction().commit();
			session.close();
			return true;
			}else {
			
			System.out.println("this type of data is already exists kindly sotre something different");
			return false;
			}
		}
	}
		
//		****************** Method to  Fetch all The category ***********
		
		public List<Category> viewCategories(){
		List<Category> categories= null;
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query hql=session.createQuery("from Category");
		categories=	hql.list();

		session.getTransaction().commit();
		session.close();
		if (categories.size()!=0) {
			System.out.println("books are present in the database");
			return categories;
		}else {
			return null;
		}
	}
	
//	*************************Method to delete the category data ********************
		
		public	void deleteCategory(int catId) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		Category cat=(Category)	session.get(Category.class, catId);
		session.remove(cat);
		session.getTransaction().commit();
		session.close();
	}
}
