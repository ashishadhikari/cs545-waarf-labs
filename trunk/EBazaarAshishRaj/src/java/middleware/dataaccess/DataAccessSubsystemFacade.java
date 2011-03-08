
package middleware.dataaccess;

import middleware.DatabaseException;
import middleware.externalinterfaces.Cleanup;
import middleware.externalinterfaces.IDataAccessSubsystem;
import middleware.externalinterfaces.IDbClass;

/**
 * @author pcorazza
 * @since Nov 10, 2004
 * Class Description:
 * 
 * 
 */
public class DataAccessSubsystemFacade implements IDataAccessSubsystem {
    public static final int MAX_CONNECTIONS = 4;

    public void read(IDbClass dbClass) throws DatabaseException {
        if(dbClass != null){
            DbAction dbAction = new DbAction(dbClass);
            dbAction.performRead();
        }

    }
	public void releaseConnections(Cleanup c){
        SimpleConnectionPool pool = SimpleConnectionPool.getInstance(c);
        if(pool != null) pool.releaseConnections();
		
	}

    public void save(IDbClass dbClass) throws DatabaseException  {
        if(dbClass != null){
            DbAction dbAction = new DbAction(dbClass);
            dbAction.performUpdate();
        }
        

    }

    public void delete(IDbClass dbClass) throws DatabaseException  {
        if(dbClass != null){
            DbAction dbAction = new DbAction(dbClass);
            dbAction.performUpdate();
        }
        

    }

}
