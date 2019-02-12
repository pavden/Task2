
package ua.training;

/**
 * Class for View component of MVC
 */
public class View {

    // Text constants
    public static final String INVITATION = "Welcome to the \"Guess the hidden number\" game! Let\'s play!";
    public static final String NUMBER_INPUT = "Please input the integer number in the range";
    public static final String INCORRECT_DATA = "Incorrect data input, try again!";
    public static final String OUT_OF_RANGE = "Your number is out of range, try again!";
    public static final String DID_NOT_GUESS = "You didn\'t guess, try again!";
    public static final String CONGRATULATION = "Excellent!!! You guessed the number and won the game!!!";
    public static final String GAME_HISTORY = "Your game history is the following:";

    // Method returns a message asking to input the integer number in the range [min, max]
    public String getNumberInputMessage(int min, int max) {
        return (NUMBER_INPUT + " ]" + min + ", " + max + "[:");
    }

    // Method prints a message to standard output
    public void printMessage(String message){
        System.out.println(message);
    }

}
