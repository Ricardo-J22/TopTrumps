import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * The main body of the Game, including the whole information in a game
 * such as number of player, state of the player, and category that chosen
 * @author Lirui Jin
 *
 */
public class Game {

    /**
     * number of player
     */
    private final int numOfPlayer;

    /**
     * array of Players in a game
     */
    private final Player[] players;

    /**
     * Player instance of current player
     */
    private Player currentPlayer;

    /**
     * The deck would be used in a game
     */
    private final Deck mainDeck;

    /**
     * The number of hand
     */
    private final int numOfPocketCard;

    /**
     * List of temp card list contain each of card of every player
     */
    private List<Card> temp;

    /**
     * index of chosen attribute
     */
    private int chosenCategory;

    /**
     * flag of draw of a round
     */
    private boolean isDraw;

    /**
     * constructor for game
     *
     * @param numOfPlayer number of player
     */
    public Game(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
        isDraw = false;
        chosenCategory = -1;
        mainDeck = new Deck(numOfPlayer);// initial card stack
        numOfPocketCard = mainDeck.getSizeOfHand();
        temp = new ArrayList<>();
        players = new Player[numOfPlayer];// initial number of player
        for (int i = 0; i < numOfPlayer; i++) {
            players[i] = new Player(i);
        }
    }

    /**
     * Initialize game
     */
    private void initGame() {
        mainDeck.shuffle();
        for (Player player : players) {
            for (int i = 0; i < numOfPocketCard; i++) {// add card to every player
                player.addCardLeft(mainDeck.getOneCard());
            }
        }

    }

    /**
     * Start game
     * Select random currentPlayer for start
     */
    public void startGame() {
        initGame();
        currentPlayer = players[randomiseFirstPlayer()];//
    }

    /**
     * Random select random player
     *
     * @return PlayerId
     */
    private int randomiseFirstPlayer() {
        return new Random().nextInt(numOfPlayer);
    }


    /**
     * Begin next round according to next round
     */
    public void nextRound() {
        checkRoundResult();
    }

    /**
     * Set computer choice if current player is computer
     */
    public void setComputerChoice() {
        if (!currentPlayer.equals(players[0])) {
            int category = currentPlayer.getTop().getRandom();
            setChosenCategory(category);
        }
    }


    /**
     * Helper method for nextRound(),
     * add every player's top of card into temp list(Nondestructive way).
     * Compare the value of chosen category and get the winner.
     * Then remove cards of everyone's top(Destructive method) and put cards in temp list to the winner player's
     * card won list. Next, clear the temp list and set winner as player playing next round, set isDraw flag to false.
     * If draw，remain temp list and currentPlayer, set isDraw flag to true
     */
    private void checkRoundResult() {
        int highestVal = Integer.parseInt(currentPlayer.getTop().getCategoryValue(chosenCategory));
        Player winner = currentPlayer;
        int drawValue = 0;
        addCardToTemp();// add cards on the top to temp list
        for (Player player : players) {
            if (!player.isTerminated()) { // check remains hand
                if (!player.equals(currentPlayer)) {
                    if (Integer.parseInt(player.getTop().getCategoryValue(chosenCategory)) > highestVal) {
                        highestVal = Integer.parseInt(player.getTop().getCategoryValue(chosenCategory));
                        winner = player;
                    } else if (Integer.parseInt(player.getTop().getCategoryValue(chosenCategory)) == highestVal) {
                        drawValue = highestVal;
                    }
                }

            }
        }
        // remove every card on the top of hand
        for (Player player : players) {
            if (!player.isTerminated()) {
                player.pop();
            }
        }
        // if is a draw set flag
        if (highestVal == drawValue) {
            System.out.println("It is a draw");
            isDraw = true;
            return;
        }
        // move card in temp to the winner
        for (Card card : temp) {
            winner.addCardWon(card);
        }
        temp = new ArrayList<>();// clear temp
        currentPlayer = winner;// set next player be the winner
        System.out.println("player " + currentPlayer.getPlayerId() + " win this round");
        isDraw = false;

    }

    /**
     * Add the top card of each player who still has a hand left(Nondestructive method)
     */
    private void addCardToTemp() {
        for (Player player : players) {
            if (!player.isTerminated()) {
                temp.add(player.getTop());
            }

        }
    }

    /**
     * check whether is terminated
     * @return player has card left
     */
    private boolean isTerminated() {
        return players[0].isTerminated();
    }

    /**
     * Return a final winner, if does not has, return null
     *
     * @return the final winner
     */
    public Player getFinalWinner() {
        if (isTerminated()) {
            Player winner = players[0];
            int numOfCard = players[0].getNumOfWon();
            for (Player player : players) {
                if (player.getNumOfWon() > numOfCard) {
                    winner = player;
                    numOfCard = player.getNumOfWon();
                }
            }
            return winner;
        }
        for (Player player : players) {
            if (player.getNumOfWon() > (numOfPocketCard * numOfPlayer / 2)) {
                return player;
            }
        }

        return null;
    }

    /**
     * get the player play for next round
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * get array of players
     * @return array of players
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * Check if have two or more winners
     * @return Whether the game has two or more winners
     */
    public boolean hasTwoWinner() {
        Player winner = getFinalWinner();
        if (winner != null) {
            for (Player player : players) {
                if ((!player.equals(winner)) && (player.getNumOfWon() == winner.getNumOfWon())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * return the index of chosenCategory
     * @return index of chosenCategory
     */
    public int getChosenCategory() {
        return chosenCategory;
    }

    /**
     * set category through the index
     * @param chosenCategory the chosenCategory to set
     */
    public void setChosenCategory(int chosenCategory) {
        this.chosenCategory = chosenCategory;
    }

    /**
     * return if this round is a draw
     * @return If this round is a draw
     */
    public boolean isDraw() {
        return isDraw;
    }
}
