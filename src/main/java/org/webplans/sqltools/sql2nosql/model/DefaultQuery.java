/**
 * 
 */
package org.webplans.sqltools.sql2nosql.model;

import net.sf.jsqlparser.statement.Statement;

/**
 * @author Roshan Titus
 *
 */
public class DefaultQuery implements Query {

	private Statement statement;
	
	public DefaultQuery(Statement stmnt) {
		this.statement = stmnt;
	}

	@Override
	public void accept(QueryVisitor queryVisitor) {
		queryVisitor.visit(statement);
		
	}

}
