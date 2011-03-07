package unittests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import business.productSubsystem.ProductSubsystemFacade;
import business.shoppingCartSubsystem.ShoppingCartSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;


public class TestShoppingCartfacade {
	ShoppingCart testCart = new ShoppingCartSubsystemFacade();
	ProductSubsystem prodSubsystem = new ProductSubsystemFacade();	
	Catalog books;
	Product goneWind;
	Product coreJava;
	Product umlDistilled;
	

	  public final static double TESTCARTCOST = 1500;
	  public final static double ERRORMARGIN = .001;
	  
	
	/* create a shipping and a billing address */
	
	/* create a credit card */

	@Before
	public void setUp() throws Exception {
		
		books = prodSubsystem.createCatalog(ProductSubsystemFacade.BOOKS);
		goneWind = prodSubsystem.createProduct("Gone With The Wind", 10, 100, "Classic novel of US civil war", books);
		coreJava = prodSubsystem.createProduct("Core Java", 50, 10, "MPP Text", books);
		umlDistilled = prodSubsystem.createProduct("UML Distilled", 30, 100, "SWEng Text", books);
		
		testCart.addCartItem(goneWind,100);
		testCart.addCartItem(coreJava,10);
		
	}


	
	@Test
	public void testAddLineItem() {
		//ShoppingCart testCartAddItem = new ShoppingCartSubsystemFacade();
		/*
		 * first get the line items in the cart; then add a new one; then get them 
		 * again and see if get one more than previous
		 */
		/* the following should be products and catalogs in the system */

//		int numItems = testCartAddItem.getCartItems().size();
//		assertEquals("adding initial items failed", 2, numItems);
//		testCartAddItem.addCartItem(umlDistilled, 1);
//		assertEquals("adding a 3rd item failed", testCartAddItem.getCartItems().size(), 3);
		
		int numItems = testCart.getCartItems().size();
		assertEquals("initial cart unexpected size", 2, numItems);
		testCart.addCartItem(umlDistilled, 1);
		assertEquals("adding a 3rd item failed", testCart.getCartItems().size(), 3);		
			
	}
	
	@Test
	public void testGetCartCost() {
		/* 
		 * should refactor this test so it is independent of others??--seems that tests
		 * do run "independently, i.e., 3rd item added by above test not present for this test??
		 */
		double cost = testCart.getCartCost();
		assertEquals(TESTCARTCOST, cost, ERRORMARGIN);
		
	}


}
