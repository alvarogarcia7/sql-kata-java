package com.example.kata.sql;

import org.junit.Test;

import static com.example.kata.sql.WhereBuilder.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WhereShould {

	@Test
	public void equal_to_strings_none_of_them_a_column () {

		assertThat(constant("a").equalTo(constant("a")).build(), is("where 'a'" +
				" = 'a'"));
	}

	private WhereBuilder constant (final String a) {
		return aNew().constant(a);
	}

}
