package edu.semo.cs445.strategy;

import java.util.OptionalInt;

/**
 * Simple ParserStrategy that tries to parse the number as
 */
public class IntParser implements ParserStrategy {
	@Override
	public OptionalInt parse(String numericText) {
		try {
			return OptionalInt.of(Integer.parseInt(numericText));
		}
		catch (NumberFormatException e) {
			return OptionalInt.empty();
		}
	}
}
