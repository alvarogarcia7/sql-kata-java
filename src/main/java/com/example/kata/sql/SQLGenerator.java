package com.example.kata.sql;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class SQLGenerator {
	private static final String ALL_COLUMNS = "*";
	private static final String COLUMN_SEPARATOR = ", ";
	private static final String SELECT = "select ";
	private static final String FROM_CLAUSE = " from ";

	public String select (final String[] columns, final String table) {
		return SELECT + getColumns(columns) + FROM_CLAUSE + table;
	}

	private String getColumns (final String[] columns) {
		return StringUtils.join(Arrays.asList(columns), COLUMN_SEPARATOR);
	}

	public String selectAll (final String table) {
		return SELECT+ ALL_COLUMNS +FROM_CLAUSE + table;
	}
}
