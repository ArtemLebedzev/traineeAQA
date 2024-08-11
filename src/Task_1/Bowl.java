package Task_1;

import java.io.IOException;

public class Bowl {
    private int amountEatInBowl;

    public Bowl() {}

    public Bowl(int amountEat) {
        this.amountEatInBowl = amountEat;
    }

    public int getAmountEat() {
        return amountEatInBowl;
    }

    public void setAmountEat(int amountEat) {
        if (amountEat < 0) {
            throw new RuntimeException("\n***ERROR***\nНевозможно установить данное значение!");
        }
        this.amountEatInBowl = amountEat;
    }

    public void addAmountEatInBowl(int amountEat) {
        int newAmount = getAmountEat() + amountEat;
        if (newAmount < 0) {
            throw new RuntimeException("\n***ERROR***\nНевозможно добавить данное значение!");
        }
        setAmountEat(newAmount);
        System.out.printf("В миску добавлено %d еды\n", amountEat);
    }

    public void checkAmountEatInBowl(){
        System.out.printf("Кол-во еды в миске: %d\n",getAmountEat());
    }
}
