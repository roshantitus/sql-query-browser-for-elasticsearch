/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.dao;

import org.springframework.stereotype.Repository;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.ConnectionFactory;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.data.es.ElasticSearchConnectionFactory;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;


/**
 * @author Roshan Titus
 *
 */
@Repository
public class QueryDAOImpl implements QueryDAO {

	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.data.QueryDAO#executeQuery(java.lang.Object)
	 */
	@Override
	public Result executeQuery(Query queryObject, DataSource dataSource, Configuration config) 
	{
		Result result = null;
		ConnectionFactory connectionFactory = getConnectionFactory(dataSource);
		Connection connection = connectionFactory.openConnection(config);
		String query = connection.buildQuery(queryObject);
		Object resultset = connection.executeQuery(query);
		result = connection.processResult(resultset);
		connection.close();
		return result;
	}
	
	private ConnectionFactory getConnectionFactory(DataSource dataSource)
	{
		ConnectionFactory connectionFactory = null;
		if(DataSource.ELASTICSEARCH.equals(dataSource))
		{
			connectionFactory = new ElasticSearchConnectionFactory();
		}		
		return connectionFactory;
	}	

}
