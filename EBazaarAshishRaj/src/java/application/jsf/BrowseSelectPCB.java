/*
 * This is a Presentation Control Bean for the browse and select use case.  It
 * is intended to hold JSF action methods for the Browse and 
 * Select use case.
 * 
 * It will also hold fields accessed by the JSF pages.
 * 
 * @since 8/4/08 -- had to add the imports
 * @author levi
 */
package application.jsf;

import application.BrowseSelectController;
import business.productSubsystem.MPTestProductSubsystemFacade;
import business.subsystemExternalInterfaces.ProductSubsystem;
import business.subsystemExternalInterfaces.Product;
import business.subsystemExternalInterfaces.ShoppingCart;
import business.subsystemExternalInterfaces.ShoppingCartLineItem;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class BrowseSelectPCB implements Serializable {

    public BrowseSelectPCB() {
    }

    private static final int DEFAULT_ORDER_QUANTITY = 1;

    private ProductSubsystem stubProdSS = new MPTestProductSubsystemFacade();
    private BrowseSelectController bsController = new BrowseSelectController(stubProdSS);
    private String currentCatalogName = "";
    private String currentProductName = "";
    private int currentOrderQuantity = DEFAULT_ORDER_QUANTITY;

    public List<String> getCatalogNames() {
        
        return stubProdSS.getCatalogNames();
    }

    public String getCurrentCatalogName() {
        return currentCatalogName;
    }

    public void setCurrentCatalogName(String currentCatalogName) {
        this.currentCatalogName = currentCatalogName;
    }

    public List<Product> getProducts() {
        return bsController.getProducts(currentCatalogName);
    }

    public Product getCurrentProduct() {
        return bsController.getProduct(currentProductName);
    }

    public String getCurrentProductName() {
        return currentProductName;
    }

    public void setCurrentProductName(String currentProductName) {
        this.currentProductName = currentProductName;
    }

    public int getCurrentOrderQuantity() {
        return currentOrderQuantity;
    }

    public void setCurrentOrderQuantity(int currentOrderQuantity) {
        this.currentOrderQuantity = currentOrderQuantity;
    }

    public List<ShoppingCartLineItem> getShoppingCartItems() {
        return bsController.getShoppingCart().getCartItems();
    }

    /**
     * Action method for browsing catalog
     * @return navigation string to browseCatalog
     */
    public String browseCatalog() {
        return "browseCatalog?faces-redirect=true";
    }

    public String productDetails() {
        return "productDetails?faces-redirect=true";
    }

    public String orderProduct() {
        return "orderProduct?faces-redirect=true";
    }

    public String addProductToCart() {
        bsController.add2Cart(currentProductName, currentOrderQuantity);
        currentOrderQuantity = DEFAULT_ORDER_QUANTITY;
        return "shoppingCart?faces-redirect=true";
    }

    public String cancelProduct() {
        currentOrderQuantity = 0;
        return "availableProducts?faces-redirect=true";
    }

    public ShoppingCart getShoppingCart() {
        return bsController.getShoppingCart();
    }

}
