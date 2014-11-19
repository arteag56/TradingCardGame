package src;

import java.awt.BorderLayout;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
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
    private JTextField textField1, textField2, textField3, textField4, textField5;
    private Card card;
    final JButton cardInHand1 = new JButton("Card #1");
    final JButton cardInHand2 = new JButton("Card #2");
    final JButton cardInHand3 = new JButton("Card #3");
    final JButton cardInHand4 = new JButton("Card #4");
    final JButton cardInHand5 = new JButton("Card #5");
    final JButton activePlayingCard1 = new JButton("Active Playing Card #1");
    final JButton activePlayingCard2 = new JButton("Active Playing Card #2");
    final JButton activePlayingCard3 = new JButton("Active Playing Card #3");
    final JButton activePlayingCard4 = new JButton("Active Playing Card #4");
    final JButton activePlayingCard5 = new JButton("Active Playing Card #5");
    private int cardInHandCount = 5;
    
    
    /**
     * Constructor for objects of class GameBoardGUI
     */
    public GameBoardGUI()
    {
        card = new CreatureCard(20,100,false);
        card.setName("Boo");
        card.setCardNumber(1);
        JTextField();
        makeFrame();
    }
    
    /**
     * This is my JText Field
     */
    public void JTextField()
    {
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();
        textField5 = new JTextField();
    }
    
    /**
     *
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
        west.add(new JTextField(10));
        west.add(new JLabel(""));
        west.add(new JLabel(""));
        west.add(new JLabel(""));
        west.add(new JLabel("Player1"));
        west.add(new JTextField(10));
        west.add(new JLabel("Player1 Record"));
        west.add(new JTextField(10));
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
       
        //panel for the east side of the frame
        JPanel east = new JPanel();
        contentPane.add(east, BorderLayout.EAST);
        east.setLayout(new GridLayout(9,1));
        east.add(new JLabel("Player2"));
        east.add(new JTextField(10));
        east.add(new JLabel("Player2 Record"));
        east.add(new JTextField(10));
        east.add(new JLabel(""));
        east.add(new JLabel(""));
        east.add(new JLabel(""));
        JButton deck = new JButton("Deck");
        east.add(deck);
        JButton attackButton = new JButton("Attack!");
        east.add(attackButton);
        
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
        final JButton activePlayingCard6 = new JButton("Active Playing Card #6");
        final JButton activePlayingCard7 = new JButton("Active Playing Card #7");
        final JButton activePlayingCard8 = new JButton("Active Playing Card #8");
        final JButton activePlayingCard9 = new JButton("Active Playing Card #9");
        final JButton activePlayingCard10 = new JButton("Active Playing Card #10");
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
     * 
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
            }
        });
    }
    
    /**
     * 
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
     *
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
    }
    
    /**
     *
     */
    public static void main(String[] args)
    {
        GameBoardGUI x = new GameBoardGUI();
    }
    
    /**
     *
     */
    public void openFile()
    {
    }
    
    /**
     *
     */
    public void quit()
    {
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
     * 
     */
    public void displayWinner()
    {
        String message = "(Insert Player Here) is the WINNER!";
        JOptionPane optionPane = new JOptionPane();
        optionPane.setMessage(message);
        optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = optionPane.createDialog(null, "Width 100");
        dialog.setVisible(true);
    }
}
