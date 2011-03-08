package business.subsystemExternalInterfaces;

import java.util.List;

import business.shoppingCartSubsystem.ShoppingCartLineItemImpl;

/**
 * @uml.dependency   supplier="business.subsystemExternalInterfaces.ShoppingCartLineItem"
 */
public interface ShoppingCart {

	/**
	 */
	public abstract List<ShoppingCartLineItem> getCartItems();

	/**
	 */
	public abstract void setShippingAddress(Address address);

	/**
	 */
	public abstract void saveBillingAddress(Address address);

	/**
	 */
	public abstract void saveCreditCard(CreditCard card);


	/**
	 * Create and add a shopping cart line item to the cart with product name
	 *  itemName, that belongs in catalog with this name, and this many of the 
	 *  items. 
	 * @param itemName
	 * @param quantity
	 * @param catalogName
	 */
	public abstract void addCartItem(Product prod, int quantity);

	/** returns the total cost of all line items in the cart
	 * 
	 * @return
	 */
	public abstract double getCartCost();

	public abstract Address getShippingAddress();

	public abstract Address getBillingAddress();
	
	/**
	 * returns the credit card to be used with this order
	 * TODO kl refactor -- should name savecreditcard to be savePaymentMethod (next course offering)
	 */  
	public CreditCard getPaymentMethod();

}