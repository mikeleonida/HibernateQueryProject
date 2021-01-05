package manytomanypack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyRelation {

	public static void main(String[] args) {
		
		System.out.println("Many to many relation");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		try {
			Transaction tx = session.beginTransaction();

			Product tv = new Product(202l, "TV", 300);			
			Order tvOrder = new Order(2001l, "Megan");
			Product m = new Product(201l, "Microwave", 40);
			Order order2 = new Order(2002l, "Mike");
			
			OrderDetail od1 = new OrderDetail(2);
			OrderDetail od2 = new OrderDetail(5);
			Set<OrderDetail> ods1 = new HashSet<>();
			ods1.add(od1);
			ods1.add(od2);
			
			Set<OrderDetail> megsItems = new HashSet<OrderDetail>();
			megsItems.add(od1);
			tvOrder.setItems(megsItems);
			tv.setOrders(ods1);

			OrderDetail microOrderDetail = new OrderDetail(1);
			Set<OrderDetail> ods2 = new HashSet<OrderDetail>();
			ods2.add(microOrderDetail);			
			m.setOrders(ods2);

			Set<OrderDetail> mikesOrderDetail = new HashSet<OrderDetail>();
			mikesOrderDetail.add(microOrderDetail);
			mikesOrderDetail.add(od2);
			order2.setItems(mikesOrderDetail);

			session.save(tv);
			session.save(m);
			session.save(tvOrder);
			session.save(order2);
			session.save(od1);
			session.save(od2);
			session.save(microOrderDetail);
			tx.commit();

			System.out.println("Record Saved.");
			System.out.println("**************************");
			
			List<OrderDetail> productsOrdered = session.createQuery("from OrderDetail o").list();
			productsOrdered.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
