package edu.semo.cs445.mvc.model;

/**
 * A location in a fantasy world.
 */
public class Location {

	private final String name;
	private final String modifier;
	private final int population;

	public Location(String name, String modifier, int population) {
		this.name = name;
		this.modifier = modifier;
		this.population = population;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (modifier != null) {
			sb.append(modifier).append(" ");
		}
		sb.append(name);
		sb.append(" (pop. ").append(population).append(")");
		return sb.toString();
	}
}
