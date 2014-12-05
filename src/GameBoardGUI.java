package src;


import java.awt.BorderLayout;
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
    private Card card;
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
    private JButton deck;
    private int cardInHandCount = 5;
    private static JFileChooser fileChooser = new JFileChooser(System.getProperty("user.dir"));
    private JTextField currentPlayer = new JTextField(10);
    
    
    
    /**
     * Constructor for objects of class GameBoardGUI
     */
    public GameBoardGUI()
    {
        game = new GameBoard();
        card = new CreatureCard(1,"Monster1",30,100,"FIRE",true);
        card.setName("Boo");
        card.setCardNumber(1);
         final JButton cardInHand1 = new JButton(game.getThisPlayer().getHand().get(0).getName());
    final JButton cardInHand2 = new JButton(game.getThisPlayer().getHand().get(1).getName());
    final JButton cardInHand3 = new JButton(game.getThisPlayer().getHand().get(2).getName());
    final JButton cardInHand4 = new JButton(game.getThisPlayer().getHand().get(3).getName());
    final JButton cardInHand5 = new JButton(game.getThisPlayer().getHand().get(4).getName());
    final JButton activePlayingCard1 = new JButton("Active Playing Card #1");
    final JButton activePlayingCard2 = new JButton("Active Playing Card #2");
    final JButton activePlayingCard3 = new JButton("Active Playing Card #3");
    final JButton activePlayingCard4 = new JButton("Active Playing Card #4");
    final JButton activePlayingCard5 = new JButton("Active Playing Card #5");
    final JButton activePlayingCard6 = new JButton("Active Playing Card #6");
    final JButton activePlayingCard7 = new JButton("Active Playing Card #7");
    final JButton activePlayingCard8 = new JButton("Active Playing Card #8");
    final JButton activePlayingCard9 = new JButton("Active Playing Card #9");
    final JButton activePlayingCard10 = new JButton("Active Playing Card #10");
     JButton deck = new JButton("Deck");
        
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
        
        //panel for the south side of the frame
        JPanel south = new JPanel();
        contentPane.add(south, BorderLayout.SOUTH);
        final JButton cardInHand1 = new JButton("Card #1");
        final JButton cardInHand2 = new JButton("Card #2");
        final JButton cardInHand3 = new JButton("Card #3");
        final JButton cardInHand4 = new JButton("Card #4");
        final JButton cardInHand5 = new JButton("Card #5");
        south.add(cardInHand1);
        south.add(cardInHand2);
        south.add(cardInHand3);
        south.add(cardInHand4);
        south.add(cardInHand5);
        
        infoCard(cardInHand1);
        infoCard(cardInHand2);
        infoCard(cardInHand3);
        infoCard(cardInHand4);
        infoCard(cardInHand5);
        
        
        
        
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
        
        JButton endTurn = new JButton("End Turn");
        east.add(endTurn);
        currentPlayer.setText(game.whoStartsGame()); 
        endTurn.addActionListener(new ActionListener()
        {
          public void actionPerformed(ActionEvent e) 
          {
               currentPlayer.setText(game.nextTurn());
               
               if (currentPlayer.getText().equals(game.getPlayer1Name()))
               {
                   game.thisPlayer(currentPlayer.getText());
                   game.player1NewTurn();
                   game.getPlayer1Deck();
                   game.getPlayer1Hand();
               }
               
               if (currentPlayer.getText().equals(game.getPlayer2Name()))
               {
                   game.thisPlayer(currentPlayer.getText());
                   game.player2NewTurn();
                   game.getPlayer2Deck();
                   game.getPlayer2Hand();
               }
          }
        });
        
        
        east.add(deck);
        JButton attackButton = new JButton("Attack!");
        east.add(attackButton);
        deck.setEnabled(false);
        
        deck.addActionListener(new ActionListener()
        {
            int i = 6;
            
            public void actionPerformed(ActionEvent e)
            {
                JButton newCard = new JButton("Card #" + i);
                south.add(newCard);
                newCard.setVisible(true);
                south.revalidate();
                cardInHandCount = cardInHandCount + 1; 
                i++;
                if (cardInHandCount == 5)
                {
                    deck.setEnabled(false);
                }
            }
        });
        
        attackButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //GameBoard.Player1
            }
        });
        
        
        
        
        //panel for the center of the frame
        JPanel center = new JPanel();
        contentPane.add(center, BorderLayout.CENTER);
        center.setLayout(new GridLayout(3,5));
       
        center.add(activePlayingCard1);
        center.add(activePlayingCard2);
        center.add(activePlayingCard3);
        center.add(activePlayingCard4);
        center.add(activePlayingCard5);
        center.add(new JLabel(""));
        center.add(new JLabel(""));
        center.add(new JLabel(""));
        center.add(new JLabel(""));
        center.add(new JLabel(""));
        center.add(activePlayingCard6);
        center.add(activePlayingCard7);
        center.add(activePlayingCard8);
        center.add(activePlayingCard9);
        center.add(activePlayingCard10);
        
        activePlayingCard1.setVisible(false);
        activePlayingCard2.setVisible(false);
        activePlayingCard3.setVisible(false);
        activePlayingCard4.setVisible(false);
        activePlayingCard5.setVisible(false);
        activePlayingCard6.setVisible(false);
        activePlayingCard7.setVisible(false);
        activePlayingCard8.setVisible(false);
        activePlayingCard9.setVisible(false);
        activePlayingCard10.setVisible(false);
        
        
        activePlayingCard1.setToolTipText(card.toString());
        activePlayingCard1.addMouseListener(new MouseAdapter() 
        {
            public void mouseEntered(MouseEvent e)
            {
                activePlayingCard1.getToolTipText();
            }
            
        });
        
        transferValue(cardInHand1, activePlayingCard1);
        transferValue(cardInHand2, activePlayingCard2);
        transferValue(cardInHand3, activePlayingCard3);
        transferValue(cardInHand4, activePlayingCard4);
        transferValue(cardInHand5, activePlayingCard5);
        
       
        
        
    
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    /**
     * Transfers the value from the hand onto the playing field 
     */
    public void transferValue(JButton hand, JButton field)
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
    public void infoCard(JButton infoHand)
    {
        infoHand.setToolTipText("Info about card");
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
     * currently does not work
     */
    public void openFile()
    {
        //try
        {
            //String appData = System.getenv("APPDATA");
            //File appDataDir = new File(appData);
            //File textureDir = new File(appDataDir, "texture");
            //Desktop.getDesktop().open(textureDir);
        }
        //catch(FileNotFoundException fnfe)
        {
            //return;  
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
     * This does nothing at the moment, but I want it left in here
     * because I may need it in the future, not sure yet. Thanks.
     */
    public void replenishCard()
    {
        new ActionListener()
        {
            int i = 6;
            public void actionPerformed(ActionEvent e)
            {
                JButton newCard = new JButton("Card #" + i);
                newCard.setVisible(true);
                i++;
            }
        };
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
    
    /**
     * This does not do anythhing at the moment, but it might in the future
     * so please leave it alone
     */
    public void switchDecks()
    {
        if (currentPlayer.getText().equals(game.getPlayer1Name()))
        {
           
            transferValue(cardInHand1, activePlayingCard6);
            transferValue(cardInHand2, activePlayingCard7);
            transferValue(cardInHand3, activePlayingCard8);
            transferValue(cardInHand4, activePlayingCard9);
            transferValue(cardInHand5, activePlayingCard10);
        }
        
        if (currentPlayer.getText().equals(game.getPlayer2Name()))
        {
            transferValue(cardInHand1, activePlayingCard1);
            transferValue(cardInHand2, activePlayingCard2);
            transferValue(cardInHand3, activePlayingCard3);
            transferValue(cardInHand4, activePlayingCard4);
            transferValue(cardInHand5, activePlayingCard5);
            
        }
        //NOT COMPLETED
    }
}
