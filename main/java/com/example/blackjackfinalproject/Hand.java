package com.example.blackjackfinalproject;

public class Hand extends CardCollection {
    public void addToHand(Card card)
    {
        addCard(card);
    }

    public int getValue()
    {
        int value = 0;
        for(int i = 0; i < getCardCollection().size(); i++)
        {
            if(getCard(i).getValue() > 10)
                value += 10;
            else
                value += getCard(i).getValue();

        }
        return value;
    }
    public int getValue(Card card)
    {
            if(card.getValue() > 10)
                return 10;
            else
                return card.getValue();
    }
}
