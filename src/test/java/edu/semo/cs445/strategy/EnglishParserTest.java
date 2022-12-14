package edu.semo.cs445.strategy;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

public class EnglishParserTest {
	@Test
	public void parseEmptyString() {
		EnglishParser ep = new EnglishParser();
		assertEquals(ep.parse(""), OptionalInt.empty());
	}

	@Test
	public void parseOne() {
		EnglishParser ep = new EnglishParser();
		assertEquals(ep.parse("One"), OptionalInt.of(1));
		assertEquals(ep.parse("ONE"), OptionalInt.of(1));
		assertEquals(ep.parse("one"), OptionalInt.of(1));
	}

	@Test
	public void parseFourteen() {
		EnglishParser ep = new EnglishParser();
		assertEquals(ep.parse("Fourteen"), OptionalInt.of(14));
		assertEquals(ep.parse("FOURTEEN"), OptionalInt.of(14));
		assertEquals(ep.parse("fourteen"), OptionalInt.of(14));
	}
}
