package edu.semo.cs445.junit;

/**
 * Playing card ranks.
 */
public enum CardRank {
	Two("2"),
	Three("3"),
	Four("4"),
	Five("5"),
	Six("6"),
	Seven("7"),
	Eight("8"),
	Nine("9"),
	Ten("10"),
	Jack("J"),
	Queen("Q"),
	King("K"),
	Ace("A"),
	;

	public final String character;

	CardRank(String character) {
		this.character = character;
	}

	public static CardRank of(String card) {
		for (CardRank rank : values()) {
			if (card.contains(rank.character)) {
				return rank;
			}
		}
		return null;
	}
}
