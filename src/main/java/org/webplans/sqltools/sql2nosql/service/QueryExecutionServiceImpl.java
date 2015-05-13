/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import java.util.List;

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
		Configuration config = getConfiguration(dataSourceConnectionParameters);
		return queryDAO.executeQuery(queryObject, DataSource.getDataSourceByCode(dataSourceConnectionParameters.getDataSourceCode()), config);
	}



	/**
	 * @param dataSourceConnectionParameters
	 * @return
	 */
	private Configuration getConfiguration(
			DataSourceConnectionParameters dataSourceConnectionParameters) {
		if(null == dataSourceConnectionParameters)
		{
			throw new IllegalArgumentException("dataSourceConnectionParameters cannot be null!");
		}
		Configuration config = new Configuration(dataSourceConnectionParameters.getHostName(), dataSourceConnectionParameters.getPort(), dataSourceConnectionParameters.getDatabase());
		return config;
	}



	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.service.QueryExecutionService#fetchIndices()
	 */
	@Override
	public List<String> fetchIndices(DataSourceConnectionParameters dataSourceConnectionParameters) 
	{
		Configuration config = getConfiguration(dataSourceConnectionParameters);
		return queryDAO.fetchIndices(DataSource.getDataSourceByCode(dataSourceConnectionParameters.getDataSourceCode()), config);
	}

}
