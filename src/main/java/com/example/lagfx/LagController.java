package com.example.lagfx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class LagController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}