package edu.semo.cs445.junit;

/**
 * Record of a standard playing card. Comparable to other playing cards based on
 * rank followed by suit.
 *
 * @param rank The rank of this card
 * @param suit The suit of this card
 */
public record Card(CardRank rank, CardSuit suit) implements Comparable<Card> {
	/**
	 *
	 * @param card The card represented as a short string like "A♠"
	 * @return The card that the given string is equivalent to.
	 */
	public static Card of(String card) {
		CardRank rank = CardRank.of(card);
		CardSuit suit = CardSuit.of(card);
		if (rank == null || suit == null) {
			throw new IllegalArgumentException(card + " couldn't be parsed as a card.");
		}
		return new Card(rank, suit);
	}

	@Override
	public int compareTo(Card o) {
		int rankCompare = rank.compareTo(o.rank);
		int suitCompare = suit.compareTo(o.suit);
		if (rankCompare == 0) {
			return suitCompare;
		}
		return rankCompare;
	}

	public boolean equalRank(Card card) {
		return rank == card.rank;
	}

	public boolean equalSuit(Card card) {
		return suit == card.suit;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	/**
	 *
	 * @return A short string representation of the card.
	 */
	public String toShortString() {
		return rank.character + suit.symbol;
	}
}
