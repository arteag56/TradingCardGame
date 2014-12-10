import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Desktop;
/**
 * Write a description of class GameBoardGUI here.
 *
 * @author (Peter Cipolone)
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
     * Constructor for objects of class GameBoardGUI
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
        activePlayingCard1 = new JButton(cardInHand1.getText());
        activePlayingCard2 = new JButton(cardInHand2.getText());
        activePlayingCard3 = new JButton(cardInHand3.getText());
        activePlayingCard4 = new JButton(cardInHand4.getText());
        activePlayingCard5 = new JButton(cardInHand5.getText());
        activePlayingCard6 = new JButton(cardInHand1.getText());
        activePlayingCard7 = new JButton(cardInHand2.getText());
        activePlayingCard8 = new JButton(cardInHand3.getText());
        activePlayingCard9 = new JButton(cardInHand4.getText());
        activePlayingCard10 = new JButton(cardInHand5.getText());
        deck = new JButton("Deck");
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
        
        
        //panel for the north side of the frame
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
                if (currentPlayer.getText().equals(game.getPlayer1Name()))
                {
                    game.thisPlayer(currentPlayer.getText());
                    JButton newCard = new JButton();
                    south.remove(cardInHand1);
                    south.remove(cardInHand2);
                    south.remove(cardInHand3);
                    south.remove(cardInHand4);
                    south.remove(cardInHand5);
                    south.revalidate();
                    game.player1NewTurn();
                    //game.getPlayer1Deck();
                    for(Card card: game.getThisPlayer().getHand())
                    {
                           newCard = new JButton(card.getName());
                           south.add(newCard);
                           newCard.setVisible(true);
                           south.revalidate();
                    }
                    
                    //cardInHand1.setVisible(true);
                    //cardInHand2.setVisible(true);
                    //cardInHand3.setVisible(true);
                    //cardInHand4.setVisible(true);
                    //cardInHand5.setVisible(true);
                    
                    transferValue(newCard, activePlayingCard6); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
                    transferValue(newCard, activePlayingCard7); //FOR PLAYER1
                    transferValue(newCard, activePlayingCard8);
                    transferValue(newCard, activePlayingCard9);
                    transferValue(newCard, activePlayingCard10);   
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    //south.add(game.getPlayer1Hand());//the hand needs to be added to the frame. 
                }
                else
                {
                    game.thisPlayer(currentPlayer.getText());
                    JButton newCard = new JButton();
                    south.remove(cardInHand1);
                    south.remove(cardInHand2);
                    south.remove(cardInHand3);
                    south.remove(cardInHand4);
                    south.remove(cardInHand5);
                    south.revalidate();
                    game.player2NewTurn();
                    //game.getPlayer2Deck();
                    for(Card card: game.getThisPlayer().getHand())
                {
                    newCard = new JButton(card.getName());
                    south.add(newCard);
                    newCard.setVisible(true);
                    south.revalidate();
                }
                    
                   // cardInHand1.setVisible(true);
                    //cardInHand2.setVisible(true);
                   // cardInHand3.setVisible(true);
                   // cardInHand4.setVisible(true);
                    //cardInHand5.setVisible(true);
                    
                    transferValue(newCard, activePlayingCard1); //SENDING THE VALUE FROM THE CARD IN HAND TO THE CARD ON THE PLAYING FIELD
                    transferValue(newCard, activePlayingCard2); //FOR PLAYER 2
                    transferValue(newCard, activePlayingCard3);
                    transferValue(newCard, activePlayingCard4);
                    transferValue(newCard, activePlayingCard5);
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    south.remove(newCard);
                    
                }
            }
        });
        east.add(deck); //DECK IS DEFINED ABOVE - GLOBAL VARIABLE
        deck.setEnabled(false);
        deck.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //DOES NOT WORK - NOT SURE WHY
                
                //JButton newCard = new JButton(game.getThisPlayer().draw().getName()); //JUST GRABS THE VALUE OF THE LAST PLAYED CARD //NOT ASSOCIATED WITH THE GUI CLASS
                //south.add(newCard);
                //newCard.setVisible(true);
                
                south.revalidate();
                cardInHandCount = cardInHandCount + 1;
                if (cardInHandCount == 5)
                {
                    deck.setEnabled(false);
                }
                
            }
        });
        east.add(attackButton); //ATTACKBUTTON IS DEFINED ABOVE - GLOBAL VARIABLE
        attackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //STILL NEEDS TO BE IMPLEMENTED
            }
        });
        
        
        //panel for the center of the frame
        JPanel center = new JPanel();
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
        infoCard(activePlayingCard1,0); //GIVES INFORMATION ABOUT THE PLAYING CARDS IN THE FIELD FOR PLAYER 2
        infoCard(activePlayingCard2,1);
        infoCard(activePlayingCard3,2);
        infoCard(activePlayingCard4,3);
        infoCard(activePlayingCard5,4);
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
                field.setVisible(true);
                
                cardInHandCount = cardInHandCount - 1;
                if (cardInHandCount < 5)
                {
                    deck.setEnabled(true);
                }
            }
        });
    }
   
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
    
    /**
     * Implements the menu item
     */
    public void actionPerformed(ActionEvent event)
    {
        System.out.println("Menu item: " + event.getActionCommand());
    }
    
    /**
     * Create the main Frame's menu bar.
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
            {
                openFile();
            }
        });
        fileMenu.add(openItem);
        JMenuItem quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                quit();
            }
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
     *
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
