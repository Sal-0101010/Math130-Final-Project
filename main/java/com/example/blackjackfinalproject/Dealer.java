package com.example.blackjackfinalproject;

/**
 * Dealer is a child class to the Player class which has specified functions that a dealer would have in a game
 * of blackjack.
 *
 * @author Sal Garcia
 */
public class Dealer extends Player {
    private Deck deck;

    /**
     * adds a Card to the Dealers hand.
     * @param card
     */
    public void addCard(Card card)
    {
       super.addCard(card);
    }

    /**
     * gives cards to the player and the dealer alternately and added to their Hand through the use of the addCard method.
     * @param player
     */
    public void deal(Player player) {
        player.addCard(deck.draw());
        addCard(deck.draw());
        player.addCard(deck.draw());
        addCard(deck.draw());
    }

    /**
     * initalizes the deck that the Dealer has to the same that is initalized in the main so when removing a card or
     * drawing a card at random it's the same as in the main.
     * @param deck
     */
    public void gettingDeck(Deck deck)
    {
        this.deck = deck;
    }


}
