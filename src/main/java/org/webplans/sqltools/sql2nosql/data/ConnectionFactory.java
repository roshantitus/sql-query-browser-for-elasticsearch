package org.webplans.sqltools.sql2nosql.data;

/**
 * @author Roshan Titus
 *
 */
public interface ConnectionFactory {

	Connection openConnection(Configuration config);

}
