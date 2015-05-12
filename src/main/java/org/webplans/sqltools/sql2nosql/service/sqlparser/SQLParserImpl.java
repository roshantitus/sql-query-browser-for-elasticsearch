/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service.sqlparser;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;

import org.springframework.stereotype.Component;
import org.webplans.sqltools.sql2nosql.exception.SQLParseException;
import org.webplans.sqltools.sql2nosql.model.DefaultQuery;
import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
@Component
public class SQLParserImpl implements SQLParser {
	
	public Query parse(String queryString) throws SQLParseException {
		Query query = null;
		try
		{
			Statement stmnt = CCJSqlParserUtil.parse(queryString);
			query = new DefaultQuery(stmnt);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw new SQLParseException("Error parsing the queryString", exception);
		}
		return query;
	}

}
