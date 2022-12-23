package edu.semo.cs445.mvc.model.treasure;

/**
 * Pile of treasure found in a cheesy fantasy world.
 */
public class Treasure {
	private final Quality quality;
	private final Material material;

	public Treasure(Quality quality, Material material) {
		this.quality = quality;
		this.material = material;
	}
}
