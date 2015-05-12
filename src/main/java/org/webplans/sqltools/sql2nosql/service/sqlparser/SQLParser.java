/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service.sqlparser;

import org.webplans.sqltools.sql2nosql.exception.SQLParseException;
import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
public interface SQLParser {

	Query parse(String queryString) throws SQLParseException ;

}
