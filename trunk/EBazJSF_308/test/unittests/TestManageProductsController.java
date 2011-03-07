/**
 * 
 */
package unittests;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import application.ManageProductsController;
import business.productSubsystem.MPTestProductSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.ProductSubsystem;

/**
 * @author apoudyal;  refactored by kl
 * This class has test cases for a few operations on the manage products controller.  There 
 * should be additional test cases for adding, editing, saving products.
 * @since 19 Sept 2007
 */
public class TestManageProductsController {
	ManageProductsController manageController; 
	ProductSubsystem mpTestProdSubsystem = new MPTestProductSubsystemFacade();
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		/* dependency injection of the mock subsystem into the controller to support testing */
		manageController = new ManageProductsController(mpTestProdSubsystem);
	}

	/**
	 * Test method for {@link application.ManageProductsController#getCatalogNames()}.
	 */
	@Test
	public void testGetCatalogNames() {
		
		List<String[]> catNameArrayList = manageController.getCatalogNames();
		Assert.assertEquals("GetCatalogNames failed",2, catNameArrayList.size());
		Assert.assertEquals("GetCatalogNames failed",catNameArrayList.get(0)[0], "BOOKS");
		Assert.assertTrue("GetCatalogNames failed", catNameArrayList.get(1)[0].contains("CLOTHES"));
	}

	/**
	 * Test method for {@link application.ManageProductsController#getProductCatalogChoices(java.lang.String)}.
	 */
	@Test
	public void testGetProductNameArrays() {
		//ManageProductsController manageController = new ManageProductsController();
		List<String[]> aProductList = manageController.getProductNameArrays("BOOKS"); //getProductCatalogChoices("BOOKS");
		Assert.assertTrue("GetProductCataogChoices Fail", aProductList.get(0)[0].contains("GONE_WITH_THE_WIND"));
		Assert.assertTrue("GetProductCataogChoices Fail", aProductList.get(0)[0].contains("GONE_WITH_THE_WIND"));
	}

	/**
	 * Test method for {@link application.ManageProductsController#getCatalog(java.lang.String)}.
	 */
	@Test
	public void testGetCatalog() {
		//ManageProductsController manageController = new ManageProductsController();
		Catalog catalog = manageController.getCatalog("BOOKS");
		System.out.println("catalog is: " + catalog);
		Assert.assertTrue("GetProductCataogChoices Fail", catalog.getCatalogName().equalsIgnoreCase("BOOKS"));
	}
	
	/* need tests of operations for adding and editing and deleting products */

}
