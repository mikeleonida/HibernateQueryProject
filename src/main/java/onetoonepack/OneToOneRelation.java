package onetoonepack;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneToOneRelation {

	public static void main(String[] args) {
		System.out.println("One to one relation");
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		EmployeeDetail employeeDetail = new EmployeeDetail("Bergenfield");
		Employee employee = new Employee("Megan", "M", new Date(2012-12-01));
		employee.setEmployeeId((long) 202);
		
		employee.setEmployeeDetail(employeeDetail);
		employeeDetail.setEmployee(employee);
		session.save(employee);
		tx.commit();
		
		System.out.println("Record Saved.");
		
		List<Employee> employees = session.createQuery("from Employee e").list();
		for (Employee employee1 : employees) {
			System.out.println(employee1.getFirstName() + ", " + employee1.getEmployeeDetail().getCity());
		}
		
		session.close();
	}

}
