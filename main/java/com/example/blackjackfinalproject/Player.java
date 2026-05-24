package com.example.blackjackfinalproject;

/**
 * Player initalizes a hand object, stores Card objects in the hand, and checks the Winner of the game.
 * @author Sal Garcia
 */
public class Player {
   private Hand hand = new Hand();

   /**
    * adds the Card object to the Hand array list
    * @param card
    */
   public void addCard(Card card)
   {
      hand.addCard(card);
   }

   /**
    * returns the hand array list of the player.
    * @return
    */
   public Hand getHand()
   {
       return hand;
   }

   /**
    * returns true if the dealer busted or the player has a grater vlaue hand under or equal to 21 and returns false if the
    * player busted or if the dealer has a greater or equal value hand than the player.
    * @param player
    * @param dealer
    * @return
    */
   public static boolean checkWinner(Player player, Dealer dealer)
   {
      int playerTotal = player.getHand().getValue();
      int dealerTotal = dealer.getHand().getValue();

      if(playerTotal > 21)
         return false;
      if (dealerTotal > 21)
         return true;
      return playerTotal > dealerTotal;
   }
}
