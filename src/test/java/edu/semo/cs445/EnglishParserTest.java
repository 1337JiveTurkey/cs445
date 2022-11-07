package edu.semo.cs445;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.OptionalInt;

public class EnglishParserTest {
	@Test
	public void parseEmptyString() {
		EnglishParser ep = new EnglishParser();
		Assertions.assertEquals(ep.parse(""), OptionalInt.empty());
	}

	@Test
	public void parseOne() {
		EnglishParser ep = new EnglishParser();
		Assertions.assertEquals(ep.parse("One"), OptionalInt.of(1));
		Assertions.assertEquals(ep.parse("ONE"), OptionalInt.of(1));
		Assertions.assertEquals(ep.parse("one"), OptionalInt.of(1));
	}

	@Test
	public void parseFourteen() {
		EnglishParser ep = new EnglishParser();
		Assertions.assertEquals(ep.parse("Fourteen"), OptionalInt.of(14));
		Assertions.assertEquals(ep.parse("FOURTEEN"), OptionalInt.of(14));
		Assertions.assertEquals(ep.parse("fourteen"), OptionalInt.of(14));
	}
}
