import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Desktop;
/**
 * This class is the GUI for our program. It's job is to take the information from the user and execute it.
 * All the components (labels, textfields, buttons) are created and executed in this class.
 * All methods are called from the GameBoard class; this is how the GUI grabs methods from all the other classes.
 *
 * @author (Michael Arteaga, Joseph Carbone, Peter Cipolone, Eric Oliver)
 * @version (October 31, 2014)
 */
public class GameBoardGUI implements ActionListener
{
	// instance variables - replace the example below with your own
	private JFrame frame;
	private GameBoard game;
	JButton cardInHand1;
	JButton cardInHand2;
	JButton cardInHand3;
	JButton cardInHand4;
	JButton cardInHand5;
	JButton activePlayingCard1;
	JButton activePlayingCard2;
	JButton activePlayingCard3;
	JButton activePlayingCard4;
	JButton activePlayingCard5;
	JButton activePlayingCard6;
	JButton activePlayingCard7;
	JButton activePlayingCard8;
	JButton activePlayingCard9;
	JButton activePlayingCard10;
	JButton deck;
	JButton endTurn;
	JButton attackButton;
	private int cardInHandCount = 5;
	private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
	private JTextField currentPlayer = new JTextField(10);
	public String whoStarts;
	/**
	 * Default constructor for the GameBoardGUI class
	 */
	public GameBoardGUI()
	{
		game = new GameBoard();
		whoStarts= game.whoStartsGame();
		cardInHand1 = new JButton(game.getThisPlayer().getHand().get(0).getName());
		cardInHand2 = new JButton(game.getThisPlayer().getHand().get(1).getName());
		cardInHand3 = new JButton(game.getThisPlayer().getHand().get(2).getName());
		cardInHand4 = new JButton(game.getThisPlayer().getHand().get(3).getName());
		cardInHand5 = new JButton(game.getThisPlayer().getHand().get(4).getName());
		activePlayingCard1 = new JButton(game.getPlayer2Hand().get(0).getName());
		activePlayingCard2 = new JButton(game.getPlayer2Hand().get(1).getName());
		activePlayingCard3 = new JButton(game.getPlayer2Hand().get(2).getName());
		activePlayingCard4 = new JButton(game.getPlayer2Hand().get(3).getName());
		activePlayingCard5 = new JButton(game.getPlayer2Hand().get(4).getName());
		activePlayingCard6 = new JButton(game.getPlayer1Hand().get(0).getName());
		activePlayingCard7 = new JButton(game.getPlayer1Hand().get(1).getName());
		activePlayingCard8 = new JButton(game.getPlayer1Hand().get(2).getName());
		activePlayingCard9 = new JButton(game.getPlayer1Hand().get(3).getName());
		activePlayingCard10 = new JButton(game.getPlayer1Hand().get(4).getName());
		// deck = new JButton("Deck");
		endTurn = new JButton("End Turn");
		attackButton = new JButton("Attack!");
		makeFrame();
	}
	/**
	 * This method makes the frame and adds all the components.
	 * Implements buttons that only exist in this class
	 */
	public void makeFrame()
	{
		frame = new JFrame("GameBoard");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		makeMenuBar(frame);
		//panel for the west side of the frame
		JPanel west = new JPanel();
		contentPane.add(west, BorderLayout.WEST);
		west.setLayout(new GridLayout(9,1));
		west.add(new JLabel("Current Player"));
		west.add(currentPlayer);
		currentPlayer.setText(whoStarts);
		west.add(new JLabel(""));
		west.add(new JLabel(""));
		west.add(new JLabel(""));
		west.add(new JLabel("Player1"));
		JTextField Player1 = new JTextField(10);
		west.add(Player1);
		Player1.setText(game.getPlayer1Name());
		west.add(new JLabel("Player1 Record"));
		JTextField Player1Record = new JTextField(10);
		west.add(Player1Record);
		Player1Record.setText("0-0");
		//THIS IS USED TO START THE GAME PLAYING AND THE CARD TRANSFERING
		if(currentPlayer.getText().equals(game.getPlayer1Name()))
		{
			transferValue(cardInHand1, activePlayingCard6); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
			transferValue(cardInHand2, activePlayingCard7); //FOR PLAYER1
			transferValue(cardInHand3, activePlayingCard8);
			transferValue(cardInHand4, activePlayingCard9);
			transferValue(cardInHand5, activePlayingCard10);
		}
		else
		{
			transferValue(cardInHand1, activePlayingCard1); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
			transferValue(cardInHand2, activePlayingCard2); //FOR PLAYER 2
			transferValue(cardInHand3, activePlayingCard3);
			transferValue(cardInHand4, activePlayingCard4);
			transferValue(cardInHand5, activePlayingCard5);
		}
		//panel for the south side of the frame
		final JPanel south = new JPanel();
		contentPane.add(south, BorderLayout.SOUTH);
		south.add(cardInHand1); //ADDING THE CARDS IN HAND TO THE SOUTH SIDE OF THE FRAME
		south.add(cardInHand2);
		south.add(cardInHand3);
		south.add(cardInHand4);
		south.add(cardInHand5);
		infoCard(cardInHand1,0); //GIVES INFORATION ABOUT THE CARDS IN HAND
		infoCard(cardInHand2,1);
		infoCard(cardInHand3,2);
		infoCard(cardInHand4,3);
		infoCard(cardInHand5,4);
		//panel for the north side of the frame ////////////////////////////////////////////////////////////
		JPanel north = new JPanel();
		contentPane.add(north, BorderLayout.NORTH);
		JLabel player1Health = new JLabel("Player 1 Health");
		north.add(player1Health);
		JTextField playerOneHealth = new JTextField(10);
		north.add(playerOneHealth);
		playerOneHealth.setText("100");
		JLabel player2Health = new JLabel("Player 2 Health");
		north.add(player2Health);
		JTextField playerTwoHealth = new JTextField(10);
		north.add(playerTwoHealth);
		playerTwoHealth.setText("100");
		//panel for the center of the frame
		final JPanel center = new JPanel();
		contentPane.add(center, BorderLayout.CENTER);
		center.setLayout(new GridLayout(3,5));
		center.add(activePlayingCard1); //ADDING PLAYING CARDS 1-5 TO THE PLAYING FIELD
		center.add(activePlayingCard2);
		center.add(activePlayingCard3);
		center.add(activePlayingCard4);
		center.add(activePlayingCard5);
		center.add(new JLabel("")); //ADDING EMPTY LABELS TO THE PLAYING FIELD (FOR SPACING PURPOSES)
		center.add(new JLabel(""));
		center.add(new JLabel(""));
		center.add(new JLabel(""));
		center.add(new JLabel(""));
		center.add(activePlayingCard6); //ADDING PLAYING CARDS 6-10 TO THE PLAYING FIELD
		center.add(activePlayingCard7);
		center.add(activePlayingCard8);
		center.add(activePlayingCard9);
		center.add(activePlayingCard10);
		activePlayingCard1.setVisible(false); //SETTING ALL THE PLAYING CARDS TO INVISIBLE
		activePlayingCard2.setVisible(false);
		activePlayingCard3.setVisible(false);
		activePlayingCard4.setVisible(false);
		activePlayingCard5.setVisible(false);
		activePlayingCard6.setVisible(false);
		activePlayingCard7.setVisible(false);
		activePlayingCard8.setVisible(false);
		activePlayingCard9.setVisible(false);
		activePlayingCard10.setVisible(false);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//panel for the east side of the frame
		JPanel east = new JPanel();
		contentPane.add(east, BorderLayout.EAST);
		east.setLayout(new GridLayout(9,1));
		east.add(new JLabel("Player2"));
		JTextField Player2 = new JTextField(10);
		east.add(Player2);
		Player2.setText(game.getPlayer2Name());
		east.add(new JLabel("Player2 Record"));
		JTextField Player2Record = new JTextField(10);
		east.add(Player2Record);
		Player2Record.setText("0-0");
		east.add(new JLabel(""));
		east.add(new JLabel(""));
		east.add(endTurn); //ENDTURN IS DEFINED ABOVE - GLOBAL VARIABLE
		endTurn.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				currentPlayer.setText(game.nextTurn());
				south.removeAll();
				if (currentPlayer.getText().equals(game.getPlayer1Name()))
				{
					game.endTurn("player1");
					game.getThisPlayer().getHand().clear();
					game.getThisPlayer().getHand();
					cardInHand1 = new JButton(game.getThisPlayer().getHand().get(0).getName());
					cardInHand2 = new JButton(game.getThisPlayer().getHand().get(1).getName());
					cardInHand3 = new JButton(game.getThisPlayer().getHand().get(2).getName());
					cardInHand4 = new JButton(game.getThisPlayer().getHand().get(3).getName());
					cardInHand5 = new JButton(game.getThisPlayer().getHand().get(4).getName());
					south.revalidate();
					game.player1NewTurn();
					transferValue(cardInHand1, activePlayingCard6); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
					transferValue(cardInHand2, activePlayingCard7); //FOR PLAYER1
					transferValue(cardInHand3, activePlayingCard8);
					transferValue(cardInHand4, activePlayingCard9);
					transferValue(cardInHand5, activePlayingCard10);
				}
				else
				{
					game.endTurn("player2");
					game.getThisPlayer().getHand().clear();
					game.getThisPlayer().getHand();
					cardInHand1 = new JButton(game.getThisPlayer().getHand().get(0).getName());
					cardInHand2 = new JButton(game.getThisPlayer().getHand().get(1).getName());
					cardInHand3 = new JButton(game.getThisPlayer().getHand().get(2).getName());
					cardInHand4 = new JButton(game.getThisPlayer().getHand().get(3).getName());
					cardInHand5 = new JButton(game.getThisPlayer().getHand().get(4).getName());
					south.revalidate();
					game.player2NewTurn();
					transferValue(cardInHand1, activePlayingCard1); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
					transferValue(cardInHand2, activePlayingCard2); //FOR PLAYER2
					transferValue(cardInHand3, activePlayingCard3);
					transferValue(cardInHand4, activePlayingCard4);
					transferValue(cardInHand5, activePlayingCard5);
				}
				south.add(cardInHand1); //ADDING THE CARDS IN HAND TO THE SOUTH SIDE OF THE FRAME
				south.add(cardInHand2);
				south.add(cardInHand3);
				south.add(cardInHand4);
				south.add(cardInHand5);
				infoCard(cardInHand1,0); //GIVES INFORATION ABOUT THE CARDS IN HAND
				infoCard(cardInHand2,1);
				infoCard(cardInHand3,2);
				infoCard(cardInHand4,3);
				infoCard(cardInHand5,4);
				cardInHand1.setVisible(true);
				cardInHand2.setVisible(true);
				cardInHand3.setVisible(true);
				cardInHand4.setVisible(true);
				cardInHand5.setVisible(true);
			} });
		east.add(attackButton); //ATTACKBUTTON IS DEFINED ABOVE - GLOBAL VARIABLE
		attackButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//STILL NEEDS TO BE IMPLEMENTED
			}
		});
	}
	/**
	 * Transfers the value from the hand onto the playing field
	 */
	public void transferValue(final JButton hand, final JButton field)
	{
		hand.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				hand.setVisible(false);
				String value = hand.getText();
				game.removeCard(value);//////////////////////////////////////////////////////
				field.setVisible(true);
				infoFieldCard(field, game.getThisPlayer().getRemovedCard());
				cardInHandCount = cardInHandCount - 1;
				// if (cardInHandCount < 5)
				// {
				// deck.setEnabled(true);
				// }
			}
		});
	}
	/**
	 * Transfers the value from the hand into buttons
	 */
	/**
	 * gives information about the card in question
	 */
	public void infoCard(final JButton infoHand, int i)
	{
		infoHand.setToolTipText(game.getThisPlayer().getHand().get(i).toString());
		infoHand.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				infoHand.getToolTipText();
			}
		});
	}
	/**gives information about the card on the field*/
	public void infoFieldCard(final JButton infoHand, int i){
		try{infoHand.setToolTipText(game.getField().get(i).toString());
		infoHand.addMouseListener(new MouseAdapter()
		{
			public void mouseEntered(MouseEvent e)
			{
				infoHand.getToolTipText();
			}
		});
		}
		catch(IndexOutOfBoundsException obe)
		{System.out.println("Out of Bounds");}
	}
	/**
	 * Implements the menu item
	 */
	public void actionPerformed(ActionEvent event)
	{
		System.out.println("Menu item: " + event.getActionCommand());
	}
	/**
	 * Creates the main Frame's menu bar.
	 */
	private void makeMenuBar(JFrame frame)
	{
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		//create the file menu
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);
		JMenuItem getHelp = new JMenuItem("Get Help");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{openFile(); }
		});
		fileMenu.add(openItem);
		JMenuItem quitItem = new JMenuItem("Quit");
		quitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{quit();}
		});
		fileMenu.add(quitItem);
		getHelp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String message = "This is for the player to learn how to play the game." +
						"They read the rules here.";
				JOptionPane optionPane = new JOptionPane();
				optionPane.setMessage(message);
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog(null, "Rules of the Game");
				dialog.setVisible(true);
			}
		});
		helpMenu.add(getHelp);
	}
	/**
	 * This is our main testest for this class
	 */
	public static void main(String[] args)
	{
		GameBoardGUI x = new GameBoardGUI();
	}
	/**
	 * opens the directory for searching for a file
	 *
	 */
	public void openFile()
	{
		File folder = new File("C:\\"); // path to the directory to be opened
		Desktop desktop = null;
		if (Desktop.isDesktopSupported()) {
			desktop = Desktop.getDesktop();
		}
		try {
			desktop.open(folder);
		} catch (IOException e) {
		}
	}
	/**
	 * this method quits the program
	 */
	public void quit()
	{
		System.exit(0);
	}
	/**
	 * message box displaying the winner
	 */
	public void displayWinner()
	{
		String message;
		if(game.gameResult().equals(game.getPlayer1Name()))
		{
			message = game.getPlayer2Name() + " is the WINNER!";
		}
		else
		{
			message = game.getPlayer1Name() + " is the WINNER!";
		}
		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(message);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Width 100");
		dialog.setVisible(true);
	}
}