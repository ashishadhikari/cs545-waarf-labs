package business.subsystemExternalInterfaces;

import java.util.List;


/**
 * @uml.dependency   supplier="business.subsystemExternalInterfaces.OrderSubsystem"
 */
public interface CustomerSubsystem {
	
			public List<Order> getOrders();
			public List<Address> getAllAddresses();
			public Address createAddress(String name, String street, String city, String state, String zip );
            public Customer getCustomer();
            public Customer login();
            public CreditCard createCreditCard(String name,String type, String number, String expDate);
		    public void initalizeCustomer(String id, String password);
		    public Customer CreateCustomer(String id, String password);

	}