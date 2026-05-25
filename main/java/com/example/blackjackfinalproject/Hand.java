package com.example.blackjackfinalproject;

/**
 * Hand is a child class of the CardCollection class that holds each card that is in a players hand
 *
 * @author Sal Garcia
 */
public class Hand extends CardCollection {
    /**
     * adds the card object passed in the parameter to the array list of the hand given through card collection class.
     * @param card
     */
    public void addToHand(Card card)
    {
        addCard(card);
    }

    /**
     * gets the value of the entire hand with face cards ceing 10.
     * @return int
     */
    public int getValue()
    {
        int value = 0;
        for(int i = 0; i < getCardCollection().size(); i++)
        {
            if(getCard(i).getValue() > 10 && getCard(i).getValue() <= 13)
                value += 10;
            else if(getCard(i).getValue() == 0)
                value += 11;
            else
                value += getCard(i).getValue();

        }
        return value;
    }

    /**
     * gets the value of the card object passed in the parameter, makes it equal to 10 if it is a face card and
     * and then passes the value as 10.
     * @param card
     * @return
     */
    public int getValue(Card card)
    {
            if(card.getValue() > 10)
                return 10;
            else
                return card.getValue();
    }
}
