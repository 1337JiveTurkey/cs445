package edu.semo.cs445.junit.matchers;

public class StraightMatcher implements HandMatcher<StraightMatcher> {
	@Override
	public HandRank getRank() {
		return HandRank.Straight;
	}

	@Override
	public int compareWithinRank(StraightMatcher hm) {
		return 0;
	}
}
