package edu.semo.cs445.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestCardsDemo {

	@Test
	public void topCardIsNotDuplicatedThroughoutDeck() {
		Deck deck = new Deck();
		Card originalCard = deck.drawCard();
		while (deck.hasCardsLeft()) {
			Assertions.assertNotEquals(originalCard, deck.drawCard());
		}
	}

	@Test
	public void twoDecksAreShuffledDifferently() {
		Deck deck1 = new Deck();
		Deck deck2 = new Deck();
		int sameCount = 0;
		while (deck1.hasCardsLeft() && deck2.hasCardsLeft()) {
			Card card1 = deck1.drawCard();
			Card card2 = deck2.drawCard();
			if (card1.equals(card2)) {
				sameCount++;
			}
		}
		// Unlikely to the point of impossible if it's sorting at all
		Assertions.assertNotEquals(52, sameCount,
				"Two identically shuffled decks!");
	}

	@Test
	public void aceIsHigherThanKing() {
		Card aceOfSpades = Card.of("A♠");
		Card kingOfSpades = Card.of("K♠");
		Assertions.assertEquals(1, aceOfSpades.compareTo(kingOfSpades),
				"Rank comparisons not working right.");
	}

	@Test
	public void spadesAreHigherThanHearts() {
		Card aceOfSpades = Card.of("A♠");
		Card aceOfHearts = Card.of("A♥");
		Assertions.assertEquals(1, aceOfSpades.compareTo(aceOfHearts),
				"Suit comparisons not working right.");
	}

	@Test
	public void ranksBeatSuitsInComparison() {
		Card aceOfHearts = Card.of("A♥");
		Card kingOfSpades = Card.of("K♠");
		Assertions.assertEquals(1, aceOfHearts.compareTo(kingOfSpades),
				"Rank should make the ace beat the king regardless of suit.");
	}
}
