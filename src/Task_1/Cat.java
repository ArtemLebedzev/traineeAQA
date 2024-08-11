package Task_1;

import java.io.IOException;

public class Cat extends Animal{
    private static final short runLimit = 200;
    private boolean satiety;
    private static int countCats;

    public Cat(String name) {
        super(name);
        this.satiety = false;
        countCats++;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public static int getCountCats() {
        return countCats;
    }

    @Override
    public void toRun(int distanceLength) {
        if (distanceLength < 0){
            throw new RuntimeException("\n***ERROR***\nНекорректное значение!");
        }
        else if (distanceLength > runLimit) {
            System.out.printf("%s не пробежал %d м.\n", getName(), distanceLength);
        }
        else {
            System.out.printf("%s пробежал %d м.\n",getName(),distanceLength);
        }
    }

    @Override
    public void toSwim(int distanceLength) {
        if (distanceLength < 0){
            throw new RuntimeException("\n***ERROR***\nНекорректное значение!");
        }
        else System.out.printf("%s не умеет плавать\n", getName());
    }

    public void toFeedCat(int amountEatToFeedCat, Bowl bowl){
        if (amountEatToFeedCat < 0){
            throw new RuntimeException("\n***ERROR***\nНекоррекное значение!");
        }
        if (amountEatToFeedCat > bowl.getAmountEat()) {
            setSatiety(false);
        }
        else {
            setSatiety(true);
            int newAmount = bowl.getAmountEat() - amountEatToFeedCat;
            bowl.setAmountEat(newAmount);
        }
    }

    public void checkSatiety(){
        if(satiety) System.out.printf("%s поел и не голодный\n",getName());
        else System.out.printf("%s голодный и не поел\n",getName());
    }
}
