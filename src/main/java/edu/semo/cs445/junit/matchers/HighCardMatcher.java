package edu.semo.cs445.junit.matchers;

import edu.semo.cs445.junit.Card;

public class HighCardMatcher implements HandMatcher<HighCardMatcher> {
	private Card highCard;
	@Override
	public HandRank getRank() {
		return HandRank.HighCard;
	}

	@Override
	public int compareWithinRank(HighCardMatcher hm) {
		return highCard.compareTo(hm.highCard);
	}

	public String toString() {
		return highCard + " high";
	}
}
