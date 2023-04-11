package edu.semo.cs445.factorymethod;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

/**
 * Factory methods are a way of creating new objects that hides the constructor
 * behind a method called the factory method. The advantage of this is that the
 * constructor doesn't need to be called directly, and we can use one of many
 * implementations. A common example is random number generators which have many
 * algorithms, and it's hard for the average developer to know which one's best.
 * The RandomGenerator.getDefault() gets a generator that's guaranteed to be
 * pretty good by most standards without you needing to know the constructor or
 * algorithm being used.
 */
public class FactoryMethodDemo {
	public static void main(String[] argv) {
		/*
		This is an example of a factory method being used to hide what the
		actual implementation is. The real implementation isn't visible to us,
		so it can be changed to whatever happens to be best in the future.
		 */
		RandomGenerator rng = RandomGenerator.getDefault();

		/*
		Here are all the random number generators that your Java installation has.
		Not all installations will have the same generators and
		 */
		for (RandomGeneratorFactory<RandomGenerator> factory : RandomGeneratorFactory.all().toList()) {
			System.out.println(factory.name());
		}
	}
}
