package edu.semo.cs445.mvc.model;

public class RandGenTown extends RandGen<Location> {
	private static final RandGenString firstHalves = new RandGenString(
			"Abbe",
			"Arn",
			"Bel",
			"Blan",
			"Card",
			"Chas",
			"Collins",
			"Cort",
			"Dell",
			"Eason",
			"Forth",
			"Gren",
			"Hort",
			"Lask",
			"Mal",
			"Meddel",
			"Murth",
			"Neb",
			"Ob",
			"Ox",
			"Pen",
			"Rath",
			"Sobel",
			"Tang",
			"Wick",
			"Worrel"
	);

	private static final RandGenString secondHalves = new RandGenString(
			"cester",
			"ingham",
			"ington",
			"forth",
			"wester",
			"fertham"
	);

	private static final RandGenString modifiers = new RandGenString(
			"North",
			"South",
			"East",
			"West",
			"Upper",
			"Lower",
			"Central",
			"Mid",
			"Old"
	);

	public String name() {
		return firstHalves.get() + secondHalves.get();
	}

	public int population() {
		return about(5000, 2500);
	}

	@Override
	public Location get() {
		return new Location(name(), null, population());
	}
}
