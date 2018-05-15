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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hu.unideb.sleepysam.controller.Game;
import hu.unideb.sleepysam.controller.LoadManager;
import hu.unideb.sleepysam.controller.SituationFactory;
import hu.unideb.sleepysam.model.FlavorTextTemplate;
import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;
import hu.unideb.sleepysam.model.GameDifficulty;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main extends Application {

    public static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception{
        LoadManager loadManager = new LoadManager();
        loadManager.loadSituationsFromJson();
        loadManager.loadShipNames();
        game = new Game();
        game.setDifficulty(GameDifficulty.NORMAL);
        SituationFactory factory = new SituationFactory(game);
        game.setCurrentSituation(factory.getRandomSituation());
        // testFunction();

        Parent root = FXMLLoader.load((getClass().getClassLoader().getResource("welcomeScreen.fxml")));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Orion Trail");
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        logger.info("Starting program");
        game.resetGame();
        primaryStage.show();
    }

    public void testFunction() {
        List<FlavorTextTemplate> testFlavors = new ArrayList<>();
        testFlavors.add(new FlavorTextTemplate("asd %s", "spaceship"));

        Situation testSituation = new Situation(
                new FlavorTextTemplate("asd %s", "spaceship"),
                new Option("option1", "congrats",
                        1, 1, 1),
                new Option("option2", "absolute unit",
                        2, 2, 2),
                new Option("option3", "congrats u cunt",
                3, 3, 3));

        GsonBuilder testBuilder = new GsonBuilder();
        testBuilder.serializeNulls().enableComplexMapKeySerialization().setPrettyPrinting();
        Gson testGson = testBuilder.create();
        String testJson = testGson.toJson(testSituation);
        System.out.println(testJson);

        String greetings = String.format(
                testSituation.getFlavorTextTemplate().getPattern(),
                testSituation.getFlavorTextTemplate().getContent());

        System.out.println(greetings);

        Situation asdfSituation = new Situation();
        asdfSituation = testGson.fromJson(testJson, Situation.class);
        System.out.println(asdfSituation);
    }

    private void appFont(Stage stage, Scene scene) {
        Font.loadFont(getClass().getResourceAsStream("Exo2-Regular.ttf"), 18);
    }

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        launch(args);
    }
}
