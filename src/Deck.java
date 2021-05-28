import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * Deck contain the card stack would use in a game.
 * It includes the process of reading data from excel
 * , creating cards instance and store in a List of card
 * @author Lirui Jin
 */
public class Deck {

    /**
     * List of cards instance used in a game
     */
    private List<Card> cardStack;

    /**
     * The total number of card would be used
     */
    private int numOfCardUsed;

    /**
     * Number of hand cards of every player
     */
    private int sizeOfHand;

    /**
     * Number of players in a game
     */
    private int numOfPlayer;

    /**
     * Initialize the game
     *
     * @param numOfPlayer
     */
    public Deck(int numOfPlayer) {
        cardStack = new ArrayList<>();
        this.numOfPlayer = numOfPlayer;
        initialCardStack();
    }

    /**
     * Initialize the card stack
     * 1. Read data from excel using jxl api
     * 2. Create card instance to store information from excel
     * 3. Calculate the number of cards would be used
     * 4. Random remove cards to adapt the standard
     *
     * @see <a href="http://jexcelapi.sourceforge.net/">
     * http://jexcelapi.sourceforge.net/</a>
     */
    private void initialCardStack() {
        cardStack = readExcel();
        sizeOfHand = (cardStack.size() - (cardStack.size() % numOfPlayer)) / numOfPlayer;
        numOfCardUsed = sizeOfHand * numOfPlayer;
        if (numOfCardUsed != cardStack.size()) {
            Random random = new Random();
            for (int i = 0; i < cardStack.size() - numOfCardUsed; i++) { // 根据传进来的参数决定随机移除多少个
                cardStack.remove(random.nextInt(cardStack.size()));
            }
        }
    }

    /**
     * Using jxl api to read the information from excel
     * 1.get workbook from excel
     * 2.get the sheet
     * 3.get cells in a line and get the content in String
     * 4.using the information read from excel to create card instance
     *
     * @return list of card
     * @see <a href="http://jexcelapi.sourceforge.net/">
     *      * http://jexcelapi.sourceforge.net/</a>
     */
    private List<Card> readExcel() {
        List<Card> stack = new ArrayList<>();
        int i;
        Sheet sheet;
        Workbook book;
        try {
            book = Workbook.getWorkbook(new File("res\\data\\players.xls"));

            // 获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
            sheet = book.getSheet(0);
            i = 1;// 从第一行开始读
            while (true) {
                // 获取每一行的单元格
                Cell[] array = new Cell[13];
                for (int j = 0; j < array.length; j++) {
                    array[j] = sheet.getCell(j, i);
                }

                if ("".equals(array[0].getContents())) {// 如果读取的数据为空
                    break;
                }
                Card card = initCard(array);
                stack.add(card);
                i++;
            }
            book.close();
        } catch (Exception e) {

        }
        return stack;
    }

    /**
     * Read information from Cell array and create a Card instance
     *
     * @param arrayCells
     * @return a instance of Card
     */
    private Card initCard(Cell[] arrayCells) {
        String[] attribute = new String[13];
        for (int i = 0; i < arrayCells.length; i++) {
            attribute[i] = arrayCells[i].getContents();
        }
        return new Card(attribute);
    }

    /**
     * use Collection.shuffle() to shuffle the card stack
     * @see java.util.Collections
     */
    public void shuffle() {
        Collections.shuffle(cardStack);
    }


    /**
     * get size of hand of every player
     * @return numbers of hand
     */
    public int getSizeOfHand() {
        return sizeOfHand;
    }

    /**
     * get the card on the top and remove it
     *
     * @return card
     */
    public Card getOneCard() {
        Card top = cardStack.get(0);
        cardStack.remove(0);
        return top;
    }
}
