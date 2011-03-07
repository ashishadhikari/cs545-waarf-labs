package business.productSubsystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;


public class CatalogImpl implements Catalog {
	private String catalogName;
	/** 
	 * @uml.property name="productList"
	 * @uml.associationEnd multiplicity="(1 -1)" aggregation="shared" inverse="catalog:business.Product"
	 */
	private List<Product> productList = new java.util.ArrayList();

		
		public CatalogImpl(String catName) {
			this.catalogName = catName;
		// TODO Auto-generated constructor stub
	}

		/**
		 * finds product in the product list with the given name and returns it.
		 * TODO kl refactor:  should throw an exception if not found
		 * @see business.productSubsystem.Catalog#getProduct(java.lang.String)
		 */
		public Product getProduct(String product2Get){
			Product foundProd = null;
			
			for (Product nextProd: productList) {
				if (nextProd.getProdName().equals(product2Get))
					foundProd = nextProd;
			}
			if (foundProd==null){
				System.out.println("No such product--should throw exception here");
			}
			return foundProd;
		
		}



		/**
		 * field getter
		 */
		public List<Product> getProductList() {
			return productList;
		}

		public String getCatalogName() {
			return catalogName;
		}

		public void setCatalogName(String catalogName) {
			this.catalogName = catalogName;
		}

		public void addProduct(Product prod) {
			productList.add(prod);
			
		}

}
