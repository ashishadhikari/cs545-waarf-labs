package application;

import java.util.ArrayList;
import java.util.List;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;


/**
 * @uml.dependency   supplier="business.Product"
 */
public class ManageProductsController {
	

	/**
	 * @uml.property  name="productSubsystem"
	 * @uml.associationEnd  inverse="ManageProductsController:business.subsystemExternalInterfaces.ProductSubsystem"
	 */
	private ProductSubsystem productSubsystem;	


	/**
	 * this constructor injects a product subsystem (facade)--e.g., dependency injection
	 * for use in testing the ManageProductsController
	 * @param facade
	 * @author levi
	 * @since sept 19 2007
	 */
	public ManageProductsController(ProductSubsystem prodSubsys) {
		productSubsystem = prodSubsys;
	}

	/**
	 */
	public void processSaveCommand() {

	}

	/**
	 */
	public List<String[]> getCatalogNames() {
		return null; 
	}

		
		/**
		 */
		public Catalog getCatalog(String catalogName){
			return productSubsystem.retrieveCatalog(catalogName);
		
		}


		
		/**
		 * returns a List of String[1], each holding a product name for the products in the input catalog
		 * @param catalogName
		 * @return
		 * TODO kl - refactor:  this is a copy of a method in the browse and select controller,
		 *   should put into the ProductSubsystem so is not duplicated
		 */
		public List<String[]> getProductNameArrays(String catalogName) {
			Catalog cat = productSubsystem.retrieveCatalog(catalogName);   
			System.out.println("cat is:" + cat);
			List<Product> prodList = cat.getProductList();  //productSubsystem.getCatalogProducts(cat);
			/* now make this into a List of String[] of the prod names */ 
			/* put each name into a string array, in a list */
			List<String[]> prodDisplayList = new ArrayList<String[]>();
			for (Product aProd: prodList) {
				String[] prodNameArray = new String[1];
				prodNameArray[0] = aProd.getProdName();
				prodDisplayList.add(prodNameArray);
			}		
			
	        //List<String[]> prods = DefaultData.getInstance().getProductCatalogChoices(catalogName);
			return prodDisplayList;
		}

}
