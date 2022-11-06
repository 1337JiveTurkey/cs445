package edu.semo.cs445;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

/**
 * This is a set of unit tests. Each method annotated with a @Test is called a
 * test case and is run to see if the assertions inside are true. In a "proper"
 * unit test there should be one assertion per test case. I've stuck to three
 * per test case so that there's fewer test cases but the specific things that
 * I'm testing are related to each other. This is officially naughty but whatever
 * I'm the instructor.
 */
public class RomanNumeralParserTest {

	/**
	 * This test case tests that an empty string produces no number as a result.
	 */
	@Test
	public void parseEmptyString() {
		RomanNumeralParser rnp = new RomanNumeralParser();
		Assertions.assertEquals(rnp.parse(""), OptionalInt.empty());
	}

	/**
	 * This test case tests that single character strings produce the value expected.
	 */
	@Test
	public void parseSingleCharacters() {
		RomanNumeralParser rnp = new RomanNumeralParser();
		Assertions.assertEquals(rnp.parse("I"), OptionalInt.of(1));
		Assertions.assertEquals(rnp.parse("V"), OptionalInt.of(5));
		Assertions.assertEquals(rnp.parse("X"), OptionalInt.of(10));
	}

	/**
	 * This test case tests that strings with duplicate characters, even if they're
	 * not normally allowed, produce the expected result.
	 */
	@Test
	public void parseDuplicates() {
		RomanNumeralParser rnp = new RomanNumeralParser();
		Assertions.assertEquals(rnp.parse("II"), OptionalInt.of(2));
		Assertions.assertEquals(rnp.parse("VV"), OptionalInt.of(10));
		Assertions.assertEquals(rnp.parse("XX"), OptionalInt.of(20));
	}

	/**
	 * This tests whether descending sequences of characters produce the expected
	 * result.
	 */
	@Test
	public void parseDescending() {
		RomanNumeralParser rnp = new RomanNumeralParser();
		Assertions.assertEquals(rnp.parse("VI"), OptionalInt.of(6));
		Assertions.assertEquals(rnp.parse("XVI"), OptionalInt.of(16));
		Assertions.assertEquals(rnp.parse("LXVI"), OptionalInt.of(66));
	}

	/**
	 * This tests whether ascending sequences of characters produce the expected
	 * result.
	 */
	@Test
	public void parseAscending() {
		RomanNumeralParser rnp = new RomanNumeralParser();
		Assertions.assertEquals(rnp.parse("IV"), OptionalInt.of(4));
		Assertions.assertEquals(rnp.parse("VX"), OptionalInt.of(5));
		Assertions.assertEquals(rnp.parse("XL"), OptionalInt.of(40));
	}
}
