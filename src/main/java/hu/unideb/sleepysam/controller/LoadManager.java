package hu.unideb.sleepysam.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hu.unideb.sleepysam.model.Situation;
import hu.unideb.sleepysam.view.Main;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoadManager {

    private final String situationsDataFilePath = "situations.data";
    private final String shipPrefixesFilePath = "shipPrefixes.data";
    private final String shipSuffixesFilePath = "shipSuffixes.data";

    public void loadShipNames(){
        ArrayList<String> shipNamePrefixes = new ArrayList<>();
        ArrayList<String> shipNameSuffixes = new ArrayList<>();

        String jsonContents = new String();

        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(shipPrefixesFilePath);
            jsonContents = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(shipPrefixesFilePath),"UTF-8");

            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Type listType = new TypeToken<ArrayList<String>>(){}.getType();
            shipNamePrefixes = gson.fromJson(jsonContents, listType);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception while reading filenames");
        }
        logger.info("Ship names pref: " + shipNamePrefixes);


        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(shipSuffixesFilePath);
            jsonContents = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(shipSuffixesFilePath),"UTF-8");
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Type listType = new TypeToken<ArrayList<String>>(){}.getType();
            shipNameSuffixes = gson.fromJson(jsonContents, listType);

            logger.info("Ship names suf: " + shipNameSuffixes);
        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (Exception e) {
            logger.error("Exception while reading filenames");
        }
        logger.info("Ship names suff: " + shipNameSuffixes);

        SituationFactory.setShipPrefixes(shipNamePrefixes);
        SituationFactory.setShipSuffixes(shipNameSuffixes);
    }

    public void loadSituationsFromJson() {
        String result = "";
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(situationsDataFilePath);
            result = IOUtils.toString(this.getClass().getClassLoader().getResourceAsStream(situationsDataFilePath),"UTF-8");
        }
        catch(IOException e){
            System.out.println("IO Exception");
            logger.error("Exception while reading {}", situationsDataFilePath);
            logger.error(e.getMessage());
        }
        //logger.info("The read situations: " + result);

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<ArrayList<Situation>>(){}.getType();
        List<Situation> situations = gson.fromJson(result, listType);
        //logger.info("Deserialized all situations: " + situations);

        // shuffles situations
        Collections.shuffle(situations);
        Game.setSituationTemplates(situations);
    }

    public static Logger logger = LoggerFactory.getLogger(Main.class);
}
