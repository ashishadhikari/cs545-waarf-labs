package business.orderSubsystem;

import java.util.ArrayList;
import java.util.List;

import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.Order;
import business.subsystemExternalInterfaces.OrderLineItem;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

public class OrderImpl implements Order {
	private List<OrderLineItem> orderItems = new ArrayList<OrderLineItem>();
	private Address shippingAddress;
	private Address billingAddress;
	private CreditCard paymentCard;
	private String orderId;
	private String orderDate;
	
	
	public OrderImpl(Address shippingAddress, Address billingAddress, CreditCard paymentCard) {
		super();
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.paymentCard = paymentCard;
	}

	/**
	 * constructor that instantiates the order fields from a shopping cart
	 * @param shopCart
	 */
	public OrderImpl(ShoppingCart shopCart) {
		 
		shippingAddress = shopCart.getShippingAddress();
		billingAddress = shopCart.getBillingAddress();
		
		 for (ShoppingCartLineItem nextCartItem: shopCart.getCartItems()) {
			 OrderLineItem newOrderItem = new OrderLineItemImpl(nextCartItem.getCartProduct(),
					 nextCartItem.getQuantity());
			 orderItems.add(newOrderItem);
		 }
	}
	public Address getBillingAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrderDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrderId() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getOrderItems() {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditCard getPaymentCard() {
		// TODO Auto-generated method stub
		return null;
	}

	public Address getShippingAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	public double getTotalPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setBillingAddress(Address address) {
		// TODO Auto-generated method stub

	}

	public void setPaymentCard(CreditCard card) {
		// TODO Auto-generated method stub

	}

	public void setShippingAddress(Address address) {
		// TODO Auto-generated method stub

	}

	public void submit(ShoppingCart shopCart, String custId) {
		// TODO Auto-generated method stub

	}



}
