package unittests;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import application.BrowseSelectController;
import business.productSubsystem.ProductSubsystemFacade;
import business.shoppingCartSubsystem.ShoppingCartSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

public class TestBrowseSelectController {

	BrowseSelectController bsc;
	ShoppingCart shopCart = new ShoppingCartSubsystemFacade();
	
	private final static int NUMBER_CATALOGS = 2;
	private final static int NUMBER_BOOKS = 2;
	private List<String> catalogNames = new ArrayList();
	private List<String> productNames = new ArrayList();
	private String testCatName = "Books";
	private String testProdName = "Tom Soyer";
	private Catalog bookCat = null;
	Product prod1 = null;
	Product prod2 = null;
	Product prod3 = null;
	Product prod4 = null;

	@Before
	public void setUp() throws Exception {
		
		ProductSubsystem productSF = new ProductSubsystemFacade();	
		catalogNames.add(testCatName);
		catalogNames.add("Clothes");
		productNames.add("Harry Porter");
		productNames.add("Tom Soyer");
		productNames.add("T-Shirt");
		productNames.add("Pant");		
		
		
		bookCat = productSF.createCatalog(testCatName);		
		
		prod1 = productSF.createProduct("Harry Porter", 10, 5, "None", bookCat);
		prod2 = productSF.createProduct(testProdName, 20, 15, "None", bookCat);
		
		Catalog clothesCat = productSF.createCatalog("Clothes");		
		
		prod3 = productSF.createProduct("T-Shirt", 11, 12, "None", clothesCat);
		prod4 = productSF.createProduct("Pant", 20, 15, "None", clothesCat);
		
		bsc = new BrowseSelectController(productSF);
		
		buildShoppingCart();
		bsc.setShoppingCart(shopCart);

	}
	
	/*
	 * create and put a few cart line items in the shopping cart
	 */
	private void buildShoppingCart() {
		shopCart.addCartItem(prod1, 1);
		shopCart.addCartItem(prod3, 2);		
	}
        
        @Test
        /**
         * Tests for whether the expected number of catalog names are returned and first one is correct
         */
        public void testGetCatalogNames() {
            List<String> catNames = bsc.getCatalogNames();
            Assert.assertEquals("Wrong number cat names", NUMBER_CATALOGS, catNames.size());
            String firstName = (String)catNames.get(0);
            Assert.assertTrue(firstName.equals("Books"));
        }
        
        @Test
        /**
         * Tests for whether the expected number of  products are returned and first one has correct name
         */
        public void testGetProducts() { 
            List<Product> prods = bsc.getProducts("Books");
            Assert.assertEquals("Wrong number products", 2, prods.size());
            String firstProdName = ((Product)prods.get(0)).getProdName();
            Assert.assertTrue(firstProdName.equals("Harry Porter"));   
            
        }       

	@Test
	public void testGetProductNameList() {  
		/*
		 * See if a list comes back with the right number of elements,
		 * and check for at least one expected element.
		 * --dependency injection for the ProductSubsystem?
		 */
		List<String[]> nameArrayList = bsc.getProductNameStringArrays("Books");
		Assert.assertEquals("Wrong number product names returned", NUMBER_BOOKS, nameArrayList.size() );
		String[] firstArray = nameArrayList.get(1);
		String firstName = firstArray[0];
		boolean found = false;
		for (String nextName: productNames){
			if (firstName.equals(nextName)) {
				found = true;
			}
		}
		Assert.assertTrue("did not find product name", found);
	}

	@Test
	public void testAdd2Cart() {
		/*
		 * have the controller add another  to the cart,
		 *  and see if it comes back in the cart items list
		 */
		List<ShoppingCartLineItem> beforeItems = shopCart.getCartItems();
		Assert.assertEquals("Cart did not have expected initial items", 2, beforeItems.size());
		bsc.setCat2Browse(bookCat);  //need to insert proper catalog into controller so can get product from name
		bsc.add2Cart(testProdName, 100);
		List<ShoppingCartLineItem> afterItems = shopCart.getCartItems();
		Assert.assertEquals("New cart item not added", 3, afterItems.size());
		/* TODO should check to see if new product is really in the list */
	}
	
	/* should test for adding same product multiple times, adding more than are in stock etc */

	@Test
	public void testValidateQuantity() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCatalogNamesList() {
		/*
		 * See if a list comes back with the right number of elements,
		 * and check for at least one expected element.
		 */
		List<String[]> nameArrayList = bsc.getCatalogNamesStringArray();
		Assert.assertEquals("Wrong number catalog names returned", NUMBER_CATALOGS, nameArrayList.size() );
		String[] firstArray = nameArrayList.get(1);
		String firstName = firstArray[0];
		boolean found = false;
		for (String nextName: catalogNames){
			if (firstName.equals(nextName)) {
				found = true;
			}
		}
		Assert.assertTrue("did not find catalog name", found);
		//System.out.println(firstName + " :  firstName");
		//System.out.println(catalogNames);
		//Assert.assertTrue("did not find expected catalog name", catalogNames.contains(firstArray));
	}

	@Test
	public void testGetProductDetails() {
		/* request a product from a catalog given a product name */
		Product retrievedProd = bookCat.getProduct(testProdName);
		String prodName = retrievedProd.getProdName();
		Assert.assertEquals("Did not get expected product." , testProdName, prodName);
	}

	@Test
	public void testGetCartDisplayList() {
		/*
		 * check that the number returned is one greater than the number of items in the
		 * cart, and that the last item in the list has a first element equal to "Total"
		 */
		
		List<String[]> cartDisplayList = bsc.getCartDisplayList();
		int numCartItems = shopCart.getCartItems().size();
		System.out.println("numitems: " + numCartItems);
		Assert.assertEquals(numCartItems + 1, cartDisplayList.size());
		
		String[] lastRow = cartDisplayList.get(cartDisplayList.size()-1);
		System.out.println("lastrow is: " + lastRow[0] + " " +lastRow[1]);
		Assert.assertTrue(lastRow[0].equalsIgnoreCase("Total"));


	}

}
