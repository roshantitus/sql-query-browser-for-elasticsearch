/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.dao;

import java.util.List;

import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public interface QueryDAO {

	Result executeQuery(Query queryObject, DataSource dataSource, Configuration config);

	/**
	 * @param dataSourceByCode
	 * @param config
	 * @return
	 */
	List<String> fetchIndices(DataSource dataSource, Configuration config);
}
