package business.subsystemExternalInterfaces;

import business.shoppingCartSubsystem.ShoppingCartSubsystemFacade;

public interface ShoppingCartLineItem {
	
	public Product getCartProduct();


	public int getQuantity();


	/**
	 * returns total cost of this line item
	 * @return
	 */
	public double getItemCost();

}