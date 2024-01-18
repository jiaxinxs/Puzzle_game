import ui.GameJFrame;
import ui.LoginJFrame;
/**
 * The App class serves as the main entry point for the puzzle game application. 
 * This class contains the main method which launches the game.
 */
public class App {
	 /**
     * The main method is the entry point of the application. It creates an instance of the GameJFrame,
     * which initializes and displays the main game window. This is where the game starts.
     *
     * @param args Command line arguments (not used in this application).
     */
	public static void main(String[] args) {
		new GameJFrame();
	}
}
