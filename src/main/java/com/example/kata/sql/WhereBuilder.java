package com.example.kata.sql;

public class WhereBuilder {
	public static WhereBuilder aNew () {
		return new WhereBuilder();
	}

	public WhereBuilder constant (final String value) {
		return this;
	}

	public String build () {
		return "where 'a' = 'a'";
	}

	public WhereBuilder equalTo (final WhereBuilder where) {
		return this;
	}
}
