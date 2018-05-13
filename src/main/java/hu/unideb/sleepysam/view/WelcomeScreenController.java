package hu.unideb.sleepysam.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static hu.unideb.sleepysam.view.Main.logger;

public class WelcomeScreenController {

    @FXML
    private Button startGameButton;

    @FXML
    private void handleStartGameButton() {
        logger.info("New game started!");
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/startScreen.fxml"));
            root = loader.load();
            loader.<SituationController> getController();
            stage = (Stage) startGameButton.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
