/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webplans.sqltools.sql2nosql.exception.NotSupportedException;
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

	private static final String PORT = "9300";
	private static final String HOST_NAME = "192.168.1.3";
	private static final String DATASOURCE = "es";
	
	@Autowired
	private QueryService queryService;
	
	@Test
	public void testExecuteQueryForSimpleSelect() {
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		
		//setup data
		String queryString = "select * from employee";

		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);		
	}

	@Test
	public void testExecuteQueryForDelete() {
			
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		
		//setup data
		String queryString = "delete from employee";
		
		//run	
		try
		{
			Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
			
			//set expectations
			fail();
		}
		catch(Exception exception)
		{
			assertThat(exception, instanceOf(NotSupportedException.class));
		}

	}	
}
