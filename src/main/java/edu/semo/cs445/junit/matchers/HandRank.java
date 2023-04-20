package edu.semo.cs445.junit.matchers;

/**
 * The rank of a hand (in contrast to that of a card) is the type of hand for
 * purposes of determining who won. These are in order of worst to best by
 * what the hand contains. Note that a royal flush is just a straight flush,
 * aces high.
 */
public enum HandRank {
	HighCard,       // Nothing
	Pair,           // Pair of cards of the same rank
	TwoPair,        // Two pairs of cards
	ThreeOfAKind,   // Three cards of the same rank
	Straight,       // Five cards in order
	Flush,          // Five cards of the same suit
	FullHouse,      // A pair plus a separate three of a kind
	FourOfAKind,    // Four cards of the same rank
	StraightFlush,  // Five cards of the same suit in order
	;
}
