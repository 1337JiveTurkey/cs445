package edu.semo.cs445.mvc.model;

import org.junit.jupiter.api.Test;

public class LocationTest {
	@Test
	public void testGenerator() {
		RandGenVillage rvg = new RandGenVillage();
		for (int i = 0; i < 100; i++) {
			System.out.println(rvg.get());
		}
	}
}
