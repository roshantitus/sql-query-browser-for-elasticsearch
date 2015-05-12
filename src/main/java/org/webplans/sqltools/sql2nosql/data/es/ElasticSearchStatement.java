/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHitField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.exception.DataAccessException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.model.Row;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchStatement implements Statement{

	final Logger logger = LoggerFactory.getLogger(ElasticSearchStatement.class);
	private Configuration config;
	private Client client;
	private ElasticSearchQuery elasticSearchQuery;
	
	
	public ElasticSearchStatement(Configuration config, Client client, Query queryObject) {
		super();
		this.config = config;
		this.client = client;
		buildQuery(queryObject);
	}



	private void buildQuery(Query queryObject) {

		ElasticSearchQueryBuilder elastcSearchQueryBuilder = new ElasticSearchQueryBuilder();
		elasticSearchQuery = elastcSearchQueryBuilder.buildQuery(queryObject, config.getDatabase());
	}



	@Override
	public Result execute() throws DataAccessException {
		return executeQuery();
	}



	/**
	 * @return
	 */
	private Result executeQuery() {
		Result result = null;
		try
		{			
			SearchRequestBuilder searchRequest = client.prepareSearch(elasticSearchQuery.getIndex()).setQuery(elasticSearchQuery.getQuerybuilder());
			for(String field : elasticSearchQuery.getFields())
			{
				searchRequest.addField(field);				
			}
			logger.info("SearchRequest: " + searchRequest.toString());
			SearchResponse response = searchRequest.execute().actionGet();
			logger.info("SearchReponse: " + response.toString());
			
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
			if(totalHits > 0)
			{
				Iterator<SearchHit> iterator = response.getHits().iterator();
				while(iterator.hasNext())
				{
					SearchHit searchHit = iterator.next();
					Map<String, SearchHitField> fieldsAndValues = searchHit.getFields();
					Row<String, Object> row = new Row<String, Object>();
					for(Entry<String, SearchHitField> mapEntry : fieldsAndValues.entrySet())
					{
						row.put(mapEntry.getKey(), mapEntry.getValue().getValue());
					}
					result.addRow(row);
				}
			}
		}
		return result;
	}
	
}
