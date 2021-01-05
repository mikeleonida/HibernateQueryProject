package hibquery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;


public class NativeQueryDemo {

	public static void main(String[] args) {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Query q = session.createSQLQuery("Select * from insurancetable").addEntity(Insurance.class);
			List<Insurance> ins = q.list();
			
			ins.forEach(System.out::println);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

}
