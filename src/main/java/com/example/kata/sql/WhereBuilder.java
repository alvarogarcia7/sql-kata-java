package com.example.kata.sql;

import java.util.Optional;

public class WhereBuilder {
	private static final String WHITESPACE = " ";
	private static final String WHERE = "where ";
	private static final String SINGLE_QUOTE = "'";
	private static final String EQUALS = "=";
	private String constant;
	private String operation;
	private WhereBuilder otherClause;
	private Optional<String> column = Optional.empty();

	public static WhereBuilder aNew () {
		return new WhereBuilder();
	}

	public WhereBuilder constant (final String value) {
		this.constant = value;
		return this;
	}

	public String build () {
		if (column.isPresent()) {
			return WHERE + column.get() + WHITESPACE + operation + WHITESPACE + otherClause.buildSubqueryOnly();
		}
		return WHERE + singleQuote(constant) + WHITESPACE + operation + WHITESPACE + otherClause.buildSubqueryOnly();
	}

	private String buildSubqueryOnly () {
		return singleQuote(constant);
	}

	private String singleQuote (final String constant1) {
		return SINGLE_QUOTE + constant1 + SINGLE_QUOTE;
	}

	public WhereBuilder equalTo (final WhereBuilder where) {
		this.operation = EQUALS;
		this.otherClause = where;
		return this;
	}

	public WhereBuilder column (final String column) {
		this.column = Optional.of(column);
		return this;
	}
}
