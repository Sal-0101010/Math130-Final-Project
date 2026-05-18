package com.example.blackjackfinalproject;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GameController {
    @FXML
    private Button hitButton;

    @FXML
    public void initialize() {
        System.out.println("Game screen loaded successfully!");
    }
}
