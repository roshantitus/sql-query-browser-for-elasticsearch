/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.data.dao.QueryDAO;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
@Service
public class QueryExecutionServiceImpl implements QueryExecutionService {
	
	private QueryDAO queryDAO;	
	
	@Autowired	
	public QueryExecutionServiceImpl(QueryDAO queryDAO) {
		super();
		this.queryDAO = queryDAO;
	}



	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.service.QueryExecutionService#executeQuery()
	 */
	@Override
	public Result executeAgainstDatasource(Query queryObject, DataSourceConnectionParameters dataSourceConnectionParameters) 
	{
		if(null == dataSourceConnectionParameters)
		{
			throw new IllegalArgumentException("dataSourceConnectionParameters cannot be null!");
		}
		String dataSourceCode = dataSourceConnectionParameters.getDataSourceCode();
		Configuration config = new Configuration(dataSourceConnectionParameters.getHostName(), Integer.valueOf(dataSourceConnectionParameters.getPort()));
		return queryDAO.executeQuery(queryObject, DataSource.getDataSourceByCode(dataSourceCode), config);
	}

}
