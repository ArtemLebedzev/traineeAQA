package Task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dog dog1 = new Dog("Арс");
        Cat[] cats = new Cat[]{new Cat("Нолик"),
                new Cat("Фимка"),
                new Cat("Макс")};
        Bowl bowl = new Bowl();
        System.out.println("Кол-во животных: " + Animal.getCountAnimals());
        System.out.println("Кол-во собачек: " + Dog.getCountDogs());
        System.out.println("Кол-во котеек: " + Cat.getCountCats());

        int distanceLength;
        System.out.println("=====Task_1=====");
        System.out.print("Введите расстояние: ");
        distanceLength = scanner.nextInt();
        System.out.println("-----Собакен-----");
        dog1.toRun(distanceLength);
        dog1.toSwim(distanceLength);
        System.out.println("-----Кот-----");
        cats[0].toRun(distanceLength);
        cats[0].toSwim(distanceLength);

        System.out.println("-----Время кормить котов-----");
        System.out.print("Ввести кол-во еды для заполнения миски: ");
        bowl.setAmountEat(scanner.nextInt());
        System.out.print("Ввести кол-во еды, которую осилит каждый котейка: ");
        int amountEat = scanner.nextInt();
        for(Cat cat: cats){
            cat.toFeedCat(amountEat,bowl);
            cat.checkSatiety();
            bowl.checkAmountEatInBowl();
        }
        bowl.addAmountEatInBowl(amountEat);
        cats[2].toFeedCat(amountEat,bowl);
        cats[2].checkSatiety();
        bowl.checkAmountEatInBowl();

    }
}
