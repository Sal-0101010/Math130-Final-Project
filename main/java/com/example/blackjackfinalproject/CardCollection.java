package com.example.blackjackfinalproject;
/**
 * Represents a collection of cards specifically playing Cards with the implementation of the Card class
 *
 * @author Sal Garcia
 * @version 0.0 alpha
 */

import java.util.ArrayList;
public class CardCollection {
    private ArrayList<Card> cardCollection;

    /**
     * default constructor: initalizes an ArrayList.
     */
    public CardCollection()
    {
        cardCollection = new ArrayList<>();
    }

    /**
     * adds a Card to the cardCollection array list
     * @param card
     */
    public void addCard(Card card)
    {
        cardCollection.add(card);
    }

    /**
     * removes a specified card from the array list
     * @param card
     */
    public void removeCard(Card card)
    {
        cardCollection.remove(card);
    }

    /**
     * gets the Card in the index "index" and returns it.
     * @param index
     * @return Card
     */
    public Card getCard(int index)
    {
        return cardCollection.get(index);
    }

    /**
     * allows to get the whole array list in order to call functions specified to array lists like .size().
     * @return ArrayList<Card>
     */
    public ArrayList<Card> getCardCollection()
    {
        return cardCollection;
    }

}
