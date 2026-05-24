package com.example.blackjackfinalproject;

public class Dealer extends Player {
    private Deck deck;
    public void addCard(Card card)
    {
       super.addCard(card);
    }
    public void deal(Player player)
    {
        player.addCard(deck.draw());
        addCard(deck.draw());
        player.addCard(deck.draw());
        addCard(deck.draw());
    }

    public void gettingDeck(Deck deck)
    {
        this.deck = deck;
    }


}
