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
	
	private int totalHits;
	private List<Row> rows;
	
	
	public Result() {
		super();
		totalHits = 0;
		rows = new ArrayList<Row>();
	}
	
	public int getTotalHits() {
		return totalHits;
	}
	
	public void setTotalHits(int totalHits) {
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
