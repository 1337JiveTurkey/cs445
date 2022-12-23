package edu.semo.cs445.mvc.model;

import java.util.*;
import java.util.function.Supplier;

/**
 * Class for generating a random part of the model. This follows what are
 * considered best practices for a class that can be extended. Everything is
 * specifically either meant to be extended or not extensible at all. This makes
 * it easier to understand what behavior the program will have without needing
 * to
 *
 * @param <T> The type of object generated.
 */
public abstract class RandGen<T> implements Supplier<T> {
	private final Random rand = new Random();

	/**
	 * Pick one from a list of Ts.
	 *
	 * @param ts The list to pick from.
	 * @return One of the list, picked at random.
	 */
	protected final T pick(List<T> ts) {
		return ts.get(rand.nextInt(ts.size()));
	}

	protected final T pick(T[] ts) {
		return ts[rand.nextInt(ts.length)];
	}

	protected final boolean maybeIf(int x, int y) {
		return x > rand.nextInt(y);
	}

	public final RandGen<Optional<T>> maybe(int x, int y) {
		return new Maybe(x, y);
	}

	/**
	 * Generate a number that's about the center value plus or minus some second
	 * number. The number can be outside of the range but will generally (about
	 * 97% of the time) end up within the range. If the number ends up negative,
	 * it's negated to always give a positive number.
	 *
	 * @param center The center/mean of the distribution.
	 * @param plusOrMinus The standard deviation times 2.
	 * @return An integer that's about the number requested.
	 */
	protected final int about(int center, int plusOrMinus) {
		double generated = rand.nextGaussian(center, ((double) plusOrMinus) / 2);
		if (generated < 0) {
			generated = -generated;
		}
		return (int) generated;
	}

	private final class Maybe extends RandGen<Optional<T>> {
		private final int x, y;

		private Maybe(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public Optional<T> get() {
			if (maybeIf(x, y)) {
				return Optional.of(RandGen.this.get());
			} else {
				return Optional.empty();
			}
		}
	}
	public String getString() {
		return get().toString();
	}
	public RandGen<String> asString() {
		return new RandGen<String>() {
			public String get() {
				return getString();
			}
		};
	}
}
