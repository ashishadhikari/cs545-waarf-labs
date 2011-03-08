package business.subsystemExternalInterfaces;

import java.util.List;


public interface OrderSubsystem {

	/**
	 * submitOrder creates an order from the shopping cart.  It copies all of 
	 * the information from the shopping cart into the fields of the order, and persists itself.
	 * I.e., the order subsystem is the order.
	 * Submit should return a unique order id string for the submitted order.
	 * @param shopCart
	 * @param custId
	 */
	public abstract String submit(ShoppingCart shopCart, String custId);

	/**
	 * returns an Order for the input orderId
	 * @param orderId
	 * @return
	 */
	public abstract Order getOrder(String orderId);

	/**
	 * This is not currently needed by any use cases, but is an example of an 
	 * operation on the entire order list that we might want in the future.  Such operations will
	 * be most naturally assigned to the OrderSubsystem class.
	 * 
	 * This operation returns the total value of all the orders for the current customer.
	 * @return
	 */
	public abstract double getAllOrdersTotal();

	/**
	 * returns list of all the orders for the current customer.
	 * @return
	 */
	public abstract List<Order> getCustomerOrderList();

}