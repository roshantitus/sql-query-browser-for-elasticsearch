/**
 * 
 */
package org.webplans.sqltools.sql2nosql.model;



/**
 * @author Roshan Titus
 *
 */
public interface Query {

	void accept(QueryVisitor queryVisitor);
	
}
