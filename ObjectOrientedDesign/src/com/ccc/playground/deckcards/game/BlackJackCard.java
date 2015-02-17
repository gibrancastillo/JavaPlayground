package com.ccc.playground.deckcards.game;

import com.ccc.playground.deckcards.Card;

/**
 * A blackjack game, so we need to know the value of the cards.
 * Face cards are ten and an ace is 11 (most of the time, but that’s the job of the Hand class).
 * 
 * @author Gibran E. Castillo
 *
 */
public class BlackJackCard extends Card {
	public BlackJackCard(int r, Suit s) {
		super(r, s);
	}
	
	@Override
	public int value() {
		int r = super.value();
		
		if(r == 1) {
			return 11; // Aces are 11
		}
		
		if(r < 10) {
			return r;
		}
		
		return 10;
	}
	
	boolean isAce() {
		return super.value() == 1;
	}
}