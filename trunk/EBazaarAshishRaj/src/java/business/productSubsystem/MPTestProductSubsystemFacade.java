package business.productSubsystem;

import java.util.ArrayList;
import java.util.List;

import business.subsystemExternalInterfaces.Catalog;
import business.subsystemExternalInterfaces.Product;

public class MPTestProductSubsystemFacade extends ProductSubsystemFacade {
	
	
		List<Product> productList;
		List<Catalog> catalogList;
		
		public static String BOOKS = "Books";
		public static String CLOTHES = "Clothes";

		public MPTestProductSubsystemFacade() {
			productList = new ArrayList<Product>();
			catalogList = new ArrayList<Catalog>();
			
			/**
			 * Dummay Data
			 */
			// TODO
			Catalog cat1 = createCatalog("BOOKS");
			Product prod1 = createProduct("GONE_WITH_THE_WIND",12.00,20,"A moving classic that tells a tale of love and a tale of courage.",cat1);
			Product prod2 = createProduct("MESSIAH_OF_DUNE",43.00,100,"You saw how good Dune was. This is Part 2 of this unforgettable trilogy.",cat1);
			Product prod3 = createProduct("GARDEN_OF_RAMA",52.00,30,"Highly acclaimed Book of Isaac Asimov. A real nail-biter.",cat1);
			
			Catalog cat2 = createCatalog("CLOTHES");
			Product prod4 = createProduct("PANTS",12.00,20,"I've seen the Grand Canyon. I've camped at Yellowstone. But nothing on earth compares to the glory of wearing these pants.", cat2);
			Product prod5 = createProduct("TSHIRTS",43.00,100,"Can be worn by men or women. Always in style.", cat2);
			Product prod6 = createProduct("SKIRTS",52.00,30,"Once this brand of skirts becomes well-known, watch out!", cat2);
			}
	

}
