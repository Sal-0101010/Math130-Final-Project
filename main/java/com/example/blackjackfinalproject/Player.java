package com.example.blackjackfinalproject;

public class Player {
   private Hand hand = new Hand();

   public void hit (Card card)
   {
       hand.addCard(card);
   }
   public void addCard(Card card)
   {
      hand.addCard(card);
   }
   public Hand getHand()
   {
       return hand;
   }

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
