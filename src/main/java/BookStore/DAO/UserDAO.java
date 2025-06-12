package BookStore.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import BookStore.entity.Book;
import BookStore.entity.Category;
import BookStore.entity.User;

public class UserDAO {
		Configuration cfg = new Configuration().addAnnotatedClass(Book.class).addAnnotatedClass(User.class)
				.addAnnotatedClass(Category.class).configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
//		******************* Method to add User ******************
		
		public boolean addUser(User user) {
		Session session = sf.openSession();
		session.beginTransaction();
		User u = session.get(User.class, user.id);
		if (u!=null) {
			return false;
		}else {
			
			Query hql = session.createQuery("from User where email=:mail",User.class);
			hql.setParameter("mail", user.email);
			
			u = (User)hql.uniqueResult();
			if (u!=null) {
				return false;
			}else {
			session.save(user);
			session.getTransaction().commit();
			session.close();
			return true;
				}
			}
		}
		
//			******************************* Check User either Registered or Not ************
			public boolean checkUser(User user) {
			Session session  = sf.openSession();
			User u = null;
			Query query = session.createQuery("from User where email=:mail AND password=:pass");
			query.setParameter("mail", user.email);
			query.setParameter("pass", user.password);
			
			u = (User)query.uniqueResult();
			if (u!=null) {
				return true;
			}else {
				return false;
			}
			
		}
	
}
