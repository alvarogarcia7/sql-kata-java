package com.example.kata.sql;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class SQLGenerator {
	private final String SELECT = "select ";
	private final String FROM_CLAUSE = " from ";

	public String select (final String[] columns, final String table) {
		return SELECT + getColumns(columns) + FROM_CLAUSE + table;
	}

	private String getColumns (final String[] columns) {
		return StringUtils.join(Arrays.asList(columns), ", ");
	}

	public String selectAll (final String table) {
		return SELECT+"* from " + table;
	}
}
