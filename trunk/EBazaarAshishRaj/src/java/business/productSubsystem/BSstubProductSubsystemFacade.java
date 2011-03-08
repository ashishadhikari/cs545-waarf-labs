package business.productSubsystem;

//import org.junit.Test;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;

public class BSstubProductSubsystemFacade extends ProductSubsystemFacade {
	
	private final String[] testCatalogNames = {"Books","Clothes","TestCat3"};
	private Catalog books;
	private Catalog clothes;
	private Catalog testcat3;


	public BSstubProductSubsystemFacade() {
		/* create dummy catalogs */
		createCatalog("Books");		
		createCatalog("Clothes");		
		createCatalog("TestCat3");		
	
	createProduct("1stTstbook", 10, 100, "great", retrieveCatalog("Books"));
	createProduct("2ndTstBook", 100, 1, "really great", retrieveCatalog("Books"));
	}


}
