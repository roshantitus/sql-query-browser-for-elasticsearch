/**
 * 
 */
package org.webplans.sqltools.sql2nosql.data.es;

import org.webplans.sqltools.sql2nosql.data.Configuration;
import org.webplans.sqltools.sql2nosql.data.Connection;
import org.webplans.sqltools.sql2nosql.data.ConnectionFactory;

/**
 * @author Roshan Titus
 *
 */
public class ElasticSearchConnectionFactory implements ConnectionFactory {

	@Override
	public Connection openConnection(Configuration config) {
		return new ElasticSearchConnection();
	}

}
