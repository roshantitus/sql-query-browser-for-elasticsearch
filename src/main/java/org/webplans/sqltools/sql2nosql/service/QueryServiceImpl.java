/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 *
 */
@Service
public class QueryServiceImpl implements QueryService {

	private QueryExecutionService queryExecutionService;
	private QueryTransformationService queryTransformationService;
	
	@Autowired
	public QueryServiceImpl(QueryExecutionService queryExecutionService,
			QueryTransformationService queryTransformationService) {
		super();
		this.queryExecutionService = queryExecutionService;
		this.queryTransformationService = queryTransformationService;
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
		Query queryObject = queryTransformationService.transformQueryStringToObjectHeirarchy(queryString);
		Result result = queryExecutionService.executeAgainstDatasource(queryObject, dataSourceConnectionParameters);
		return result;
	}
	
	public List<String> getAllAvailableIndices(DataSourceConnectionParameters dataSourceConnectionParameters)
	{
		return queryExecutionService.fetchIndices(dataSourceConnectionParameters);
	}

}
