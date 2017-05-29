package hu.unideb.sleepysam.view;

/*-
 * #%L
 * OrionTrail
 * %%
 * Copyright (C) 2017 University of Debrecen
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * #L%
 */

import hu.unideb.sleepysam.controller.SituationFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static hu.unideb.sleepysam.view.Main.logger;

/**
 * Created by vtibi on 5/21/2017.
 */
public class OutcomeController implements Initializable {
    @FXML
    private Label crewPastLabel;

    @FXML
    private Label crewDiffLabel;

    @FXML
    private Label crewResultLabel;

    @FXML
    private Label foodPastLabel;

    @FXML
    private Label foodDiffLabel;

    @FXML
    private Label foodResultLabel;

    @FXML
    private Label fuelPastLabel;

    @FXML
    private Label fuelDiffLabel;

    @FXML
    private Label fuelResultLabel;

    @FXML
    private Label outcomeTextDisplay;

    @FXML
    public void handleNextButton() {
        Main.game.setCurrentSituation(SituationFactory.getRandomSituation());

        Stage stage;
        Parent root;

        logger.info("Condition {}", Main.game.getCrew() <= 0 || Main.game.getFood() <= 0 || Main.game.getFuel() <= 0);

        if(Main.game.getCrew() <= 0 || Main.game.getFood() <= 0 || Main.game.getFuel() <= 0) {
            logger.info("Game lost branch");
            Main.game.resetGame();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("loseScreen.fxml"));
                root = loader.load();
                loader.<LoseScreenController>getController();
                stage = (Stage) crewPastLabel.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception");
                // logger.debug("The exception: " + e.getMessage());
            }
        }
        else if(Main.game.getVictoryCounter() != Main.game.getWinGoal()) {
            logger.info("Moving...");
            logger.info("Crew: {}", Main.game.getCrew());
            logger.info("Food: {}", Main.game.getFood());
            logger.info("Fuel: {}", Main.game.getFuel());
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("situation.fxml"));
                root = loader.load();
                loader.<SituationController>getController();
                stage = (Stage) crewPastLabel.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception");
                // logger.debug("The exception: " + e.getMessage());
            }
        }
        else {
            logger.info("Game won branch");
            Main.game.resetGame();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("winScreen.fxml"));
                root = loader.load();
                loader.<WinScreenController>getController();
                stage = (Stage) crewPastLabel.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                System.out.println("Exception");
                // logger.debug("The exception: " + e.getMessage());
            }
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        crewPastLabel.setText(String.valueOf(Main.game.getCrew() - Main.game.getLastChosenOption().getOutcomeCrewDiff()));
        foodPastLabel.setText(String.valueOf(Main.game.getFood() - Main.game.getLastChosenOption().getOutcomeFoodDiff()));
        fuelPastLabel.setText(String.valueOf(Main.game.getFuel() - Main.game.getLastChosenOption().getOutcomeFuelDiff()));

        crewDiffLabel.setText(String.valueOf(Main.game.getLastChosenOption().getOutcomeCrewDiff()));
        foodDiffLabel.setText(String.valueOf(Main.game.getLastChosenOption().getOutcomeFoodDiff()));
        fuelDiffLabel.setText(String.valueOf(Main.game.getLastChosenOption().getOutcomeFuelDiff()));

        crewResultLabel.setText(String.valueOf(Main.game.getCrew()));
        foodResultLabel.setText(String.valueOf(Main.game.getFood()));
        fuelResultLabel.setText(String.valueOf(Main.game.getFuel()));

        outcomeTextDisplay.setText(Main.game.getLastChosenOption().getOutcomeText());
    }
}
