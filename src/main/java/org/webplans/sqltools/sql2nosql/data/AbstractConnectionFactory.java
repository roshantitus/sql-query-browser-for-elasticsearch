/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

import org.webplans.sqltools.sql2nosql.data.es.ElasticSearchConnectionFactory;

/**
 * @author Roshan Titus
 *
 */
public abstract class AbstractConnectionFactory {
	
	public static ConnectionFactory getConnectionFactory(DataSource dataSource)
	{
		ConnectionFactory connectionFactory = null;
		if(DataSource.ELASTICSEARCH.equals(dataSource))
		{
			connectionFactory = new ElasticSearchConnectionFactory();
		}
		else
		{
			throw new IllegalArgumentException("Datasource not supported!");
		}
		return connectionFactory;
	}		
}
