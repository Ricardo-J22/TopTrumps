import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * Define property of player,
 * operation on card stack,
 * record hand and cards won
 * @author  Lirui Jin
 */
public class Player {

    /**
     * player id
     */
    private final int playerId;

    /**
     * Use Stack to keep track of hands
     */
    private final Stack<Card> cardLeft;

    /**
     * Use a list to keep track of card won
     */
    private final List<Card> cardWon;

    /**
     * initial the player, set playerId and initial stack and list
     *
     * @param playerId id of player
     */
    public Player(int playerId) {
        this.playerId = playerId;
        cardLeft = new Stack<>();
        cardWon = new ArrayList<>();
    }

    /**
     * get id of player
     * @return the id of player
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * put card into hand
     *
     * @param card card
     */
    public void addCardLeft(Card card) {
        cardLeft.push(card);
    }

    /**
     * get numbers of card left
     * @return number of card left
     */
    public int getNumOfLeft() {
        return cardLeft.size();
    }

    /**
     * check whether player has rest of hand
     *
     * @return is empty
     */
    public boolean isTerminated() {
        return cardLeft.isEmpty();
    }

    /**
     * put card won into the stack of won
     *
     * @param card card to put in
     */
    public void addCardWon(Card card) {
        cardWon.add(card);
    }

    /**
     * get numbers of card won
     * @return number of card won
     */
    public int getNumOfWon() {
        return cardWon.size();
    }

    /**
     * look at the top of stack
     *
     * @return card on the top
     */
    public Card getTop() {
        if (cardLeft.isEmpty()) {
            throw new RuntimeException(getPlayerId() + "没卡了");
        }
        return cardLeft.peek();
    }

    /**
     * remove the card on the top
     */
    public void pop() {
        cardLeft.pop();
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + playerId;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        return playerId == other.playerId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", cardLeft=" + cardLeft.size() +
                ", cardWon=" + cardWon.size() +
                '}';
    }
}
