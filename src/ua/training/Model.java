
package ua.training;

import java.util.ArrayList;

/**
 * Class for Model component of MVC
 */
public class Model {

    // Model constants
    public static final int INITIAL_RANGE_MIN = 0;
    public static final int INITIAL_RANGE_MAX = 100;

    private int hiddenNumber;
    private int currentRangeMin;
    private int currentRangeMax;
    private boolean gameOver;
    private ArrayList<Integer> gameHistory;

    // Constructor
    public Model() {
        hiddenNumber = generateHiddenNumber();
        currentRangeMin = INITIAL_RANGE_MIN;
        currentRangeMax = INITIAL_RANGE_MAX;
        gameOver = false;
        gameHistory = new ArrayList<>();
    }

    // Method generates a hidden number for the game
    private int generateHiddenNumber() {
        return randomInt(INITIAL_RANGE_MIN, INITIAL_RANGE_MAX);
    }

    // Method returns a pseudo-random integer number in the range [min, max]
    private int randomInt(int min, int max) {
        return (int)(min + Math.random() * (max - min + 1));
    }

    // Method adds the answer to the game history,
    // verifies whether the answer is a hidden number,
    // and if not then adjusts the range
    public void processAnswer(int answer) {
        addAnswerToGameHistory(answer);
        if (answer < hiddenNumber)
            setCurrentRangeMin(answer + 1);
        else if (answer > hiddenNumber)
            setCurrentRangeMax(answer - 1);
        else
            setGameOver(true);
    }

    // Getter for current range minimum
    public int getCurrentRangeMin() {
        return currentRangeMin;
    }

    // Setter for current range minimum
    public void setCurrentRangeMin(int currentRangeMin) {
        this.currentRangeMin = currentRangeMin;
    }

    // Getter for current range maximum
    public int getCurrentRangeMax() {
        return currentRangeMax;
    }

    // Setter for current range maximum
    public void setCurrentRangeMax(int currentRangeMax) {
        this.currentRangeMax = currentRangeMax;
    }

    // Getter for the game over indicator
    public boolean isGameOver() {
        return gameOver;
    }

    // Setter for the game over indicator
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    // Getter for the game history
    public String getGameHistory() {
        return gameHistory.toString();
    }

    // Method adds the answer to the game history
    public void addAnswerToGameHistory(int answer) {
        gameHistory.add(answer);
    }

}
