package business.shoppingCartSubsystem;

import business.productSubsystem.ProductSubsystemFacade;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

/**
 * For now, am assuming that product names are unique.  Might need to refactor that later.
 * @author levi
 *
 */
public class ShoppingCartLineItemImpl implements ShoppingCartLineItem {
	private Product cartProduct;
	private int quantity;
	
	public ShoppingCartLineItemImpl(Product prod, int quantity) {
		super();
		cartProduct = prod;
		this.quantity = quantity;
	}



	public Product getCartProduct() {
		return cartProduct;
	}



	public void setCartProduct(Product cartProduct) {
		this.cartProduct = cartProduct;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getItemCost() {
		return quantity * cartProduct.getPrice();
	}
	
	
	

}
