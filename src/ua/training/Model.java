
package ua.training;

import java.util.ArrayList;

/**
 * Class for Model component of MVC
 */
public class Model {

    // Model constants
    public static final int INITIAL_RANGE_MIN = 0;
    public static final int INITIAL_RANGE_MAX = 100;

    private int currentRangeMin;
    private int currentRangeMax;

    private int hiddenNumber;

    private ArrayList<Integer> gameHistory = new ArrayList<>();

    // Method sets a hidden number range for the game
    public void setHiddenNumberRange(int currentRangeMin, int currentRangeMax) {
        this.currentRangeMin = currentRangeMin;
        this.currentRangeMax = currentRangeMax;
    }

    // Getter for a hidden number
    public int getHiddenNumber() {
        return hiddenNumber;
    }

    // Method sets a hidden number for the game,
    // which is a pseudo-random integer number in the range ]min, max[
    public void setHiddenNumber() {
        hiddenNumber = (int) (Math.random() * ((currentRangeMax - 1) - (currentRangeMin + 1) + 1) + (currentRangeMin +1));
    }

    // Method adds the answer to the game history,
    // verifies whether the answer is a hidden number,
    // and if not then adjusts the range
    public boolean isHiddenNumber(int answer) {
        gameHistory.add(answer);

        if (answer == hiddenNumber) {
            return true;
        } else if (answer < hiddenNumber) {
            currentRangeMin = answer;
        } else {
            currentRangeMax = answer;
        }

        return false;
    }

    // Getter for current range minimum
    public int getCurrentRangeMin() {
        return currentRangeMin;
    }

    // Getter for current range maximum
    public int getCurrentRangeMax() {
        return currentRangeMax;
    }

    // Getter for the game history
    public ArrayList<Integer> getGameHistory() {
        return gameHistory;
    }

    // Method clears the game history
    public void clearGameHistory() {
        gameHistory.clear();
    }

}
