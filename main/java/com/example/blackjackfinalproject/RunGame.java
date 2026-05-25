package com.example.blackjackfinalproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * RunGame helps the game, black jack, function and run the game smoothly with the use of the
 * Player, Dealer, Card, and Deck clesses.
 * @author Sal Garcia
 */
public class RunGame {
    @FXML
    private Button hitButton;
    @FXML
    private HBox playerBox;
    @FXML
    private Button dealButton;
    @FXML
    private Button standButton;
    @FXML
    private Label winnerText;
    @FXML
    private HBox dealerBox;
    @FXML
    private Label playerValue;
    @FXML
    private Label dealersValue;
    @FXML
    private Button aceToEleven, aceToOne;


    private Deck deck;
    private Player player;
    private Dealer dealer;
    private Card card;

    /**
     *initalizes the Deck, Player, and Dealer objects for the game and shuffles the deck.
     */
    @FXML
    public void initialize(){
        deck = new Deck();
        deck.shuffle();
        player = new Player();
        dealer = new Dealer();
    }

    /**
     * allows for when the hit button is clicked it will pull a card from the deck,
     * change the text that displays the player's hand value, display the card on the screen, and check if the card
     * that was pulled was an Ace.
     *
     * @param event
     */
    @FXML
    public void onHitButtonClick(ActionEvent event) {
        Card cardPulled = deck.draw();
        player.addCard(cardPulled);
        String cardImage = Card.getCardImage(cardPulled);
        displayCard(cardImage, playerBox);


        if (cardPulled.getValue() == 1)
        {
            aceChoice();
        }
        else
        {
            setValue(player);
            checkPlayerBust();
        }
    }

    /**
     * when the AceToOne button is clicked it will set the value of the ace that was recently pulled to 1;
     * @param event
     */

    @FXML
    public void onAceToOneClick(ActionEvent event) {
        int lastIndex = player.getHand().getCardCollection().size() - 1;
        Card lastCard = player.getHand().getCard(lastIndex);
        lastCard.setValue(1);

        afterAceChoice();
    }
    /**
     * when the AceToEleven button is clicked it will set the value of the ace that was recently pulled to 11;
     * @param event
     */
    @FXML
    public void onAceToElevenClick(ActionEvent event) {
        int lastIndex = player.getHand().getCardCollection().size() - 1;
        Card lastCard = player.getHand().getCard(lastIndex);
        lastCard.setValue(0);

        afterAceChoice();
    }

    /**
     * called when an ace is pulled and disables the hit, stand, and deal buttons and enable the 11 and 1 buttons
     * for aces. Also making the 11 and 1 buttons visible.
     */
    private void aceChoice() {
        aceToOne.setDisable(false);
        aceToOne.setVisible(true);
        aceToEleven.setDisable(false);
        aceToEleven.setVisible(true);
        hitButton.setDisable(true);
        standButton.setDisable(true);
        dealButton.setDisable(true);
    }

    /**
     * Called after the value of an ace was chosen it will disable the 11 and 1 button and enable the stand, hit,
     * and deal buttons again as well as hide the 11 and 1 button. Also sets the value of the player's hand and checks
     * if they busted after the new value chosen.
     */
    private void afterAceChoice() {
        aceToOne.setDisable(true);
        aceToOne.setVisible(false);
        aceToEleven.setDisable(true);
        aceToEleven.setVisible(false);
        hitButton.setDisable(false);
        standButton.setDisable(false);
        dealButton.setDisable(false);

        setValue(player);
        checkPlayerBust();
    }

    /**
     * checks if the players hand is over 21 and will disable the hit button and display a text to inform the user
     * that they have busted.
     */
    private void checkPlayerBust() {
        Integer playersHandValue = player.getHand().getValue();
        if(playersHandValue > 21)
        {
            winnerText.setText("Busted. Dealer Wins \uD83D\uDC4E");
            hitButton.setDisable(true);
        }
    }

    /**
     * will enable all the buttons essential to playing the program and will reset the UI to its default look.
     * Also, will display the Players hand and the first card of the dealer but the back of the card of the second card
     * of the dealer, while also displaying the value of the hands.
     * @param event
     */
    @FXML
    public void onDealButtonClick(ActionEvent event){
        hitButton.setDisable(false);
        aceToOne.setVisible(false);
        aceToEleven.setVisible(false);
        aceToEleven.setDisable(true);
        aceToOne.setDisable(true);
        playerBox.getChildren().clear();
        dealerBox.getChildren().clear();
        winnerText.setText("");

        initialize();
        dealer.gettingDeck(deck);
        dealer.deal(player);
        for(int i = 0; i < 2; i++)
        {
            displayCard(Card.getCardImage(player.getHand().getCard(i)), playerBox);
        }
        displayCard(Card.getCardImage(dealer.getHand().getCard(0)), dealerBox);
        displayCard("backOfCard.png", dealerBox);

        setValue(player);
        Integer dealerHand = dealer.getHand().getValue(dealer.getHand().getCard(0));
        dealersValue.setText(dealerHand.toString());
    }

    /**
     * when the stand button is clicked it will display what the second card of the dealer's hand is and the dealer will
     * draw a card until their hand is either over or equal to 17. Then display the total value of the dealer's hand
     * and who won.
     * @param event
     */
    @FXML
    public void onStandButtonClick(ActionEvent event)
    {
        hitButton.setDisable(true);
        standButton.setDisable(false);

        dealerBox.getChildren().clear();
        for(int i = 0; i < 2; i++)
            displayCard(Card.getCardImage(dealer.getHand().getCard(i)), dealerBox);


        Integer totalValue = dealer.getHand().getValue();
        dealersValue.setText(totalValue.toString());

        while ((dealer.getHand().getValue() < 17) && (dealer.getHand().getValue() < player.getHand().getValue())){
            Card tempCard = deck.draw();
            dealer.addCard(tempCard);
            displayCard(Card.getCardImage(dealer.getHand().getCard(dealer.getHand().getCardCollection().size()- 1)), dealerBox);

            totalValue = dealer.getHand().getValue();
            dealersValue.setText(totalValue.toString());
        }

        boolean playerWon = Player.checkWinner(player, dealer);

        if(playerWon)
            winnerText.setText("You Win!!!");
        else if(player.getHand().getValue() == dealer.getHand().getValue())
            winnerText.setText("Tied :(");
        else
            winnerText.setText("You Lost :(");
    }

    /**
     * displays the value of either the players or dealers hand.
     * @param player
     */
    @FXML
    private void setValue(Player player)
    {
        Integer playersHandValue = player.getHand().getValue();
        playerValue.setText(playersHandValue.toString());
    }

    /**
     * displays the card with the same file name passed as a parameter and in the HBox passed as a parameter.
     * @param fileName
     * @param destination
     */
    private void displayCard(String fileName, HBox destination) {
        String path = "/com/example/blackjackfinalproject/images/" + fileName;
        var inputStream = getClass().getResourceAsStream(path);

        if (inputStream == null) {
            System.err.println("Could not find image: " + path);
            return;
        }

        Image cardImage = new Image(inputStream);
        ImageView cardView = new ImageView(cardImage);
        cardView.setFitWidth(65);
        cardView.setPreserveRatio(true);

        destination.getChildren().add(cardView);
    }
}


