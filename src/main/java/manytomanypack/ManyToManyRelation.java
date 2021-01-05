package manytomanypack;

import java.util.Date;
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

			Product tv = new Product("TV", 300);
			tv.setProductId((long) 202);
			
			Order tvOrder = new Order("Megan");
			tvOrder.setOrderId((long) 2001);
			
			Product m = new Product("Microwave", 40);
			m.setProductId((long) 201);
			
			Order order2 = new Order("Mike");
			order2.setOrderId((long) 2002);
			
			OrderDetail od1 = new OrderDetail(2);
			OrderDetail od2 = new OrderDetail(5);
			Set<OrderDetail> ods1 = new HashSet<OrderDetail>();
			ods1.add(od1);
			ods1.add(od2);
			
			Set<OrderDetail> megsItems = new HashSet<OrderDetail>();
			megsItems.add(od1);
			tvOrder.setItems(megsItems);

			tv.setOrders(ods1);
			for (OrderDetail d : ods1) {
				d.setProduct(tv);
			}
			od1.setOrder(tvOrder);

			OrderDetail microOrderDetail = new OrderDetail(1);
			Set<OrderDetail> ods2 = new HashSet<OrderDetail>();
			ods2.add(microOrderDetail);
			microOrderDetail.setProduct(m);
			microOrderDetail.setOrder(order2);
			od2.setOrder(order2);
			
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
//			for (OrderDetail orderDetail : productsOrdered) {
//				System.out.println(orderDetail.getId());
//			}
			productsOrdered.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
