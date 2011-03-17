package business.shoppingCartSubsystem;

import business.productSubsystem.ProductImpl;
import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.CustomerSubsystem;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ShoppingCartSubsystemFacade implements ShoppingCart {


	/** 
	 * @uml.property name="customer1"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="shoppingCart:business.CustomerSubsystemFacade"
	 */
	private CustomerSubsystem customerSubsys;
	private ShoppingCartImpl cartImplementation = new ShoppingCartImpl();
	
	/* (non-Javadoc)
	 * @see business.shoppingCartSubsystem.ShoppingCart#setShippingAddress(business.Address)
	 */
	public void setShippingAddress(Address address) {

	}

	/* (non-Javadoc)
	 * @see business.shoppingCartSubsystem.ShoppingCart#saveBillingAddress(business.Address)
	 */
	public void saveBillingAddress(Address address) {

	}

	/* (non-Javadoc)
	 * @see business.shoppingCartSubsystem.ShoppingCart#saveCreditCard(business.CreditCardImpl)
	 */
	public void saveCreditCard(CreditCard card) {

	}


	public void addCartItem(Product prod, int quantity) {
		cartImplementation.addCartItem(prod, quantity);
		
	}

	/**
	 * returns the total cost of all the items in the cart
	 */
	public double getCartCost() {
		return cartImplementation.getTotalCartCost();
	}



	public Address getShippingAddress() {
		return cartImplementation.getDefaultShipAdd();
	}



	public Address getBillingAddress() {
		return cartImplementation.getDefaultbillAdd();
	}


	public List<ShoppingCartLineItem> getCartItems() {
		// TODO Auto-generated method stub
		return cartImplementation.getCartLineItems();
	}

	public CreditCard getPaymentMethod() {
		// TODO Auto-generated method stub
		return null;
	}

}
