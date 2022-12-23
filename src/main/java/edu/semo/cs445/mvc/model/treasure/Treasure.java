package edu.semo.cs445.mvc.model.treasure;

/**
 * Pile of treasure found in a cheesy fantasy world.
 */
public class Treasure {
	private final String type;
	private final Quality quality;
	private final Material material;

	public Treasure(String type, Quality quality, Material material) {
		this.type = type;
		this.quality = quality;
		this.material = material;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (quality != null) {
			sb.append(quality);
		}
		if (material != null) {
			sb.append(material);
		}
		sb.append(type);
		return sb.toString();
	}
}
