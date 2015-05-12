/**
 * 
 */
package org.webplans.sqltools.sql2nosql.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roshan Titus
 *
 */
public class Result {
	
	private Long totalHits;
	private List<Row<String, Object>> rows;
	
	
	public Result() {
		super();
		totalHits = 0L;
		rows = new ArrayList<Row<String, Object>>();
	}
	
	public Long getTotalHits() {
		return totalHits;
	}
	
	public void setTotalHits(Long totalHits) {
		this.totalHits = totalHits;
	}
	
	public List<Row<String, Object>> getRows() {
		return rows;
	}
	
	public void setRows(List<Row<String, Object>> rows) {
		this.rows = rows;
	}

	public void addRow(Row<String, Object> row)
	{
		rows.add(row);
	}
}
