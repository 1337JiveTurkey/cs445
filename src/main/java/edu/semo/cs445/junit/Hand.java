package edu.semo.cs445.junit;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A sorted set of cards used to determine who won a round of poker.
 */
public class Hand {
	private final SortedSet<Card> cards = new TreeSet<>();

	public Hand() {

	}

	@Override
	public String toString() {
		return super.toString();
	}

	/**
	 * Creates a hand which is
	 *
	 * @param handString The space-delimited string representation of the hand.
	 * @return The hand associated with the string.
	 */
	public static Hand of(String handString) {
		String[] cardStrings = handString.toUpperCase().split("\\s+");
		Card[] cards = Arrays.stream(cardStrings).map(Card::of).toArray(Card[]::new);
		return Hand.of(cards);
	}

	public static Hand of(Card... cards) {
		Hand hand = new Hand();
		hand.cards.addAll(Arrays.asList(cards));
		return hand;
	}
}
