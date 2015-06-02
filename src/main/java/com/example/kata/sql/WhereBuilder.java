package com.example.kata.sql;

public class WhereBuilder {
	public static final String WHITESPACE = " ";
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
		return "where "+singleQuoute(constant)+ WHITESPACE +operation+ WHITESPACE + otherClause.smallBuild();
	}

	private String smallBuild () {
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
