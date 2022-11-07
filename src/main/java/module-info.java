import edu.semo.cs445.EnglishParser;
import edu.semo.cs445.IntParser;
import edu.semo.cs445.ParserStrategy;
import edu.semo.cs445.RomanNumeralParser;

/**
 * This is a Java 9-style module header.
 */
module StrategyDemo.main {
	uses ParserStrategy;

	provides ParserStrategy with
			RomanNumeralParser,
			IntParser,
			EnglishParser;
}