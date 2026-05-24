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

/**
 * connects the two scenes together so when the play button is pressed the scene will change to the second scene.
 * @author Sal Garcia
 */
public class SceneConnector implements Initializable {

    @FXML
    private Label welcomeText;

    @FXML
    private Label Label1;

    @FXML
    private Spinner<Integer> players;

    @FXML
    private Button playButton;


    /**
     * displays the spinner and sets the max integer to 4 and the minimum to 1
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set up your spinner here
        SpinnerValueFactory<Integer> spinFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 4, 1);
        players.setValueFactory(spinFactory);
    }

    /**
     * switches the scene from the welcoming scene to the blackjack scene.
     * @param event
     */
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

