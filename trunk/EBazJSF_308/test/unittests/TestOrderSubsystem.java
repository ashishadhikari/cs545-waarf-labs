package unittests;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import business.orderSubsystem.OrderSubsystemFacade;
import business.productSubsystem.ProductSubsystemFacade;
import business.shoppingCartSubsystem.ShoppingCartSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Order;
import business.subsystemExternalInterfaces.OrderSubsystem;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;

public class TestOrderSubsystem {
	

	private OrderSubsystem orderSubsystem = new OrderSubsystemFacade();
	private ShoppingCart cart = new ShoppingCartSubsystemFacade();
	private ProductSubsystem prodSubsystem = new ProductSubsystemFacade();
	private String custId = "1";
	private int numOfOrders = 0;
	private List<Order> orderList = null;
	private String orderId;
	private static final double DELTA_MARGIN = .0001;

	@Before
	public void setUp() throws Exception {
		Catalog books = prodSubsystem.createCatalog(ProductSubsystemFacade.BOOKS);
		Product goneWind = prodSubsystem.createProduct("Gone With The Wind", 10, 100, "Classic novel of US civil war", books);
		cart.addCartItem(goneWind, 10);
		
		Product coreJava = prodSubsystem.createProduct("Core Java", 50, 10, "MPP Text", books);
		cart.addCartItem(coreJava, 1);
		orderList = orderSubsystem.getCustomerOrderList();
		numOfOrders = orderList.size();
	}

	@Test
	public void testSubmit() {
		/*
		 * add a new order and test that order list (createdin setup) is one larger than before the submit.
		 */
		orderId = orderSubsystem.submit(cart, custId);
		Assert.assertEquals("submit did not result in expected number of orders", numOfOrders+1, 
		orderSubsystem.getCustomerOrderList().size());
	}
	
	@Test
	public void testGetOrderTotal(){
		/* 
		 * test that total cost of a new order is same as the total cost of a submitted shopping cart
		 */
		Assert.assertEquals(cart.getCartCost(), orderSubsystem.getOrder(orderId).getTotalPrice(), DELTA_MARGIN);
		
	}
	
	
}
