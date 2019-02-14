
package ua.training;

/**
 * Class for View component of MVC
 */
public class View {

    // Text constants
    public static final String GREETING = "Welcome to the \"Guess the hidden number\" game!";
    public static final String LETS_PLAY_ROUND =  "Let\'s play the new round of the game!";
    public static final String RANGE_MIN_INPUT = "Please input the integer number for the range minimum:";
    public static final String RANGE_MAX_INPUT = "Please input the integer number for the range maximum:";
    public static final String MUST_BE_GREATER = "The range maximum must be at least 2 greater than the range minimum, try again!";
    public static final String NUMBER_INPUT = "Please input the integer number in the range";
    public static final String INCORRECT_DATA = "Incorrect data input, try again!";
    public static final String OUT_OF_RANGE = "Your number is out of range, try again!";
    public static final String DID_NOT_GUESS = "You didn\'t guess, try again!";
    public static final String CONGRATULATION = "Excellent!!! You guessed the number and won the game!!!";
    public static final String GAME_HISTORY = "Your game history is the following:";
    public static final String WANT_PLAY_MORE = "Do you want to play one more round? 0 - No, 1 - Yes :";
    public static final String FAREWELL = "Good bye!";

    // Method returns a message asking to input the integer number in the range [min, max]
    public String getNumberInputMessage(int min, int max) {
        return (NUMBER_INPUT + " ]" + min + ", " + max + "[:");
    }

    // Method prints a message to standard output
    public void printMessage(String message){
        System.out.println(message);
    }

}
