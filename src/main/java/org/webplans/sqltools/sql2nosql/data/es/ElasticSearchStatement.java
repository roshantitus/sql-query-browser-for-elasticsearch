/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilder;
import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.index.query.FilterBuilders.*;

import org.webplans.sqltools.sql2nosql.data.Statement;
import org.webplans.sqltools.sql2nosql.data.exception.DataAccessException;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchStatement implements Statement{

	private Client client;
	private QueryBuilder querybuilder;
	
	
	public ElasticSearchStatement(Client client, Query queryObject) {
		super();
		this.client = client;
		buildQuery(queryObject);
	}



	private void buildQuery(Query queryObject) {

		querybuilder = matchQuery(
			    "name",                  
			    "kimchy elasticsearch"   
			);
	}



	@Override
	public Result execute() throws DataAccessException {
		Result result = null;
		try
		{
			SearchResponse response = client.prepareSearch().setQuery(querybuilder).execute().actionGet();
			System.out.println(response.toString());
			
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
		return null;
	}
	
}
