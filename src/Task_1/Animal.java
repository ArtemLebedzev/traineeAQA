package Task_1;

public abstract class Animal {
    private String name;
    private static int countAnimals;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }

    public abstract void toRun(int distanceLength);

    public abstract void toSwim(int distanceLength);
}
