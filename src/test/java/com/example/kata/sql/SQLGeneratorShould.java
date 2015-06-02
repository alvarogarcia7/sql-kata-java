package com.example.kata.sql;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SQLGeneratorShould {

	private SQLGenerator sqlGenerator = new SQLGenerator();

	@Test
	public void generate_sql_for_two_columns () {
		assertThat(sqlGenerator.select(columns("a", "d"), from("c")), is("select a, d from c"));
	}

	@Test
	public void generate_sql_for_one_column () {
		assertThat(sqlGenerator.select(columns("a"), from("c")), is("select a from c"));
	}

	@Test
	public void select_all_the_columns () {

		assertThat(sqlGenerator.selectAll(from("a")), is("select * from a"));
	}

	@Test
	public void select_from_another_table () {

		assertThat(sqlGenerator.select(columns("a", "d"), from("d")), is("select a, d from d"));
	}

	private String[] columns (String... columns) {
		return columns;
	}

	private String from (final String tableName) {
		return tableName;
	}

}
