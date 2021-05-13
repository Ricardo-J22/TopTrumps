/**
 * 程序的入口通过 Main.java 打开窗口
 */
public class Main {
    public static void main(String[] args) {
       Game a = new Game(2);
       a.startGame();
       Player b = a.getCurrentPlayer();
       while(b != null){
            b = a.nextRound(b);
           
       }
    }
}