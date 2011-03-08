package application;

import business.AddressSanitizerBoundary;
import business.CreditVerificationBoundary;
import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.CustomerSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;

public class CheckoutController {

	public CheckoutController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 */
	public void validateCC() {

	}

	/**
	 */
	public void submitOrder() {

	}

	/**
	 * @uml.property  name="shoppingCart"
	 * @uml.associationEnd  inverse="checkoutController:business.ShoppingCartSubsystemFacade"
	 */
	private ShoppingCart shoppingCart;

	/**
	 * Getter of the property <tt>shoppingCart</tt>
	 * @return  Returns the shoppingCart.
	 * @uml.property  name="shoppingCart"
	 */
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	/**
	 * Setter of the property <tt>shoppingCart</tt>
	 * @param shoppingCart  The shoppingCart to set.
	 * @uml.property  name="shoppingCart"
	 */
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	/**
	 * @uml.property  name="creditVerificationBoundary"
	 * @uml.associationEnd  inverse="checkoutController:application.CreditVerificationBoundary"
	 */
	private CreditVerificationBoundary creditVerificationBoundary;

	/**
	 * @uml.property  name="addressSanitizerBoundary"
	 * @uml.associationEnd  inverse="checkoutController:application.AddressSanitizerBoundary"
	 */
	private AddressSanitizerBoundary addressSanitizerBoundary;

	/**
	 * 
	 * Create ShoppingCartSubsystemFacade if necessary and assign the CustomerSubsystemFacade to the shopping cart.
	 */
	public void startCheckout() {

	}


	/**
	 * 
	 * First validate the input address, and then if it is valid, store it in the shopping cart.
	 */
	public void saveShipAddress() {

	}

	/**
	 * 
	 * Validates the address and then if valid, saves as billing address in the shopping cart.
	 */
	public void saveBillingAddress(Address address) {

	}

	/**
	 * 
	 * validates the input credit card, and if valid, then stores in the shopping cart.
	 */
	public void saveCreditCard(CreditCard card) {

	}

	/**
	 * @uml.property  name="customerSubsystem"
	 * @uml.associationEnd  inverse="checkoutController:business.subsystemExternalInterfaces.CustomerSubsystem"
	 */
	private CustomerSubsystem customerSubsystem;

	/**
	 * Getter of the property <tt>customerSubsystem</tt>
	 * @return  Returns the customerSubsystem.
	 * @uml.property  name="customerSubsystem"
	 */
	public CustomerSubsystem getCustomerSubsystem() {
		return customerSubsystem;
	}

	/**
	 * Setter of the property <tt>customerSubsystem</tt>
	 * @param customerSubsystem  The customerSubsystem to set.
	 * @uml.property  name="customerSubsystem"
	 */
	public void setCustomerSubsystem(CustomerSubsystem customerSubsystem) {
		this.customerSubsystem = customerSubsystem;
	}

	/**
	 * @uml.property  name="liveCart"
	 * @uml.associationEnd  inverse="checkoutController:business.subsystemExternalInterfaces.ShoppingCart"
	 */
	private ShoppingCart liveCart;

}
