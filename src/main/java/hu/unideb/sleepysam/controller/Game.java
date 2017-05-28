package hu.unideb.sleepysam.controller;

import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;

/**
 * Created by vtibi on 5/10/2017.
 */
public class Game {
    private Option lastChosenOption;

    /**
     * The amount of the crew resource.
     */
    private int crew;

    /**
     * The amount of the fuel resource.
     */
    private int fuel;

    /**
     * The amount of the food resource.
     */
    private int food;

    /**
     * The starting amount of the crew resource, used to set the difficulty option.
     */
    private int startCrew;

    /**
     * The starting amount of the fuel resource, used to set the difficulty option.
     */
    private int startFuel;

    /**
     * The starting amount of the food resource, used to set the difficulty option.
     */
    private int startFood;

    /**
     * The number of situations you need to survive before reaching the goal of the game, used to set the difficulty option.
     */
    private int winGoal;

    /**
     * The counter used to move towards the goal of the game.
     */
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

    /**
     * Getter method for the crew.
     *
     * @return the crew
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Setter method for the crew.
     *
     * @param crew
     */
    public void setCrew(int crew) {
        this.crew = crew;
    }

    /**
     * Getter method for the fuel.
     *
     * @return the fuel
     */
    public int getFuel() {
        return fuel;
    }

    /**
     * Setter method for the fuel.
     *
     * @param fuel
     */
    public void setFuel(int fuel) {
        this.fuel = fuel;
    }

    /**
     * Getter method for the food.
     *
     * @return
     */
    public int getFood() {
        return food;
    }

    /**
     * Setter method for the food.
     *
     * @param food
     */
    public void setFood(int food) {
        this.food = food;
    }

    public int getVictoryCounter() {
        return victoryCounter;
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

    public void setStartCrew(int startCrew) {
        this.startCrew = startCrew;
    }

    public void setStartFuel(int startFuel) {
        this.startFuel = startFuel;
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
