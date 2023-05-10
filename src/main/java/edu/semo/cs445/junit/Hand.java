package edu.semo.cs445.junit;

import java.util.*;

/**
 * A sorted set of cards used to determine who won a round of poker.
 */
public class Hand {
	private final NavigableSet<Card> cards = new TreeSet<>();

	public Hand() {

	}

	/**
	 * Creates a hand which is represented by a string giving the ranks
	 * and suits of each card in the hand, separated by spaces.
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

	/**
	 *
	 * @return The highest card in the hand, if any.
	 */
	public Card getHighCard() {
		if (cards.isEmpty()) {
			return null;
		}
		return cards.last();
	}

	public Set<Card> getPair() {
		return null;
	}

	public CardSuit getFlush() {
		for (CardSuit suit : CardSuit.values()) {
			// Greater than five to allow for 7-card stud and the like
			if (getNumberOfSuit(suit) >= 5) {
				return suit;
			}
		}
		return null;
	}

	/**
	 * Gets the number of cards of a given rank.
	 *
	 * @param rank The rank to search for.
	 * @return The number of cards of that rank.
	 */
	public int getNumberOfRank(CardRank rank) {
		int count = 0;
		for (Card card : cards) {
			if (card.rank() == rank) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Gets the number of cards of a given suit.
	 *
	 * @param suit The suit to search for.
	 * @return The number of cards of that suit.
	 */
	public int getNumberOfSuit(CardSuit suit) {
		int count = 0;
		for (Card card : cards) {
			if (card.suit() == suit) {
				count++;
			}
		}
		return count;
	}
}
