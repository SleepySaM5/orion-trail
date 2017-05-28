package hu.unideb.sleepysam.view;

import hu.unideb.sleepysam.controller.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application {

    public static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception{
        game = new Game();

        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("startScreen.fxml")));
        primaryStage.setTitle("Orion Trail");
        primaryStage.setScene(new Scene(root));
        logger.info("Starting program");
        game.resetGame();
        primaryStage.show();
    }

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        launch(args);
    }
}
