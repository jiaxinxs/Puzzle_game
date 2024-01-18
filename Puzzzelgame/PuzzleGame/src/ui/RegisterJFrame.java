package ui;
import javax.swing.JFrame;
/**
 * This class represents the registration window for the game. It provides the interface for new players to register
 * for the game. The frame is configured with specific dimensions, title, and default behavior settings.
 */
public class RegisterJFrame extends JFrame{
	  /**
     * Constructs a new RegisterJFrame. This constructor sets up the frame with specific properties such as size, 
     * title, and default close operation. The frame is centered on the screen and made visible upon creation.
     */
	public RegisterJFrame() {
		this.setSize(488,500);
		this.setTitle("RegisterGame V1.0");
		this.setAlwaysOnTop(true);;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
}
