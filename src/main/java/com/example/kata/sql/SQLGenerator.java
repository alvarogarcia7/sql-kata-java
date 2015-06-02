package com.example.kata.sql;

import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class SQLGenerator {
	private final String SELECT = "select ";
	private final String FROM_CLAUSE = " from ";

	public String select (final String[] columns, final String table) {
		if(columns.length == 2) {
			return SELECT + getColumns(columns) + FROM_CLAUSE + table;
		}
		return SELECT +"a"+ FROM_CLAUSE + table;
	}

	private String getColumns (final String[] columns) {
		final List<String> colum = new ArrayList<>();
		for (String s : columns) {
			colum.add(s);
		}
		return StringUtils.join(colum, ", ");
	}

	public String selectAll (final String table) {
		return SELECT+"* from " + table;
	}
}
