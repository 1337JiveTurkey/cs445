package edu.semo.cs445;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * A demonstration of how the strategy pattern works and can be used to solve
 * a small problem. This is the context that the parser is run w
 *
 * @author Paul Setzer
 */
public class StrategyDemonstration {
	public static void main(String[] args) throws Throwable {
		StrategyDemonstration demo = new StrategyDemonstration();
		demo.doTheThing();
	}

	/**
	 * Create a list of the different strategies we can use. Strategies are
	 * just objects so we can create a list of them, sort them, do all that
	 * standard object-type stuff with them and then invoke them. For here
	 * I'm just creating a list and using that to parse a bunch of strings.
	 */
	private static final List<ParserStrategy> strategiesList = List.of(
			new RomanNumeralParser(),
			new EnglishParser(),
			new IntParser()
	);

	public void doTheThing() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		while ((line = reader.readLine()) != null && !line.isBlank()) {
			final String finalLine = line;
			for (ParserStrategy strategy : strategiesList) {
				// Use the strategy to turn a string into an integer, maybe
				// If there's no integer because it couldn't parse it skips everything
				// Otherwise the "i ->" is a new
				strategy.parse(finalLine).ifPresent(i -> System.out.println(finalLine + " is " + i));
			}
		}
	}
}
