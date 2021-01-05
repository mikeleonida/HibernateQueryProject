package manytomanypack;

import java.io.Serializable;
import java.util.Set;

public class Product implements Serializable {
	private long productId;
	private String name;
	private int price;
	private Set<OrderDetail> orders;
	
	public Product() {
		
	}

	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Set<OrderDetail> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderDetail> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", price=" + price + ", orders=" + orders + "]";
	}

	
	
	
}
