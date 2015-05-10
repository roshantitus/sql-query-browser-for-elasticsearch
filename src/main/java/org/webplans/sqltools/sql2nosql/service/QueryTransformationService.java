/**
 * 
 */
package org.webplans.sqltools.sql2nosql.service;

import org.webplans.sqltools.sql2nosql.model.Query;

/**
 * @author Roshan Titus
 *
 */
public interface QueryTransformationService {

	Query transformQueryStringToObjectHeirarchy(String queryString);

}
