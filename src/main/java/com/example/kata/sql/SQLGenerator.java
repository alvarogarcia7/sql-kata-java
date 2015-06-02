package com.example.kata.sql;

public class SQLGenerator {
	private final String SELECT = "select ";
	private final String FROM_CLAUSE = " from ";

	public String select (final String[] columns, final String table) {
		if(columns.length == 2) {
			return SELECT +"a, d"+ FROM_CLAUSE + table;
		}
		return SELECT +"a"+ FROM_CLAUSE + table;
	}

	public String sql (final String table) {
		return SELECT+"* from " + table;
	}
}
