
/**
 * @author Ricardo
 * 定义每个玩家的剩余牌堆和已经获得的数量
 * 对每个玩家的牌堆的操作
 */
import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private int playerId;// 记录第几位玩家
    private Stack<Card> cardLeft; // 剩余的牌堆
    private List<Card> cardWon; // 赢得的排堆

    /**
     * @param playerId
     */
    public Player(int playerId) {
        this.playerId = playerId;
        cardLeft = new Stack<>();
        cardWon = new ArrayList<>();
    }

    /**
     * 返回玩家的编号
     * 
     * @return the playerId
     */
    public int getPlayerId() {
        return playerId;
    }

    /**
     * 用于初始化牌堆！！！ 不用于赢得牌的加入
     * 
     * @param card
     */
    public void addCardLeft(Card card) {
        cardLeft.push(card);
    }

    /**
     * @return number of cardLeft
     */
    public int getNumOfLeft() {
        return cardLeft.size();
    }

    /**
     * 判断是否没有剩余卡了
     * 
     * @return is empty
     */
    public boolean isTermined() {
        return cardLeft.isEmpty();
    }

    /**
     * 将赢得的卡放入List中
     * 
     * @param stack
     */
    public void addCardWon(Card card) {
        cardWon.add(card);
    }

    /**
     * @return 已经赢得的卡数
     */
    public int getNumOfWon() {
        return cardWon.size();
    }
    /**
     * 查看最上面的一张卡
     * 不移除
     * @return card on the top
     */
    public Card getTop(){
        return cardLeft.peek();
    }
    /**
     * 查看并移除最上面的一张卡
     * @return card on the top
     */
    public Card pop(){
        return cardLeft.pop();
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + playerId;
        return result;
    }

    

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (playerId != other.playerId)
            return false;
        return true;
    }

    
}
