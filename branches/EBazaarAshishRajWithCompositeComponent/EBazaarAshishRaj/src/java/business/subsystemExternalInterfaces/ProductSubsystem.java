package business.subsystemExternalInterfaces;

import java.util.List;

import business.productSubsystem.ProductImpl;

public interface ProductSubsystem {

	public abstract List<String> getCatalogNames();

	public abstract Catalog retrieveCatalog(String catName);

	public abstract Product createProduct(String prodName, double price,
			int quantityInStock, String description, Catalog catalog);


	public abstract Catalog createCatalog(String catalogName);

	/* Delete the catalog from the subsystem.
	 * Also delete all the products contained within the catalog.
	 * Should return the success of the operation.
	 */
	public abstract boolean deleteCatalog(Catalog catalog);

	/* Retrieve all the products for a given catalog */
	public abstract List<Product> getCatalogProducts(Catalog catalog);

}