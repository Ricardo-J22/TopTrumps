import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.*;
import java.util.EventObject;

/**
 * ComputerPlayer class is for computer vs human model
 *
 * @author Bohan Liu
 * @author YuKun Chen
 */
public class ComputerPlayer implements ActionListener {
    private Game game;
    private JFrame computerModel;
    private int numOfPlayer;
    //leftPanel1
    private JLabel player0;
    private JLabel playerImage;
    private ImageIcon playerIcon;
    private JLabel[] info = new JLabel[7];
    private JLabel[] infoName = new JLabel[7];
    private JLabel numOfLeft, numOfWon;
    //rightPanel1
    private JRadioButton[] factor = new JRadioButton[5];
    private JLabel[] value = new JLabel[5];
    //basicPanel2
    private JLabel mLabel;
    private JButton[] mbutton = new JButton[4];
    //basicPanel3
    private JPanel[] rPanel = new JPanel[4];
    private JLabel[] rLabel = new JLabel[4];
    private JLabel[][] rLabel1 = new JLabel[4][3];
    private JLabel[][] rLabel2 = new JLabel[4][3];
    private String[] factorName = new String[5];
    //create panel
    private JPanel basicPanel1, basicPanel2, basicPanel3;
    private JPanel leftPanel1, rightPanel1;
    private JPanel panel1, panel2;

    /**
     * Creates a ComputerPlayer which includes the layouts and
     * game codes
     *
     * @param numOfPlayer the number of players in this model
     */
    public ComputerPlayer(int numOfPlayer) {
        game = new Game(numOfPlayer);
        this.numOfPlayer = numOfPlayer;
        factorName[0] = "attack";
        factorName[1] = "defence";
        factorName[2] = "skill";
        factorName[3] = "speed";
        factorName[4] = "power";
        computerModel = new JFrame();
        computerModel.setTitle("Computer Model");
        computerModel.setSize(1200, 600);
        computerModel.setLayout(new GridLayout(1, 3));
        computerModel.setLocationRelativeTo(null);
        computerModel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layoutBasicPanel1();
        layoutBasicPanel2();
        layoutBasicPanel3();
        computerModel.setVisible(true);
    }

    /**
     * Creates the layout of basicPanel1
     * basicPanel1 includes leftPanel1 and rightPanel1,
     * rightPanel1 includes panel1 and panel2
     */
    private void layoutBasicPanel1() {

        //layout leftPanel1
        leftPanel1 = new JPanel();
        Image leftPanel1_image = new ImageIcon("res/bkg/panel1_bkg.jpg").getImage();
        leftPanel1 = new BackgroundPanel(leftPanel1_image);
        leftPanel1.setLayout(null);
        //set player0 label
        player0 = new JLabel("Real Player", SwingConstants.CENTER);
        player0.setBounds(40, 10, 140, 30);
        player0.setHorizontalAlignment(SwingConstants.CENTER);
        player0.setBorder(new LineBorder(Color.BLACK));
        player0.setBackground(Color.CYAN);
        player0.setOpaque(true);
        //set player image
        playerIcon = new ImageIcon();
        playerImage = new JLabel(playerIcon);
        playerImage.setBounds(35, 50, 150, 150);
        playerImage.setBorder(BorderFactory.createRaisedBevelBorder());
        //set player info
        infoName[0] = new JLabel("name", SwingConstants.CENTER);
        infoName[1] = new JLabel("nation", SwingConstants.CENTER);
        infoName[2] = new JLabel("club", SwingConstants.CENTER);
        infoName[3] = new JLabel("height", SwingConstants.CENTER);
        infoName[4] = new JLabel("weight", SwingConstants.CENTER);
        infoName[5] = new JLabel("foot", SwingConstants.CENTER);
        infoName[6] = new JLabel("age", SwingConstants.CENTER);
        for (int i = 0; i < 7; i++) {
            info[i] = new JLabel("", SwingConstants.CENTER);
            info[i].setBounds(50, 235 + i * 48, 120, 30);
            info[i].setBorder(BorderFactory.createLoweredBevelBorder());
            infoName[i].setBounds(50, 200 + i * 48, 120, 50);
        }

        //add content to leftPanel1
        leftPanel1.add(player0);
        leftPanel1.add(playerImage);
        for (int i = 0; i < 7; i++) {
            leftPanel1.add(info[i]);
            leftPanel1.add(infoName[i]);
        }

        //layout rightPanel1
        Image rightPanel1_image = new ImageIcon("res/bkg/panel1_bkg.jpg").getImage();
        rightPanel1 = new BackgroundPanel(rightPanel1_image);
        rightPanel1.setLayout(null);
        //layout panel1 in rightPanel1
        panel1 = new JPanel();
        panel1.setSize(200, 400);
        //panel1.setBorder(new LineBorder(Color.BLACK));
        panel1.setLayout(null);
        //add content to panel1
        factor[0] = new JRadioButton("attack");
        factor[1] = new JRadioButton("defence");
        factor[2] = new JRadioButton("skill");
        factor[3] = new JRadioButton("speed");
        factor[4] = new JRadioButton("power capability");
        for (int i = 0; i < 5; i++) {
            factor[i].setBounds(10, 30 + i * 70, 130, 30);
            factor[i].addActionListener(this);
            factor[i].setEnabled(false);
            factor[i].setOpaque(true);
            panel1.add(factor[i]);
        }
        for (int i = 0; i < 5; i++) {
            value[i] = new JLabel();
            value[i].setBounds(160, 30 + i * 70, 20, 30);
            value[i].setText("0");
            panel1.add(value[i]);
        }
        //layout panel2 in rightPanel1
        panel2 = new JPanel();
        panel2.setLayout(null);
        panel2.setBounds(0, 400, 200, 200);
        panel2.setBackground(Color.GREEN);
        //add content to panel2
        numOfLeft = new JLabel("Card Left", SwingConstants.CENTER);
        numOfLeft.setBounds(10, 30, 150, 30);
        numOfLeft.setBorder(new LineBorder(Color.BLACK));
        numOfLeft.setBackground(Color.white);
        numOfLeft.setOpaque(true);

        numOfWon = new JLabel("Card Won", SwingConstants.CENTER);
        numOfWon.setBounds(10, 80, 150, 30);
        numOfWon.setBorder(new LineBorder(Color.BLACK));
        numOfWon.setBackground(Color.white);
        numOfWon.setOpaque(true);

        panel2.add(numOfLeft);
        panel2.add(numOfWon);
        //layout rightPanel1  
        rightPanel1.add(panel1);
        rightPanel1.add(panel2);
        panel1.setOpaque(false);
        panel2.setOpaque(false);
        //layout basicPanel1
        basicPanel1 = new JPanel(new GridLayout(1, 2));
        basicPanel1.setBorder(new LineBorder(Color.black, 2, true));
        basicPanel1.add(leftPanel1);
        basicPanel1.add(rightPanel1);
        computerModel.add(basicPanel1);
    }

    /**
     * Creates the layout of basicPanel2
     */
    private void layoutBasicPanel2() {
        basicPanel2 = new JPanel();
        Image basicPanel2_image = new ImageIcon("res/bkg/panel3_bkg.jpg").getImage();
        basicPanel2 = new BackgroundPanel(basicPanel2_image);
        basicPanel2.setLayout(null);
        mLabel = new JLabel("Player x win", SwingConstants.CENTER);
        mLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        mLabel.setFont(new Font("Arial", Font.BOLD, 20));
        mLabel.setBounds(85, 360, 230, 150);
        mbutton[0] = new JButton("Next Round");
        mbutton[1] = new JButton("Show Card");
        mbutton[2] = new JButton("New Game");
        mbutton[3] = new JButton("Main Menu");

        for (int i = 0; i < 4; i++) {
            mbutton[i].setBounds(140, 70 + (70 * i), 120, 50);
            mbutton[i].setBorder(BorderFactory.createRaisedBevelBorder());
            mbutton[i].setBackground(Color.CYAN);
            mbutton[i].addActionListener(this);
        }
        mbutton[0].setEnabled(false);
        mbutton[1].setEnabled(false);
        for (int i = 0; i < 4; i++) {
            basicPanel2.add(mbutton[i]);
        }
        basicPanel2.add(mLabel);
        computerModel.add(basicPanel2);
    }

    /**
     * Creates the layout of basicPanel3
     */
    private void layoutBasicPanel3() {
        basicPanel3 = new JPanel();
        basicPanel3.setLayout(new GridLayout(4, 1));
        Image rPanel_image = new ImageIcon("res/bkg/panel1_bkg.jpg").getImage();
        for (int i = 0; i < 4; i++) {
            rPanel[i] = new JPanel();
            rPanel[i] = new BackgroundPanel(rPanel_image);
        }

        for (int i = 0; i < 4; i++) {
            rPanel[i].setLayout(null);
            rPanel[i].setBorder(new LineBorder(Color.white));
        }

        for (int i = 0; i < 4; i++) {
            rLabel[i] = new JLabel("P" + (i + 1), SwingConstants.CENTER);
            rLabel[i].setBounds(10, 20, 170, 50);
            rLabel[i].setBorder(new LineBorder(Color.BLACK));
            rLabel[i].setBackground(Color.cyan);
            rLabel[i].setOpaque(true);
        }

        for (int i = 0; i < 4; i++) {
            rLabel1[i][0] = new JLabel("  ", SwingConstants.CENTER);
            rLabel1[i][0].setBounds(315, 80, 75, 50);
            rLabel1[i][0].setBorder(new LineBorder(Color.white));
            rLabel1[i][0].setBorder(BorderFactory.createLoweredBevelBorder());
        }

        for (int i = 0; i < 4; i++) {
            rLabel1[i][1] = new JLabel("  ", SwingConstants.CENTER);
            rLabel1[i][1].setBounds(60, 80, 120, 50);
            rLabel1[i][1].setBorder(new LineBorder(Color.white));
            rLabel1[i][1].setBorder(BorderFactory.createLoweredBevelBorder());
        }

        for (int i = 0; i < 4; i++) {
            rLabel1[i][2] = new JLabel("  ", SwingConstants.CENTER);
            rLabel1[i][2].setBounds(315, 20, 75, 50);
            rLabel1[i][2].setBorder(new LineBorder(Color.white));
            rLabel1[i][2].setBorder(BorderFactory.createLoweredBevelBorder());
        }

        for (int i = 0; i < 4; i++) {
            rLabel2[i][0] = new JLabel("Card Won", SwingConstants.CENTER);
            rLabel2[i][0].setBounds(220, 80, 95, 50);
            rLabel2[i][0].setBorder(new LineBorder(Color.BLACK));
            rLabel2[i][0].setBackground(Color.yellow);
            rLabel2[i][0].setOpaque(true);
        }

        for (int i = 0; i < 4; i++) {
            rLabel2[i][1] = new JLabel("Name", SwingConstants.CENTER);
            rLabel2[i][1].setBounds(10, 80, 50, 50);
            rLabel2[i][1].setBorder(new LineBorder(Color.BLACK));
            rLabel2[i][1].setBackground(Color.yellow);
            rLabel2[i][1].setOpaque(true);
        }

        for (int i = 0; i < 4; i++) {
            rLabel2[i][2] = new JLabel("Factor", SwingConstants.CENTER);
            rLabel2[i][2].setBounds(220, 20, 95, 50);
            rLabel2[i][2].setBorder(new LineBorder(Color.BLACK));
            rLabel2[i][2].setBackground(Color.red);
            rLabel2[i][2].setOpaque(true);
        }

        for (int i = 0; i < 4; i++) {
            rPanel[i].add(rLabel[i]);

            for (int j = 0; j < 3; j++) {
                rPanel[i].add(rLabel1[i][j]);
                rPanel[i].add(rLabel2[i][j]);
            }
        }

        for (int i = 0; i < this.numOfPlayer - 1; i++) {
            basicPanel3.add(rPanel[i]);
        }
        computerModel.add(basicPanel3);
    }

    /**
     * Sets the image of human player
     *
     * @param playerIcon
     */
    private void setPlayerIcon(ImageIcon playerIcon) {
        this.playerIcon = playerIcon;
        playerIcon.setImage(playerIcon.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
        playerImage.setIcon(playerIcon);
    }

    /**
     * Sets the information of human player's cards
     */
    private void setPlayerInfo() {
        for (int i = 0; i < 7; i++) {
            this.info[i].setText(game.getPlayers()[0].getTop().getAttribute()[i]);
        }
        playerIcon = new ImageIcon(game.getPlayers()[0].getTop().getIcon_id());
        this.setPlayerIcon(playerIcon);
    }

    /**
     * Sets the factor value of human player's cards
     */
    private void setFactorValue() {
        for (int i = Card.ATTACK; i < Card.POWER_CAP + 1; i++) {
            this.value[i - 8].setText(game.getPlayers()[0].getTop().getAttribute()[i]);
        }
    }

    /**
     * Sets the number of card which human player left
     *
     * @param numOfLeft
     */
    private void setNumOfLeft(int numOfLeft) {
        this.numOfLeft.setText("Card Left: " + numOfLeft + "");
    }

    /**
     * Sets the number of cards which human player won
     *
     * @param numOfWon
     */
    private void setNumOfWon(int numOfWon) {
        this.numOfWon.setText("Card Won: " + numOfWon + "");
    }

    /**
     * Sets the infomation of other players' cards
     *
     * @param playerId
     */
    private void setOtherCard(int playerId) {
        this.rLabel1[playerId - 1][1].setText(game.getPlayers()[playerId].getTop().getAttribute()[0]);
        this.rLabel2[playerId - 1][2].setText(factorName[game.getChosenCategory() - Card.ATTACK]);
        this.rLabel1[playerId - 1][2].setText(game.getPlayers()[playerId].getTop().getAttribute()[this.game.getChosenCategory()]);
    }

    /**
     * Sets the number of cards which other players won
     */
    private void setOtherCardWon() {
        for (int i = 0; i < numOfPlayer - 1; i++) {
            this.rLabel1[i][0].setText(this.game.getPlayers()[i + 1].getNumOfWon() + "");
        }
    }

    /**
     * Sets the winner of last round
     */
    private void setWinPlayer() {
        if (game.isDraw()) {
            this.mLabel.setText("It is a draw");
        } else if (game.getCurrentPlayer().getPlayerId() == 0) {
            this.mLabel.setText("You win");
        } else {
            this.mLabel.setText("Player " + game.getCurrentPlayer().getPlayerId() + "" + " win");
        }
    }

    /**
     * Sets the final winner on the screen
     */
    private void setFinalWinner() {
        this.mbutton[1].setEnabled(false);
        if (game.hasTwoWinner()) {
            this.mLabel.setText("<html>Game is Over.<br> It is DRAW</html>");
        } else {
            if (game.getFinalWinner().getPlayerId() == 0) {
                this.mLabel.setText("<html>Game is Over.<br> YOU WIN</html>");
            } else {
                this.mLabel.setText("<html>Game is Over.<br> PLAYER " + game.getFinalWinner().getPlayerId() + " WIN");
            }
        }
    }

    /**
     * Hides all player's cards except winner's
     */
    private void hideCard() {
        for (int i = 0; i < 7; i++) {
            info[i].setText("");
        }
        for (int i = 0; i < 5; i++) {
            value[i].setText("");
        }
        playerImage.setIcon(null);
        for (int i = 0; i < numOfPlayer - 1; i++) {
            rLabel1[i][1].setText("");
        }
        for (int i = 0; i < numOfPlayer - 1; i++) {
            rLabel1[i][2].setText("");
        }
        for (int i = 0; i < numOfPlayer - 1; i++) {
            rLabel[i].setBorder(null);
        }
    }

    /**
     * Shows the card of the winner of the last round
     *
     * @param playerId the id of player
     */
    private void showWinnerCard(int playerId) {
        if (playerId == 0) {
            this.setPlayerInfo();
            this.setFactorValue();
        } else {
            game.setComputerChoice();
            this.setOtherCard(playerId);
            rPanel[playerId - 1].setBorder(BorderFactory.createRaisedBevelBorder());
        }
    }

    /**
     * Makes the buttons of factor clickable or unclickable
     *
     * @param b true to make the buttons of factors clickable, otherwise false
     */
    private void setFactorClickable(boolean b) {
        for (int i = 0; i < 5; i++) {
            factor[i].setEnabled(b);
        }
    }

    /**
     * Refreshes the radio buttons to initial state
     */
    private void refreshRadioButton() {
        for (int i = 0; i < 5; i++) {
            factor[i].setEnabled(true);
            factor[i].setSelected(false);
            if (game.getCurrentPlayer().getPlayerId() != 0) {
                if (i == (game.getChosenCategory() - Card.ATTACK)) {
                    factor[i].setSelected(true);
                }
                factor[i].setEnabled(false);
            }
        }

    }

    /**
     * initializes information of all cards
     */
    private void initCards() {
        //init player0
        this.playerImage.setIcon(null);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                rLabel1[j][i].setText("");
            }
        }
    }

    /**
     * Creates a new game
     */
    private void newGame() {
        this.game = new Game(this.numOfPlayer);
        for (int i = 0; i < 5; i++) {
            factor[i].setEnabled(true);
            factor[i].setSelected(false);
        }
        mbutton[1].setEnabled(true);
        for (int i = 0; i < 4; i++) {
            rPanel[i].setBorder(new LineBorder(Color.white));
        }
        this.initCards();
        game.startGame();
        game.setComputerChoice();
        if (game.getCurrentPlayer().equals(game.getPlayers()[0])) {
            this.mLabel.setText("It's your turn");
            for (int i = 0; i < 5; i++) {
                factor[i].setEnabled(true);
            }
            this.setPlayerInfo();
            this.setFactorValue();
        } else {
            for (int i = 0; i < 5; i++) {
                factor[i].setEnabled(false);
            }
            this.mLabel.setText("It's Player" + game.getCurrentPlayer().getPlayerId() + "" + "'s turn");
            this.setOtherCard(game.getCurrentPlayer().getPlayerId());
            rPanel[game.getCurrentPlayer().getPlayerId() - 1].setBorder(BorderFactory.createBevelBorder(0, Color.RED, Color.RED));
        }

        this.setNumOfLeft(game.getPlayers()[0].getNumOfLeft());
        this.setNumOfWon(game.getPlayers()[0].getNumOfWon());
        this.setOtherCardWon();


    }

    /**
     * Shows all players' top cards
     * and compares the factor value
     */
    public void showCard() {
        if (game.getFinalWinner() == null) {
            this.setPlayerInfo();
            this.setFactorValue();

            for (int i = 0; i < numOfPlayer - 1; i++) {
                this.setOtherCard(i + 1);
            }
        } else {
            this.setFactorClickable(false);
            this.mbutton[1].setEnabled(false);
        }
        game.nextRound();
        this.setNumOfWon(game.getPlayers()[0].getNumOfWon());
        this.setNumOfLeft(game.getPlayers()[0].getNumOfLeft());
        this.setOtherCardWon();
        this.setWinPlayer();
    }

    /**
     * Enters the next round if the game is not over
     * and ends the game if there is a final winner
     */
    private void nextRound() {
        if (game.getFinalWinner() == null) {

            if (game.getCurrentPlayer().getPlayerId() == 0) {
                this.mLabel.setText("It's your turn");
            } else this.mLabel.setText("It's Player " + game.getCurrentPlayer().getPlayerId() + "'s turn");
            this.hideCard();
            this.showWinnerCard(game.getCurrentPlayer().getPlayerId());
            for (int i = 0; i < numOfPlayer - 1; i++) {
                this.rPanel[i].setBorder(new LineBorder(Color.white));
            }
            if (game.getCurrentPlayer().getPlayerId() != 0) {
                this.rPanel[game.getCurrentPlayer().getPlayerId() - 1].setBorder(BorderFactory.createBevelBorder(0, Color.RED, Color.RED));
            }
            this.refreshRadioButton();

        } else {
            this.setFinalWinner();
            this.mbutton[0].setEnabled(false);
        }

    }


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e) {
        //if click next round
        if (e.getSource() == mbutton[0]) {
            this.nextRound();
            this.mbutton[0].setEnabled(false);
            this.mbutton[1].setEnabled(true);
        }
        //if click show card
        if (e.getSource() == mbutton[1]) {
            this.showCard();
            this.mbutton[1].setEnabled(false);
            this.mbutton[0].setEnabled(true);
        }
        //if click new game
        if (e.getSource() == mbutton[2]) {
            this.game = new Game(numOfPlayer);
            this.newGame();
        }
        //if click main menu
        if (e.getSource() == mbutton[3]) {
            computerModel.dispose();
            GameCover ga = new GameCover();
        }
        //if click attack
        if (e.getSource() == factor[0]) {
            game.setChosenCategory(Card.ATTACK);
            this.setFactorClickable(false);
        }
        //if click defence
        if (e.getSource() == factor[1]) {
            game.setChosenCategory(Card.DEFENCE);
            this.setFactorClickable(false);
        }
        //if click skill
        if (e.getSource() == factor[2]) {
            game.setChosenCategory(Card.SKILL);
            this.setFactorClickable(false);
        }
        //if click speed
        if (e.getSource() == factor[3]) {
            game.setChosenCategory(Card.SPEED);
            this.setFactorClickable(false);
        }
        //if click power capability
        if (e.getSource() == factor[4]) {
            game.setChosenCategory(Card.POWER_CAP);
            this.setFactorClickable(false);
        }
    }
}

