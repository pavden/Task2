
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
        Scanner scanner = new Scanner(System.in);
        view.printMessage(View.INVITATION);

        while (true) {
            view.printMessage(view.getNumberInputMessage(model.getCurrentRangeMin(), model.getCurrentRangeMax()));
            String inputLine = scanner.nextLine();
            int answer;

            try {
                answer = Integer.parseInt(inputLine);
            } catch (NumberFormatException e) {
                view.printMessage(View.INCORRECT_DATA);
                continue;
            }

            if (answer < model.getCurrentRangeMin() || answer > model.getCurrentRangeMax()) {
                view.printMessage(View.OUT_OF_RANGE);
                continue;
            }

            model.processAnswer(answer);

            if (model.isGameOver()) {
                view.printMessage(View.CONGRATULATION);
                view.printMessage(View.GAME_HISTORY);
                view.printMessage(model.getGameHistory());
                break;
            } else {
                view.printMessage(View.DID_NOT_GUESS);
            }
        }

        scanner.close();
    }

}
