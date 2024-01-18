package ui;
import javax.swing.JFrame;
/**
 * This class represents the login window for the game. It is responsible for displaying the login interface 
 * where players can presumably enter their credentials to access the game. The frame is set with predefined
 * dimensions, title, and other properties.
 */
public class LoginJFrame extends JFrame {
	 /**
     * Constructs a new LoginJFrame. This constructor initializes the frame with specific properties like size, 
     * title, and default close operation. It also centers the frame on the screen and makes it visible.
     */
	public LoginJFrame() {
		this.setSize(488,430);
		this.setTitle("LoginGame V1.0");
		this.setAlwaysOnTop(true);;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
	}
}
