package com.example.kata.sql;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SQLGeneratorShould {

	private static final String ANY_WHERE_CLAUSE = null;
	private SQLGenerator sqlGenerator;
	private Where where;

	@Before
	public void setUp () {
		where = mock(Where.class);
		sqlGenerator = new SQLGenerator(where);
	}

	@Test
	public void generate_sql_for_two_columns () {
		assertThat(sqlGenerator.select(columns("a", "d"), from("c")), is("select a, d from c"));
	}

	@Test
	public void select_all_the_columns () {
		assertThat(sqlGenerator.selectAll(from("a")), is("select * from a"));
	}

	@Test
	public void ask_the_where_collaborator_for_its_subquery () {
		sqlGenerator.selectAll("table", ANY_WHERE_CLAUSE);
		verify(where).generateQuery(ANY_WHERE_CLAUSE);
	}

	private String[] columns (String... columns) {
		return columns;
	}

	private String from (final String tableName) {
		return tableName;
	}

}
