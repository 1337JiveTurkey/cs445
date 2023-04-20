package edu.semo.cs445.junit.matchers;

public class StraightFlushMatcher implements HandMatcher<StraightFlushMatcher> {
	@Override
	public HandRank getRank() {
		return HandRank.StraightFlush;
	}

	@Override
	public int compareWithinRank(StraightFlushMatcher hm) {
		return 0;
	}
}
