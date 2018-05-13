package hu.unideb.sleepysam.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import hu.unideb.sleepysam.view.StartScreenController;
import javafx.stage.FileChooser;
import org.apache.commons.io.FileUtils;

import static hu.unideb.sleepysam.view.Main.game;
import static hu.unideb.sleepysam.view.Main.main;

public class SaveManager {

    private final String fileNamePrefix = "Orion_trail_save_";

    public SaveManager() {

    }

    public String fileNameGenerator() {
        return fileNamePrefix + LocalDateTime.now().format(DateTimeFormatter.ofPattern("H_m_s")) + ".save";
    }

    public void saveGame() {
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls().enableComplexMapKeySerialization().setPrettyPrinting();
        Gson gson = builder.create();
        String json = gson.toJson(game);

        File file = new File(fileNameGenerator());

        System.out.println("File path: " + file.getAbsolutePath());
        try {
            FileUtils.writeStringToFile(file, json, StandardCharsets.UTF_8, false);
        } catch (IOException e) {

        }
    }
}
