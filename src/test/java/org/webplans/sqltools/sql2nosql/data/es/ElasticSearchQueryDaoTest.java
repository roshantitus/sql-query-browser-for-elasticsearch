/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.DataSource;
import org.webplans.sqltools.sql2nosql.data.dao.QueryDAOImpl;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchQueryDaoTest {

	private static final String PORT = "9300";
	private static final String HOST_NAME = "RTITUS-PC";
	
	@Test
	public void testGetConnection() {
		
		QueryDAOImpl queryDAO = new QueryDAOImpl();
		Configuration config = new Configuration(HOST_NAME, Integer.valueOf(PORT));
		Connection connection = queryDAO.openConnectionToDatasource(DataSource.ELASTICSEARCH, config);
		assertNotNull(connection);
		assertThat(connection, instanceOf(ElasticSearchConnection.class));		
		assertNotNull(((ElasticSearchConnection)connection).getClient());
		connection.close();
	}

}
