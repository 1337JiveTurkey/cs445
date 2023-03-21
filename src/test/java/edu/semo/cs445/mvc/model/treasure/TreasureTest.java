package edu.semo.cs445.mvc.model.treasure;

import org.junit.jupiter.api.Test;

public class TreasureTest {
	/**
	 * This is what's known as a smoke test. It doesn't really test much of
	 * anything, but it's enough to tell if something's profoundly broken.
	 * Not exactly good practice here, but it's something you'll see if you
	 * go on to develop software.
	 */
	@Test
	public void testGenerator() {
		RandGenHeadwear rghw = new RandGenHeadwear();
		for (int i = 0; i < 100; i++) {
			System.out.println(rghw.get());
		}
	}
}
