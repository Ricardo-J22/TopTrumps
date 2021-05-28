import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The cover of the Game, including the choice of modes, and you can
 * also learn the rules about the game by clicking help button, and the cover
 * also provides the choice of the number of enemies in the mode of human
 * vs computers, this cover provides a link between the users and game
 */
public class GameCover {

    /**
     * The button of human vs human mode
     */
    private JButton mode_button1;

    /**
     * The button of human vs computers mode
     */
    private JButton mode_button2;

    /**
     * The button of start the human vs human mode game
     */
    private JButton start_button;

    /**
     * The button of providing the rules of the mode1 game
     */
    private JButton help1_button;

    /**
     * The button of providing the rules of the mode2 game
     */
    private JButton help2_button;

    /**
     * The button of choosing the number of enemies
     */
    private JButton number_button;

    /**
     * The button of backing to the interface of human vs human
     */
    private JButton back1_button;

    /**
     * The button of backing to the interface of human vs computers
     */
    private JButton back2_button;

    /**
     * The button of backing to the interface of mode selection from the interface of human vs human interface
     */
    private JButton back3_button;

    /**
     * The button of backing to the interface of mode selection from human vs computers interface
     */
    private JButton back4_button;

    /**
     * The button of backing to the interface of human vs computers
     */
    private JButton back5_button;

    /**
     * The button of submitting the number of enemies
     */
    private JButton submit_button;

    /**
     * Button to realize the selection of the number of machines behind
     */
    JRadioButton[] options;

    /**
     * The labels that show rules of the games
     */
    private JLabel rule, rule2;

    /**
     * All the panels that used
     */
    private JPanel panel1, panel2, panel3, panel4, panel5, panel6;

    /**
     * The frame of the CoverGame
     */
    private final JFrame frame;

    /**
     * The ActionListener of human vs human mode
     */
    private class ModeButton1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel1.setVisible(false);
            panel2.setVisible(true);
        }
    }

    /**
     * The ActionListener of human vs computers mode
     */
    private class ModeButton2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            panel1.setVisible(false);
            panel4.setVisible(true);

        }
    }

    /**
     * The ActionListener of help1 button
     */
    private class Help1Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel2.setVisible(false);
            panel3.setVisible(true);
            panel4.setVisible(false);
            panel5.setVisible(false);
        }
    }

    /**
     * The ActionListener of help2 button
     */
    private class Help2Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel2.setVisible(false);
            panel4.setVisible(false);
            panel5.setVisible(false);
            panel6.setVisible(true);
        }
    }

    /**
     * The ActionListener of choosing the number of enemies
     */
    private class NumberButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel5.setVisible(true);
            panel4.setVisible(false);
        }
    }

    /**
     * The ActionListener of back1 button
     */
    private class Back1Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel4.setVisible(true);
            panel6.setVisible(false);
        }
    }

    /**
     * The ActionListener of back2 button
     */
    private class Back2Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel2.setVisible(true);
            panel3.setVisible(false);
        }
    }

    /**
     * The ActionListener of back3 button
     */
    private class Back3Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel4.setVisible(false);
        }
    }

    /**
     * The ActionListener of back4 button
     */
    private class Back4Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel1.setVisible(true);
            panel2.setVisible(false);
            panel4.setVisible(false);
        }
    }

    /**
     * The ActionListener of back5 button
     */
    private class Back5Button implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Switching the interface by changing if_visible of different panels
            panel1.setVisible(false);
            panel4.setVisible(true);
            panel5.setVisible(false);
        }
    }

    /**
     * The ActionListener of start button
     */
    private class StartButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // To change the frame, delete the present frame
            frame.dispose();
            // Create an object of TwoPlayer
            TwoPlayer t = new TwoPlayer();
        }
    }

    /**
     * The ActionListener of ok button
     */
    private class SubmitButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Choose any number of enemies then change the frame, delete the present frame
            for (int i = 0; i < options.length; i++) {
                if (options[i].isSelected()) {
                    frame.dispose();
                    // create an object of human vs computers mode
                    new ComputerPlayer(i + 2);
                }
            }
        }
    }

    /**
     * Constructor of GameCover
     * Display the cover of game
     * create and set a frame
     * Call methods that set panels
     * add ActionListener
     */
    public GameCover() {

        //create a new frame
        frame = new JFrame();
        frame.setTitle("TopTrumps");
        frame.setLayout(null);
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Call the methods to create panel
        layout_panel1();
        layout_panel2();
        layout_panel3();
        layout_panel4();
        layout_panel5();
        layout_panel6();

        //Add ActionListener to all the buttons
        mode_button1.addActionListener(new ModeButton1());
        start_button.addActionListener(new StartButton());
        mode_button2.addActionListener(new ModeButton2());
        help1_button.addActionListener(new Help1Button());
        help2_button.addActionListener(new Help2Button());
        back1_button.addActionListener(new Back1Button());
        back2_button.addActionListener(new Back2Button());
        number_button.addActionListener(new NumberButton());
        submit_button.addActionListener(new SubmitButton());
        back3_button.addActionListener(new Back3Button());
        back4_button.addActionListener(new Back4Button());
        back5_button.addActionListener(new Back5Button());

        //Refresh the interface
        panel1.setVisible(false);
        panel1.setVisible(true);
    }

    /**
     * Method of panel1
     * Set the initial interface of GameCover
     */
    public void layout_panel1() {

        //import the image in the res as the background
        Image panel1_image = new ImageIcon("res/bkg/NeyMar (2).jpg").getImage();
        panel1 = new BackgroundPanel(panel1_image);
        panel1.setLayout(null);

        // Initialize the button
        mode_button1 = new JButton("human_VS_human");
        mode_button2 = new JButton("human_VS_computers");
        mode_button1.setBorder(BorderFactory.createRaisedBevelBorder());
        mode_button2.setBorder(BorderFactory.createRaisedBevelBorder());
        mode_button1.setSize(200, 50);
        mode_button2.setSize(200, 50);
        mode_button1.setLocation(940, 170);
        mode_button2.setLocation(940, 300);
        mode_button1.setBackground(new Color(255, 251, 240));
        mode_button2.setBackground(new Color(255, 251, 240));

        // Set the size of the panel and add the buttons to the panel
        panel1.setSize(1200, 600);
        panel1.add(mode_button1);
        panel1.add(mode_button2);

        // Add the panel to the frame
        frame.add(panel1);
    }

    /**
     * Method of panel2
     * Set interface of human vs human mode
     */
    public void layout_panel2() {

        //import the image in the res as the background
        Image panel2_image = new ImageIcon("res/bkg/Messi.jpg").getImage();
        panel2 = new BackgroundPanel(panel2_image);
        panel2.setLayout(null);
        panel2.setVisible(false);

        // Initialize the button
        start_button = new JButton("Start");
        help1_button = new JButton("Help");
        back4_button = new JButton("Back");

        // Set the button have border
        start_button.setBorder(BorderFactory.createRaisedBevelBorder());
        help1_button.setBorder(BorderFactory.createRaisedBevelBorder());
        back4_button.setBorder(BorderFactory.createRaisedBevelBorder());

        //Set the size and Location and background
        start_button.setSize(200, 50);
        help1_button.setSize(200, 50);
        back4_button.setSize(200, 50);
        start_button.setLocation(840, 50);
        help1_button.setLocation(840, 155);
        back4_button.setLocation(840, 260);
        help1_button.setBackground(new Color(225, 215, 210));
        start_button.setBackground((new Color(125, 210, 210)));
        back4_button.setBackground(new Color(225, 210, 210));

        // Set the size of the panel and add the buttons to the panel
        panel2.setSize(1200, 600);
        panel2.add(start_button);
        panel2.add(help1_button);
        panel2.add(back4_button);

        // Add the panel to the frame
        frame.add(panel2);
    }

    /**
     * Method of panel3
     * Set interface of rules of human vs human mode
     */
    public void layout_panel3() {

        //import the image in the res as the background
        Image panel3_image = new ImageIcon("res/bkg/HelpbackGround.png").getImage();
        panel3 = new BackgroundPanel(panel3_image);
        panel3.setLayout(null);
        panel3.setVisible(false);

        // Initialize the button and label
        back2_button = new JButton("Back");
        rule = new JLabel("<html>2. Players are eliminated when they lose their last card, " +
                "and the winner is" + " the player who have \n" + "won more than 50% of the cards.");
        rule2 = new JLabel("<html>1. The mode of human VS human is played by two players, and at the beginning" +
                " the game will randomly select one player to speak first, and the player can choose one attribute to compare " +
                "with another player, if the number of the attribute is larger than another player, you will win the tow cards" +
                " but if the number is smaller, you will lose your card, if the result is draw, the two cards will be placed" +
                " in the middle, and wait the next round, the winner in the next round will take all the cards.");

        // Set the font of the words in the label
        rule2.setFont(new Font("Times New Roman", 1, 25));
        rule.setFont(new Font("Times New Roman", 1, 25));

        // Set border of the button
        back2_button.setBorder(BorderFactory.createRaisedBevelBorder());

        // Set size and location of the button and label
        rule.setSize(1000, 250);
        rule2.setSize(1000, 250);
        back2_button.setSize(100, 50);
        rule.setLocation(140, 280);
        rule2.setLocation(140, 30);
        back2_button.setLocation(1050, 500);
        back2_button.setBackground(new Color(220, 120, 120));

        // Set the size of panel and add the button and label to the panel
        panel3.setSize(1200, 600);
        panel3.add(rule);
        panel3.add(rule2);
        panel3.add(back2_button);

        // Add the panel to the frame
        frame.add(panel3);
    }

    /**
     * Method of panel4
     * Set interface of human vs computers mode
     */
    public void layout_panel4() {

        //import the image in the res as the background
        Image panel4_image = new ImageIcon("res/bkg/Mbappé.jpg").getImage();
        panel4 = new BackgroundPanel(panel4_image);
        panel4.setLayout(null);
        panel4.setVisible(false);

        // Initialize the button and label
        number_button = new JButton("Choose Machine_Number");
        help2_button = new JButton("Help");
        back3_button = new JButton("Back");

        // Set border of the buttons
        number_button.setBorder(BorderFactory.createRaisedBevelBorder());
        help2_button.setBorder(BorderFactory.createRaisedBevelBorder());
        back3_button.setBorder(BorderFactory.createRaisedBevelBorder());

        // Set size and location of the buttons
        number_button.setSize(200, 50);
        help2_button.setSize(200, 50);
        back3_button.setSize(200, 50);
        number_button.setLocation(140, 110);
        help2_button.setLocation(140, 230);
        back3_button.setLocation(140, 350);

        // Set background of the buttons
        help2_button.setBackground(new Color(247, 238, 214));
        number_button.setBackground((new Color(247, 208, 214)));
        back3_button.setBackground(new Color(247, 238, 214));

        // Set the size of panel and add the button to the panel
        panel4.setSize(1200, 600);
        panel4.add(number_button);
        panel4.add(help2_button);
        panel4.add(back3_button);

        // Add the panel to the frame
        frame.add(panel4);
    }

    /**
     * Method of panel5
     * Set interface of choosing number of enemies
     */
    public void layout_panel5() {

        //import the image in the res as the background
        Image panel5_image = new ImageIcon("res/bkg/Ronaldo2.jpg").getImage();
        panel5 = new BackgroundPanel(panel5_image);
        panel5.setLayout(null);
        panel5.setVisible(false);

        // Create a checkbox and the buttons it selects
        submit_button = new JButton("OK");
        back5_button = new JButton("Back");

        // Set border of the buttons
        submit_button.setBorder(BorderFactory.createRaisedBevelBorder());
        back5_button.setBorder(BorderFactory.createRaisedBevelBorder());

        // Create buttons to let the users choose how many enemies
        options = new JRadioButton[4];
        for (int i = 0; i < options.length; i++) {
            options[i] = new JRadioButton("" + (i + 1));
        }

        // Set size and location for the buttons
        for (JRadioButton button : options
        ) {
            button.setSize(250, 150);
            button.setBackground(new Color(200, 180, 110));
            button.setFont(new Font("Times New Roman", 1, 30));
            panel5.add(button);
        }
        for (int i = 0; i < options.length; i++) {
            options[i].setLocation(880, 50 + 100 * i);
        }
        submit_button.setSize(130, 40);
        back5_button.setSize(130, 40);
        submit_button.setLocation(865, 510);
        back5_button.setLocation(1010, 510);

        // Set background to the buttons
        submit_button.setBackground(new Color(250, 252, 250));
        back5_button.setBackground(new Color(250, 252, 250));

        //Add buttons to the panel
        panel5.add(submit_button);
        panel5.add(back5_button);

        // Set the border
        panel5.setBorder(BorderFactory.createTitledBorder("One option"));
        panel5.setSize(1200, 600);

        // Add the panel to the frame
        frame.add(panel5);
    }

    /**
     * Method of panel6
     * Set interface of rules of human vs computers
     */
    public void layout_panel6() {

        //import the image in the res as the background
        Image panel6_image = new ImageIcon("res/bkg/HelpbackGround.png").getImage();
        panel6 = new BackgroundPanel(panel6_image);
        panel6.setLayout(null);
        panel6.setVisible(false);

        // Initialize the button and label
        back1_button = new JButton("Back");
        rule = new JLabel("<html>2. Players are eliminated when they lose their last card, " +
                "and the winner is\n" + " the player who have " + "won more than 50% of the cards.");
        rule2 = new JLabel("<html>1. NEW GAME: Start a new game with the number of players you have chosen before." +
                "If it’s your turn you can start to choose a factor. If it’s others’ turn, wait a minute.\n" +
                "SHOW CARD: Show all cards in this round, after you have chosen a factor " +
                "(or when you have no choice to choose). The player who have the highest value will win this round.\n" +
                "NEXT ROUND: Click next round after you have clicked “show card”. The card of the winner of " +
                "the last round will be shown directly. If you are that one, you can make a choice. " +
                "If you are not, just show your card.");

        // Set size and style of the words in the label
        rule2.setFont(new Font("Times New Roman", 1, 25));
        rule.setFont(new Font("Times New Roman", 1, 25));

        // Set border for the button
        back1_button.setBorder(BorderFactory.createRaisedBevelBorder());

        //Set size and location of the buttons and labels
        rule.setSize(1000, 300);
        rule2.setSize(1000, 250);
        back1_button.setSize(100, 50);
        rule.setLocation(140, 260);
        rule2.setLocation(140, 30);
        back1_button.setLocation(1050, 500);
        panel6.setSize(1200, 600);

        // Set color of the button
        back1_button.setBackground(new Color(220, 120, 120));

        // Add buttons and label to the panel
        panel6.add(rule2);
        panel6.add(rule);
        panel6.add(back1_button);

        // Add the panel to the frame
        frame.add(panel6);
    }

}

