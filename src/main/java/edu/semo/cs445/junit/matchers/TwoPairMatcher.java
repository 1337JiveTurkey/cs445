package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.Card;
import edu.semo.cs445.junit.CardRank;

public class TwoPairMatcher implements HandMatcher<TwoPairMatcher> {
	private CardRank highPairRank;
	private CardRank lowPairRank;
	private Card kicker;

	@Override
	public HandRank getRank() {
		return HandRank.TwoPair;
	}

	@Override
	public int compareWithinRank(TwoPairMatcher hm) {
		int highPairCompare = highPairRank.compareTo(hm.highPairRank);
		if (highPairCompare != 0) {
			return highPairCompare;
		}
		int lowPairCompare = lowPairRank.compareTo(hm.lowPairRank);
		if (lowPairCompare != 0) {
			return lowPairCompare;
		} else {
			return kicker.compareTo(hm.kicker);
		}
	}

	@Override
	public String toString() {
		return "Pair of " + highPairRank + "s over pair of " + lowPairRank + "s";
	}
}
