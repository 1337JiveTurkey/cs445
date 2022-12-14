import edu.semo.cs445.strategy.EnglishParser;
import edu.semo.cs445.strategy.IntParser;
import edu.semo.cs445.strategy.ParserStrategy;
import edu.semo.cs445.strategy.RomanNumeralParser;

/**
 * This is a Java 9-style module header.
 */
module StrategyDemo.main {
	requires java.desktop;

	uses ParserStrategy;

	provides ParserStrategy with
			RomanNumeralParser,
			IntParser,
			EnglishParser;
}