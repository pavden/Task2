
package ua.training;

import java.util.Scanner;

/**
 * Class for Controller component of MVC
 */
public class Controller {

    private Model model;
    private View view;

    // Constructor
    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Method that runs the game
    public void runGame(){
        model.setHiddenNumberRange(Model.INITIAL_RANGE_MIN, Model.INITIAL_RANGE_MAX);
        model.setHiddenNumber();

        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.INVITATION);

        while (true) {
            view.printMessage(view.getNumberInputMessage(model.getCurrentRangeMin(), model.getCurrentRangeMax()));
            String inputLine = scanner.nextLine();

            if (!isInputIntNumber(inputLine)) {
                view.printMessage(View.INCORRECT_DATA);
                continue;
            }

            int answer = Integer.parseInt(inputLine);

            if (!isAnswerInRange(answer)) {
                view.printMessage(View.OUT_OF_RANGE);
                continue;
            }

            if (model.isHiddenNumber(answer)) {
                view.printMessage(View.CONGRATULATION);
                view.printMessage(View.GAME_HISTORY);
                view.printMessage(String.valueOf(model.getGameHistory()));
                break;
            } else {
                view.printMessage(View.DID_NOT_GUESS);
            }
        }

        scanner.close();
    }

    // Method verifies whether the input is an integer number
    private boolean isInputIntNumber(String inputLine) {
        Scanner scanner = new Scanner(inputLine);
        scanner.useDelimiter("\n");

        boolean isInputIntNumber = scanner.hasNextInt();

        scanner.close();
        return isInputIntNumber;
    }

    // Method verifies whether the answer is in the acceptable range
    private boolean isAnswerInRange(int answer) {
        return answer > model.getCurrentRangeMin() && answer < model.getCurrentRangeMax();
    }

}
