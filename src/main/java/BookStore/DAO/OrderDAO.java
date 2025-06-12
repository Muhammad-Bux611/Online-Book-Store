package BookStore.DAO;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import BookStore.entity.Book;
import BookStore.entity.Category;
import BookStore.entity.OrderEntity;
import BookStore.entity.User;
import jakarta.servlet.http.HttpSession;

public class OrderDAO {

		Configuration cfg = new Configuration().addAnnotatedClass(User.class).addAnnotatedClass(OrderEntity.class)
				.addAnnotatedClass(Category.class).addAnnotatedClass(Book.class).configure();
		
		SessionFactory sf = cfg.buildSessionFactory();
		
//		******** Method to place the order ********************
		
			public	void placeOrder(OrderEntity order) {
			Session session = sf.openSession();
			session.beginTransaction();

			session.save(order);
			session.getTransaction().commit();
			session.close();
		}
			
//		 ************************Method to the User detail with the help of Email*************
			
		public User getUserbyEmail(String email) {
		Session session = sf.openSession();
		session.beginTransaction();
		Query hql = session.createQuery("from User where email=:mail",User.class);
		hql.setParameter("mail", email);
		User user = null;
		user = (User)hql.uniqueResult();
 		session.getTransaction().commit();
 		session.close();
 		if (user!=null) {
			return user;
		}else {
			return null;
		}
	}
		
//	****************** Method to Fetch the order of the perticular user ***************
		
	public	List<OrderEntity> viewOrdersByUser(String userEmail){
		Session session = sf.openSession();
		List<OrderEntity> orders= null;
		session.beginTransaction();
		Query getUser = session.createQuery("from User where email=:mail");
		getUser.setParameter("mail", userEmail);
		User u = (User)getUser.uniqueResult();
		Query hql = session.createQuery("from OrderEntity as o where o.user.id=:id",OrderEntity.class);
		hql.setParameter("id", u.id);
		orders = (List<OrderEntity>)hql.list();
		session.getTransaction().commit();
		session.close();
		if (orders.size()!=0) {
			return orders;
		}else {
			return null;
		}
		
	}
	
//	********************** Method to delete The order with the help of Order id ************************
	
	public	void deleteOrderbyId(int orderId) {
		Session session = sf.openSession();
		session.beginTransaction();
		OrderEntity o=session.get(OrderEntity.class, orderId);
		session.remove(o);
		session.getTransaction().commit();
		session.close();
	}
	 
//	******************************** Method to view All order by Admin *********************
	
	public	List<OrderEntity> viewOrder(){
		List<OrderEntity> allOrder = null;
		Session session = sf.openSession();
		session.beginTransaction();
		Query hql = session.createQuery("from OrderEntity");
		allOrder=hql.list();
		if (allOrder.size()!=0) {
		return allOrder;
		}else {
		return null;
		}
	}
	
//	************************* View Order by Order Id **************
	
	public	OrderEntity viewById(int orderID) {
		Session session = sf.openSession();
		session.beginTransaction();
		OrderEntity order = session.get(OrderEntity.class, orderID);
		session.getTransaction().commit();
		session.close();
		if (order!=null) {
			return order;
		}else {
			return null;
		}
	}
	
//	************************* Update Order Detail *********************
	
   public	void updateOrder(int orderId, OrderEntity o) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.saveOrUpdate(o);
		session.getTransaction().commit();
		session.close();
	}
}
