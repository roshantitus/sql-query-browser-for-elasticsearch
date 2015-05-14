/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import java.util.List;
import java.util.Map;

import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
public interface QueryService {

	Result executeQuery(String queryString,
			DataSourceConnectionParameters dataSourceConnectionParameters);

	List<String> getAllIndices(DataSourceConnectionParameters dataSourceConnectionParameters);

	Map<String, String> getAllDatasources();
}
