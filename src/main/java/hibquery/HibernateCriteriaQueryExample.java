package hibquery;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class HibernateCriteriaQueryExample {

	public static void main(String[] args) {
		Session session = null;
		try {
			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();
			session = sessionFactory.openSession();
			
			Criteria c = session.createCriteria(Insurance.class);
			List<Insurance> ins = c.addOrder(Order.asc("investmentAmount")).list();
			
//			for (Iterator it = ins.iterator(); it.hasNext();) {
//				Insurance insurance = (Insurance) it.next();
//				System.out.println("ID: " + insurance.getInsuranceId());
//				System.out.println("Name: " + insurance.getInsuranceName());
//			}
			
			ins.forEach(System.out::println);
			
			System.out.println("***************************");
			
			c = session.createCriteria(Insurance.class);
			ins = c.add(Restrictions.between("investmentAmount", 22, 29)).list();
			ins.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			session.close();
		}

	}

}
