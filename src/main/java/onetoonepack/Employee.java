package onetoonepack;

import java.io.Serializable;
import java.util.Date;

public class Employee implements Serializable {
	private long employeeId;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private EmployeeDetail employeeDetail;
	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public EmployeeDetail getEmployeeDetail() {
		return employeeDetail;
	}

	public void setEmployeeDetail(EmployeeDetail employeeDetail) {
		this.employeeDetail = employeeDetail;
	}
	
	
}
