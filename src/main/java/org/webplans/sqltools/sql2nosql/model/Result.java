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
	private List<Row> rows;
	
	
	public Result() {
		super();
		totalHits = 0L;
		rows = new ArrayList<Row>();
	}
	
	public Long getTotalHits() {
		return totalHits;
	}
	
	public void setTotalHits(Long totalHits) {
		this.totalHits = totalHits;
	}
	
	public List<Row> getRows() {
		return rows;
	}
	
	public void setRows(List<Row> rows) {
		this.rows = rows;
	}

	public void addRow(Row row)
	{
		rows.add(row);
	}
}
