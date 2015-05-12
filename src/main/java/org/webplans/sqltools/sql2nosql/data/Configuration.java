/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

/**
 * @author Roshan Titus
 *
 */
public class Configuration {

	private String hostName;
	private Integer portNo;
	private String database;	
	private String username;
	private String password;	

	public Configuration(String hostName, Integer portNo, String database) {
		super();
		this.hostName = hostName;
		this.portNo = portNo;
		this.database = database;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public Integer getPortNo() {
		return portNo;
	}

	public void setPortNo(Integer portNo) {
		this.portNo = portNo;
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
