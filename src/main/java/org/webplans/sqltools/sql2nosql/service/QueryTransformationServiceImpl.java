/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.service.sqlparser.SQLParser;

/**
 * @author Roshan Titus
 *
 */
@Service
public class QueryTransformationServiceImpl implements
		QueryTransformationService {

	@Autowired
	private SQLParser sqlParser;
	
	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.service.QueryTransformationService#transformQueryStringToObjectHeirarchy(java.lang.String)
	 */
	@Override
	public Query transformQueryStringToObjectHeirarchy(String queryString) {
		return sqlParser.parse(queryString);
	}

}
