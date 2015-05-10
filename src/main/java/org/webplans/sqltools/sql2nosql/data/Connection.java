/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

import org.webplans.sqltools.sql2nosql.data.exception.ConnectionException;
import org.webplans.sqltools.sql2nosql.data.exception.DataAccessException;
import org.webplans.sqltools.sql2nosql.data.exception.QueryException;
import org.webplans.sqltools.sql2nosql.data.exception.ResultException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public interface Connection {

	String buildQuery(Query queryObject) throws QueryException;

	Object executeQuery(String query) throws DataAccessException;

	void close() throws ConnectionException;

	Result processResult(Object resultset) throws ResultException;

}
