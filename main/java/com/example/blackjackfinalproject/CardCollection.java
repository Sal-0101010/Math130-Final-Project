package com.example.blackjackfinalproject;

import java.util.ArrayList;
public class CardCollection {
    private ArrayList<Card> cardCollection;
    public CardCollection()
    {
        cardCollection = new ArrayList<>();
    }
    public void addCard(Card card)
    {
        cardCollection.add(card);
    }
    public void removeCard(Card card)
    {
        cardCollection.remove(card);
    }
    public Card getCard(int index)
    {
        return cardCollection.get(index);
    }
    public ArrayList<Card> getCardCollection()
    {
        return cardCollection;
    }

}
