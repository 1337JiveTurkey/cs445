package edu.semo.cs445.mvc.model;

public enum Denizen {
	Human,
	Donkey,
	Dwarf,
	Elf,
	Goblin,
	Orc,
	Orphan,
	Rat,
	Troll,
	Weasel,
	Zombie;

	public static RandGenEnum<Denizen> Random = new RandGenEnum<>(Denizen.class);
}
