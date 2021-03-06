/**
 * 
 */
package org.webplans.sqltools.sql2nosql.sqlparser;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.ExpressionVisitorAdapter;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitorAdapter;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectVisitorAdapter;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.webplans.sqltools.sql2nosql.model.Query;
import org.webplans.sqltools.sql2nosql.model.QueryVisitorAdapter;
import org.webplans.sqltools.sql2nosql.service.sqlparser.SQLParser;
import org.webplans.sqltools.sql2nosql.service.sqlparser.SQLParserImpl;

/**
 * @author Roshan Titus
 *
 */
public class SQLParserTest {

	final Logger logger = LoggerFactory.getLogger(SQLParserTest.class);
	
	@Test
	public void testParse() {
		
		SQLParser sqlParser = new SQLParserImpl();
		Query query = sqlParser.parse("SELECT * FROM MYTABLE WHERE COLUMN_A = :paramA AND COLUMN_B <> :paramB");
		
        final Stack<Pair<String, String>> params = new Stack<Pair<String, String>>();
        
		query.accept(new QueryVisitorAdapter(){
		    @Override
		    public void visit(Statement statement) {
		    	statement.accept(new StatementVisitorAdapter() {
		            @Override
		            public void visit(Select select) {
		                select.getSelectBody().accept(new SelectVisitorAdapter() {
		                    @Override
		                    public void visit(PlainSelect plainSelect) {
		                    	
		                    	logger.info("Table: " + plainSelect.getFromItem());
		                    	logger.info("Columns: " + plainSelect.getSelectItems());
		                    	
		                        plainSelect.getWhere().accept(new ExpressionVisitorAdapter() {
		                            @Override
		                            protected void visitBinaryExpression(BinaryExpression expr) {
		                                if (!(expr instanceof AndExpression)) {
		                                	
		                                	params.push(new Pair<String, String>(null, null));
		                                }
		                                super.visitBinaryExpression(expr);
		                            }

		                            @Override
		                            public void visit(Column column) {
		                                params.push(new Pair<String, String>(column.getColumnName(), params.pop().getRight()));
		                            }

		                            @Override
		                            public void visit(JdbcNamedParameter parameter) {
		                            	params.push(new Pair<String, String>(params.pop().getLeft(), parameter.getName()));
		                            }
		                        });
		                    }
		                });
		            }
		        });
		    }			
		});
		
        assertEquals(2, params.size());
        Pair<String, String> param2 = params.pop();
        assertEquals("COLUMN_B", param2.getLeft());
        assertEquals("paramB", param2.getRight());
        Pair<String, String> param1 = params.pop();
        assertEquals("COLUMN_A", param1.getLeft());
        assertEquals("paramA", param1.getRight());
	}
	
	private static class Pair<L, R> {
        private final L left;
        private final R right;

        private Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Pair{");
            sb.append("left=").append(left);
            sb.append(", right=").append(right);
            sb.append('}');
            return sb.toString();
        }
    }	
}
