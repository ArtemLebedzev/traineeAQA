package Task_1;

public class Dog extends Animal{
    private static final short runLimit = 500;
    private static final byte swimLimit = 10;
    private static int countDogs;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    public static int getCountDogs() {
        return countDogs;
    }

    @Override
    public void toRun(int distanceLength) {
        if (distanceLength < 0){
            throw new RuntimeException("\n***ERROR***\nНекоррекное значение!");
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
            throw new RuntimeException("\n***ERROR***\nНекоррекное значение!");
        }
        else if (distanceLength > swimLimit) {
            System.out.printf("%s не проплыл %d м.\n", getName(), distanceLength);
        }
        else {
            System.out.printf("%s проплыл %d м.\n",getName(),distanceLength);
        }
    }
}
