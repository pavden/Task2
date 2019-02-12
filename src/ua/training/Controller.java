
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
    public void runGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            runGameRound(scanner);
            if (!isNewRoundNeeded(scanner)) {
                break;
            }
        }

        scanner.close();
    }

    // Method that runs the game round
    public void runGameRound(Scanner scanner){
        model.setHiddenNumberRange(Model.INITIAL_RANGE_MIN, Model.INITIAL_RANGE_MAX);
        model.setHiddenNumber();

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
                model.clearGameHistory();
                break;
            } else {
                view.printMessage(View.DID_NOT_GUESS);
            }
        }
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

    // Method verifies whether a new round of the game is needed
    private boolean isNewRoundNeeded(Scanner scanner) {
        boolean isNewRoundNeeded;

        while (true) {
            view.printMessage(View.WANT_PLAY_MORE);
            String inputLine = scanner.nextLine();

            if (!isInputIntNumber(inputLine)) {
                view.printMessage(View.INCORRECT_DATA);
                continue;
            }

            int answer = Integer.parseInt(inputLine);

            if (answer != 0 && answer != 1) {
                view.printMessage(View.INCORRECT_DATA);
                continue;
            } else {
                isNewRoundNeeded = (answer == 1);
            }

            break;
        }

        return isNewRoundNeeded;
    }

}
