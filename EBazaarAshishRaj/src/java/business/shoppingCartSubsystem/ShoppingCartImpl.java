package business.shoppingCartSubsystem;

import java.util.ArrayList;
import java.util.List;

import business.subsystemExternalInterfaces.Address;
import business.subsystemExternalInterfaces.CreditCard;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;

public class ShoppingCartImpl {
	
	/* list of all the line items for this cart */
	private List<ShoppingCartLineItem> cartLineItems = new ArrayList<ShoppingCartLineItem>();
	private Address defaultShipAdd;
	private Address defaultbillAdd;
	private CreditCard defaultPayment;
	
	
	public List<ShoppingCartLineItem> getCartLineItems() {
		return cartLineItems;
	}
	public void setCartLineItems(List<ShoppingCartLineItem> cartLineItems) {
		this.cartLineItems = cartLineItems;
	}
	public Address getDefaultbillAdd() {
		return defaultbillAdd;
	}
	public void setDefaultbillAdd(Address defaultbillAdd) {
		this.defaultbillAdd = defaultbillAdd;
	}
	public CreditCard getDefaultPayment() {
		return defaultPayment;
	}
	public void setDefaultPayment(CreditCard defaultPayment) {
		this.defaultPayment = defaultPayment;
	}
	public Address getDefaultShipAdd() {
		return defaultShipAdd;
	}
	public void setDefaultShipAdd(Address defaultShipAdd) {
		this.defaultShipAdd = defaultShipAdd;
	}
	public void addCartItem(Product prod, int quantity) {
		ShoppingCartLineItem cartItem = new ShoppingCartLineItemImpl(prod, quantity);
		cartLineItems.add(cartItem);
		
	}
	public double getTotalCartCost() {
		
		double totCost = 0; 
		for (ShoppingCartLineItem nextItem: cartLineItems){
			totCost = totCost + nextItem.getItemCost();
		}
		return totCost;
	}

}
