/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import java.util.List;

import org.elasticsearch.index.query.QueryBuilder;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchQuery {

	private String index;
	private QueryBuilder querybuilder;
	private List<String> fields;
	
	public ElasticSearchQuery(String index, QueryBuilder querybuilder,
			List<String> fields) {
		super();
		this.index = index;
		this.querybuilder = querybuilder;
		this.fields = fields;
	}

	public String getIndex() {
		return index;
	}

	public QueryBuilder getQuerybuilder() {
		return querybuilder;
	}

	public List<String> getFields() {
		return fields;
	}
	
	
}
