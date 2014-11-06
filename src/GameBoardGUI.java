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
public class GameBoardGUI
    implements ActionListener
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private JTextField textField1, textField2, textField3, textField4, textField5;
    

    /**
     * Constructor for objects of class GameBoardGUI
     */
    public GameBoardGUI()
    {
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
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
        west.add(new JLabel("Current Player"));
        west.add(new JTextField(10));
        west.add(new JLabel("Player1 Record"));
        west.add(new JTextField(10));
        west.add(new JLabel("Player2 Record"));
        west.add(new JTextField(10));
        
        
        //panel for the south side of the frame
        JPanel south = new JPanel();
        contentPane.add(south, BorderLayout.SOUTH);
        south.add(new JButton("Card #1"));
        south.add(new JButton("Card #2"));
        south.add(new JButton("Card #3"));
        south.add(new JButton("Card #4"));
        south.add(new JButton("Card #5"));
        
        
        //panel for the north side of the frame
         JPanel north = new JPanel();
        contentPane.add(north, BorderLayout.NORTH);
        
        
        
        
        
        
        frame.pack();
        frame.setVisible(true);
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
}

