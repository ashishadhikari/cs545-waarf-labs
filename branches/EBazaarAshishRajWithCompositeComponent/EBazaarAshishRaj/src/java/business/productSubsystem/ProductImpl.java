package business.productSubsystem;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;




public class ProductImpl implements Product  {
	/**
	 * @uml.property  name="prodName"
	 */
	private String prodName;
	/**
	 * @uml.property  name="price"
	 */
	private double price;
	/**
	 * @uml.property  name="quantityInStock"
	 */
	private int quantityInStock;
	/**
	 * @uml.property  name="description"
	 */
	private String description;
	/** 
	 * @uml.property name="catalog"
	 * @uml.associationEnd multiplicity="(1 1)" inverse="productList:business.Catalog"
	 */
	private Catalog catalog;
	
	
	public ProductImpl(String prodName, double price, int quantityInStock, String description, Catalog catalog) {
		super();
		this.prodName = prodName;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.description = description;
		this.catalog = catalog;
	}
	/* (non-Javadoc)
	 * @see business.productSubsystem.Product#getDescription()
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description  the description to set
	 * @uml.property  name="description"
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/* (non-Javadoc)
	 * @see business.productSubsystem.Product#getPrice()
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price  the price to set
	 * @uml.property  name="price"
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/* (non-Javadoc)
	 * @see business.productSubsystem.Product#getProdName()
	 */
	public String getProdName() {
		return prodName;
	}
	/**
	 * @param prodName  the prodName to set
	 * @uml.property  name="prodName"
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	/* (non-Javadoc)
	 * @see business.productSubsystem.Product#getQuantityInStock()
	 */
	public int getQuantityInStock() {
		return quantityInStock;
	}
	/**
	 * @param quantityInStock  the quantityInStock to set
	 * @uml.property  name="quantityInStock"
	 */
	public void setQuantityInStock(int quantityInStock) {
		this.quantityInStock = quantityInStock;
	}
	  

}
