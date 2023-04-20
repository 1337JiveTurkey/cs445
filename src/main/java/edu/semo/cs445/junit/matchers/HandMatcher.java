package edu.semo.cs445.junit.matchers;

/**
 * This is a complicated set of classes to implement a complicated set of logic.
 * HandMatchers first look at a hand and determine if they "fit" the hand. If
 * they do then a HandMatcher is created. After that HandMatchers are compared
 * to other HandMatchers to determine which one is the best fit for the hand.
 * Finally, the HandMatchers are compared again to determine which hand wins.
 *
 * @param <HM> This HandMatcher type for compareWithinRank.
 */
public interface HandMatcher<HM extends HandMatcher<HM>> extends Comparable<HandMatcher<?>> {
	/**
	 * The rank of this hand for comparison purposes.
	 *
	 * @return The HandRank for purposes of sorting HandMatchers.
	 */
	public HandRank getRank();

	/**
	 * Comparison within the same hand rank
	 *
	 * @param hm The HandMatcher to be compared to.
	 * @return -1, 0 or 1 depending on the ordering of the two hands.
	 */
	public int compareWithinRank(HM hm);

	/**
	 * Compare two HandMatchers to determine which one is the higher ranking
	 *
	 * @param hm the object to be compared.
	 * @return -1, 0 or 1 depending on the ordering of the two hands.
	 */
	@SuppressWarnings("unchecked")
	public default int compareTo(HandMatcher<?> hm) {
		// In the off chance we compare against ourselves
		if (hm == this) {
			return 0;
		}
		// Compare the rank of the hand as a first approximation
		int ranks = getRank().compareTo(hm.getRank());
		if (ranks != 0) {
			return ranks;
		}
		// This cast is safe so long as there's one HandMatcher per HandRank
		// Hand rank must be identical at this point so matcher is identical
		return compareWithinRank((HM) hm);
	}
}
