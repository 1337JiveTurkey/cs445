package edu.semo.cs445.junit;

/**
 * Playing card suits.
 */
@SuppressWarnings("UnnecessaryUnicodeEscape")
public enum CardSuit {
	Clubs   ("\u2663", "C"),
	Diamonds("\u2666", "D"),
	Hearts  ("\u2665", "H"),
	Spades  ("\u2660", "S"),
	;
	public final String symbol;
	public final String letter;

	private CardSuit(String symbol, String letter) {
		this.symbol = symbol;
		this.letter = letter;
	}

	public static CardSuit of(String card) {
		for (CardSuit suit : values()) {
			if (card.contains(suit.symbol) || card.contains(suit.letter)) {
				return suit;
			}
		}
		return null;
	}
}
