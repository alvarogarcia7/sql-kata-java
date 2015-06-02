package com.example.kata.sql;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhereShould {

	@Test
	public void equal_to_strings_none_of_them_a_column () {

		assertThat(WhereBuilder.aNew().constant("a").equalTo(WhereBuilder.aNew().constant("a")).build(), is("where 'a'" +
				" = 'a'"));
	}

}
