/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.exception.DataAccessException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchStatement implements Statement{

	final Logger logger = LoggerFactory.getLogger(ElasticSearchStatement.class);
	private Client client;
	private QueryBuilder querybuilder;
	
	
	public ElasticSearchStatement(Client client, Query queryObject) {
		super();
		this.client = client;
		buildQuery(queryObject);
	}



	private void buildQuery(Query queryObject) {

		querybuilder = ElastcSearchQueryBuilder.buildQuery(queryObject);
	}



	@Override
	public Result execute() throws DataAccessException {
		Result result = null;
		try
		{
			
			logger.info(querybuilder.toString());
			SearchResponse response = client.prepareSearch().setQuery(querybuilder).execute().actionGet();
			logger.info(response.toString());
			
			result = processSeachResponse(response);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			throw new DataAccessException("Failed to retrieve data from ElasticSearch server", exception);
		}	
		return result;
	}



	private Result processSeachResponse(SearchResponse response) {
		// TODO Auto-generated method stub
		Result result = null;
		if(null != response)
		{
			result = new Result();
			Long totalHits = response.getHits().getTotalHits();
			result.setTotalHits(totalHits);
//			if(totalHits > 0)
//			{
//				Iterator iterator = response.getHits().iterator();
//				while(iterator.hasNext())
//				{
//					iterator.next();
//				}
//			}
		}
		return result;
	}
	
}
