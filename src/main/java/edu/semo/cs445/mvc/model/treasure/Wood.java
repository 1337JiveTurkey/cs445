package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum Wood implements Material {
	Ash,
	Ebony,
	Elm,
	Mahogany,
	Maple,
	Oak,
	Purpleheart,
	Rosewood,
	Walnut;

	public static RandGenEnum<Wood> Random = new RandGenEnum<>(Wood.class);
}
