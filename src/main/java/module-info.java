import edu.semo.cs445.IntParser;
import edu.semo.cs445.ParserStrategy;
import edu.semo.cs445.RomanNumeralParser;

module StrategyDemo.main {
	uses ParserStrategy;

	provides ParserStrategy with RomanNumeralParser, IntParser;
}