import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Two-player battle game
 */
public class TwoPlayer {

    /**
     * Build a game
     */
    private Game mainGame;

    /**
     * Button color flag
     */
    private boolean color_flag = false;

    /**
     * player0 Label for panel1
     */
    private JLabel player0;
    /**
     * image of player0 for panel1
     */
    private JLabel player0_image;

    /**
     * The player0's basic information title for panel1
     */
    private JLabel[] info_player0 = new JLabel[7];

    /**
     * The player0's basic information data for panel1
     */
    private JLabel[] data_player0 = new JLabel[7];

    /**
     * The player0's basic attributes button text for panel2
     */
    private JButton[] factor_player0 = new JButton[5];

    /**
     * The player0's basic attributes data for panel2
     */
    private JLabel[] value_player0 = new JLabel[5];

    /**
     * The winning cards text for player0 for panel2
     */
    private JLabel win_card0;

    /**
     * The resting card text for player0 for panel2
     */
    private JLabel rest_card0;

    /**
     * The number of winning cards for player0 for panel2
     */
    private JLabel win_card0_num;

    /**
     * The number of resting cards for player0 for panel2
     */
    private JLabel rest_card0_num;

    /**
     * The game key for panel3
     */
    private JButton[] cButton = new JButton[4];

    /**
     * Result display window for panel3
     */
    private JLabel resultLabel;

    /**
     * player1 Label for panel4
     */
    private JLabel player1;

    /**
     * The player1's basic information title for panel4
     */
    private JLabel player1_image;

    /**
     * The player1's basic information title for panel4
     */
    private JLabel[] info_player1 = new JLabel[7];

    /**
     * The player1's basic information data for panel4
     */
    private JLabel[] data_player1 = new JLabel[7];

    /**
     * The player1's basic attributes button text for panel5
     */
    private JButton[] factor_player1 = new JButton[5];

    /**
     * The player1's basic attributes data for panel5
     */
    private JLabel[] value_player1 = new JLabel[5];

    /**
     * The winning cards text for player1 for panel5
     */
    private JLabel win_card1;

    /**
     * The resting cards text for player1 for panel5
     */
    private JLabel rest_card1;

    /**
     * The number of winning cards for player0 for panel5
     */
    private JLabel win_card1_num;

    /**
     * The number of resting cards for player0 for panel5
     */
    private JLabel rest_card1_num;

    /**
     * This button is used to return to the main interface menu
     */
    private JButton back;

    /**
     * All Panel
     */
    private JPanel panel1, panel2, panel3, panel4, panel5;

    /**
     * The frame of two-player battle game
     */
    private JFrame frame;

    /**
     * player0's attack ActionListener
     */
    private class player0_attackButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.ATTACK);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[0].setBackground(Color.RED);
            factor_player1[0].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player0's defense ActionListener
     */
    private class player0_defenseButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.DEFENCE);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[1].setBackground(Color.RED);
            factor_player1[1].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player0's skill ActionListener
     */
    private class player0_skillButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.SKILL);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[2].setBackground(Color.RED);
            factor_player1[2].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player0's speed ActionListener
     */
    private class player0_speedButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.SPEED);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[3].setBackground(Color.RED);
            factor_player1[3].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player0's power capability ActionListener
     */
    private class player0_powButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.POWER_CAP);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[4].setBackground(Color.RED);
            factor_player1[4].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player1's attack ActionListener
     */
    private class player1_attackButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.ATTACK);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[0].setBackground(Color.RED);
            factor_player1[0].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player1's defense ActionListener
     */
    private class player1_defenseButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.DEFENCE);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[1].setBackground(Color.RED);
            factor_player1[1].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player1's skill ActionListener
     */
    private class player1_skillButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.SKILL);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[2].setBackground(Color.RED);
            factor_player1[2].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player1's speed ActionListener
     */
    private class player1_speedButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.SPEED);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[3].setBackground(Color.RED);
            factor_player1[3].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * player1's power capability ActionListener
     */
    private class player1_powButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.setChosenCategory(Card.POWER_CAP);
            if (color_flag) {
                refreshButton();
            }
            factor_player0[4].setBackground(Color.RED);
            factor_player1[4].setBackground(Color.RED);
            color_flag = true;
        }
    }

    /**
     * Game start button ActionListener (in Panel3)
     */
    private class startButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.startGame();
            update_info();
            update_card_num();
            printVisible(false);
            cButton[0].setEnabled(false);
        }
    }

    /**
     * Play button ActionListener (in Panel3)
     */
    private class playButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame.nextRound();
            update_card_num();
            update_result();
            allVisible(true);
            printVisible(true);
            cButton[1].setEnabled(false);
        }
    }

    /**
     * nextRound button ActionListener (in Panel3)
     */
    private class nextRoundButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            update_info();
            refreshButton();
            printVisible(false);
            cButton[1].setEnabled(true);
        }
    }

    /**
     * nextGame button ActionListener (in Panel3)
     */
    private class nextGameButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mainGame = new Game(2);
            allVisible(false);
            cButton[0].setEnabled(true);
            cButton[1].setEnabled(true);
        }
    }

    /**
     * back button ActionListener (in Panel5)
     */
    private class backButton implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
            GameCover a = new GameCover();
        }
    }

    /**
     * constructor of TwoPlayer
     * Build a game
     * Create and set a frame
     * add ActionListener
     */
    public TwoPlayer() {

        //Build a game, the number of player is 2
        mainGame = new Game(2);
        //frame
        frame = new JFrame();
        frame.setTitle("Two Players");
        //GridLayout of frame
        frame.setLayout(new GridLayout(1, 5));
        frame.setSize(1200, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //five panels methods
        layout_panel1();
        layout_panel2();
        layout_panel3();
        layout_panel4();
        layout_panel5();

        //add ActionListener to all the button
        //player0
        factor_player0[0].addActionListener(new player0_attackButton());
        factor_player0[1].addActionListener(new player0_defenseButton());
        factor_player0[2].addActionListener(new player0_skillButton());
        factor_player0[3].addActionListener(new player0_speedButton());
        factor_player0[4].addActionListener(new player0_powButton());
        //player1
        factor_player1[0].addActionListener(new player1_attackButton());
        factor_player1[1].addActionListener(new player1_defenseButton());
        factor_player1[2].addActionListener(new player1_skillButton());
        factor_player1[3].addActionListener(new player1_speedButton());
        factor_player1[4].addActionListener(new player1_powButton());
        //Game key part (middle part)
        cButton[0].addActionListener(new startButton());
        cButton[1].addActionListener(new playButton());
        cButton[2].addActionListener(new nextRoundButton());
        cButton[3].addActionListener(new nextGameButton());
        //back to the main menu
        back.addActionListener(new backButton());

        //Refresh the interface
        panel1.setVisible(false);
        panel1.setVisible(true);
    }

    /**
     * The method of panel1
     * The basic information of player0
     */
    public void layout_panel1() {
        //Create panel1
        Image panel1_image = new ImageIcon("res/bkg/panel2_bkg.jpg").getImage();
        panel1 = new BackgroundPanel(panel1_image);
        panel1.setLayout(null);

        //player0 label
        player0 = new JLabel("player0", SwingConstants.CENTER);
        player0.setSize(120, 30);
        player0.setLocation(50, 10);
        player0.setOpaque(true);
        player0.setBackground(new Color(9, 234, 141));
        player0.setBorder(BorderFactory.createLoweredBevelBorder());
        player0.setFont(new Font("Times New Roman", 1, 17));
        panel1.add(player0);

        //player_images
        player0_image = new JLabel();
        player0_image.setBorder(BorderFactory.createRaisedBevelBorder());
        player0_image.setBounds(40, 50, 150, 150);
        panel1.add(player0_image);

        //info_player[]
        info_player0[0] = new JLabel("name", SwingConstants.CENTER);
        info_player0[1] = new JLabel("nation", SwingConstants.CENTER);
        info_player0[2] = new JLabel("club", SwingConstants.CENTER);
        info_player0[3] = new JLabel("height", SwingConstants.CENTER);
        info_player0[4] = new JLabel("weight", SwingConstants.CENTER);
        info_player0[5] = new JLabel("foot", SwingConstants.CENTER);
        info_player0[6] = new JLabel("age", SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            //new data_player0[]
            data_player0[i] = new JLabel("", SwingConstants.CENTER);
            //Set size
            info_player0[i].setSize(120, 50);
            data_player0[i].setSize(120, 30);
            //Set location
            info_player0[i].setLocation(50, 200 + (48 * i));
            data_player0[i].setLocation(50, 235 + (48 * i));
            //Set border
            data_player0[i].setBorder(BorderFactory.createLoweredBevelBorder());
            //add label
            panel1.add(info_player0[i]);
            panel1.add(data_player0[i]);
        }
        frame.add(panel1);
    }

    /**
     * The method of panel2
     * The attribute of player0
     * Clickable attribute button
     */
    public void layout_panel2() {
        //Create Panel2
        Image panel2_image = new ImageIcon("res/bkg/panel2_bkg.jpg").getImage();
        panel2 = new BackgroundPanel(panel2_image);
        panel2.setLayout(null);

        //Create a small panel in Panel2
        JPanel smallPanel = new JPanel();
        smallPanel.setLayout(null);
        smallPanel.setBackground(new Color(5, 180, 153));
        smallPanel.setBorder(BorderFactory.createRaisedBevelBorder());
        smallPanel.setBounds(20, 80, 210, 400);

        //Create button
        factor_player0[0] = new JButton("attack");
        factor_player0[1] = new JButton("defense");
        factor_player0[2] = new JButton("skill");
        factor_player0[3] = new JButton("speed");
        factor_player0[4] = new JButton("power_capability");

        for (int i = 0; i < 5; i++) {
            //Create value_player[]
            value_player0[i] = new JLabel("", SwingConstants.CENTER);
            //Set size
            factor_player0[i].setSize(130, 30);
            value_player0[i].setSize(30, 30);
            //Set location
            factor_player0[i].setLocation(30, 50 + (70 * i));
            value_player0[i].setLocation(170, 50 + (70 * i));
            //Set color of button
            factor_player0[i].setBackground(Color.white);
            //Set style of button
            factor_player0[i].setBorder(BorderFactory.createRaisedBevelBorder());
            //add Button
            smallPanel.add(factor_player0[i]);
            smallPanel.add(value_player0[i]);
        }

        //Create win,rest card
        win_card0 = new JLabel("Win Cards:", SwingConstants.CENTER);
        rest_card0 = new JLabel("Rest Card:", SwingConstants.CENTER);
        win_card0_num = new JLabel("0", SwingConstants.RIGHT);
        rest_card0_num = new JLabel("0", SwingConstants.RIGHT);
        //Set size of win,rest card
        win_card0.setSize(80, 20);
        rest_card0.setSize(80, 20);
        win_card0_num.setSize(20, 15);
        rest_card0_num.setSize(20, 15);
        //Set location of win,rest card
        win_card0.setLocation(135, 500);
        win_card0_num.setLocation(200, 503);
        rest_card0.setLocation(135, 530);
        rest_card0_num.setLocation(200, 533);

        //add win，rest
        panel2.add(win_card0);
        panel2.add(win_card0_num);
        panel2.add(rest_card0);
        panel2.add(rest_card0_num);

        //add smallPanel into panel2
        panel2.add(smallPanel);
        frame.add(panel2);
    }

    /**
     * The method of panel3
     * Game control button and result display
     */
    public void layout_panel3() {
        //Create Panel3
        Image panel3_image = new ImageIcon("res/bkg/panel3_bkg.jpg").getImage();
        panel3 = new BackgroundPanel(panel3_image);
        panel3.setLayout(null);
        panel3.setBackground(new Color(181, 182, 198));

        //Result display window
        resultLabel = new JLabel("", SwingConstants.CENTER);
        resultLabel.setSize(204, 137);
        resultLabel.setLocation(17, 400);
        resultLabel.setFont(new Font("Times New Roman", 1, 17));
        resultLabel.setBorder(BorderFactory.createRaisedBevelBorder());
        panel3.add(resultLabel);
        cButton[0] = new JButton("Game start");
        cButton[1] = new JButton("Play");
        cButton[2] = new JButton("Next Round");
        cButton[3] = new JButton("Next Game");

        for (int i = 0; i < 4; i++) {
            //Set Size
            cButton[i].setSize(120, 50);
            //Set Location
            cButton[i].setLocation(60, 55 + (90 * i));
            //Set background color
            cButton[i].setBackground(new Color(24, 188, 239, 248));
            //Set style of border
            cButton[i].setBorder(BorderFactory.createRaisedBevelBorder());
        }
        for (int i = 0; i < 4; i++) {
            panel3.add(cButton[i]);
        }
        frame.add(panel3);
    }

    /**
     * The method of panel4
     * The basic information of player1
     */
    public void layout_panel4() {
        //Create Panel4
        Image panel4_image = new ImageIcon("res/bkg/panel2_bkg.jpg").getImage();
        panel4 = new BackgroundPanel(panel4_image);
        panel4.setLayout(null);

        //player0
        player1 = new JLabel("player1", SwingConstants.CENTER);
        player1.setSize(120, 30);
        player1.setLocation(50, 10);
        player1.setOpaque(true);
        player1.setBackground(new Color(9, 234, 141));
        player1.setBorder(BorderFactory.createLoweredBevelBorder());
        player1.setFont(new Font("Times New Roman", 1, 17));
        panel4.add(player1);

        //player_images
        player1_image = new JLabel();
        player1_image.setBorder(BorderFactory.createRaisedBevelBorder());
        player1_image.setBounds(40, 50, 150, 150);
        panel4.add(player1_image);

        //Create info_player1[]
        info_player1[0] = new JLabel("name", SwingConstants.CENTER);
        info_player1[1] = new JLabel("nation", SwingConstants.CENTER);
        info_player1[2] = new JLabel("club", SwingConstants.CENTER);
        info_player1[3] = new JLabel("height", SwingConstants.CENTER);
        info_player1[4] = new JLabel("weight", SwingConstants.CENTER);
        info_player1[5] = new JLabel("foot", SwingConstants.CENTER);
        info_player1[6] = new JLabel("age", SwingConstants.CENTER);

        for (int i = 0; i < 7; i++) {
            //Create data_player1
            data_player1[i] = new JLabel("", SwingConstants.CENTER);
            //Set Size
            info_player1[i].setSize(120, 50);
            data_player1[i].setSize(120, 30);
            //Set location
            info_player1[i].setLocation(50, 200 + (48 * i));
            data_player1[i].setLocation(50, 235 + (48 * i));
            //Set border
            data_player1[i].setBorder(BorderFactory.createLoweredBevelBorder());
            //add label
            panel4.add(info_player1[i]);
            panel4.add(data_player1[i]);
        }
        frame.add(panel4);
    }

    /**
     * The method of panel5
     * The attribute of player1
     * Clickable attribute button
     */
    public void layout_panel5() {
        //Create Panel5
        Image panel5_image = new ImageIcon("res/bkg/panel2_bkg.jpg").getImage();
        panel5 = new BackgroundPanel(panel5_image);
        panel5.setLayout(null);

        //Create smallPanel2
        JPanel smallPanel2 = new JPanel();
        smallPanel2.setLayout(null);
        smallPanel2.setBackground(new Color(5, 180, 153));
        smallPanel2.setBorder(BorderFactory.createRaisedBevelBorder());
        smallPanel2.setBounds(20, 80, 210, 400);

        //Create factor_player[]  (Button)
        factor_player1[0] = new JButton("attack");
        factor_player1[1] = new JButton("defense");
        factor_player1[2] = new JButton("skill");
        factor_player1[3] = new JButton("speed");
        factor_player1[4] = new JButton("power_capability");

        for (int i = 0; i < 5; i++) {
            //Create value_player
            value_player1[i] = new JLabel("", SwingConstants.CENTER);
            //Set Size
            factor_player1[i].setSize(130, 30);
            value_player1[i].setSize(30, 30);
            //Set location
            factor_player1[i].setLocation(30, 50 + (70 * i));
            value_player1[i].setLocation(170, 50 + (70 * i));
            //Set color of button
            factor_player1[i].setBackground(Color.white);
            //Set style of border
            factor_player1[i].setBorder(BorderFactory.createRaisedBevelBorder());
            //add Button
            smallPanel2.add(factor_player1[i]);
            smallPanel2.add(value_player1[i]);
        }

        //Back button
        back = new JButton("Back");
        back.setSize(100, 40);
        back.setLocation(120, 20);
        back.setBackground(new Color(12, 245, 168, 255));
        back.setFont(new Font("Times New Roman", 1, 17));
        back.setForeground(Color.RED);

        //Create win,rest card
        win_card1 = new JLabel("Win Cards:", SwingConstants.CENTER);
        rest_card1 = new JLabel("Rest Card:", SwingConstants.CENTER);
        win_card1_num = new JLabel("0", SwingConstants.RIGHT);
        rest_card1_num = new JLabel("0", SwingConstants.RIGHT);

        //Set size of win,rest card
        win_card1.setSize(80, 20);
        rest_card1.setSize(80, 20);
        win_card1_num.setSize(20, 15);
        rest_card1_num.setSize(20, 15);

        //Set Location of win,rest card
        win_card1.setLocation(135, 500);
        win_card1_num.setLocation(200, 503);
        rest_card1.setLocation(135, 530);
        rest_card1_num.setLocation(200, 533);

        //add win，rest and back into Panel5
        panel5.add(win_card1);
        panel5.add(win_card1_num);
        panel5.add(rest_card1);
        panel5.add(rest_card1_num);
        panel5.add(back);

        //add smallPanel into panel5
        panel5.add(smallPanel2);

        frame.add(panel5);
    }

    /**
     * Update player information
     */
    public void update_info() {
        Player winner = mainGame.getFinalWinner();
        //Determine if the game is over
        if (winner != null) {
            int final_won_person = winner.getPlayerId();
            print_final_result(final_won_person);
            //Determine if the game is a tie
            if (mainGame.isDraw()) {
                printDraw();
            }
        } else {
            //The player who wins each round
            int round_won_person = mainGame.getCurrentPlayer().getPlayerId();
            print_round_result(round_won_person, mainGame.isDraw());

            //Get the picture of player

            //player0
            String imagePath0 = mainGame.getPlayers()[0].getTop().getIcon_id();
            ImageIcon playerIcon0 = new ImageIcon(imagePath0);
            playerIcon0.setImage(playerIcon0.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            player0_image.setIcon(playerIcon0);

            //player1
            String imagePath1 = mainGame.getPlayers()[1].getTop().getIcon_id();
            ImageIcon playerIcon1 = new ImageIcon(imagePath1);
            playerIcon1.setImage(playerIcon1.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
            player1_image.setIcon(playerIcon1);

            //Get player basic information
            for (int i = 0; i < 7; i++) {
                data_player0[i].setText(mainGame.getPlayers()[0].getTop().getAttribute()[i]);
                data_player1[i].setText(mainGame.getPlayers()[1].getTop().getAttribute()[i]);
            }
            //Get player ability values
            for (int i = 0; i < 5; i++) {
                value_player0[i].setText(mainGame.getPlayers()[0].getTop().getAttribute()[i + 8]);
                value_player1[i].setText(mainGame.getPlayers()[1].getTop().getAttribute()[i + 8]);
            }

            //Set the loser not visible
            dataVisible(round_won_person);
        }

    }

    /**
     * Update card count
     */
    public void update_card_num() {
        //player0
        //win number
        win_card0_num.setText("" + mainGame.getPlayers()[0].getNumOfWon());
        //rest number
        rest_card0_num.setText("" + mainGame.getPlayers()[0].getNumOfLeft());

        //player1
        //win number
        win_card1_num.setText("" + mainGame.getPlayers()[1].getNumOfWon());
        //rest number
        rest_card1_num.setText("" + mainGame.getPlayers()[1].getNumOfLeft());
    }

    /**
     * Update the result
     */
    public void update_result() {
        Player winner = mainGame.getFinalWinner();
        //Determine if the game is over
        if (winner != null) {
            //Determine if the game is a tie
            int final_won_person = winner.getPlayerId();
            print_final_result(final_won_person);
            //Determine if the game is a tie
            if (mainGame.isDraw()) {
                printDraw();
            }
        } else {
            //The player who wins each round
            int round_won_person = mainGame.getCurrentPlayer().getPlayerId();
            print_round_result(round_won_person, mainGame.isDraw());
        }
    }

    /**
     * Control data visible
     */
    public void dataVisible(int num) {
        boolean flag0;
        boolean flag1;
        if (num == 0) {
            flag0 = true;
            flag1 = false;
        } else {
            flag0 = false;
            flag1 = true;
        }
        //player0
        player0_image.setVisible(flag0);
        for (int i = 0; i < 7; i++) {
            data_player0[i].setVisible(flag0);
        }
        for (int i = 0; i < 5; i++) {
            value_player0[i].setVisible(flag0);
        }

        //player1
        player1_image.setVisible(flag1);
        for (int i = 0; i < 7; i++) {
            data_player1[i].setVisible(flag1);
        }
        for (int i = 0; i < 5; i++) {
            value_player1[i].setVisible(flag1);
        }
    }

    /**
     * Control everything visible
     */
    public void allVisible(boolean flag) {
        //player0
        player0_image.setVisible(flag);
        for (int i = 0; i < 7; i++) {
            data_player0[i].setVisible(flag);
        }
        for (int i = 0; i < 5; i++) {
            value_player0[i].setVisible(flag);
        }

        //player1
        player1_image.setVisible(flag);
        for (int i = 0; i < 7; i++) {
            data_player1[i].setVisible(flag);
        }
        for (int i = 0; i < 5; i++) {
            value_player1[i].setVisible(flag);
        }
    }

    /**
     * Control result table visible
     *
     * @param flag
     */
    public void printVisible(boolean flag) {
        resultLabel.setVisible(flag);
    }

    /**
     * Update the color of the Button
     */
    public void refreshButton() {
        for (int i = 0; i < 5; i++) {
            factor_player0[i].setBackground(Color.white);
            factor_player0[i].setForeground(Color.BLACK);
            factor_player1[i].setBackground(Color.white);
            factor_player1[i].setForeground(Color.BLACK);
        }
    }

    /**
     * Print the draw result
     */
    public void printDraw() {
        resultLabel.setText("It's a draw game");
    }

    /**
     * Print the final result
     *
     * @param win_player
     */
    public void print_final_result(int win_player) {
        resultLabel.setText("<html>Game is over<br>Player " + win_player + " win this game</html>");
    }

    /**
     * Print the results of each round
     *
     * @param round_won_person
     * @param draw
     */
    public void print_round_result(int round_won_person, boolean draw) {
        if (draw) {
            resultLabel.setText("This round is a draw");
        } else {
            resultLabel.setText("Player " + round_won_person + " win this round");
        }
    }
}
