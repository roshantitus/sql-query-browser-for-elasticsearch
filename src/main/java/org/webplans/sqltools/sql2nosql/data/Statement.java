/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

import org.webplans.sqltools.sql2nosql.data.exception.DataAccessException;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public interface Statement {

	Result execute() throws DataAccessException;

}
