package hu.unideb.sleepysam.controller;

import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;

/**
 * Created by vtibi on 5/10/2017.
 */
public class Game {
    private Option lastChosenOption;

    private int crew;
    private int fuel;
    private int food;

    private int startCrew;
    private int startFuel;
    private int startFood;
    private int winGoal;

    private int victoryCounter = 0;

    private Situation currentSituation;

    public Game() {
        currentSituation = SituationFactory.getRandomSituation();
    }

    public Situation getCurrentSituation() {
        return currentSituation;
    }

    public void setCurrentSituation(Situation currentSituation) {
        this.currentSituation = currentSituation;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getVictoryCounter() {
        return victoryCounter;
    }

    public void setVictoryCounter(int victoryCounter) {
        this.victoryCounter = victoryCounter;
    }

    public void incrementVictoryCounter() {
        this.victoryCounter++;
    }

    public Option getLastChosenOption() {
        return lastChosenOption;
    }

    public void setLastChosenOption(Option lastChosenOption) {
        this.lastChosenOption = lastChosenOption;
    }

    public int getStartCrew() {
        return startCrew;
    }

    public void setStartCrew(int startCrew) {
        this.startCrew = startCrew;
    }

    public int getStartFuel() {
        return startFuel;
    }

    public void setStartFuel(int startFuel) {
        this.startFuel = startFuel;
    }

    public int getStartFood() {
        return startFood;
    }

    public void setStartFood(int startFood) {
        this.startFood = startFood;
    }

    public int getWinGoal() {
        return winGoal;
    }

    public void setWinGoal(int winGoal) {
        this.winGoal = winGoal;
    }

    public void applyChosenOption(Option chosenOption) {
        setLastChosenOption(chosenOption);
        setFood(getFood() + chosenOption.getOutcomeFoodDiff());
        setFuel(getFuel() + chosenOption.getOutcomeFuelDiff());
        setCrew(getCrew() + chosenOption.getOutcomeCrewDiff());
    }

    public void resetGame() {
        setFood(startFood);
        setCrew(startCrew);
        setFuel(startFuel);
    }
}
