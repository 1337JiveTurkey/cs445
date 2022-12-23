package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenEnum;

public enum Wood implements Material {
	Acacia,
	Alder,
	Ash,
	Aspen,
	Balsa,
	Basswood,
	Birch,
	Boxwood,
	Buckeye,
	Camphor,
	Cedar,
	Cherry,
	Chestnut,
	Cottonwood,
	Cypress,
	Dogwood,
	Ebony,
	Elm,
	Eucalyptus,
	Fir,
	Greenheart,
	Gum,
	Hemlock,
	Hickory,
	Ironwood,
	Larch,
	Locust,
	Mahogany,
	Maple,
	Oak,
	Olive,
	Pine,
	Poplar,
	Purpleheart,
	Rosewood,
	Sandalwood,
	Spruce,
	Teak,
	Walnut,
	Willow;

	public static RandGenEnum<Wood> Random = new RandGenEnum<>(Wood.class);
}
