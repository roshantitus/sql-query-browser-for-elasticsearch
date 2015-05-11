/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.data.exception.ConnectionException;
import org.webplans.sqltools.sql2nosql.data.exception.QueryException;
import org.webplans.sqltools.sql2nosql.data.exception.ResultException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchConnection implements Connection {

	private Configuration config;
	private Client client;
	
	public ElasticSearchConnection(Configuration config) {
		super();
		this.config = config;
		connect();
	}
	
	private void connect() throws ConnectionException
	{
		try
		{
//			Settings settings = ImmutableSettings.settingsBuilder()
//		            .put("cluster.name", "elasticsearch").build();
			client = new TransportClient().addTransportAddress(new InetSocketTransportAddress(this.config.getHostName(), this.config.getPortNo()));
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw new ConnectionException("Failed to connect to ElasticSearch server");
		}
	}

	@Override
	public Statement buildStatement(Query queryObject) throws QueryException {
		return new ElasticSearchStatement(client, queryObject);
	}



	@Override
	public Result processResponse() throws ResultException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() throws ConnectionException 
	{
		try
		{
			client.close();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw new ConnectionException("Failed to close connection to ElasticSearch server");
		}			
	}

	public Client getClient() {
		return client;
	}

	
}
