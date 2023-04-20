package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.Card;
import edu.semo.cs445.junit.CardRank;

public class PairMatcher implements HandMatcher<PairMatcher> {
	private CardRank pairRank;
	private Card kicker;

	@Override
	public HandRank getRank() {
		return HandRank.Pair;
	}

	@Override
	public int compareWithinRank(PairMatcher hm) {
		int pairCompare = pairRank.compareTo(hm.pairRank);
		if (pairCompare != 0) {
			return pairCompare;
		} else {
			return kicker.compareTo(hm.kicker);
		}
	}

	@Override
	public String toString() {
		return "Pair of " + pairRank + "s, " + kicker + " high";
	}
}
