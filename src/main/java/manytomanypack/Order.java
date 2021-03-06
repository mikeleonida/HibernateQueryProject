package manytomanypack;

import java.io.Serializable;
import java.util.Set;

public class Order implements Serializable {
	private long orderId;
	private String personName;
	private Set<OrderDetail> items;
	
	public Order() {
		
	}

	public Order(String personName) {
		super();
		this.personName = personName;
	}

	public Order(long orderId, String personName) {
		super();
		this.orderId = orderId;
		this.personName = personName;
	}

	public Order(long orderId, String personName, Set<OrderDetail> items) {
		super();
		this.orderId = orderId;
		this.personName = personName;
		this.items = items;
		for (OrderDetail o : this.items) {
			o.setOrder(this);
		}
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Set<OrderDetail> getItems() {
		return items;
	}

	public void setItems(Set<OrderDetail> items) {
		this.items = items;
		for (OrderDetail o : this.items) {
			o.setOrder(this);
		}
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", personName=" + personName + ", items=" + items + "]";
	}

	
	
	
}
