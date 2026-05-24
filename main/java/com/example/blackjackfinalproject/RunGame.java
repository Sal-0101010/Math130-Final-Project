package com.example.blackjackfinalproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

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

    @FXML
    public void initialize(){
        deck = new Deck();
        deck.shuffle();
        player = new Player();
        dealer = new Dealer();
    }

    @FXML
    public void onHitButtonClick(ActionEvent event) {
        Card cardPulled = deck.draw();
        player.addCard(cardPulled);
        String cardImage = Card.getCardImage(cardPulled);
        displayCard(cardImage, playerBox);
        setValue(player);

        if (cardPulled.getValue() == 1)
        {

            aceChoice();
        }
        else
        {
            checkPlayerBust();
        }
    }

    @FXML
    public void onAceToOneClick(ActionEvent event) {
        int lastIndex = player.getHand().getCardCollection().size() - 1;
        Card lastCard = player.getHand().getCard(lastIndex);
        lastCard.setValue(1);

        afterAceChoice();
    }

    @FXML
    public void onAceToElevenClick(ActionEvent event) {
        int lastIndex = player.getHand().getCardCollection().size() - 1;
        Card lastCard = player.getHand().getCard(lastIndex);
        lastCard.setValue(11);

        afterAceChoice();
    }

    private void aceChoice() {
        aceToOne.setDisable(false);
        aceToOne.setVisible(true);
        aceToEleven.setDisable(false);
        aceToEleven.setVisible(true);
        hitButton.setDisable(true);
        standButton.setDisable(true);
        dealButton.setDisable(true);
    }

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

    private void checkPlayerBust() {
        Integer playersHandValue = player.getHand().getValue();
        if(playersHandValue > 21)
        {
            winnerText.setText("Busted. Dealer Wins \uD83D\uDC4E");
            hitButton.setDisable(true);
        }
    }

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

    @FXML
    private void setValue(Player player)
    {
        Integer playersHandValue = player.getHand().getValue();
        playerValue.setText(playersHandValue.toString());
    }

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


