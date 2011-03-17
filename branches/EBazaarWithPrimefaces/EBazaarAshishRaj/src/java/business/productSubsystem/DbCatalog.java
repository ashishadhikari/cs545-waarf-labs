package business.productSubsystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import middleware.DatabaseException;
import middleware.dataaccess.DataAccessSubsystemFacade;
import middleware.externalinterfaces.IDataAccessSubsystem;
import middleware.externalinterfaces.IDbClass;
import application.gui.CatalogListWindow;

/**
 * 
 * @author levi
 *
 */
public class DbCatalog implements IDbClass {

	/* queryType, query, and dataAccess needed for all shadow classes */
    private String queryType;  //set by target-query-method inside shadow class
    private String query;	//set by local method, called by DAO
    private IDataAccessSubsystem dataAccess;
    
    private int catId = -99;  //used as parameter in queries--i.e., get products from catalog
    
    /* fields to hold returned objects or datastructures from reads--clients need to know getters for these */
	List<String[]> catalogNameDisplayList = new ArrayList<String[]>();
	List<String[]> productListFromCatalog = new ArrayList<String[]>();

    
    private final String SAVE = "Save";
    private final String READCATALOGNAMES = "ReadCatalogNames";
    private final String READPRODUCTS = "ReadProductsFromCatalog";
    
	public DbCatalog() {
		super();		
	}

	/**
	 *  Called by DAO when we read from the database.
     *  You need to add clause logic for calling each query.
	 */
	public void buildQuery() {
		if (queryType.equals(READCATALOGNAMES)) {
			buildNameDisplayQuery();
		}
		else if (queryType.equals(READPRODUCTS)) {
			buildGetProductsQuery();
		}
	}

	
	/**
	 * You need to write one of these for each query.
	 *
	 */
	private void buildNameDisplayQuery(){
		query = "SELECT * FROM CatalogType";
	}
	
	private void buildGetProductsQuery() {
		query = "SELECT productname, productid FROM Product "
		+ "WHERE catalogid ='" + catId + "';" ;
	}


    /**
     *  Called by DAO when we read from the database.
     *  You need to add clause logic for calling each query.  (should be refactored)
     */
    public void populateEntity(ResultSet rs) throws DatabaseException {
        if(queryType.equals(READCATALOGNAMES)){
            populateCatalogData(rs);
        }
        else if(queryType.equals(READPRODUCTS)){
            populateProductsForCatalog(rs);
        }
		//else if(queryType.equals(READ_CUST_NAME)){
          //     			while(rs.next()){

		//}
  }
    
    /**
     * Builds a list of string arrays of the names of the catalogs, which can be used as input
     * to the update methods of the CatalogListWindow.  You need to write one of these for
     * each read query.
     * @see CatalogListWindow
     * @since 18 May 2006
     * @author levi
     * @param rs
     * @throws DatabaseException
     */
	private void populateCatalogData(ResultSet rs) throws DatabaseException {
        try {
        	while(rs.next()){

    				String id = rs.getString("catalogid");
    				String name = rs.getString("catalogname");
    				System.out.println("id: "+ id + " name: "+name);
    				catalogNameDisplayList.add(new String[]{name});                                        
            }
        }
        catch(SQLException e) {
            throw new DatabaseException(e);
        }    
    }    
	
    /**
     * Builds a list of string arrays of the names of the catalogs, which can be used as input
     * to the update methods of the CatalogListWindow.  You need to write one of these for
     * each read query.
     * @see CatalogListWindow
     * @since 18 May 2006
     * @author levi
     * @param rs
     * @throws DatabaseException
     */
	private void populateProductsForCatalog(ResultSet rs) throws DatabaseException {
        try {
        	while(rs.next()){

        		 	String id = rs.getString("productid");
        			String name = rs.getString("productname");
        			System.out.println("id: "+ id + " name: "+name);
        			productListFromCatalog.add(new String[]{name});                                       
            }
        }
        catch(SQLException e) {
            throw new DatabaseException(e);
        }    
    }   	
	//
	/*
	 * 


	 */
	
	/**
	 * Used by DAO.  You need to enter the return value
	 */
	public String getDbUrl() {
		return "jdbc:odbc:EbazProducts";
	}

	/**
	 * Used by DAO.
	 */
	public String getQuery() {
		return query;
	}

	//getter used by clients to retrieve built objects
	public List<String[]> getCatalogNameDisplayList() {
		return catalogNameDisplayList;
	}
	
	public List<String[]> getProductListFromCatalog() {
		return productListFromCatalog;
	}	


	/* write a public target-query-method that clients will call for each desired query */
    public void readCatalogNames() throws DatabaseException {
        queryType=READCATALOGNAMES;
        dataAccess = new DataAccessSubsystemFacade();
        dataAccess.read(this);   
    }
    
	/* write a public target-query-method that clients will call for each desired query */
    public void readProductsForCatalog() throws DatabaseException {
        queryType=READPRODUCTS;
        dataAccess = new DataAccessSubsystemFacade();
        dataAccess.read(this);   
    }    

    /**
     * setter
     * @param catId
     */
	public void setCatId(int catId) {
		this.catId = catId;
		
	}


}
