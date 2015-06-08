/**
 * 
 */
package org.webplans.sqltools.sql2nosql.web.command;

import java.util.Map;

import org.webplans.sqltools.sql2nosql.model.Result;

/**
 * @author Roshan Titus
 *
 */
public class QueryCommand {

	private String dataSourceCode;
	private String hostname;
	private Integer port;
	private String database;
	private String query;
    private Result result;	
    private Map<String, String> datasources;
    
	public Map<String, String> getDatasources() {
		return datasources;
	}
	public void setDatasources(Map<String, String> datasources) {
		this.datasources = datasources;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public Result getResult() {
		return result;
	}
	public void setResult(Result result) {
		this.result = result;
	}
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
	
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getHostname() {
		return hostname;
	}
	
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("dataSourceCode: " + dataSourceCode + ";");
		string.append("hostname: " + hostname + ";");
		string.append("port: " + port + ";");
		string.append("database: " + database + ";");
		string.append("query: " + query + ";");
		return string.toString();
	}
}
