package hu.unideb.sleepysam.controller;

import hu.unideb.sleepysam.model.Option;
import hu.unideb.sleepysam.model.Situation;

/**
 * Created by vtibi on 5/10/2017.
 */
public class Game {
    private Option lastChosenOption;

    /**
     * The current amount of the crew resource.
     */
    private int crew;

    /**
     * The current amount of the fuel resource.
     */
    private int fuel;

    /**
     * The current amount of the food resource.
     */
    private int food;

    /**
     * The starting amount of the crew resource.
     * It is used to set the starting number of the crew when choosing the difficulty option.
     */
    private int startCrew;

    /**
     * The starting amount of the fuel resource.
     * It is used to set the starting number of the fuel resource when choosing the difficulty option.
     */
    private int startFuel;

    /**
     * The starting amount of the food resource.
     * It is used to set the starting number of the food resource when choosing the difficulty option.
     */
    private int startFood;

    /**
     * The number of situations you need to survive before reaching the goal of the game.
     * It is used to when choosing the difficulty option.
     */
    private int winGoal;

    /**
     * The counter that is to be incremented towards the goal of the game.
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
     * @param crew current value of the crew resource
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
     * @param fuel current value of the fuel resource
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
     * @param food current value of the food resource
     */
    public void setFood(int food) {
        this.food = food;
    }

    /**
     * Getter method for the victory counter.
     * @return
     */
    public int getVictoryCounter() {
        return victoryCounter;
    }

    /**
     * Method that increments the victoryCounter by 1.
     */
    public void incrementVictoryCounter() {
        this.victoryCounter++;
    }

    public Option getLastChosenOption() {
        return lastChosenOption;
    }

    public void setLastChosenOption(Option lastChosenOption) {
        this.lastChosenOption = lastChosenOption;
    }

    /**
     * Setter method for the number of the starting crew, used for the difficulty option.
     * @param startCrew value of startCrew
     */
    public void setStartCrew(int startCrew) {
        this.startCrew = startCrew;
    }

    /**
     * Setter method for the number of the starting fuel, used for the difficulty option.
     * @param startFuel value of startFuel
     */
    public void setStartFuel(int startFuel) {
        this.startFuel = startFuel;
    }

    /**
     * Setter method for the number of the starting food, used for the difficulty option.
     * @param startFood value of startFood
     */
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

    /**
     * Used to set starting values according to the difficulty chosen.
     * Pressing a difficulty button sets the three start values,
     * this method changes the current values to the values of the chosen difficulty.
     */
    public void resetGame() {
        setFood(startFood);
        setCrew(startCrew);
        setFuel(startFuel);
    }

    public int getStartCrew() {
        return startCrew;
    }

    public int getStartFuel() {
        return startFuel;
    }

    public int getStartFood() {
        return startFood;
    }
}
