package business.productSubsystem;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Have started some implementation on this in order to get the testGetCatalogNames operation
 * to work.
 * @author levi
 *
 */
public class ProductSubsystemFacade implements ProductSubsystem {

	public static final String CLOTHES = "Clothes";
	public static final String BOOKS = "Books";
	
	/** 
	 * @uml.property name="catalogsInSystem"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="composite"
	 */
	private List<Catalog> catalogsInSystem = new ArrayList<Catalog>(); 

	/**
	 * returns a list of Strings of names of all catalogs in the system
	 */
	public List<String> getCatalogNames() {
		List<String> names = new ArrayList<String>();
		for (Catalog nextCat:catalogsInSystem){
			names.add(nextCat.getCatalogName());
		}
		return names;
	}

	/**
	 * returns a catalog containing products corresponding to catName
	 */
	public Catalog retrieveCatalog(String catName) {
		Catalog foundCat = null;
		/* look in the catalogsInSystem for it first and return from there if found */
		for (Catalog nextCatalog: catalogsInSystem) {
			if (catName.equalsIgnoreCase(nextCatalog.getCatalogName())) {
				foundCat = nextCatalog;
				}
		}
		/* else look in the persistency store and return from there if found */

		/* else throw an exception */

		return foundCat;
		
	}
	
	/** 
	 * create a product and add it to the given catalog 
	 *  returns created product, which is convenient for testing purposes.
	 */
	public Product createProduct(String prodName, double price, int quantityInStock, String description, Catalog catalog) {
		Product prod = new ProductImpl(prodName, price, quantityInStock, description, catalog);
		catalog.addProduct(prod);
		return prod;
	}

	/**
	 * create a catalog and add it to the list of catalogs
	 * returns created catalog, which is convenient for testing purposes.
	 */
	public Catalog createCatalog(String catalogName) {
		Catalog newCatalog = new CatalogImpl(catalogName);
		catalogsInSystem.add(newCatalog);
		return newCatalog;
	}
	
	
	public List<Product> getCatalogProducts(Catalog catalog) {
		// TODO Auto-generated method stub
		return catalog.getProductList();
	}

	public boolean deleteCatalog(Catalog catalog) {
		// TODO Auto-generated method stub
		return false;
	}



}
