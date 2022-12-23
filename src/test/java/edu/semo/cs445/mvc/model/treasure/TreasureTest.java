package edu.semo.cs445.mvc.model.treasure;

import edu.semo.cs445.mvc.model.RandGenVillage;
import org.junit.jupiter.api.Test;

public class TreasureTest {
	@Test
	public void testGenerator() {
		RandGenHeadwear rvhw = new RandGenHeadwear();
		for (int i = 0; i < 100; i++) {
			System.out.println(rvhw.get());
		}
	}
}
