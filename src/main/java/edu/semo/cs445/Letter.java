package edu.semo.cs445;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * The letters of the Roman numeral system with associated values.
 * These are also listed in order of size so that the natural ordering
 * of their enumeration
 */
public enum Letter {
	I(1),
	V(5),
	X(10),
	L(50),
	C(100),
	D(500),
	M(1000),
	;

	/**
	 * Collection of all the values as a HashMap for lookup.
	 */
	public static final Map<Character, Letter> byChar;

	public final int value;
	private Letter(int value) {
		this.value = value;
	}

	static {
		Map<Character, Letter> letters = new HashMap<>();
		for (Letter letter : Letter.values()) {
			letters.put(letter.name().charAt(0), letter);
		}
		byChar = Collections.unmodifiableMap(letters);
	}
}
