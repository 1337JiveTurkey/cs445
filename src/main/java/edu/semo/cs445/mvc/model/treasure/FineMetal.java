package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum FineMetal implements Material {
	Electrum,
	Gold,
	Platinum,
	Silver;

	public static RandGenEnum<FineMetal> Random = new RandGenEnum<>(FineMetal.class);
}
