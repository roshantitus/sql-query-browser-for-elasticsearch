/**
 * 
 */
package org.webplans.sqltools.sql2nosql.model;

import net.sf.jsqlparser.statement.StatementVisitorAdapter;

/**
 * @author Roshan Titus
 *
 */
public interface Query {

	void accept(QueryVisitorAdapter queryVisitorAdapter);
}
