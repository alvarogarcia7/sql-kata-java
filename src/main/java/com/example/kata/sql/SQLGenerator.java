package com.example.kata.sql;

import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class SQLGenerator {
	private static final String ALL_COLUMNS = "*";
	private static final String COLUMN_SEPARATOR = ", ";
	private static final String SELECT = "select ";
	private static final String FROM = " from ";
	private final Where where;

	public SQLGenerator (final Where where) {
		this.where = where;
	}

	public String select (final String[] columns, final String table) {
		return SELECT + getColumns(columns) + FROM + table;
	}

	private String getColumns (final String[] columns) {
		return StringUtils.join(Arrays.asList(columns), COLUMN_SEPARATOR);
	}

	public String selectAll (final String table) {
		return SELECT+ ALL_COLUMNS + FROM + table;
	}

	public String selectAll (final String table, final String where) {
		this.where.generateQuery(where);
		return null;
	}
}
