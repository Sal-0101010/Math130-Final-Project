package com.example.blackjackfinalproject;

import java.util.ArrayList;
import java.util.Random;

/**
 * Deck is one of the child classes of CardCollection and has all the functions that a deck would have
 * such as suffle and draw.
 * @author Sal Garcia
 */
public class Deck extends CardCollection {
    /**
     * default constructor that initalizes the deck in order from Ace to King suit from suit.
     */
    public Deck()
    {
        char[] suits = { Card.HEART, Card.DIAMOND, Card.CLUB, Card.SPADE};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                addCard(new Card(j + 1, suits[i]));
            }
        }
    }

    /**
     * shuffles the deck in a random order.
     */
    public void shuffle(){
        Random rand = new Random();
        ArrayList<Card> deck = getCardCollection();
        int n = deck.size();

        for (int i = n - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = rand.nextInt(i + 1);

            // Swap elements at i and j
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    /**
     * takes the first card of the deck, removes it and then returns the card that was pulled.
     * @return Card
     */
    public Card draw()
    {
        Card card = getCardCollection().getFirst();
        getCardCollection().removeFirst();
        return card;
    }



}
