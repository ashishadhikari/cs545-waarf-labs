package business.subsystemExternalInterfaces;

import java.util.List;

/**
 * Orders should be held directly in a list by a customer subsystem.  
 * @author levi
 *
 */
public interface Order {
	public void submit(ShoppingCart shopCart, String custId);
    public List getOrderItems();   
	public String getOrderDate();
	public String getOrderId();
	public double getTotalPrice();
	
	public void setBillingAddress(Address address);
	public void setShippingAddress(Address address);
	public void setPaymentCard(CreditCard card);
	
	public Address getBillingAddress();
	public Address getShippingAddress();
	public CreditCard getPaymentCard();
}
