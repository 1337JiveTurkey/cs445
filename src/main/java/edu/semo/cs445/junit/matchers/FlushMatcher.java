package edu.semo.cs445.junit.matchers;

public class FlushMatcher implements HandMatcher<FlushMatcher> {
	@Override
	public HandRank getRank() {
		return HandRank.Flush;
	}

	@Override
	public int compareWithinRank(FlushMatcher hm) {
		return 0;
	}
}
