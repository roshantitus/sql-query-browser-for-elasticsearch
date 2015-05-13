/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

import java.util.List;

import org.webplans.sqltools.sql2nosql.exception.ConnectionException;
import org.webplans.sqltools.sql2nosql.exception.QueryException;
import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
public interface Connection {
	
	Statement buildStatement(Query queryObject) throws QueryException;

	void close() throws ConnectionException;

	/**
	 * @return
	 */
	List<String> fetchIndices();

}
