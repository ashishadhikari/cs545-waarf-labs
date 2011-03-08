package business.orderSubsystem;

import business.subsystemExternalInterfaces.OrderLineItem;
import business.subsystemExternalInterfaces.Product;

public class OrderLineItemImpl implements OrderLineItem {
	private Product orderProduct;
	private int quantity;
	


	public OrderLineItemImpl(Product prod, int quantity) {
		super();
		this.orderProduct= prod;
		this.quantity = quantity;
	}
	
	
	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(Product orderProduct) {
		this.orderProduct = orderProduct;
	}

}
