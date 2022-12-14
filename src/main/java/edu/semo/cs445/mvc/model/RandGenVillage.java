package edu.semo.cs445.mvc.model;

import java.util.Optional;

public class RandGenVillage extends RandGen<Location> {
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

	private static final RandGenString wordSecondHalves = new RandGenString(
			"abbey",
			"bridge",
			"wood",
			"ford",
			"hole",
			"hollow",
			"thorpe",
			"vale",
			"ville",
			"wall"
	);

	private static final RandGenString nonWordSecondHalves = new RandGenString(
			"cester",
			"ingham",
			"ington",
			"forth",
			"wester",
			"fertham"
	);

	private static final RandGenString secondHalves = nonWordSecondHalves.add(wordSecondHalves);

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

	private static final RandGenString denizens = new RandGenString(
			"Dragon",
			"Elf",
			"Goblin",
			"Rat",
			"Orc",
			"Troll"
	);

	private static final RandGenString materials = new RandGenString(
			"Silver",
			"Stone",
			"Wood"
	);

	/**
	 * Town names that are
	 */
	private static final RandGen<String> originalTownNames = firstHalves.append(secondHalves);
	private static final RandGen<String> denizenTownNames = denizens.append(wordSecondHalves);
	private static final RandGen<String> materialTownNames = materials.append(wordSecondHalves);

	public String name() {
		return denizenTownNames.maybe(1, 10).get().
				or(materialTownNames.maybe(1,9)).
				orElse(originalTownNames.get());
	}

	public Optional<String> modifier() {
		return modifiers.maybe(1, 4).get();
	}

	public int population() {
		return about(500, 250);
	}

	@Override
	public Location get() {
		return new Location(name(), modifier().orElse(null), population());
	}


}
