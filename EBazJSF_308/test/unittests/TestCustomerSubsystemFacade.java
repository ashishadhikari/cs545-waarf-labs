package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import business.customerSubsystem.CustomerSubsystemFacade;
import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.Customer;
import business.subsystemExternalInterfaces.CustomerSubsystem;
    

/**
 * JUnit test class for the Customer Subsystem. 
 * 
 * @author Rubia and Abeba
 * @date May 23, 2007
 */
public class TestCustomerSubsystemFacade {
	String name1="Rubia Meskeen";
	String street1="1000 N 4th Street";
	String city1="Fairfield";
	String state1="IA";
	String zip1="52557";
	
	String name2="Misrak Ararso";
	String street2="1000 N Broadway Street";
	String city2="Alexandria";
	String state2="VA";
	String zip2="52557";
	String expDate="03/10";
	String CCtype="Visa";
	String CCNum="0954671287";
	Address add1 = null;
	Address add2 = null;
	
	List<Address>adds= new LinkedList<Address>();
	CustomerSubsystem customerF=new CustomerSubsystemFacade();
	@Before
	public void setUp() throws Exception {
		
		 add1=customerF.createAddress(name1, street1, city1, state1, zip1);
		 add2=customerF.createAddress(name2, street2, city2, state2, zip2);
		
	}

    
    /**
     * Test whether getAllAddresses returns all of the addresses set by both
     * the setDefaultShippingAddress and setDefaultBillAddress methods.
     * (Alternate addresses should also be returned, but no alternate addresses
     * are created here.)
     */
	@Test
	public void testGetAllAddresses() {
		/* 
         * first create a customer object ,set add1 and add2 to customer object
         * and finally get all addressess through the customerfacace object
		 */
		
		Customer cust=customerF.CreateCustomer("jhon", "test");
		
		cust.setDefaultShippingAddress(add1);
		cust.setDefaultBillAddress(add2);
		List<Address> adds=customerF.getAllAddresses();
		
		assertEquals("Setting and getting for 2 Addresses failed", adds.size(), 2);
		
		
	}

	@Test
	public void testCreateAddress() {
		//first creat a single address, then get all the addresses and check the size
		//then check whether each parameter of the address has the expected value
		//do the same for the second element
		
		if (add1==null)
			fail("Creating address failed");
		
		//assertEquals("creating the first Address Failed: name differs", name1, add1.getName());
		//assertEquals("creating the first Address Failed: street differs", street1, add1.getStreet());
		assertEquals("creating the first Address Failed: city differs", city1, add1.getCity());
		assertEquals("creating the first Address Failed: state differs", state1, add1.getState());
		//assertEquals("creating the first Address Failed: zip differs", zip1, add1.getName());
					
	}



    /**
     * Test whether createCreditCard works as expected for legal input parameters.
     */
	@Test
	public void testCreateCreditCard() {
		//first create creditcard by invoking createCreaditCard method of the facade object
		//check whether a card object is returned, if null test fails otherwise
		// check whether the properties of  the object returned is
		// the same as the parametes we passed
		
		CreditCard card=customerF.createCreditCard( name1, expDate, CCNum, CCtype);
		if(card==null)
			fail("creating credit card failed");
		assertEquals("creating Credit card failed: name differs", name1, card.getNameOnCard());
		assertEquals("creating Credit card failed: name expDate", expDate, card.getExpirationDate());
		assertEquals("creating Credit card failed: name differs", CCNum, card.getCardNum());
		assertEquals("creating Credit card failed: name differs", CCtype, card.getCardType());
		
		
	}



}
