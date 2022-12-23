package edu.semo.cs445.mvc.model;

public class RandGenEnum<T extends Enum<T>> extends RandGen<T> {
	private final T[] constants;
	public RandGenEnum(Class<T> clazz) {
		constants = clazz.getEnumConstants();
	}
	@Override
	public T get() {
		return pick(constants);
	}
}
