package business.subsystemExternalInterfaces;

public interface Customer {
	
	public CreditCard getDefaultCreditCard();
	public String getCustName();
	public void setCustName(String name);
	public Address getDefaultBillAddress();
	public void setDefaultBillAddress(Address add);
	public Address getDefaultShippingAddress();
	public void setDefaultShippingAddress(Address add);
	public ShoppingCart getShoppingCart();
	public void setShoppingCart(ShoppingCart cart);
	public String getCustId();


}