package edu.semo.cs445.strategy;

import java.util.OptionalInt;

/**
 * ParserStrategy that tries to interpret the string as a Roman Numeral.
 *
 * Borrowed and slightly modified from the code found at:
 * https://rosettacode.org/wiki/Roman_numerals/Decode#Java_2
 */
public class RomanNumeralParser implements ParserStrategy {

	public OptionalInt parse(String romanNumeral) {
		// Empty strings break the parser otherwise
		if (romanNumeral.isEmpty()) {
			return OptionalInt.empty();
		}
		int result = 0;
		String uRoman = romanNumeral.toUpperCase(); //case-insensitive
		for(int i = 0; i < uRoman.length() - 1; i++) {
			int charValue = decodeSingle(uRoman.charAt(i));
			if (charValue == 0) {
				// Bail out on illegal characters
				return OptionalInt.empty();
			}
			// If this character has a lower value than the next character
			if (charValue < decodeSingle(uRoman.charAt(i+1))) {
				//subtract it
				result -= charValue;
			} else {
				//add it
				result += charValue;
			}
		}
		//decode the last character, which is always added
		result += decodeSingle(uRoman.charAt(uRoman.length()-1));
		return OptionalInt.of(result);
	}

	private static int decodeSingle(char letter) {
		switch(letter) {
			case 'M': return 1000;
			case 'D': return 500;
			case 'C': return 100;
			case 'L': return 50;
			case 'X': return 10;
			case 'V': return 5;
			case 'I': return 1;
			default: return 0;
		}
	}
}
