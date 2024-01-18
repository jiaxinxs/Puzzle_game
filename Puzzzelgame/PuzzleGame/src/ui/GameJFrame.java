package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.BevelBorder;
/**
 * This class represents the main frame for a puzzle game. It includes functionalities for managing game states, 
 * handling user input, and updating the UI components. The game is a typical tile-based puzzle where the player 
 * moves tiles to arrange them in a specific order.
 */
public class GameJFrame extends JFrame implements KeyListener, ActionListener{
	//create multi dimensional array to manage data. when pic loaded ,order will be loaded based on array
	// Fields
    /**
     * A 2D array representing the current state of the puzzle. Each element corresponds to a tile in the puzzle.
     */
	int[][] data=new int[4][4];
	//record location of pic 0
	/**
     * The x-coordinate of the empty tile in the puzzle.
     */
	int x;
	   /**
     * The y-coordinate of the empty tile in the puzzle.
     */
	int y;
	//declare an variable,record pic path
	  /**
     * The path to the directory containing the image resources for the puzzle.
     */
	String path="..\\PazzleGame\\img\\animal5\\";
	   /**
     * A 2D array representing the winning state of the puzzle.
     */
	int [][]win = {
		{1,2,3,4},
		{5,6,7,8},
		{9,10,11,12},
		{13,14,15,0}
	};
	//Initialize variable to count steps
	 /**
     * Counter for the number of steps the player has taken in the game.
     */
	int step = 0;
	JMenuItem replayItem = new JMenuItem("Replay");
	JMenuItem reLoginItem = new JMenuItem("Relogin");
	JMenuItem closeItem = new JMenuItem("Exit");
	
	JMenuItem contactItem = new JMenuItem("Contact Information");
	/**
     * Constructs a new GameJFrame. It initializes the frame, menus, game data, and images.
     */
	public GameJFrame() {
		initJFrame();
		
		initJMenu();
		
		initData();
		
		initImage();
		
		
		this.setVisible(true);//last step
	}
	/**
	 * Initializes the game data by randomly shuffling the puzzle tiles.
	 */
	private void initData() {
		//declare an array
		int[]tempArr= {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		Random r = new Random();
		for (int i = 0; i < tempArr.length; i++) {
			int index = r.nextInt(tempArr.length);
			int temp = tempArr[i];
			tempArr[i]=tempArr[index];
			tempArr[index]=temp;
		}
//		int index = 0;
//		for (int i = 0; i < data.length; i++) {
//			for (int j = 0; j < data[i].length; j++) {
//				data[i][j]= tempArr[index];
//				index++;
//			}
//		}
		for (int i = 0; i < tempArr.length; i++) {
			if(tempArr[i]==0) {
				x = i/4;
				y = i%4;
			}
			data[i/4][i%4] = tempArr[i];
			
		}
		
	}
	//pic will be loaded bease on 2-dim array
	
	/**
	 * Initializes and updates the images on the game board. This method positions the puzzle pieces
	 * according to the current state of the 'data' array. It also updates the step count display and 
	 * checks for a win condition, displaying a victory image if the player has won.
	 */
	
	private void initImage() {
		//clear exisiting pic
		this.getContentPane().removeAll();
		if(victory()) {
			JLabel winJlabel = new JLabel(new ImageIcon("..\\PazzleGame\\img\\win.png"));
			winJlabel.setBounds(203, 283, 197, 73);
			this.getContentPane().add(winJlabel);
			
		}
		JLabel stepCount = new JLabel("Step:" + step);
		stepCount.setBounds(50, 30, 100, 20);
		this.getContentPane().add(stepCount);
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				int num = data[i][j];
				//init pic
				//create an imageicon object
				JLabel jLabel = new JLabel(new ImageIcon(path+num+".jpg"));
				this.add(jLabel);
				//set icon location
				jLabel.setBounds(105*j+83,105*i+134,105,105);
				//add border
				jLabel.setBorder(new BevelBorder(1));
				//0 raised
				//1 lowered
				this.getContentPane().add(jLabel);
				
				}
		}
		//background img
		JLabel background = new JLabel(new ImageIcon("..\\PazzleGame\\img\\background.png"));
		background.setBounds(40, 40, 508, 560);
		//add background img to app
		this.getContentPane().add(background);
		//background img should be added on last step
		
		//refresh 
		this.getContentPane().repaint();
	}
	/**
	 * Initializes the main JFrame. This method sets the size, title, default close operation, and layout of the frame.
	 * It also adds a key listener to handle keyboard inputs.
	 */
	private void initJFrame() {
		this.setSize(603,680);
		this.setTitle("PuzzleGame V1.0");
		this.setAlwaysOnTop(true);;
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(3);//0.do nothing 1. default
		//2.terminate when all windows are closed 3. terminate when one window closed 
		
		//cancel default layout
		this.setLayout(null);
		//add keylistener to this frame
		this.addKeyListener(this);
	}
	
	
	/**
	 * Initializes the menu bar for the JFrame. This method creates and adds menu items like 'Replay', 'Relogin', and 'Exit'
	 * to the main menu bar of the frame. It also attaches action listeners to these menu items for handling user interactions.
	 */
	private void initJMenu() {
		//Main menu object
		JMenuBar jMenuBar = new JMenuBar();
				
		//side menu objects
		JMenu functionJMenu = new JMenu("Function");
		JMenu aboutJMenu = new JMenu("About me");
				

				
		//link items with menu
		functionJMenu.add(replayItem);
		functionJMenu.add(reLoginItem);
		functionJMenu.add(closeItem);
		aboutJMenu.add(contactItem);
		
		replayItem.addActionListener(this);
		reLoginItem.addActionListener(this);
		closeItem.addActionListener(this);
		contactItem.addActionListener(this);
		//add to main menu
		jMenuBar.add(functionJMenu);
		jMenuBar.add(aboutJMenu);
				
		this.setJMenuBar(jMenuBar);	
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	/**
	 * Handles key press events. This method defines the game's response to specific key presses, 
	 * allowing the player to interact with the puzzle using the keyboard. It includes controls for 
	 * moving the tiles and displaying the full picture.
	 * 
	 * @param e The KeyEvent object that contains information about the key event.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//if user type A
		if(code== 65) {
			this.getContentPane().removeAll();
			JLabel all = new JLabel(new ImageIcon(path+"all.jpg"));
			all.setBounds(83, 134, 420, 420);
			this.getContentPane().add(all);
			//background img
			JLabel background = new JLabel(new ImageIcon("..\\PazzleGame\\img\\background.png"));
			background.setBounds(40, 40, 508, 560);
			//add background img to app
			this.getContentPane().add(background);
			//refresh
			this.getContentPane().repaint();
		}
		
		
	}
	/**
	 * Handles action events from menu items. This method defines responses to user interactions with menu items,
	 * such as replaying the game, re-login, exiting the game, and displaying contact information.
	 * 
	 * @param e The ActionEvent object that contains information about the action event.
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		//consider if user win, if win, game over
		if (victory()) {
			return;
		}
		
		//left 37 up 38 right 39 down 40
		int code = e.getKeyCode();
		if(code == 37) {
			if(y==0) {
				return;
			}
			data[x][y] = data[x][y-1];
			data[x][y-1]=0;
			y--;
			step++;
			//use new index to load pic
			initImage();
		}else if(code == 38) {
			if(x==3) {
				return;
			}
			data[x][y] = data[x+1][y];
			data[x+1][y]=0;
			x++;
			step++;
			//use new index to load pic
			initImage();
		}else if(code == 39) {
			if(y==3) {
				return;
			}
			data[x][y] = data[x][y+1];
			data[x][y+1]=0;
			y++;
			step++;
			//use new index to load pic
			initImage();
		}else if(code == 40) {
			if(x==0) {
				return;
			}
			data[x][y] = data[x-1][y];
			data[x-1][y]=0;
			x--;
			step++;
			//use new index to load pic
			initImage();
		}else if (code == 65){
			initImage();
		}else if (code == 87) {// keyboard w
			data = new int[][] {
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,0}
			};
		initImage();
		}
		
	}
	
	public boolean victory(){
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if(data[i][j]!=win[i][j]) {
					return false;
				}
				
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == replayItem) {
		//recount step
			step = 0;
		//mix up the order of the pic
			initData();
		//reload pic
			initImage();

		}else if (obj == reLoginItem) {
		this.setVisible(false);
		new LoginJFrame();
		}else if (obj == closeItem) {
			System.exit(0);
		}else if (obj == contactItem) {
			JDialog jDialog = new JDialog();
			JLabel jLabel = new JLabel (new ImageIcon("..\\PazzleGame\\img\\about.png"));
			jLabel.setBounds(0, 0, 258, 235);
			jDialog.getContentPane().add(jLabel);
			jDialog.setSize(500,500);
			jDialog.setAlwaysOnTop(true);
			jDialog.setLocationRelativeTo(null);
			jDialog.setModal(true);
			jDialog.setVisible(true);
			
		}
		
	}
}

