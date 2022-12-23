package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum Quality {
	Crappy,
	Terrible,
	Awful,
	Miserable,
	Subpar,
	Meh,
	Average,
	Nice,
	Good,
	Excellent,
	Amazing,
	Wonderful;

	public static final RandGenEnum<Quality> Random = new RandGenEnum<>(Quality.class);
}
