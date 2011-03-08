package business.subsystemExternalInterfaces;

public interface Product {

	/**
	 * @return  the description
	 * @uml.property  name="description"
	 */
	public abstract String getDescription();

	/**
	 * @return  the price
	 * @uml.property  name="price"
	 */
	public abstract double getPrice();

	/**
	 * @return  the prodName
	 * @uml.property  name="prodName"
	 */
	public abstract String getProdName();

	/**
	 * @return  the quantityInStock
	 * @uml.property  name="quantityInStock"
	 */
	public abstract int getQuantityInStock();

}