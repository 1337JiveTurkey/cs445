package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum CheapStone implements Material {
	Anthracite,
	Feldspar,
	Granite,
	Marble,
	Mica,
	Obsidian,
	Quartz;

	public static RandGenEnum<CheapStone> Random = new RandGenEnum<>(CheapStone.class);
}
