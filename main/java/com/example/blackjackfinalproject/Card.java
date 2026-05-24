package com.example.blackjackfinalproject;

/**
 * Represents one playing card from a standard 52-card deck
 * (https://en.wikipedia.org/wiki/Playing_card)
 *
 * Class Invariant:
 * - Card value represents the number/letter printed on the card,
 * usually in the corners (A, 2, 3, ..., 9, 10, J, Q, K)
 * - Card value is stored as an integer to make error checking/validation
 * easier,
 * but must be outputted appropriately (1 is A, 11 is J, 12 is Q, 13 is K) for
 * user
 * - Card suit represents one of 4 suits (heart, diamond, club, spade)
 * - Card suit is stored as the unicode char representing the suit,
 * constant variables will be used throughout code for consistency
 * - Whenever value/suit is changed, it must be within the valid values
 *
 * @author Sal Garcia
 * @version 0.0 alpha
 */

public class Card {

    /*** CONSTANT VARIABLES ***/

    public static final char HEART = 'h';//♥
    public static final char DIAMOND = 'd';
    public static final char CLUB = 'c';//♣
    public static final char SPADE = 's';//♠
    public static final int DEFAULT_VALUE = 1;
    public static final int DEFAULT_SUIT = 'h';

    /*** INSTANCE VARIABLES ***/
    private int value;
    private char suit;

    /*** CONSTRUCTOR METHODS ***/
    /**
     * Default constructor, builds default card object as: A ♥
     */
    public Card() {
        this.value = DEFAULT_VALUE;
        this.suit = DEFAULT_SUIT;
    }

    /**
     * Full constructor builds object with all data for instance variables provided.
     * If arguments are not valid, program shuts down with error message
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     * @param suit  one of four suit values (unicode value for heart, diamond,
     *              spade, or club)
     */
    public Card(int value, char suit) {
        if ((value >= 1 && value <= 13) && (suit == HEART || suit == SPADE
                || suit == CLUB || suit == DIAMOND)) {
            this.value = value;
            this.suit = suit;
        }
        else
        {
            System.err.println("Not valid input");
            System.exit(1);
        }
    }

    /**
     * Copy constructor builds object with all data from Card object provided. No
     * changes made to original object, no shallow copying
     *
     * @param original Card object to be copied
     */
    public Card(Card original)
    {
        if (original == null) {
            System.err.println("Please provide a reference to a card object (not null)");
            System.exit(1);
        }
        else
        {
            setAll(original.value, original.suit);
        }

    }

    /*** MUTATOR METHODS (SETTERS) ***/



    /**
     * Sets value for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occured (false) or
     * operation completed successfully (true)
     *
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     *
     * @return true if card value is between 1 and 13 (inclusive), false otherwise
     */
    public boolean setValue(int value) {
        if(value >= 1 && value <= 13)
        {
            this.value = value;
            return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * Sets suit for card only if valid, otherwise will not change instance
     * variable. Returns boolean representing whether error occured (false) or
     * operation completed successfully (true)
     *
     * @param suit one of four suit values (unicode value for heart, diamond, spade,
     *             or club)
     *
     * @return true if card suit is unicode value for heart, diamond, club or spade.
     *         false otherwise
     */
    public boolean setSuit(char suit) {
        if (suit == HEART || suit == SPADE
                || suit == HEART || suit == DIAMOND) {
            this.suit = suit;
            return true;
        } else {
            return false;
        }

    }

    /**
     * Sets suit and value for card only if valid, returns boolean representing
     * whether error occured (false) or operation completed successfully (true)
     *
     * @param suit  one of four suit values (unicode value for heart, diamond,
     *              spade, or club)
     * @param value numerical value of card (1-13), not what shows on card (A, 2-10,
     *              J, Q, K)
     *
     * @return true if card suit AND value are valid, false otherwise
     */
    public boolean setAll(int value, char suit)
    {
        return setValue(value) && setSuit(suit);
    }

    /*** ACCESSOR METHODS (GETTERS) ***/

    /**
     * Access unicode character representing suit of card
     *
     * @return suit as unicode character for heart, spade, diamond, or club
     */
    public char getSuit()
    {
        return suit;
    }

    /**
     * Access numerical value of card (1-13)
     *
     * @return value as raw integer 1-13 (not what player sees as A, 2-10, J, Q, K;
     *         see {@link #getPrintValue()})
     */
    public int getValue()
    {
        return value;
    }
    /**
     * Access value of card as seen by user (A, 2-10, J, Q, K) that would be printed
     * on card
     *
     * @return value as String user sees on card (A, 2-10, J, Q, K), not numerical
     *         value 1-13 (see {@link #getValue()})
     */

    public String getPrintValue()
    {
        if(value == 1)
            return "A";
        else if (value == 11)
            return "J";
        else if (value == 12)
            return "Q";
        else if (value == 13)
            return "K";
        else
            return String.valueOf(value);


    }

    /**
     * Access ASCII art version of card data, each line separated by newline
     * character, no newline character at end of String
     *
     * @return String containing ASCII art with card suit and card print value
     */
    public String getPrintCard()
    {
        String dash = "-------";
        String top = "|" + suit + "   " + suit + "|";
        String middle = "|  " + getPrintValue() + "  |";
        return (dash + "\n" + top + "\n" + middle + "\n" + top + "\n" + dash);
    }

    /*** OTHER REQUIRED METHODS ***/

    /**
     * String of all instance variables, no newline character at end of String.
     * Using print value to use as "condensed" version of printed card (ex: A ♥)
     *
     * @return String containing (print) value and suit, separated by a space
     */
    public String toString()
    {
        return (getPrintValue() + " " + suit);
    }
    /**
     * Checking for equality of Card objects, all instance variables exactly equal
     * to each other (case-sensitive). Argument object not changed
     *
     * @param otherCard Card object to compare for equality
     *
     * @return boolean representing equality between both objects, all data is
     *         exactly equal to each other
     */
    public boolean equals(Card otherCard)
    {
        return ((otherCard.suit == this.suit) && (otherCard.value == this.value));
    }

    /*** EXTRA METHODS ***/

    /**
     * Prints card ASCII art to console (see {@link #getPrintCard()})
     */
    public void printCard() {
        System.out.println(getPrintCard());
    }
    public static String getCardImage(Card card)
    {
        return card.getSuit() + card.getPrintValue() + ".png";
    }

    public Card setValue(Card card, int value)
    {
        card.setValue(value);
        return card;
    }


}
