package com.example.kata.sql;

public class WhereBuilder {
	public static final String WHITESPACE = " ";
	public static final String WHERE = "where ";
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
		return "'" + constant1 + "'";
	}

	public WhereBuilder equalTo (final WhereBuilder where) {
		this.operation = "=";
		this.otherClause = where;
		return this;
	}
}
