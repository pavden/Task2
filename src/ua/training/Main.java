
/**
 * Console version of "Guess the hidden number" game using MVC pattern
 * @author Pavel Denisenko
 * @since 10.02.2019
 */
package ua.training;

/**
 * The entry point of this program
 */
public class Main {

    public static void main(String[] args) {
        // MVC initialization
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Run the game
        controller.runGame();
    }

}
