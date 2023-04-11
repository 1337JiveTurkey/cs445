package edu.semo.cs445.factorymethod;

import java.util.random.RandomGenerator;

/**
 * This is an interface that we want to make factory methods for. One of the
 * features of Java 8 is that we can make these factory methods directly on
 * the interface itself. Normally there will be one factory method that has
 * more complex logic involved in its implementation, but I've gone and created
 * several demonstrating various uses of the Factory Method pattern.
 */
public interface DemoInterface {

	/**
	 * First example of a factory method used to hide the implementation from
	 * users elsewhere. This implementation is not visible normally but because
	 * the interface is visible, it can make the implementation available.
	 *
	 * @return A hidden implementation of the interface.
	 */
	public static DemoInterface getHiddenInstance() {
		return new HiddenImplementation();
	}

	/**
	 * Since classes are often a more heavyweight abstraction than is totally
	 * necessary, we can even make a factory method return a lambda instance.
	 *
	 * @return An implementation of the interface as a lambda function.
	 */
	public static DemoInterface getLambdaInstance() {
		return () -> System.out.println("Doing something with lambda functions!");
	}

	/**
	 * This is more complex but shows that you can have additional logic in your
	 * factory method before actually creating an instance to return.
	 *
	 * @return A randomly selected implementation
	 */
	public static DemoInterface getRandomInstance() {
		// Here's an actual factory method in the wild!
		RandomGenerator rg = RandomGenerator.getDefault();
		if (rg.nextBoolean()) {
			return getHiddenInstance();
		} else {
			return getLambdaInstance();
		}
	}

	/**
	 * This is the method that we want our implementations of the interface to
	 * have. I could have a more elaborate interface with more methods but for
	 * this case I just wanted to have one method to keep things simple.
	 */
	public void doSomething();
}
