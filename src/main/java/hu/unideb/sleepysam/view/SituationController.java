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
        crewLabel.setText(String.valueOf(Main.game.getCrew()));
        foodLabel.setText(String.valueOf(Main.game.getFood()));
        fuelLabel.setText(String.valueOf(Main.game.getFuel()));
        flavorTextLabel.setText(Main.game.getCurrentSituation().getFlavorText());
        option1Button.setText(Main.game.getCurrentSituation().getOption1().getOptionText());
        option2Button.setText(Main.game.getCurrentSituation().getOption2().getOptionText());
        option3Button.setText(Main.game.getCurrentSituation().getOption3().getOptionText());
    }
}
