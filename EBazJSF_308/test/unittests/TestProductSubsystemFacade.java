package unittests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import business.productSubsystem.ProductSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;

/**
 * JUnit test class for the Product Subsystem. 
 * 
 * @author Stefan Minkov
 * @date May 23, 2007
 */
public class TestProductSubsystemFacade {
	
	private final String[] testCatalogNames = {"TestCat1","TestCat2","TestCat3"};
	@Test
	/*
	 * We test that function by creating a couple of new catalogs and
	 * trying to find them among the set of catalogs returned by te method call
	 */
	public void testGetCatalogNames() {
		ProductSubsystemFacade productSubsystem = new ProductSubsystemFacade();
		for(int i = 0; i < testCatalogNames.length; i++)
			productSubsystem.createCatalog(testCatalogNames[i]);
		
		List<String> catalogNames = productSubsystem.getCatalogNames();
		if (catalogNames == null)
			fail("GetCatalogNames failed--returned null");
		for(int i = 0; i < testCatalogNames.length; i++)
			assertTrue("GetCatalogNames failed",catalogNames.contains(testCatalogNames[i]));
	}

	@Test
	/* 
	 * We test the RetrieveCatalog() method by creating a new catalog and
	 * retrieving it back from the ProductSubsystem, and comparing its name with the expected name.
	 * 
	 * TODO Override equals() method in the Catalog class. 
	 */
	public void testRetrieveCatalog() {
		ProductSubsystemFacade productSubsystem = new ProductSubsystemFacade();
		//Catalog catalog = productSubsystem.createCatalog(testCatalogNames[0]);
		productSubsystem.createCatalog(testCatalogNames[0]);
		Catalog retrievedCatalog = productSubsystem.retrieveCatalog(testCatalogNames[0]);
		if (retrievedCatalog == null)
			fail("Cannot retrieve just created catalog");
		else
			assertTrue("RetrieveCatalog returned wrong catalog",testCatalogNames[0].equalsIgnoreCase(retrievedCatalog.getCatalogName()));
	}

	/**
	 * 
	 */
	@Test
	public void testCreateProduct() {
		/* create a couple products 
		 * TODO check if these products are really seved into the system..i.e. get them back 
		 * TODO redo/update the 
		 * Product, Catalog and ProductCatalogSubsystem
		 * interfaces. */
		ProductSubsystemFacade productSubsystem = new ProductSubsystemFacade();
		
		//Create new Catalog and insert 2 new Products
		Catalog catalog = productSubsystem.createCatalog(testCatalogNames[0]);
		Product prod1 = productSubsystem.createProduct("1stTstbook", 10, 100, "great", catalog);
		Product prod2 = productSubsystem.createProduct("2ndTstBook", 100, 1, "really great", catalog);
//		productSubsystem.createCatalog(testCatalogNames[0]);
//		Catalog createdCat = productSubsystem.retrieveCatalog(testCatalogNames[0]);
//		productSubsystem.createProduct("1stTstbook", 10, 100, "great", createdCat);
//		productSubsystem.createProduct("2ndTstBook", 100, 1, "really great", createdCat);
		
		//Check whether the products are put into the catalog
		List<Product> productList = catalog.getProductList();    //)productSubsystem.getCatalogProducts(catalog);
		if (productList == null)
			fail("The catalog does not contain the products that have been just added");
		else{
			assertTrue("CreateProduct failed",productList.contains(prod1));
			assertTrue("CreateProduct failed",productList.contains(prod2));
		}
		
	}
	@Test
	/*
	 * Test the deleteCatalog method.
	 */
	public void deleteCatalog() {
		ProductSubsystemFacade productSubsystem = new ProductSubsystemFacade();
		int catalogCount = 0;
		List<String> catalogNames = productSubsystem.getCatalogNames();
		if (catalogNames != null)
			catalogCount = catalogNames.size();
		for(int i = 0; i < testCatalogNames.length; i++){
			Catalog tmpCatalog = productSubsystem.createCatalog(testCatalogNames[i]);
			productSubsystem.deleteCatalog(tmpCatalog);
		}
		catalogNames = productSubsystem.getCatalogNames();
		if (catalogNames == null){
			if (catalogCount != 0) 
				fail("deleteCatalog failed");
		}
		else{
			assertEquals(catalogCount,catalogNames.size());
			for(int i = 0; i < testCatalogNames.length; i++){
				assertFalse(catalogNames.contains(testCatalogNames[i]));
			}
		}
	}
	

}
