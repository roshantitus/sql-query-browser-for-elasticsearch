/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data;

/**
 * @author Roshan Titus
 *
 */
public enum DataSource
{    
    ELASTICSEARCH("ElasticSearch","es");
    
    private String dataSourceName;   
    private String dataSourceCode;
    
	private DataSource(String dataSourceName, String dataSourceCode) {
		this.dataSourceName = dataSourceName;
		this.dataSourceCode = dataSourceCode;
	}
	
	public String getDataSourceName() {
		return dataSourceName;
	}
	
	public void setDataSourceName(String dataSourceName) {
		this.dataSourceName = dataSourceName;
	}
	
	public String getDataSourceCode() {
		return dataSourceCode;
	}
	
	public void setDataSourceCode(String dataSourceCode) {
		this.dataSourceCode = dataSourceCode;
	}
    
    public static DataSource getDataSourceByCode(String dataSourceCode)
    {
    	for(DataSource datasource : DataSource.values())
    	{
	    	if(datasource.getDataSourceCode().equals(dataSourceCode))
	    	{
	    		return datasource;
	    	}
    	}
    	return null;
    }
}
