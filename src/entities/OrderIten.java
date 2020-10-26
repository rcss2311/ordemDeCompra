package entities;

public class OrderIten {
	
	private Integer quantity;
	private Double price;
	
	// RELAÇÃO
	
	private Product product;
	
	public OrderIten() {}

	public OrderIten(Integer quantity, Double price, Product product) {
		
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public double subTotal() {
		return product.getPrice() * quantity;
	}
	
	
	
	
	

}
