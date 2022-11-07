package edu.semo.cs445;

import java.util.OptionalInt;

/**
 * An interface that can be implemented multiple ways. Each implementation
 * can perform the same basic tasks in a different way. In this case
 * we're taking text and interpreting it as a number.
 * 
 */
public interface ParserStrategy {
	/**
	 * Takes a string and tries to turn it into a number. OptionalInt is an object
	 * that represents "Maybe there's a number" more safely than using nullable
	 * Integer.
	 *
	 * @param numericText The text to turn into a number using this strategy.
	 * @return An optional number if this string could interpret the string.
	 */
	public OptionalInt parse(String numericText);
}
