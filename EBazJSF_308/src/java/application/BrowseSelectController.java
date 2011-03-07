package application;


import business.shoppingCartSubsystem.ShoppingCartSubsystemFacade;
import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

import java.util.ArrayList;
import java.util.List;

//import unittests.TestBrowseSelectController;

public class BrowseSelectController {

	/**
	 * @uml.property  name="productSubsystem"
	 * @uml.associationEnd  inverse="browseSelectController:business.subsystemExternalInterfaces.ProductSubsystem"
	 */
	private ProductSubsystem productSubsystem = null;
	

	Catalog cat2Browse = null;  //catalog being browsed
  
	/**
	 * @uml.property  name="shoppingCart"
	 * @uml.associationEnd  readOnly="true"
	 */
	private ShoppingCart shoppingCart;  //cart being used

	
	
	public BrowseSelectController() {
	}
	
        /**
         * Constructor supporting "constructor" dependency injection of the product subsystem.
         * @param prodSS
         */
	public BrowseSelectController(ProductSubsystem prodSS) {
		productSubsystem = prodSS;
		
	}	

        
	/**
	 * given a catalog name, it returns a list of products
	 * @return TODO
	 */
	public List<Product> getProducts(String catalogName) {      
		cat2Browse = productSubsystem.retrieveCatalog(catalogName);  //assumes productSubsystem was set in getting catalog names list -- refactor 
		return cat2Browse.getProductList();  //productSubsystem.getCatalogProducts(cat);
	}
        
        
	/**
	 * given a catalog name, it returns a list of product names, each enclosed in a one element array
	 * Originally written for use by the Product Display Window
	 * @return TODO
	 */
	public List<String[]> getProductNameStringArrays(String catalogName) {
        
		cat2Browse = productSubsystem.retrieveCatalog(catalogName);  //assumes productSubsystem was set in getting catalog names list -- refactor 
		List<Product> prodList = cat2Browse.getProductList();  //productSubsystem.getCatalogProducts(cat);
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


	/**
	 * retrieve a product object with the given name and add to the cart
	 * @param quantity 
	 * @param prodName 
	 */
	public void add2Cart(String prodName, int quant) {
		Product prod = cat2Browse.getProduct(prodName);
		
		if (shoppingCart == null) {
			/* create a shopping cart */
			shoppingCart = new ShoppingCartSubsystemFacade();
		}
		shoppingCart.addCartItem(prod, quant);

	}

	/**
	 */
	public void validateQuantity() {

	}


	/**
	 * 
	 * Returns the list of all catalog names.
	 */
	public List<String> getCatalogNames(){
	
		//productSubsystem = new BSstubProductSubsystemFacade(); //TODO KL remove this -- it is only temporary for getting this step to work
		return productSubsystem.getCatalogNames(); //get names from catalog		
	}
	
	/**
	 * 
	 * Returns the list of all catalog names in the system as a list of string arrays.  Each array
	 * contains a single catalog name.
	 */
	public List<String[]> getCatalogNamesStringArray(){
	
		//productSubsystem = new BSstubProductSubsystemFacade(); //TODO KL remove this -- it is only temporary for getting this step to work
		List<String> catalogNames = productSubsystem.getCatalogNames(); //get names from catalog
		
		/* put each name into a string array, in a list */
		List<String[]> nameDisplayList = new ArrayList<String[]>();
		for (String aName: catalogNames) {
			String[] nextName = new String[1];
			nextName[0] = aName;
			nameDisplayList.add(nextName);
		}
		return nameDisplayList;
	}
	

	/**
	 * Creates a String array of product parameters from a Product
	 */
	public String[] getProductParameters(String prodName){
		
		Product prod = cat2Browse.getProduct(prodName);
		int numParams = 4; //size of array for holding prod fields
		String[] prodParams = new String[numParams];
		
		/* need an array holding prod name, price, quantity, description */
		prodParams[0] = prod.getProdName();
		prodParams[1] = new Double(prod.getPrice()).toString();
		prodParams[2] = new Integer(prod.getQuantityInStock()).toString();
		prodParams[3] = prod.getDescription();
	
		
		return prodParams;
	}
	
	
	
	/**
	 * Returns a List of shopping cart info that has a Total of the shopping cart cost as the last element
	 * in the list.  The List is structured for easy display in Ebazaar app.
	 */
	public List<String[]> getCartDisplayList(){
		int numItemParams = 4;
		List<String[]> displayList = new ArrayList<String[]>();
		List<ShoppingCartLineItem> cartItems = shoppingCart.getCartItems();
		
		for (ShoppingCartLineItem nextCartItem: cartItems) {
			String[] cartParams = new String[numItemParams];
			Product prod = nextCartItem.getCartProduct();
			cartParams[0] = prod.getProdName();
			cartParams[1] = new Integer(nextCartItem.getQuantity()).toString();
			cartParams[2] = new Double(prod.getPrice()).toString();
			cartParams[3] = new Double(prod.getPrice() * nextCartItem.getQuantity()).toString();
			displayList.add(cartParams);
		}
		String[] totalLine = new String[numItemParams];
		totalLine[0] = "Total";
		totalLine[1] = " ";
		totalLine[2] = " ";
		totalLine[3] = new Double(shoppingCart.getCartCost()).toString();
		displayList.add(totalLine);
		return displayList;
	}
        
        /**
         * returns the current shopping cart being used in the browse and select use case
         * @param shopCart
         */
        public ShoppingCart getShoppingCart() {
            return shoppingCart;
        }

	public void setShoppingCart(ShoppingCart shopCart) {
		shoppingCart = shopCart;
		
	}

	/**
	 * This setter needed for dependency injection in unit testing
	 * @see  TestBrowseSelectController testAdd2Cart
	 * @param cat2Browse
	 *
	 */
	public void setCat2Browse(Catalog cat2Browse) {
		this.cat2Browse = cat2Browse;
	}

	public Product getProduct(String prodName) {
		// TODO Auto-generated method stub
		return cat2Browse.getProduct(prodName);
	}





}
