package edu.semo.cs445.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

/**
 * Assertions are what makes unit tests so useful. What you're doing with an
 * assertion is saying that something needs to be true for the test case to be
 * successful. Below are some common assertions that can be used to test your
 * software.
 */
public class TestAssertionsDemo {
	@Test
	public void testTruth() {
		final var testSet = Set.of("Test String");
		// Read as "I assert that testSet is not empty"
		Assertions.assertFalse(testSet.isEmpty());
	}

	@Test
	public void testEquals() {
		// Read as "I assert that 2 + 2 equals 4"
		Assertions.assertEquals(4, 2 + 2);
	}

	@Test
	public void testArrayEquals() {
		var toBeSorted = new int[]{3, 2, 1};
		Arrays.sort(toBeSorted);
		// Read as "I assert that toBeSorted is the same array as {1, 2, 3}"
		Assertions.assertArrayEquals(new int[]{1, 2, 3}, toBeSorted);
	}
}
