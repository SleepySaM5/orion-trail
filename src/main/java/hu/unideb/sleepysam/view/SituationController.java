//CHECKSTYLE:OFF
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
 * Created by vtibi on 5/21/2017.
 */
public class SituationController implements Initializable {
    @FXML
    private Label positionLabel;
    @FXML
    private Label crewLabel;
    @FXML
    private Label foodLabel;
    @FXML
    private Label fuelLabel;
    @FXML
    private Label flavorTextLabel;
    @FXML
    private Button option1Button;
    @FXML
    private Button option2Button;
    @FXML
    private Button option3Button;
    @FXML
    private Label winGoalLabel;

    @FXML
    private void handleOption1Button() {
        logger.info("Option 1 chosen...");
        Main.game.applyChosenOption(Main.game.getCurrentSituation().getOption1());
        changeViewToOutcome();
    }

    @FXML
    private void handleOption2Button() {
        logger.info("Option 2 chosen...");
        Main.game.applyChosenOption(Main.game.getCurrentSituation().getOption2());
        changeViewToOutcome();
    }

    @FXML
    private void handleOption3Button() {
        logger.info("Option 3 chosen...");
        Main.game.applyChosenOption(Main.game.getCurrentSituation().getOption3());
        changeViewToOutcome();
    }

    public void changeViewToOutcome(){
        logger.info("Call to changeViewToOutcome");
        Stage stage;
        Parent root;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("outcome.fxml"));
            root = loader.load();
            loader.<OutcomeController>getController();
            stage = (Stage) option1Button.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Exception");
            // logger.debug("The exception: " + e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.game.incrementVictoryCounter();

        positionLabel.setText(String.valueOf(Main.game.getVictoryCounter()));
        winGoalLabel.setText(" / " + String.valueOf(Main.game.getWinGoal()));
        crewLabel.setText(String.valueOf(Main.game.getCrew()));
        foodLabel.setText(String.valueOf(Main.game.getFood()));
        fuelLabel.setText(String.valueOf(Main.game.getFuel()));
        flavorTextLabel.setText(Main.game.getCurrentSituation().getFlavorText());
        option1Button.setText(Main.game.getCurrentSituation().getOption1().getOptionText());
        option2Button.setText(Main.game.getCurrentSituation().getOption2().getOptionText());
        option3Button.setText(Main.game.getCurrentSituation().getOption3().getOptionText());
    }
}
