package com.ccc.playground.deckcards;

/**
 * Design the data structures for a generic deck of cards.  Explain how you would sub-class it to implement particular card games.
 * 
 * A generic deck of cards contains four suits (clubs, spades, hearts, and diamonds) and a suit contains 13 cards.  Each card has a numerical value from 1 to 13.
 * If you think about a card game, different games differ from ways of dealing cards and putting cards back in.
 * 
 * @author Gibran E. Castillo
 *
 */
public class Card {
	
	/**
	 * Suit is just a label.  It does not need to be a separate class therefore a enumeration class is enough.
	 * We don't really need a wrapper class 'Deck' to be around a normal card.
	 * 
	 * @author Gibran E. Castillo
	 *
	 */
	public enum Suit {
		CLUBS(1), SPADES(2), HEARTS(3), DIAMONDS(4);
		
		int value;
		private Suit(int v) {
			value = v;
		}
	};
	
	private int card;
	private Suit suit;
	
	public Card(int r, Suit s) {
		card = r;
		suit = s;
	}
	
	public int value() {
		return card;
	}
	
	public Suit suit() {
		return suit;
	}
}