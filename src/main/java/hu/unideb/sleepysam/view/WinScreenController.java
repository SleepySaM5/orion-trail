package hu.unideb.sleepysam.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

import static hu.unideb.sleepysam.view.Main.logger;

/**
 * Created by SleepySam on 5/27/2017.
 */
public class WinScreenController {
    @FXML
    private Button startGameAgain;

    @FXML
    private void handleStartGameAgainButton () {
        logger.info("startGameAgain button pressed...");
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/startScreen.fxml"));
            root = loader.load();
            loader.<StartScreenController> getController();
            stage = (Stage) startGameAgain.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
