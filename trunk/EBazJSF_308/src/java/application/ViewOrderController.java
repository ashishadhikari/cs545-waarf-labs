package application;


import java.util.List;

import business.subsystemExternalInterfaces.CustomerSubsystem;
import business.subsystemExternalInterfaces.Order;
import business.subsystemExternalInterfaces.OrderSubsystem;

public class ViewOrderController {

	public ViewOrderController() {
		super();
		// TODO Auto-generated constructor stub
	}

		
		/**
		 * returns all orders for this customer
		 */
		public List getAllOrders(String customerId){
		List allOrders = null;
			return allOrders;
		}


			
			/**
			 * returns the list of order line items for the specified orderId
			 * 
			 */
			public List getOrderDetails(){
			List orderLineItems = null;
			
			return orderLineItems;
			}



				
				/**
				 */
				public Order getOrder(String orderId){
					return null;
				
				}




				/**
				 * @uml.property  name="customerSubsystem"
				 * @uml.associationEnd  inverse="viewOrderController:business.subsystemExternalInterfaces.CustomerSubsystem"
				 */
				private CustomerSubsystem customerSubsystem;
				/**
				 * @uml.property  name="orderSubsystem"
				 * @uml.associationEnd  inverse="viewOrderController:business.subsystemExternalInterfaces.OrderSubsystem"
				 */
				private OrderSubsystem orderSubsystem;

}
