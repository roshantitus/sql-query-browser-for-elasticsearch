/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
public interface QueryExecutionService {

	Result executeAgainstDatasource(Query queryObject, DataSourceConnectionParameters dataSourceConnectionParameters);

}
