package hu.unideb.sleepysam.model;

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

import hu.unideb.sleepysam.controller.SituationFactory;

import java.util.List;

/**
 * This class contains the most important fields and methods for tha game itself.
 */
public class Game {
    /**
     * This object is used to calculate the changes in the resources based on the chosen option for a situation.
     */
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
    private int victoryCounter = 1;

    /**
     * This object is used to display a situation on each screen after pressing the new game button on the starting screen.
     * This is achieved with the help of the {@link SituationFactory#getRandomSituation()} method.
     */
    private Situation currentSituation;

    private static List<Situation> situationTemplates;

    private GameDifficulty difficulty;

    public static List<Situation> getSituationTemplates() {
        return situationTemplates;
    }

    public static void setSituationTemplates(List<Situation> situationTemplates) {
        Game.situationTemplates = situationTemplates;
    }

    public GameDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(GameDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    /**
     * Constructor method of the Game class.
     */
    public Game() {
    }

    /**
     * Getter method for the currentSituation.
     * @return the currentSituation
     */
    public Situation getCurrentSituation() {
        return currentSituation;
    }

    /**
     * Setter method for the currentSituation.
     * @param currentSituation the currentSituation
     */
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
     * @return the food
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
     * @return the victoryCounter
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

    /**
     * Getter method for the lastChosenOption.
     * @return the lastChosenOption
     */
    public Option getLastChosenOption() {
        return lastChosenOption;
    }

    /**
     * Setter method for the lastChosenOption.
     * @param lastChosenOption the lastChosenOption
     */
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

    /**
     * Getter method for the winGoal.
     * @return the winGoal
     */
    public int getWinGoal() {
        return winGoal;
    }

    /**
     * Setter method for the winGoal.
     * @param winGoal the winGoal
     */
    public void setWinGoal(int winGoal) {
        this.winGoal = winGoal;
    }

    /**
     * This method applies the changes to the current amount of resources based on the {@link Option} chosen.
     * See more on {@link Option#getOutcomeCrewDiff()}.
     * @param chosenOption the chosenOption
     */
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
        setVictoryCounter(1);
    }

    public void setVictoryCounter(int victoryCounter) {
        this.victoryCounter = victoryCounter;
    }

    /**
     * Getter method for the starting crew.
     * Used in unit tests.
     * @return the startCrew
     */
    public int getStartCrew() {
        return startCrew;
    }

    /**
     * Getter method for the starting fuel.
     * Used in unit tests.
     * @return the startFuel
     */
    public int getStartFuel() {
        return startFuel;
    }

    /**
     * Getter method for the starting food.
     * Used in unit tests.
     * @return the startFood
     */
    public int getStartFood() {
        return startFood;
    }

    @Override
    public String toString() {
        return "Game{" +
                "lastChosenOption=" + lastChosenOption +
                ", crew=" + crew +
                ", fuel=" + fuel +
                ", food=" + food +
                ", startCrew=" + startCrew +
                ", startFuel=" + startFuel +
                ", startFood=" + startFood +
                ", winGoal=" + winGoal +
                ", victoryCounter=" + victoryCounter +
                ", currentSituation=" + currentSituation +
                ", difficulty=" + difficulty +
                '}';
    }
}
