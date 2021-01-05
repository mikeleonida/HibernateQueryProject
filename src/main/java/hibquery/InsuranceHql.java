package hibquery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;



public class InsuranceHql {

	public static void main(String[] args) {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Query q = session.createQuery("from Insurance i where i.insuranceName like 'Megan'");
			List<Insurance> ins = q.list();
			
			ins.forEach(System.out::println);
			System.out.println("*************************");
			
			q = session.createQuery("Select new list(insuranceId, insuranceName, investmentDate) "
					+ "from Insurance i where i.insuranceName like 'Megan'");
			List ins2 = q.list();
			ins2.forEach(System.out::println);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

}
