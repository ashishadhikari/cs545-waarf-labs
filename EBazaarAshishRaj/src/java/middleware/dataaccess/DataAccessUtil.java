
package middleware.dataaccess;

import java.sql.Connection;
import java.sql.ResultSet;
//import business.DbUrl;

import middleware.DatabaseException;

/**
 * @author pcorazza
 * @since Nov 10, 2004
 * Class Description:
 * 
 * 
 */
public class DataAccessUtil {
    //this method used when you use DbConnection instead of a connection pool
    public static Connection getConnection(String dbUrl) throws DatabaseException {
        return null;
        //DbConnection dbCon = new DbConnection();
        //dbCon.connect();
        //return dbCon;
        
        
    }
    public static ResultSet runQuery(String dbUrl, String query) throws DatabaseException {
        System.out.println("query = "+query);
        SimpleConnectionPool pool = 
            SimpleConnectionPool.getInstance(DataAccessSubsystemFacade.MAX_CONNECTIONS);
        Connection con = pool.getConnection(dbUrl);
        ResultSet rs = SimpleConnectionPool.doQuery(con,query);
        pool.returnToPool(con,dbUrl);
        return rs;
        
        //DbConnection dbCon = getConnection(dbUrl);
        //return dbCon.doQuery(query);
    }
    public static void runUpdate(String dbUrl, String query) throws DatabaseException {
        
        SimpleConnectionPool pool = 
            SimpleConnectionPool.getInstance(DataAccessSubsystemFacade.MAX_CONNECTIONS);
        Connection con = pool.getConnection(dbUrl);
        SimpleConnectionPool.doUpdate(con,query);  
        pool.returnToPool(con,dbUrl);
        
        
        
       
    }
    
    /// utilities for getting next id in various tables
    final static String custQuery =  "SELECT DISTINCT custid "+
	   								"FROM Customer ";
    final static String shopCartQuery  = "SELECT DISTINCT cartid "+
	   									"FROM ShopCartTbl ";
    final static String cartItemQuery =  "SELECT DISTINCT lineitemid "+
											"FROM ShopCartItems ";
    final static String orderQuery =  "SELECT DISTINCT orderid "+
											"FROM [Order] ";
    final static String orderItemQuery =  "SELECT DISTINCT lineitemid "+
    								"FROM OrderItem ";
    
   	final static String productIdQuery =  
   	    "SELECT DISTINCT productid "+
   	    "FROM Product ";	
    
   	private static String getNextId(String dburl, String theQuery, String idname) throws DatabaseException {
        SimpleConnectionPool pool = 
            SimpleConnectionPool.getInstance(DataAccessSubsystemFacade.MAX_CONNECTIONS);
        Connection con = pool.getConnection(dburl);
        ResultSet rs = SimpleConnectionPool.doQuery(con, theQuery);  
        pool.returnToPool(con,dburl);       		   
        Integer nextVal = null;
        Integer maxVal = new Integer(0);
        try {
            while(rs.next()){
                nextVal = new Integer(rs.getString(idname));
                if(nextVal.compareTo(maxVal) > 0){
                    maxVal = nextVal;
                }
            }
            
        }
        catch(Exception e){
            //do nothing
        }
        return succ(maxVal).toString();
   		
   	}
   	
    public static String getNextProductId(String theQuery, String idname) 
    													throws DatabaseException {
    		return getNextId(DbUrl.PRODUCT_DBURL, theQuery,idname);
    }	

 

    public static String getNextAvailProductId() throws DatabaseException {
    	    return getNextProductId(productIdQuery,"productid");
    }	

    
    public static String getNextAvailAccountId(String theQuery, String idname) throws DatabaseException {
    	return getNextId(DbUrl.ACCOUNT_DBURL, theQuery, idname);
    }
    public static String getNextAvailCartItemId() throws DatabaseException {
        return getNextAvailAccountId(cartItemQuery,"lineitemid");
    }
    public static String getNextAvailOrderId() throws DatabaseException{
        return getNextAvailAccountId(orderQuery,"orderid");
    }  
    public static String getNextAvailOrderItemId() throws DatabaseException{
        return getNextAvailAccountId(orderItemQuery,"lineitemid");
    }     
    public static String getNextAvailCustId() throws DatabaseException{
        return getNextAvailAccountId(custQuery,"custid");
    }

    public static String getNextAvailShopCartId() throws DatabaseException{
        return getNextAvailAccountId(shopCartQuery,"cartid");
        
    }
    public static void main(String[] args){
        try {
        System.out.println(getNextAvailCustId());
        System.out.println(getNextAvailShopCartId());
        System.out.println(getNextAvailCartItemId());
        System.out.println(getNextAvailOrderId());
        System.out.println(getNextAvailOrderItemId());
        System.out.println(getNextAvailProductId());
        }
        catch(DatabaseException e){}
    }
    
    public static Integer succ(Integer integer){
        return new Integer(integer.intValue()+1);
    }
    
    public static String succ(String integerString){
        Integer successor = succ(new Integer(integerString));
        return successor.toString();
    }
}
