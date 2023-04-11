package edu.semo.cs445.rng;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * The (relatively) new Java 17 RandomGenerator class is a very good example of
 * several design patterns. This is a short rundown of these design patterns, so
 * you can see how they work in practice.
 * <br/><br/>
 * To give a basic background, the java.util.random package was created to give
 * a better interface for random number generators or RNGs for short. Each RNG
 * is implemented in its own class that's hidden from the user but which uses
 * the RandomGenerator interface. Having a common interface is common to many
 * design patterns but is especially important for the <em>Strategy</em> pattern.
 * (See <a href="https://en.wikipedia.org/wiki/Strategy_pattern">Wikipedia</a>)
 * The strategy pattern allows for many implementations of the same strategy,
 * each in their own class. Each RandomGenerator is an implementation of a
 * strategy which has different performance characteristics. There's also an
 * example of a Strategy pattern by itself found in edu.semo.cs445.strategy for
 * homework.
 * <br/><br/>
 * The RandomGeneratorFactory is an <em>Abstract Factory</em> class for RandomGenerators.
 * (See <a href="https://en.wikipedia.org/wiki/Abstract_factory_pattern">Wikipedia</a>)
 * An abstract factory creates instances of the objects while allowing additional
 * behavior from being able to treat them as objects themselves. In this case
 * the methods are used for filtering out which types of random generators are
 * to be used. It can also be used to print out information about each type of
 * generator which is demonstrated below.
 * <br/><br/>
 * Finally, the RandomGenerator interface itself has <em>Factory Method</em>s
 * for RandomGenerators.
 * (See <a href="https://en.wikipedia.org/wiki/Factory_method_pattern">Wikipedia</a>)
 * Factory methods are a way of choosing between multiple implementations of an
 * interface such as the different RandomGenerators in this demo. The
 * RandomGenerator.getDefault() method is the simplest way to create a new RNG
 * without needing to know anything about the implementation characteristics.
 */
public class RNGPatternsDemo {
	public static void main(String[] args) {
		/*
		1. A Factory Method is a way to hide the implementation and pick from
		many implementations without bothering the user of the object about the
		details. Why not use java.util.Random? Because it's terrible as far as
		RNGs go, and you can't swap it out easily without changing your code.

		In this case the factory method is called getDefault() and returns a
		pretty good random number generator. If you're not sure what to use,
		then you're best off just using what the Factory Method provides instead
		of trying to construct a specific random generator.
		 */
		RandomGenerator rng1 = RandomGenerator.getDefault();

		/*
		2. Factory methods can also be used to support multiple implementations
		like the of() method. Each of these calls returns a different class of
		RNG. The important part is that you the user can choose many algorithms
		with only a change to a single string so that can be hardcoded or made
		into a configuration parameter.
		 */
		RandomGenerator rng2 = RandomGenerator.of("Random"); // Original RNG
		RandomGenerator rng3 = RandomGenerator.of("SecureRandom"); // Legacy secure RNG

		System.out.println("Here are the classes of the created generators:");
		System.out.println("rng1 is a " + rng1.getClass().getName());
		System.out.println("rng2 is a " + rng2.getClass().getName());
		System.out.println("rng3 is a " + rng3.getClass().getName());

		/*
		3. Abstract factories are more involved than simple factory methods but
		offer features that simple factory methods don't have. For one thing, we
		can operate on these objects like creating lists of factories. Or we can
		get properties of each factory to decide which one we want to use. Here's
		a list of all the RNG factories on the system with some of their
		properties printed out. This isn't something that you could do with
		just constructors.
		 */
		List<RandomGeneratorFactory<RandomGenerator>> factoryList = RandomGeneratorFactory.all().toList();
		for (RandomGeneratorFactory<RandomGenerator> factory : factoryList) {
			printFactory(factory);
		}
		/*
		For example let's search for a stochastic non-hardware RNG. There should
		be at least one on the system: SecureRandom. Also since we've got at
		least Java 10 we can use local variable type inference. (The 'var'
		keyword)
		 */
		var factory = RandomGeneratorFactory
				.all()
				.filter((rngf) -> !rngf.isHardware() && rngf.isStochastic())
				.findFirst()
				.orElseThrow();
		System.out.println("Factory located is " + factory.name());
	}

	private static void printFactory(RandomGeneratorFactory<?> factory) {
		System.out.println(factory.name() + " properties of note:");
		System.out.println("\t Hardware?   \t" + (factory.isHardware()? "X" : "_"));
		System.out.println("\t Jumpable?   \t" + (factory.isJumpable()? "X" : "_"));
		System.out.println("\t Leapable?   \t" + (factory.isLeapable()? "X" : "_"));
		System.out.println("\t Splittable? \t" + (factory.isSplittable()? "X" : "_"));
		System.out.println("\t Statistical?\t" + (factory.isStatistical()? "X" : "_"));
		System.out.println("\t Stochastic? \t" + (factory.isStochastic()? "X" : "_"));
		System.out.println("\t Period?     \t" + factory.period().toString());
	}
}
