package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.Card;
import edu.semo.cs445.junit.CardRank;

public class ThreeOfAKindMatcher implements HandMatcher<ThreeOfAKindMatcher> {
	private CardRank tripleRank;
	private Card kicker;

	@Override
	public HandRank getRank() {
		return HandRank.ThreeOfAKind;
	}

	@Override
	public int compareWithinRank(ThreeOfAKindMatcher hm) {
		int tripleCompare = tripleRank.compareTo(hm.tripleRank);
		if (tripleCompare != 0) {
			return tripleCompare;
		} else {
			return kicker.compareTo(hm.kicker);
		}
	}

	@Override
	public String toString() {
		return "Three " + tripleRank + "s, " + kicker + " high";
	}
}
