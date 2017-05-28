package hu.unideb.sleepysam.view;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static hu.unideb.sleepysam.view.Main.logger;

/**
 * Created by vtibi on 5/24/2017.
 */
public class StartScreenController implements Initializable {
    @FXML
    private Button newGameButton;

    @FXML
    private Label currentDifficultyLabel;

    @FXML
    private void handleNewGameButton() {
        logger.info("New game started!");
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/situation.fxml"));
            root = loader.load();
            loader.<SituationController> getController();
            stage = (Stage) newGameButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleEasyDifficultyButton() {
        logger.info("Easy difficulty chosen.");
        Main.game.setStartCrew(9);
        Main.game.setStartFuel(9);
        Main.game.setStartFood(9);
        Main.game.setWinGoal(5);
        Main.game.resetGame();

        currentDifficultyLabel.setText("Easy");
    }

    @FXML
    private void handleMediumDifficultyButton() {
        logger.info("Medium difficulty chosen.");
        Main.game.setStartCrew(6);
        Main.game.setStartFuel(6);
        Main.game.setStartFood(6);
        Main.game.setWinGoal(7);
        Main.game.resetGame();

        currentDifficultyLabel.setText("Medium");
    }

    @FXML
    private void handleHardDifficultyButton() {
        logger.info("Hard difficulty chosen.");
        Main.game.setStartCrew(3);
        Main.game.setStartFuel(3);
        Main.game.setStartFood(3);
        Main.game.setWinGoal(9);
        Main.game.resetGame();

        currentDifficultyLabel.setText("Hard");
    }

    public void initialize(URL location, ResourceBundle resources) {
        Main.game.setStartCrew(9);
        Main.game.setStartFuel(9);
        Main.game.setStartFood(9);
        Main.game.setWinGoal(5);
        Main.game.resetGame();

        currentDifficultyLabel.setText("Easy");
    }
}
