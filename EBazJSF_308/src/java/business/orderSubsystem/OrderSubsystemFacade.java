
package business.orderSubsystem;

import java.util.ArrayList;
import java.util.List;

import business.subsystemExternalInterfaces.Order;
import business.subsystemExternalInterfaces.OrderLineItem;
import business.subsystemExternalInterfaces.OrderSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

public class OrderSubsystemFacade implements OrderSubsystem {
	/* list of all the orders submitted for this customer */
	private List<Order> customerOrderList = new ArrayList<Order>();
	
	/* (non-Javadoc)
	 * @see business.orderSubsystem.OrderSubsystem#submit(business.subsystemExternalInterfaces.ShoppingCart, java.lang.String)
	 */
	 public String submit(ShoppingCart shopCart, String custId) {
		 /* copy cart fields to an order */
		 Order newOrder = new OrderImpl(shopCart);

		 
		 /* add the order to the customerOrderList */
		 customerOrderList.add(newOrder);
		 
		 /* get the order id */
		 
		 /* persist the order */
		  
		 /* return the orderId TODO -- get order id */		 
		 return null;
		 
	 }

	 /* (non-Javadoc)
	 * @see business.orderSubsystem.OrderSubsystem#getOrder(java.lang.String)
	 */
	 public Order getOrder(String orderId) {
		 return null;
	 }
	 
	 /* (non-Javadoc)
	 * @see business.orderSubsystem.OrderSubsystem#getAllOrdersTotal()
	 */
	 public double getAllOrdersTotal() {
		 return 0;
	 }

	public List<Order> getCustomerOrderList() {
		// TODO Auto-generated method stub
		return customerOrderList;
	}
	 
	 





}