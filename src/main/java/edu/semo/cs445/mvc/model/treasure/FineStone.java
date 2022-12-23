package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum FineStone implements Material {
	Agate,
	Amethyst,
	Aquamarine,
	Beryl,
	Carnelian,
	Chalcedony,
	Diamond,
	Emerald,
	Garnet,
	Jet,
	Malachite,
	Moonstone,
	Opal,
	Pearl,
	Ruby,
	Rutile,
	Sapphire,
	Spinel,
	Topaz,
	Turquoise;
	public static RandGenEnum<FineStone> Random = new RandGenEnum<>(FineStone.class);
}
