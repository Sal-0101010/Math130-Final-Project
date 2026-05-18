package com.example.blackjackfinalproject;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;

public class HelloController implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private Label Label1;

    @FXML
    private Spinner<Integer> players;

    @FXML
    private Button playButton;

    // This runs automatically when the first screen opens
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up your spinner here
        SpinnerValueFactory<Integer> spinFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1);
        players.setValueFactory(spinFactory);
    }

    @FXML
    private void handleButtonClick(ActionEvent event) {
        try {
            // Loading the second view
            FXMLLoader loader = new FXMLLoader(getClass().getResource("second-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            System.err.println("Could not find second-view.fxml. Check the filename!");
            e.printStackTrace();
        }
    }
}

