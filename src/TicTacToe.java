/**
 * Created by levis on 11/19/2015.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
public class TicTacToe {
    int i,j;
    int playerTurn = 0; // 0 = player 'O'    1 = player 'X'
    public String winner ="a";
    JMenuBar menBar = new JMenuBar();
    private JFrame mainFrame;
    public JButton button[][] ={{new JButton(""),new JButton(""),new JButton("")},
            {new JButton(""),new JButton(""),new JButton("")},
            {new JButton(""),new JButton(""),new JButton("")}};

    public TicTacToe() {
        mainFrame = new JFrame("Tic Tac Toe    ");
        mainFrame.setSize(900,900);
        Container c = mainFrame.getContentPane();
        c.setLayout(new GridLayout(3,3));
        //this adds a menu bar.
        mainFrame.setJMenuBar(menBar);
        JMenu file = new JMenu("File");
        menBar.add(file);//creates menu item.
        JMenuItem reset = new JMenuItem("New Game");
        file.add(reset);//this goes to listener that starts new game.
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);//this goes to the listener that will exit game.
        JMenu info = new JMenu("info");
        menBar.add(info);
        JMenuItem Keycode = new JMenuItem("Key Commands");
        info.add(Keycode);
        //this adds the buttons to the window.
        for(i=0; i<3;i++)
        {
            for (j=0; j<3;j++)
            {
                c.add(button[i][j]);
            }
        }
        //this adds the key listener to the buttons
        keyHandler keycode = new keyHandler();
        for(i=0; i<3;i++)
        {
            for (j = 0; j < 3; j++) {
                button[i][j].addKeyListener(keycode);
            }
        }
        //this adds the action listener to the buttons
        EventHandler bhandler = new EventHandler();
        for(i=0; i<3;i++)
        {
            for (j = 0; j < 3; j++) {
                button[i][j].addActionListener(bhandler);
            }
        }
        //listeners for when exit is clicked
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        // this is the listener when new game is clicked.
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                for(i=0;i<3;i++)
                {
                    for(j=0;j<3;j++)
                    {
                        button[i][j].setText("");
                        button[i][j].setBackground(Color.white);
                        winner = "c";
                        winner = "a";
                    }
                }
                playerTurn = 0;
            }
        });
        //this is for the info tab in the menu bar
        // so that when it is clicked another window opens to explain
        //how the Num Pad can be used and how N and X are used
        Keycode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame message = new JFrame("Key Commands");
                message.setSize(375,200);
                JTextArea tField;
                Container d = message.getContentPane();
                String words;
                words   = "  The game can be played with the number PAD. \n"
                        + "  The Num Pad numbers = the that positioned button. \n"
                        + "  The N key will start a new game.\n "
                        + "  The X key will exit the game and close the program.\n\n"
                        + "  BY: Nathan K. Levis   12/14/15. ";
                tField = new JTextArea(words);
                d.add(tField);
                tField.setFont(new Font("Time New Roman", Font.ITALIC, 15));
                tField.setEditable(false);
                tField.setVisible(true);
                message.setVisible(true);

            }
        });

        //this makes the screen visible.
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    //this makes the numpad work for playing the game.
    class keyHandler implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()== KeyEvent.VK_I)
            {
                JFrame message = new JFrame("Key Commands");
                message.setSize(375,200);
                JTextArea tField;
                Container v = message.getContentPane();
                String words;
                words   = "  The game can be played with the number PAD. \n"
                        + "  The Num Pad numbers = the that positioned button. \n"
                        + "  The N key will start a new game.\n "
                        + "  The X key will exit the game and close the program.\n\n"
                        + "  BY: Nathan K. Levis   12/14/15. ";
                tField = new JTextArea(words);
                v.add(tField);
                tField.setFont(new Font("Time New Roman", Font.ITALIC, 15));
                tField.setEditable(false);
                tField.setVisible(true);
                message.setVisible(true);
            }
            if (e.getKeyCode()== KeyEvent.VK_X)
            {System.exit(0);}
            if (e.getKeyCode() == KeyEvent.VK_N)
            {
                for(i=0;i<3;i++)
                {
                    for(j=0;j<3;j++)
                    {
                        button[i][j].setText("");
                        button[i][j].setBackground(Color.white);
                        winner = "a";
                    }
                }
                playerTurn = 0;
            }
            if (e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                if (button[0][0].getText() == "") {
                    if (playerTurn == 0) {
                        button[0][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][0].setBackground(Color.BLACK);
                        button[0][0].setForeground(Color.CYAN);
                        button[0][0].setText("O");
                    } else if (playerTurn == 1) {
                        button[0][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][0].setBackground(Color.BLACK);
                        button[0][0].setForeground(Color.RED);
                        button[0][0].setText("X");
                    }
                    System.out.println("key num7 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                if (button[0][1].getText() == "") {
                    if (playerTurn == 0) {
                        button[0][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][1].setBackground(Color.BLACK);
                        button[0][1].setForeground(Color.CYAN);
                        button[0][1].setText("O");
                    } else if (playerTurn == 1) {
                        button[0][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][1].setBackground(Color.BLACK);
                        button[0][1].setForeground(Color.RED);
                        button[0][1].setText("X");
                    }
                    System.out.println("key num8 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                if (button[0][2].getText() == "") {
                    if (playerTurn == 0) {
                        button[0][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][2].setBackground(Color.BLACK);
                        button[0][2].setForeground(Color.CYAN);
                        button[0][2].setText("O");
                    } else if (playerTurn == 1) {
                        button[0][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[0][2].setBackground(Color.BLACK);
                        button[0][2].setForeground(Color.RED);
                        button[0][2].setText("X");
                    }
                    System.out.println("key num9 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                if (button[1][0].getText() == "") {
                    if (playerTurn == 0) {
                        button[1][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][0].setBackground(Color.BLACK);
                        button[1][0].setForeground(Color.CYAN);
                        button[1][0].setText("O");
                    } else if (playerTurn == 1) {
                        button[1][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][0].setBackground(Color.BLACK);
                        button[1][0].setForeground(Color.RED);
                        button[1][0].setText("X");
                    }
                    System.out.println("key num4 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                if (button[1][1].getText() == "") {
                    if (playerTurn == 0) {
                        button[1][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][1].setBackground(Color.BLACK);
                        button[1][1].setForeground(Color.CYAN);
                        button[1][1].setText("O");
                    } else if (playerTurn == 1) {
                        button[1][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][1].setBackground(Color.BLACK);
                        button[1][1].setForeground(Color.RED);
                        button[1][1].setText("X");
                    }
                    System.out.println("key num5 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                if (button[1][2].getText() == "") {
                    if (playerTurn == 0) {
                        button[1][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][2].setBackground(Color.BLACK);
                        button[1][2].setForeground(Color.CYAN);
                        button[1][2].setText("O");
                    } else if (playerTurn == 1) {
                        button[1][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[1][2].setForeground(Color.RED);
                        button[1][2].setBackground(Color.BLACK);
                        button[1][2].setText("X");
                    }

                    System.out.println("key num6 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if (e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                if (button[2][0].getText() == "") {
                    if (playerTurn == 0) {
                        button[2][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][0].setBackground(Color.BLACK);
                        button[2][0].setForeground(Color.CYAN);
                        button[2][0].setText("O");
                    } else if (playerTurn == 1) {
                        button[2][0].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][0].setBackground(Color.BLACK);
                        button[2][0].setForeground(Color.RED);
                        button[2][0].setText("X");
                    }
                    System.out.println("key num1 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                if (button[2][1].getText() == "") {
                    if (playerTurn == 0) {
                        button[2][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][1].setBackground(Color.BLACK);
                        button[2][1].setForeground(Color.CYAN);
                        button[2][1].setText("O");
                    } else if (playerTurn == 1) {
                        button[2][1].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][1].setBackground(Color.BLACK);
                        button[2][1].setForeground(Color.RED);
                        button[2][1].setText("X");
                    }
                    System.out.println("key num2 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            else if(e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                if (button[2][2].getText() == "") {
                    if (playerTurn == 0) {
                        button[2][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][2].setForeground(Color.CYAN);
                        button[2][2].setBackground(Color.BLACK);
                        button[2][2].setText("O");
                    } else if (playerTurn == 1) {
                        button[2][2].setFont(new Font("Arial", Font.PLAIN, 123));
                        button[2][2].setForeground(Color.RED);
                        button[2][2].setBackground(Color.BLACK);
                        button[2][2].setText("X");
                    }
                    System.out.println("key num3 was pressed.");
                    if (playerTurn == 0)
                        playerTurn = 1;
                    else if (playerTurn == 1)
                        playerTurn = 0;
                }
            }
            winnerX();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }
    class EventHandler implements ActionListener
    {

        public void actionPerformed(ActionEvent e) {

            //this change=s text when button clicked
            int I = -2, J = -2;
            for (i = 0; i < 3; i++)
                for (j = 0; j < 3; j++) {
                    if (button[i][j] == e.getSource()) {
                        System.out.println("Button" + i + j + " was clicked");
                        I = i;
                        J = j;
                    }
                }

            // CHANGE THE BUTTON THAT WAS CLICKED
            if (button[I][J].getText()=="") {
                if (playerTurn == 0) {
                    button[I][J].setFont(new Font("Arial", Font.PLAIN, 123));
                    button[I][J].setForeground(Color.CYAN);
                    button[I][J].setBackground(Color.BLACK);
                    button[I][J].setText("O");
                } else if (playerTurn == 1) {
                    button[I][J].setFont(new Font("Arial", Font.PLAIN, 123));
                    button[I][J].setBackground(Color.BLACK);
                    button[I][J].setForeground(Color.RED);
                    button[I][J].setText("X");
                }
                if(playerTurn==0)
                    playerTurn = 1;
                else if (playerTurn==1)
                    playerTurn = 0;

            }

            winnerX();

        }
    }
    public String name;
    public void winnerX()
    {
        //this will tell winner by row

        for(i=0;i<3;i++)
            if (button[i][0].getText() == button[i][1].getText() && button[i][1].getText() == button[i][2].getText() && !button[i][2].getText().equals("")) {
                System.out.println("The Winner is Player" + button[i][0].getText());
                winner = "x";
                playerTurn = -1;
                name = button[i][0].getText();
            }

        //this will tell winner by column
        for(j=0;j<3;j++){
            if (button[0][j].getText() == button[1][j].getText() && button[1][j].getText() == button[2][j].getText() && !button[2][j].getText().equals(""))
            {
                System.out.println("The Winner is Player" + button[0][j].getText());
                winner = "x";
                playerTurn = -1;
                name = button[0][j].getText();
            }
        }

        //this will tell winner by diagonal
        if(button[0][0].getText() == button[1][1].getText() && button[1][1].getText() == button[2][2].getText() && !button[2][2].getText().equals("")             )
        {
            System.out.println("The Winner is Player 2/X");
            winner="x";
            playerTurn=-1;
            name = button[2][2].getText();
        }

        if (button[0][2].getText() == button[1][1].getText() && button[1][1].getText() == button[2][0].getText() && !button[2][0].getText().equals(""))
        {
            System.out.println();
            winner = "x";winner="x";
            playerTurn=-1;
            name = button[2][0].getText();
        }
        //this creates a window if x wins

        if(winner == "x")
        {
            JFrame winX = new JFrame("");
            winX.setSize(500,200);
            Container con = winX.getContentPane();
            JTextArea tField;
            tField = new JTextArea( "\tGAME OVER\n                    Player "+ name + " has Won!!!!");
            tField.setFont(new Font("Arial",Font.PLAIN,25) );
            con.add(tField);
            tField.setEditable(false);
            tField.setVisible(true);
            winX.setVisible(true);

        }

    }

    //this is just the main that activates the code above
    public static void main(String[]args)
    {
        new TicTacToe();
    }
}
