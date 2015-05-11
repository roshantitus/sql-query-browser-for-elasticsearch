package org.webplans.sqltools.sql2nosql;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.webplans.sqltools.sql2nosql.data.es.ElasticSearchQueryDaoTest;
import org.webplans.sqltools.sql2nosql.service.QueryServiceTest;
import org.webplans.sqltools.sql2nosql.service.QueryTransformationServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	QueryServiceTest.class,
	QueryTransformationServiceTest.class,
	ElasticSearchQueryDaoTest.class
})

/**
 * @author Roshan Titus
 *
 */
public class TestSuite {

}
