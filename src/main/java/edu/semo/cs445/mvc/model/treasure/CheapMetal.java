package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum CheapMetal implements Material {
	Brass,
	Bronze,
	Copper,
	Iron,
	Lead,
	Pewter,
	Steel,
	Tin;

	public static RandGenEnum<CheapMetal> Random = new RandGenEnum<>(CheapMetal.class);
}
