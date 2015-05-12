package org.webplans.sqltools.sql2nosql.service;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.webplans.sqltools.sql2nosql.model.Query;

@ContextConfiguration(locations = {"classpath:spring/business-config.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class QueryTransformationServiceTest {

	@Autowired
	private QueryTransformationService queryTransformationService;
	
	@Test
	public void testTransformQueryStringToObjectHeirarchy() {
		
		//setup data
		String queryString = "select * from employee";
		
		//run
		Query query = queryTransformationService.transformQueryStringToObjectHeirarchy(queryString);
		
		//set expectations
		assertNotNull(query);
	}

}
