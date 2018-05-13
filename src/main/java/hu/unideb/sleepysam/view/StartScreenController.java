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

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import hu.unideb.sleepysam.controller.Game;
import hu.unideb.sleepysam.model.GameDifficulty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

import static hu.unideb.sleepysam.view.Main.game;
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
            scene.getStylesheets().add("style.css");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleNormalDifficultyButton() {
        logger.info("Medium difficulty chosen.");
        Main.game.setStartCrew(6);
        Main.game.setStartFuel(6);
        Main.game.setStartFood(6);
        Main.game.setWinGoal(7);
        Main.game.resetGame();
        game.setDifficulty(GameDifficulty.NORMAL);

        currentDifficultyLabel.setText("Közepes");
    }

    @FXML
    private void handleHardDifficultyButton() {
        logger.info("Hard difficulty chosen.");
        Main.game.setStartCrew(3);
        Main.game.setStartFuel(3);
        Main.game.setStartFood(3);
        Main.game.setWinGoal(9);
        Main.game.resetGame();
        game.setDifficulty(GameDifficulty.HARD);

        currentDifficultyLabel.setText("Nehéz");
    }

    @FXML
    public void handleLoadGameButton() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Nyissa meg a mentett játékot!");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Save Files", "*.save"));

        Window stage = newGameButton.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        String jsonContents = new String();
        try {
            jsonContents = FileUtils.readFileToString(selectedFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            logger.error("IOException occured while reading: {}",  selectedFile.getPath());
            logger.error(e.getMessage());
        }
        System.out.println("A jsoncontents: " + jsonContents);

        Game loadGame;
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        loadGame = gson.fromJson(jsonContents, Game.class);

        logger.info("a mentett jatek: " + jsonContents);

        //game.setChangeGame(loadGame);
        game = loadGame;
        System.out.println("currentsit : " + game.getCurrentSituation().getFlavorText());

        Parent root;
        Stage stage1;

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("situation.fxml"));
            root = loader.load();
            loader.<SituationController>getController();
            stage1 = (Stage) currentDifficultyLabel.getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add("style.css");
            stage1.setScene(scene);
            stage1.show();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception");
            logger.debug("The exception: " + e.getMessage());
        }
    }

    public void initialize(URL location, ResourceBundle resources) {
        Main.game.setStartCrew(9);
        Main.game.setStartFuel(9);
        Main.game.setStartFood(9);
        Main.game.setWinGoal(5);
        Main.game.resetGame();

        currentDifficultyLabel.setText("Könnyű");
    }
}
