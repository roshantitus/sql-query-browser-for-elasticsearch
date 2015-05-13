/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.hppc.ObjectLookupContainer;
import org.elasticsearch.common.hppc.cursors.ObjectCursor;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.exception.ConnectionException;
import org.webplans.sqltools.sql2nosql.exception.QueryException;
import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchConnection implements Connection {

	final Logger logger = LoggerFactory.getLogger(ElasticSearchConnection.class);
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
			logger.error("Failed to connect to ElasticSearch server");
			throw new ConnectionException("Failed to connect to ElasticSearch server");
		}
	}

	@Override
	public Statement buildStatement(Query queryObject) throws QueryException {
		return new ElasticSearchStatement(config, client, queryObject);
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
			logger.error("Failed to close connection to ElasticSearch server");
			throw new ConnectionException("Failed to close connection to ElasticSearch server");
		}			
	}

	public Client getClient() {
		return client;
	}

	/* (non-Javadoc)
	 * @see org.webplans.sqltools.sql2nosql.data.Connection#fetchIndices()
	 */
	@Override
	public List<String> fetchIndices() 
	{
		List<String> indexNames = new ArrayList<String>();
		ObjectLookupContainer<String> indices = client.admin().cluster().prepareState().execute() .actionGet().getState() .getMetaData().indices().keys();
		if(null != indices && indices.size() > 0)
		{
			Iterator<ObjectCursor<String>> indexIterator = indices.iterator();
			while(indexIterator.hasNext())
			{
				String indexName = indexIterator.next().value;
				//logger.info(indexName);
				if(null != indexName && indexName.length() > 0 && !indexName.startsWith(".marvel-"))
				{
					indexNames.add(indexName);
				}
			}
		}
		return indexNames;
	}

	
}
