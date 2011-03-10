package business.customerSubsystem;

import java.util.Collection;
import java.util.List;

import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.Customer;
import business.subsystemExternalInterfaces.CustomerSubsystem;
import business.subsystemExternalInterfaces.Order;
import business.subsystemExternalInterfaces.ShoppingCart;

/*
 * will contain default shipping and billing addresses, as well as credit card info
 */
/**
 * @uml.dependency   supplier="business.subsystemExternalInterfaces.CreditCard"
 */
public class CustomerSubsystemFacade implements CustomerSubsystem {

	/* (non-Javadoc)
	 * @see business.customerSubsystem.CustomerSubsystem#getDefaultPayment()
	 */
	public CreditCard getDefaultPayment() {
		return null;

	}

	/**
	 * @uml.property   name="shoppingCart"
	 * @uml.associationEnd   inverse="customer1:business.ShoppingCartSubsystemFacade"
	 */
	private ShoppingCart shoppingCart;

	/* (non-Javadoc)
	 * @see business.customerSubsystem.CustomerSubsystem#getOrders()
	 */
	public List<Order> getOrders() {
		return null;

	}

	/* (non-Javadoc)
	 * @see business.customerSubsystem.CustomerSubsystem#getAnOrder(java.lang.String)
	 */
	public Order getAnOrder(String orderId) {
		return null;

	}

	/**
	 * @uml.property  name="order"
	 * @uml.associationEnd  multiplicity="(0 -1)" inverse="customer:business.Order"
	 */
	private Collection<Order> order;

	public Address createAddress(String name1, String street1, String city1, String state1, String zip1) {
		
		return new AddressImpl(name1, street1, city1, state1, zip1);
	}

	public Customer CreateCustomer(String id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public CreditCard createCreditCard(String name, String type, String number, String expDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Address> getAllAddresses() {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initalizeCustomer(String id, String password) {
		// TODO Auto-generated method stub
		
	}

	public Customer login() {
		// TODO Auto-generated method stub
		return null;
	}

}
