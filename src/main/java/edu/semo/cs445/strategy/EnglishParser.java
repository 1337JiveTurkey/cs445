package edu.semo.cs445.strategy;

import java.util.OptionalInt;

/**
 * Parser for spelled out english words as numbers. At least the first twenty
 * of them. I've got an idea for how to parse more that's WAY outside the scope
 * of what this is supposed to be teaching.
 */
public class EnglishParser implements ParserStrategy {
	@Override
	public OptionalInt parse(String numericText) {
		String lowerCase = numericText.toLowerCase();
		if (lowerCase.equals("zero")) {
			return OptionalInt.of(0);
		}
		int ones = handleOnes(lowerCase);
		if (ones >= 0) {
			return OptionalInt.of(ones);
		}
		int teens = handleTeens(lowerCase);
		if (teens >= 0) {
			return OptionalInt.of(teens);
		}
		return OptionalInt.empty();
	}

	private int handleOnes(String text) {
		if (text.equals("one"))
			return 1;
		if (text.equals("two"))
			return 2;
		if (text.equals("three"))
			return 3;
		if (text.equals("four"))
			return 4;
		if (text.equals("five"))
			return 5;
		if (text.equals("six"))
			return 6;
		if (text.equals("seven"))
			return 7;
		if (text.equals("eight"))
			return 8;
		if (text.equals("nine"))
			return 9;
		return -1;
	}

	private int handleTeens(String text) {
		if (text.equals("ten"))
			return 10;
		if (text.equals("eleven"))
			return 11;
		if (text.equals("twelve"))
			return 12;
		if (text.equals("thirteen"))
			return 13;
		if (text.equals("forteen"))
			return 14;
		if (text.equals("fifteen"))
			return 15;
		if (text.equals("sixteen"))
			return 16;
		if (text.equals("seventeen"))
			return 17;
		if (text.equals("eighteen"))
			return 18;
		if (text.equals("nineteen"))
			return 19;
		return -1;
	}
}
