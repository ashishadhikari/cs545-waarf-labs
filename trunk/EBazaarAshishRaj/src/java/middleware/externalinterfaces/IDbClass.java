
package middleware.externalinterfaces;

import java.sql.ResultSet;

import middleware.DatabaseException;

/** All concrete dbclasses implement this interface */
public interface IDbClass {
    public void buildQuery();
    public void populateEntity(ResultSet resultSet) throws DatabaseException ;
    public String getDbUrl();
    public String getQuery();
}
