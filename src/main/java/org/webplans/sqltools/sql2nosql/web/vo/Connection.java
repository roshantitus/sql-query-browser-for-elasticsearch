/**
 * 
 */
package org.webplans.sqltools.sql2nosql.web.vo;

/**
 * @author Roshan Titus
 *
 */
public class Connection {

	private String dataSourceCode;
	private String hostname;
	private Integer port;
	
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
	
	
}
