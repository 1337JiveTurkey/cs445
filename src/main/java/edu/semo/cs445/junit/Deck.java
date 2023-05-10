package edu.semo.cs445.junit;

import java.util.*;
import java.util.random.RandomGenerator;

/**
 * Shuffled deck of cards.
 */
public class Deck {
	private static final RandomGenerator RNG = RandomGenerator.of("L64X256MixRandom");

	private final Deque<Card> cards;

	/**
	 * Create a new deck of cards, pre-shuffled
	 */
	public Deck() {
		List<Card> tempCards = new ArrayList<>();
		// Initialize the contents of the deck
		for (CardSuit suit : CardSuit.values()) {
			for (CardRank rank : CardRank.values()) {
				tempCards.add(new Card(rank, suit));
			}
		}
		// Shuffle
		synchronized (RNG) {
			for (int i = tempCards.size(); i > 1; i--)
				Collections.swap(tempCards, i - 1, RNG.nextInt(i));
		}
		cards = new ArrayDeque<>(tempCards);
	}

	public Card peek() {
		return cards.peekFirst();
	}

	public Card drawCard() {
		return cards.removeFirst();
	}

	public Hand dealHand() {
		return null;
	}

	public boolean hasCardsLeft() {
		return !cards.isEmpty();
	}

	public int cardsLeft() {
		return cards.size();
	}
}
