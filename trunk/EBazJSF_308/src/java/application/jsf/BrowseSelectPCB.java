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



public class BrowseSelectPCB {
    ProductSubsystem stubProdSS = new MPTestProductSubsystemFacade();

    BrowseSelectController bsController = new BrowseSelectController(stubProdSS);


}

