import java.util.Random;

/**
 * Define properties of each card
 */
public class Card {
    private String name;
    private String nation;
    private String club;
    private String height;
    private String weight;
    private String foot;
    private String age;
    private int attack;
    private int defence;
    private int skill;
    private int speed;
    private int power_cap;
    private String icon_id;

    /**
     * @param name
     * @param nation
     * @param club
     * @param height
     * @param weight
     * @param foot
     * @param age
     * @param attack
     * @param defence
     * @param skill
     * @param speed
     * @param power_cap
     * @param icon_id
     */
    public Card(String name, String nation, String club, String height, String weight, String foot, String age,
            int attack, int defence, int skill, int speed, int power_cap, String icon_id) {
        this.name = name;
        this.nation = nation;
        this.club = club;
        this.height = height;
        this.weight = weight;
        this.foot = foot;
        this.age = age;
        this.attack = attack;
        this.defence = defence;
        this.skill = skill;
        this.speed = speed;
        this.power_cap = power_cap;
        this.icon_id = icon_id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @return the club
     */
    public String getClub() {
        return club;
    }

    /**
     * @return the height
     */
    public String getHeight() {
        return height;
    }

    /**
     * @return the weight
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @return the foot
     */
    public String getFoot() {
        return foot;
    }

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @return the attack
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return the defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * @return the skill
     */
    public int getSkill() {
        return skill;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @return the power_cap
     */
    public int getPower_cap() {
        return power_cap;
    }

    /**
     * @return the icon_id
     */
    public String getIcon_id() {
        return icon_id;
    }
    /**
     * 传入类别的字符串
     * 返回选定的类别的数值
     * 注意：字符串区分大小写
     * @param category
     * @return value
     */
    public int getCategoryValue(String category) {
        if (category.equals("attack")){
            return getAttack();
        }
        else if (category.equals("defence")){
            return getDefence();
        }
        else if (category.equals("skill")){
            return getSkill();
        }
        else if (category.equals("speed")){
            return getSpeed();
        }
        else 
            return getPower_cap();
    }

    /**
     * 给电脑选择随机的数值
     * @return category
     */
    public String getRandom(){
        int number = new Random().nextInt(5);
        if(number == 0){
            return "attack";
        }
        if(number == 1){
            return  "defence";
        }
        if(number == 2){
            return "skill";
        }
        if(number == 3){
            return  "speed";
        }
        else
            return  "power_cap";
        
        
    }
    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", club='" + club + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", foot='" + foot + '\'' +
                ", age='" + age + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", skill=" + skill +
                ", speed=" + speed +
                ", power_cap=" + power_cap +
                ", icon_id='" + icon_id + '\'' +
                '}';
    }
}