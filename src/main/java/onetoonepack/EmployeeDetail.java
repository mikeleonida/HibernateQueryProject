package onetoonepack;

import java.io.Serializable;

public class EmployeeDetail implements Serializable {
	private long employeeId;
	private String city;
	private Employee employee;
	
	public EmployeeDetail() {
		
	}

	public EmployeeDetail(String city) {
		super();
		this.city = city;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
