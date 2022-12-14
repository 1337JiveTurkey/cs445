package edu.semo.cs445.mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class RandGenString extends RandGen<String> implements Supplier<String> {
	private final List<String> strings;
	public RandGenString(String... strings) {
		this(List.of(strings));
	}

	private RandGenString(List<String> trustedList) {
		strings = trustedList;
	}

	public RandGenString add(RandGenString other) {
		List<String> newStrings = new ArrayList<>(strings);
		newStrings.addAll(other.strings);
		return new RandGenString(newStrings);
	}

	public RandGen<String> append(Supplier<String> other) {
		return new RandGenAppendedString(this, "", other);
	}

	public String get() {
		return pick(strings);
	}

	/**
	 * Random string generator that's just two string suppliers appending one
	 * after the other. Extends RandGen for the maybeGet() method.
	 */
	private static final class RandGenAppendedString extends RandGen<String> {
		private final Supplier<String> first;
		private final String splitter;
		private final Supplier<String> second;

		private RandGenAppendedString(Supplier<String> first, String splitter, Supplier<String> second) {
			this.first = first;
			this.splitter = splitter;
			this.second = second;
		}

		public String get() {
			return first.get() + splitter + second.get();
		}
	}
}
