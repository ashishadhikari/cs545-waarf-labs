package business.subsystemExternalInterfaces;

import java.util.List;


public interface Catalog {

	/**
	 * 
	 * returns a product given the name of the product
	 */
	public abstract Product getProduct(String product2Get);

	/**
	 * returns the list of products in the catalog
	 * @return
	 */
	public abstract List<Product> getProductList();

	public String getCatalogName();

	public void setCatalogName(String catalogName);

	/**
	 * adds the input product to this catalog
	 * @param prod
	 */
	public abstract void addProduct(Product prod);

}