/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webplans.sqltools.sql2nosql.model.Result;
import org.webplans.sqltools.sql2nosql.service.vo.DataSourceConnectionParameters;

/**
 * @author Roshan Titus
 * 
 * Integration tests for the Server layer functionality
 *
 */
@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryServiceTest {

	@Autowired
	private QueryService queryService;
	
	@Test
	public void testExecuteQuery() {
		
		//setup data
		String queryString = "select * from employee";

		String dataSourceCode = "es";
		String hostName = "localhost";
		String port = "9200";
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(dataSourceCode, hostName, port);
		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);		
	}

}
