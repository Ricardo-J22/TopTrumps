import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 游戏运行的主体
 */
public class Game {
    private int numOfPlayer;// 玩家的人数
    private Player[] players;// 玩家数组
    private Player currentPlayer;// 目前正在选择的人
    private Deck mainDeck;// 总的牌组
    private final int deckSize;// 每个人能拿到的牌
    private List<Card> temp;// 临时列表

    /**
     * @param numOfPlayer
     * @param players
     */
    public Game(int numOfPlayer) {
        this.numOfPlayer = numOfPlayer;
        deckSize = (30 - (30 % numOfPlayer)) / numOfPlayer;// 避免单数产生的干扰
        mainDeck = new Deck(deckSize * numOfPlayer);// 初始化牌组
        temp = new ArrayList<>();
        players = new Player[numOfPlayer];// 初始化玩家数组
        for (int i = 0; i < numOfPlayer; i++) {
            players[i] = new Player(i);
        }
    }

    /**
     * 初始化游戏
     */
    private void initGame() {
        mainDeck.shuffle();
        for (Player player : players) {
            for (int i = 0; i < deckSize; i++) {// 为每一个玩家添加手牌
                player.addCardLeft(mainDeck.getCardStack().get(0));
                mainDeck.getCardStack().remove(0);
            }
        }

    }

    /**
     * 开始游戏
     */
    public void startGame() {
        initGame();
        currentPlayer = players[randomiseFirstPlayer()];// 随机选取位作为开始
        nextRound(currentPlayer);
    }

    /**
     * 随机选取开始的玩家
     * 
     * @return PlayerId
     */
    private int randomiseFirstPlayer() {
        return new Random().nextInt(numOfPlayer);
    }

    /**
     * 进行下一轮
     * 分成需要人类玩家选择和电脑自动选择
     * 所有的输出语句均为调试信息可注释！！！！
     * @param currentPlayer
     * @return currentPlayer 返回这轮的胜利者
     */
    public Player nextRound(Player currentPlayer) {
        // 首先判断是否有玩家赢了超过50%的手牌，如果超过则立即停止游戏
        for (Player player : players) {
            if (player.getNumOfWon() > (deckSize * numOfPlayer / 2)) {
                System.out.println("Game is over" + "player" + player.getPlayerId() + "is the winner");
                return null;
            }
        }
        /*
         * 这里仅考虑了一名人类玩家，当人类玩家开始时，读取选择的category
         * 这里暂时使用了屏幕输入，需要GUI界面读入相应的参数！！！！！！！
         */
        if (currentPlayer.equals(players[0])) {
            System.out.println("You choose to");
            Scanner input = new Scanner(System.in);
            String b = input.next();
            System.out.println("You choose " + b + " " + currentPlayer.getTop().getCategoryValue(b));
            // System.out.println(currentPlayer.getTop().toString());
            System.out.println("Player 1 is " + players[1].getTop().getCategoryValue(b));
            // System.out.println("\n"+players[1].getTop().toString());
            return checkRoundResult(b);
        } else {
            /**
             * 当电脑为选择人的时候，电脑会调用Card下面的getRandom()去选择随机的category
             * 此时人类玩家并不需要点击操作仅需知道结构
             */
            String a = currentPlayer.getTop().getRandom();
            System.out.println("Player " + currentPlayer.getPlayerId() + " choose " + a + " "
                    + currentPlayer.getTop().getCategoryValue(a));
            // System.out.println(currentPlayer.getTop().toString());
            System.out.println("Your is " + players[0].getTop().getCategoryValue(a));
            // System.out.println("\n"+players[0].getTop().toString());
            return checkRoundResult(a);
        }

    }
    /**
     * 将选择的cateogry传入函数
     * 将每名还有剩余手牌的玩家的最上方的卡加入List(Nondestructive method)
     * 比较数值大的那个人设定为winner, 然后将每位玩家的手牌中最上方的卡pop出去(Destructive method)
     * Winner获得Temp List中的所有卡片加入 CardWon List
     * 清空 temp 中的所有内容
     * 如果遇到平局，保留temp内容，递归调用nextRound(),并保留当前正在操作的人
     * @param chosenCategory
     * @return winner 返回此轮的获胜者
     */
    private Player checkRoundResult(String chosenCategory) {
        int highestVal = currentPlayer.getTop().getCategoryValue(chosenCategory);
        Player winner = currentPlayer;
        int drawValue = 0;
        addCardToTemp();//将每名玩家最上方的卡加入temp
        for (Player player : players) {
            if (!player.isTermined()) { // 判断是否还有手牌
                if (!player.equals(currentPlayer)) { //比较时排除自己本身
                    if (player.getTop().getCategoryValue(chosenCategory) > highestVal) {
                        highestVal = player.getTop().getCategoryValue(chosenCategory);
                        winner = player;
                    } else if (player.getTop().getCategoryValue(chosenCategory) == highestVal) {
                        drawValue = highestVal; //如果遇到相同最高数，赋值给drawValue
                    }
                }

            }
        }
        //移除所有人的第一张
        for (Player player : players) {
            if (!player.isTermined()) {
                player.pop();
            }
        }
        //平均递归调用
        if (highestVal == drawValue) {
            System.out.println("It is draw");
            return nextRound(currentPlayer);
        }
        //将temp中的牌给赢家
        for (Card card : temp) {
            winner.addCardWon(card);
        }
        temp = new ArrayList<>();//清空temp
        currentPlayer = winner;//下一次操作人为winner
        System.out.println("player " + currentPlayer.getPlayerId() + " win");
        return winner;//返回winner
    }
    /**
     * 将每名还有剩余手牌的玩家的最上方的卡加入List(Nondestructive method)
     */
    private void addCardToTemp() {
        for (Player player : players) {
            if (!player.isTermined()) {
                temp.add(player.getTop());
            }

        }
    }

    /**
     * 写了没什么用
     * 测试的时候用用吧
     * @return
     */
    public boolean isOver() {
        for (Player player : players) {
            if (player.getNumOfWon() > (deckSize / 2)) {
                System.out.println("Game is over" + "player " + player.getPlayerId() + " is the winner");
                return true;
            }
        }
        return false;
    }

    /**
     * 测试用，也有可能用
     * @return the currentPlayer
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * 测试用
     * @return the players
     */
    public Player[] getPlayers() {
        return players;
    }

}
