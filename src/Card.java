import java.util.Arrays;
import java.util.Random;

/**
 *
 * Define the properties of card.
 * @author Lirui Jin
 */
public class Card {

    /**
     * String Array contain all data of the card/ football player.
     * index: 0 - 7: basic information
     * 0. name 1. nation 2.club 3.height 4. weight 5. foot 6. age 7. icon_path
     * index: 8 - 12: 4 categories of abilities for comparison
     * 8. attack 9. defence 10. skill 11. speed 12.power_capabilities
     */
    private final String[] attribute;
    public static final int ICON_PATH = 7;
    public static final int ATTACK = 8;
    public static final int DEFENCE = 9;
    public static final int SKILL = 10;
    public static final int SPEED = 11;
    public static final int POWER_CAP = 12;

    /**
     * @param attribute String array contains all data of a card
     */
    public Card(String[] attribute) {
        this.attribute = attribute;
    }

    /**
     * get category value
     * @param index index of chosen category
     * @return value of chosen category in String
     */
    public String getCategoryValue(int index) {
        switch (index) {
            case ATTACK:
                return attribute[ATTACK];
            case DEFENCE:
                return attribute[DEFENCE];
            case SKILL:
                return attribute[SKILL];
            case SPEED:
                return attribute[SPEED];
            case POWER_CAP:
                return attribute[POWER_CAP];
            default:
                return null;

        }

    }

    /**
     * generate random index for category
     * @return random index of attributes
     */
    public int getRandom() {
        return new Random().nextInt(5) + 8;

    }

    /**
     * return the icon path
     * @return ICON_PATH in String
     */
    public String getIcon_id() {
        return attribute[ICON_PATH];
    }

    /**
     * get attribute array
     * @return attribute array
     */
    public String[] getAttribute() {
        return attribute;
    }

    @Override
    public String toString() {
        return "Card{" + "attribute=" + Arrays.toString(attribute) + '}';
    }
}