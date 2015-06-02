package com.example.kata.sql;

public class WhereBuilder {
	public static final String WHITESPACE = " ";
	public static final String WHERE = "where ";
	public static final String SINGLE_QUOUTE = "'";
	public static final String EQUALS = "=";
	private String constant;
	private String operation;
	private WhereBuilder otherClause;

	public static WhereBuilder aNew () {
		return new WhereBuilder();
	}

	public WhereBuilder constant (final String value) {
		this.constant = value;
		return this;
	}

	public String build () {
		return WHERE +singleQuoute(constant)+ WHITESPACE +operation+ WHITESPACE + otherClause.buildSubqueryOnly();
	}

	private String buildSubqueryOnly () {
		return singleQuoute(constant);
	}

	private String singleQuoute (final String constant1) {
		return SINGLE_QUOUTE + constant1 + SINGLE_QUOUTE;
	}

	public WhereBuilder equalTo (final WhereBuilder where) {
		this.operation = EQUALS;
		this.otherClause = where;
		return this;
	}
}
