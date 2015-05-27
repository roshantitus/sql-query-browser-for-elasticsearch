/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webplans.sqltools.sql2nosql.data.DataSource;
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
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		dataSourceConnectionParameters.setDatabase(INDEX);
		
		//setup data
		String queryString = "select * from post";

		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);
		assertEquals(new Long(3), result.getTotalHits());
		assertEquals(3, result.getRows().size());
		assertEquals(4, result.getRows().get(0).size());
		assertTrue(result.getRows().get(0).containsKey("user"));
		assertTrue(result.getRows().get(0).containsKey("title"));
		assertTrue(result.getRows().get(0).containsKey("body"));
		assertTrue(result.getRows().get(0).containsKey("postDate"));		
	}

	@Test
	public void testExecuteQueryWithFieldSelection() {
		
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		dataSourceConnectionParameters.setDatabase(INDEX);
		
		//setup data
		String queryString = "select user, title from post";

		
		//run		
		Result result = queryService.executeQuery(queryString, dataSourceConnectionParameters);
		
		//set expectations
		assertNotNull(result);
		assertEquals(new Long(3), result.getTotalHits());
		assertEquals(3, result.getRows().size());
		assertEquals(2, result.getRows().get(0).size());
		assertTrue(result.getRows().get(0).containsKey("user"));
		assertTrue(result.getRows().get(0).containsKey("title"));
		assertFalse(result.getRows().get(0).containsKey("body"));
		assertFalse(result.getRows().get(0).containsKey("postDate"));
	}
	
	@Test
	public void testExecuteQueryForDelete() {
			
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		dataSourceConnectionParameters.setDatabase(INDEX);
		
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
	
	@Test
	public void testGetAllIndices() 
	{
		DataSourceConnectionParameters dataSourceConnectionParameters = new DataSourceConnectionParameters(DATASOURCE, HOST_NAME, PORT);
		dataSourceConnectionParameters.setDatabase(INDEX);

		List<String> indices = queryService.getAllIndices(dataSourceConnectionParameters);
		assertNotNull(indices);
		assertEquals(1, indices.size());
		assertTrue(indices.get(0).equals(INDEX));		
	}
	
	@Test
	public void testGetAllDatasources() 
	{
		Map<String, String> datasources = queryService.getAllDatasources();
		assertNotNull(datasources);
		assertEquals(1, datasources.size());
		assertNotNull(datasources.get(DATASOURCE));		
		assertEquals(datasources.get(DATASOURCE), DataSource.ELASTICSEARCH.getDataSourceName());
	}
	
}
