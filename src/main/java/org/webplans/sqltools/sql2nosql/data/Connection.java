/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

import org.webplans.sqltools.sql2nosql.data.exception.ConnectionException;
import org.webplans.sqltools.sql2nosql.data.exception.QueryException;
import org.webplans.sqltools.sql2nosql.data.exception.ResultException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public interface Connection {
	
	Statement buildStatement(Query queryObject) throws QueryException;

	void close() throws ConnectionException;

	Result processResponse() throws ResultException;

}
