package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.Card;
import edu.semo.cs445.junit.CardRank;

public class FourOfAKindMatcher implements HandMatcher<FourOfAKindMatcher> {
	private CardRank quadRank;
	private Card kicker;

	@Override
	public HandRank getRank() {
		return HandRank.FourOfAKind;
	}

	@Override
	public int compareWithinRank(FourOfAKindMatcher hm) {
		int quadCompare = quadRank.compareTo(hm.quadRank);
		if (quadCompare != 0) {
			return quadCompare;
		} else {
			return kicker.compareTo(hm.kicker);
		}
	}

	@Override
	public String toString() {
		return "Four " + quadRank + "s, " + kicker + " high";
	}

}
