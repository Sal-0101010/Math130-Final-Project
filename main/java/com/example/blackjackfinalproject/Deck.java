package com.example.blackjackfinalproject;

import java.util.ArrayList;
import java.util.Random;
//is a collection of cards
//methods: value, suit, one decks, parent class: card collection w the sub-classes Hand, Deck
public class Deck extends CardCollection {
    public Deck()
    {
        char[] suits = { Card.HEART, Card.DIAMOND, Card.CLUB, Card.SPADE};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                addCard(new Card(j + 1, suits[i]));
            }
        }
    }

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

    public Card draw()
    {
        Card card = getCardCollection().getFirst();
        getCardCollection().removeFirst();
        return card;
    }



}
