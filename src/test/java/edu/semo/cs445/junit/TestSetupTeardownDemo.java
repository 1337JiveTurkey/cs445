package edu.semo.cs445.junit;

import org.junit.jupiter.api.*;

import java.util.random.RandomGenerator;

/**
 * This is a quick demonstration of how to do setup and teardown of test
 * environments. The idea is that often you'll have something you want to do
 * beforehand like set up a database connection, but it's not really part of a
 * test. It's also often something that you want to share the effort expended,
 * so it only happens once for a set of a dozen or more tests. Likewise, once
 * the test is done you might need to roll back the database, close any open
 * connections and so forth so that you have a clean database. These two tasks
 * are handled with @BeforeAll and @AfterAll annotated methods. Note that these
 * need to be static for the purposes of JUnit. If it's not then JUnit will
 * complain and won't run.
 * <br/><br/>
 * For stuff that only
 */
public class TestSetupTeardownDemo {
	/**
	 * This is a shared resource that we want to initialize before the tests
	 * and null out after the tests to simulate something like a database.
	 */
	private static RandomGenerator rng;

	@BeforeAll
	public static void setupFirst() {
		System.out.println("This runs before all the testcases, like a database setup.");
		rng = RandomGenerator.getDefault();
	}

	@AfterAll
	public static void teardownLast() {
		System.out.println("This runs after all the testcases, like a database teardown.");
		rng = null;
	}

	@BeforeEach
	public void setupEach() {
		System.out.println("This runs before each testcase.");
	}

	@AfterEach
	public void teardownEach() {
		System.out.println("This runs after each testcase.");
	}

	/**
	 * This tests whether dereferencing a null pointer produces a NullPointerException.
	 * The results of this may shock you! Hopefully not though.
	 */
	@Test
	public void firstTest() {
		System.out.println("This is a testcase.");

		// Read as "I assert that this block of code will throw a NullPointerException"
		Assertions.assertThrows(NullPointerException.class, () -> {
			String testString = null;
			testString.getBytes();
		});
	}

	/**
	 * Just another test case to demonstrate how the other methods work.
	 */
	@Test
	public void secondTest() {
		System.out.println("This is another testcase.");

		// Read as "I assert that 'rng' is not null"
		Assertions.assertNotNull(rng, "Somehow the RNG didn't get initialized!");
	}
}
