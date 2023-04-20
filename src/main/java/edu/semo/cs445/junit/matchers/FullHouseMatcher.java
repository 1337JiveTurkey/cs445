package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.CardRank;

public class FullHouseMatcher implements HandMatcher<FullHouseMatcher> {
	private CardRank tripleRank;
	private CardRank pairRank;

	@Override
	public HandRank getRank() {
		return HandRank.FullHouse;
	}

	@Override
	public int compareWithinRank(FullHouseMatcher hm) {
		int tripleCompare = tripleRank.compareTo(hm.tripleRank);
		if (tripleCompare != 0) {
			return tripleCompare;
		}
		else {
			return pairRank.compareTo(hm.pairRank);
		}
	}

	@Override
	public String toString() {
		return "Full house, " + tripleRank + "s over " + pairRank + "s";
	}
}
