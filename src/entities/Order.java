package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enun.OrderStatus;

public class Order {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date moment;
	private OrderStatus status;
	
	// relações 
	
	private Client client;
	private List<OrderIten> orderIten = new ArrayList<>();
	
	public Order() {}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderIten> getOrderIten() {
		return orderIten;
	}

public void addItem (OrderIten orderIten) {
		
		this.orderIten.add(orderIten);
}

public void removeItem (OrderIten orderIten) {
	
	this.orderIten.remove(orderIten);
}

public double total() {
	double totalp = 0 ;
	for(OrderIten c : orderIten ) {
		totalp+=c.subTotal();
	}
		 
	return totalp ;
	
}

public String toString() {
	StringBuilder sd = new StringBuilder();
	sd.append("ORDER SUMARY: "+ "\n");
	sd.append("STATUS: "+status+ "\n");
	sd.append("Client: "+ client.getName() +", birth "+sdf.format(client.getBithDate())+", e-mail: "+client.getEmail() +"\n");
	sd.append("ORDER ITENS: "+"\n");
	for(OrderIten c: orderIten) {
		sd.append("Nome: "+c.getProduct().getName()+" ,preço: $ "+c.getPrice()+" ,Qtd "+c.getQuantity()+" ,Sub total: $ "+c.subTotal()+"\n");
	}
	sd.append("TOTAL PRICE: R$ "+total());
	
	return sd.toString();
	
	
}




	

}
