/**
 * 
 */
package org.webplans.sqltools.sql2nosql.model;

import net.sf.jsqlparser.statement.Statement;

/**
 * @author Roshan Titus
 *
 */
public interface QueryVisitor {

	void visit(Statement statement);
}
