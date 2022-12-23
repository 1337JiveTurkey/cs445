package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGen;
import edu.semo.cs445.mvc.model.RandGenEnum;
import edu.semo.cs445.mvc.model.RandGenString;

public class RandGenHeadwear extends RandGen<Treasure> {

	private static final RandGenString type = new RandGenString(
			"Cap",
			"Crown",
			"Diadem",
			"Hat",
			"Tiara",
			"Torc");

	private static final RandGenEnum<FineMetal> material = FineMetal.Random;

	public Treasure get() {
		return new Treasure(type.get(), Quality.Random.get(), material.get());
	}
}
