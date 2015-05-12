/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;


import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

import org.elasticsearch.index.query.QueryBuilder;
import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
public class ElastcSearchQueryBuilder {

	public static QueryBuilder buildQuery(Query queryObject) {

		

		return 
				matchQuery(
			    "name",                  
			    "kimchy elasticsearch"   
			);
	}

}
