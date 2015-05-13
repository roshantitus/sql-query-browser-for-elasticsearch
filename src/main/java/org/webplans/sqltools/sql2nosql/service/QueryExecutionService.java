/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import java.util.List;

import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
public interface QueryExecutionService {

	Result executeAgainstDatasource(Query queryObject, DataSourceConnectionParameters dataSourceConnectionParameters);

	/**
	 * @param dataSourceConnectionParameters 
	 * @return
	 */
	List<String> fetchIndices(DataSourceConnectionParameters dataSourceConnectionParameters);

}
