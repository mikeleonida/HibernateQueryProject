package onetomanypack;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToManyRelation {

	public static void main(String[] args) {
		System.out.println("One to many relation");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Vehicle mustang = new Vehicle("Ford Mustang");
		Vehicle honda = new Vehicle("Honda Accord");
		Set<Vehicle> vs = new HashSet<Vehicle>();
		vs.add(mustang);
		vs.add(honda);
		
		Employee employee = new Employee("Mike", "Leo", new Date(121212));
		employee.setEmployeeId((long) 202);
		employee.setVehicles(vs);
//		mustang.setEmp(employee);
//		honda.setEmp(employee);
		for (Vehicle v : vs) {
			v.setEmp(employee);
		}
		
		session.save(employee);
		session.save(mustang);
		session.save(honda);
		tx.commit();
		
		System.out.println("Record Saved.");
		
		List<Employee> employees = session.createQuery("from Employee e").list();
//		for (Employee employee1 : employees) {
//			System.out.println(employee1.getFirstName());
//		}
		
		employees.forEach(System.out::println);
		
		session.close();
	}

}
