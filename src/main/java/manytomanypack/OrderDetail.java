package manytomanypack;

import java.io.Serializable;

public class OrderDetail implements Serializable {
	private long id;
	private Order order;
	private Product product;
	private int quantity;
	
	public OrderDetail() {
		
	}

	public OrderDetail(int quantity) {
		super();
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long detailId) {
		this.id = detailId;
	}
	
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", order=" + order.getOrderId() + ", product=" + product.getName() + ", quantity=" + quantity + "]";
	}

	
}
