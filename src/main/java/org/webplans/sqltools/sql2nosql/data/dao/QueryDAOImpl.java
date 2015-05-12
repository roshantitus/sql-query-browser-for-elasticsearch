/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.dao;

import org.springframework.stereotype.Repository;
import org.webplans.sqltools.sql2nosql.data.AbstractConnectionFactory;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.ConnectionFactory;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.exception.ConnectionException;
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
		Connection connection = openConnectionToDatasource(dataSource, config);
		
		result = executeQuery(queryObject, connection);
		
		closeConnectionWithDatasource(connection);
		return result;
	}

	public Result executeQuery(Query queryObject, Connection connection) {
		Result result = null;
		Statement statement = connection.buildStatement(queryObject);
		result = statement.execute();
		return result;
	}

	public void closeConnectionWithDatasource(Connection connection) {
		connection.close();
	}

	public Connection openConnectionToDatasource(DataSource dataSource,
			Configuration config) {
		if(null == dataSource)
		{
			throw new ConnectionException("dataSource is null");
		}
		ConnectionFactory connectionFactory = AbstractConnectionFactory.getConnectionFactory(dataSource);
		Connection connection = connectionFactory.openConnection(config);
		return connection;
	}

}
