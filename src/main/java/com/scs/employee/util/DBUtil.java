package com.scs.employee.util;

import javax.sql.DataSource;

public class DBUtil {
	private DataSource datasource;
	
	public DBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

}
