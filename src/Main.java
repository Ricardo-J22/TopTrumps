/**
 * 程序的入口通过 Main.java 打开窗口
 */
public class Main {
    public static void main(String[] args) {
        Deck a = new Deck(15);
        a.initialCardStack();
        a.shuffle();
        System.out.println(a.getCardStack().get(0));
    }
}