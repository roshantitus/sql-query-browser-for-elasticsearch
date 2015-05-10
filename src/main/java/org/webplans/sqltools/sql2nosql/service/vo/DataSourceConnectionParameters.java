/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service.vo;

/**
 * @author Roshan Titus
 *
 */
public class DataSourceConnectionParameters {

	private String dataSourceCode;
	private String hostName;
	private String port;
	private String username;
	private String password;
	
	public DataSourceConnectionParameters(String dataSourceCode,
			String hostName, String port) 
	{
		super();
		this.dataSourceCode = dataSourceCode;
		this.hostName = hostName;
		this.port = port;
	}

	public String getDataSourceCode() {
		return dataSourceCode;
	}

	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
