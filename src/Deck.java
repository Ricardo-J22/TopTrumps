import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jxl.*;
import java.io.File;

public class Deck {
    private List<Card> CardStack; // 用到的牌堆（30张牌）
    private final int deckSize; // 定义每个玩家初始的手牌数量

    /**
     * @param deckSize
     */
    public Deck(int deckSize) {
        CardStack = new ArrayList<>();
        this.deckSize = deckSize;
    }

    // 初始化牌堆
    public void initialCardStack() {
        CardStack = readExcel();
    }

    /**
     * 
     * @return list of card 
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
        }
        catch (Exception e) {

        }
        return stack;
    }

    /**
     * 从excel读取数据并返回一个card对象
     * 
     * @param arrayCells
     * @return card
     */
    private Card initCard(Cell[] arrayCells) {
        String name = arrayCells[0].getContents();
        String nation = arrayCells[1].getContents();
        String club = arrayCells[2].getContents();
        String height = arrayCells[3].getContents();
        String weight = arrayCells[4].getContents();
        String foot = arrayCells[5].getContents();
        String age = arrayCells[6].getContents();
        int attack = Integer.parseInt(arrayCells[7].getContents());
        int defence = Integer.parseInt(arrayCells[8].getContents());
        int skill = Integer.parseInt(arrayCells[9].getContents());
        int speed = Integer.parseInt(arrayCells[10].getContents());
        int power_cap = Integer.parseInt(arrayCells[11].getContents());
        String icon_id = arrayCells[12].getContents();
        return new Card(name, nation, club, height, weight, foot, age, attack, defence, skill, speed, power_cap,
                icon_id);
    }

    /**
     * 打乱牌堆顺序
     */
    public void shuffle(){
        Collections.shuffle(CardStack);
    }

    /**
     * 返回当前牌堆
     */
    public List<Card> getCardStack() {
        return CardStack;
    }

}
