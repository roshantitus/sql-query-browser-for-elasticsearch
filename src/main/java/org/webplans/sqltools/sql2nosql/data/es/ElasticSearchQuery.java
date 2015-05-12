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
	private String type;
	private QueryBuilder querybuilder;
	private List<String> fields;

	public ElasticSearchQuery(String index, String type,
			QueryBuilder querybuilder) {
		super();
		this.index = index;
		this.type = type;
		this.querybuilder = querybuilder;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setIndex(String index) {
		this.index = index;
	}

	public void setQuerybuilder(QueryBuilder querybuilder) {
		this.querybuilder = querybuilder;
	}

	public void setFields(List<String> fields) {
		this.fields = fields;
	}
	
	
}
