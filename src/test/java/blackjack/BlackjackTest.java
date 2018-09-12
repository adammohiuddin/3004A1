package blackjack;

import junit.framework.TestCase;

public class BlackjackTest extends TestCase {

	public void testCardGets() {
		
		Card card = new Card(S, 7);
		assertEquals("S", card.getSuit());
		assertEquals("7", card.getRank());
		
	}
}
