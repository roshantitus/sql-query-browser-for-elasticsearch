/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;
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

	private static final Integer PORT = 9300;
	private static final String HOST_NAME = "RTITUS-PC";
	private static final String DATASOURCE = "es";
	private static final String INDEX = "blog";
	
	@Autowired
	private QueryService queryService;
	
	@Test
	public void testExecuteQueryForSimpleSelect() {
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT, INDEX);
		
		//setup data
		String queryString = "select user, title, body, postDate from post";

		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);
		assertEquals(new Long(3), result.getTotalHits());
		assertEquals(3, result.getRows().size());
		assertEquals(4, result.getRows().get(0).size());
	}

	@Test
	public void testExecuteQueryWithFieldSelection() {
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT, INDEX);
		
		//setup data
		String queryString = "select user, title from post";

		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);
		assertEquals(new Long(3), result.getTotalHits());
		assertEquals(3, result.getRows().size());
		assertEquals(2, result.getRows().get(0).size());
	}
	
	@Test
	public void testExecuteQueryForDelete() {
			
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT, INDEX);
		
		//setup data
		String queryString = "delete from post";
		
		//run	
		try
		{
			queryService.executeQuery(queryString, dataSourceConnectionParameters);
			
			//set expectations
			fail();
		}
		catch(Exception exception)
		{
			assertThat(exception, instanceOf(NotSupportedException.class));
		}

	}	
}
