/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.data.dao.QueryDAO;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.sqlparser.SQLParser;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
@Service
public class QueryServiceImpl implements QueryService {

	private SQLParser sqlParser;
	private QueryDAO queryDAO;	
	
	
	@Autowired
	public QueryServiceImpl(SQLParser sqlParser, QueryDAO queryDAO) 
	{
		super();
		this.sqlParser = sqlParser;
		this.queryDAO = queryDAO;
	}


	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.service.QueryService#executeQuery(java.lang.String, org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters)
	 */
	@Override
	public Result executeQuery(String queryString,
			DataSourceConnectionParameters dataSourceConnectionParameters) 
	{
		if(null == dataSourceConnectionParameters || null == queryString)
		{
			throw new IllegalArgumentException("queryString and dataSourceConnectionParameters cannot be null!");
		}		
		Query queryObject = transformQueryStringToObjectHeirarchy(queryString);
		Result result = executeAgainstDatasource(queryObject, dataSourceConnectionParameters);
		return result;
	}
	
	@Override
	public List<String> getAllIndices(DataSourceConnectionParameters dataSourceConnectionParameters)
	{
		return fetchIndices(dataSourceConnectionParameters);
	}

	private Query transformQueryStringToObjectHeirarchy(String queryString) {
		return sqlParser.parse(queryString);
	}
	

	private Result executeAgainstDatasource(Query queryObject, DataSourceConnectionParameters dataSourceConnectionParameters) 
	{
		Configuration config = getConfiguration(dataSourceConnectionParameters);
		return queryDAO.executeQuery(queryObject, DataSource.getDataSourceByCode(dataSourceConnectionParameters.getDataSourceCode()), config);
	}


	private List<String> fetchIndices(DataSourceConnectionParameters dataSourceConnectionParameters) 
	{
		Configuration config = getConfiguration(dataSourceConnectionParameters);
		return queryDAO.fetchIndices(DataSource.getDataSourceByCode(dataSourceConnectionParameters.getDataSourceCode()), config);
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
	 * @see org.webplans.sqltools.sql2nosql.service.QueryService#getAllDatasources()
	 */
	@Override
	public Map<String, String> getAllDatasources() {
		
		Map<String, String> datasources = new HashMap<String, String>();
		DataSource[] datasourceArray = DataSource.values();
		for(DataSource dataSource : datasourceArray)
		{
			datasources.put(dataSource.getDataSourceCode(), dataSource.getDataSourceName());
		}
		return datasources;
	}	
}
