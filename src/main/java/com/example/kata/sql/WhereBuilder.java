package com.example.kata.sql;

import java.util.Optional;

public class WhereBuilder {
	private static final String WHITESPACE = " ";
	private static final String WHERE = "where ";
	private static final String SINGLE_QUOTE = "'";
	private static final String EQUALS = "=";
	private String constant;
	private String operation;
	private WhereBuilder otherSubQuery;
	private Optional<String> column = Optional.empty();
	private Optional<Long> constantInteger  = Optional.empty();

	public static WhereBuilder aNew () {
		return new WhereBuilder();
	}

	public WhereBuilder constant (final String value) {
		this.constant = value;
		return this;
	}

	public String build () {
		final String firstSubQuery = generateFirstSubquery();
		final String secondSubQuery = this.otherSubQuery.buildSubQueryOnly();
		return WHERE + firstSubQuery + pad(operation) + secondSubQuery;
	}

	private String pad (final String operation1) {
		return WHITESPACE + operation1 + WHITESPACE;
	}

	private String generateFirstSubquery () {
		final String firstSubquery;
		if (column.isPresent()) {
			firstSubquery = column.get();
		} else {
			firstSubquery = singleQuote(constant);
		}
		return firstSubquery;
	}

	private String buildSubQueryOnly () {
		if (constantInteger.isPresent()) {
			return String.valueOf(constantInteger.get());
		}
		return singleQuote(constant);
	}

	private String singleQuote (final String constant1) {
		return SINGLE_QUOTE + constant1 + SINGLE_QUOTE;
	}

	public WhereBuilder equalTo (final WhereBuilder where) {
		this.operation = EQUALS;
		this.otherSubQuery = where;
		return this;
	}

	public WhereBuilder column (final String column) {
		this.column = Optional.of(column);
		return this;
	}

	public WhereBuilder constant (final long value) {
		this.constantInteger = Optional.of(value);
		return this;
	}
}
