package edu.semo.cs445.junit;

/**
 * Record of a standard playing card. Comparable to other playing cards based on
 * rank followed by suit.
 *
 * @param rank The rank of this card
 * @param suit The suit of this card
 */
public record Card(CardRank rank, CardSuit suit) implements Comparable<Card> {
	@Override
	public int compareTo(Card o) {
		int rankCompare = rank.compareTo(o.rank);
		int suitCompare = suit.compareTo(o.suit);
		if (rankCompare == 0) {
			return suitCompare;
		}
		return rankCompare;
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	public String toShortString() {
		return rank.character + suit.symbol;
	}

	public static Card of(String card) {
		CardRank rank = CardRank.of(card);
		CardSuit suit = CardSuit.of(card);
		if (rank == null || suit == null) {
			throw new IllegalArgumentException(card + " couldn't be parsed as a card.");
		}
		return new Card(rank, suit);
	}
}
