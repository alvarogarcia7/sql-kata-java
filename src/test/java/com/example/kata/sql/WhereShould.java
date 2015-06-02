package com.example.kata.sql;

import org.junit.Test;

import static com.example.kata.sql.WhereBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhereShould {

	@Test
	public void equal_to_strings_none_of_them_a_column () {

		assertThat(constant("constant1").equalTo(constant("constant2")).build(), is("where 'constant1'" +
				" = 'constant2'"));
	}

	@Test
	public void equal_a_string_to_a_column() {

		assertThat(column("column").equalTo(constant("value")).build(), is("where column" +
				" = 'value'"));
	}

	@Test
	public void column_greater_than_an_integer() {

		assertThat(column("column").equalTo(constant(1L)).build(), is("where column" +
				" = 1"));
	}

	@Test
	public void column_compared_to_boolean() {

		assertThat(column("column").equalTo(constant(true)).build(), is("where column" +
				" is true"));
	}

	private WhereBuilder constant (final boolean value) {
		return aNew().constant(value);
	}

	private WhereBuilder constant (final long value) {
		return aNew().constant(value);
	}


	private WhereBuilder column (final String column) {
		return aNew().column(column);
	}

	private WhereBuilder constant (final String a) {
		return aNew().constant(a);
	}

}
