import java.util.*;

public class Main {
    public static void main(String[] args) {
        WordsUniqueCounter wordsUniqueCounter = new WordsUniqueCounter();
        PhoneBook phoneBook = new PhoneBook();

        wordsUniqueCounter.add("Car");
        wordsUniqueCounter.add("Table");
        wordsUniqueCounter.add("Stone");
        wordsUniqueCounter.add("Smoke");
        wordsUniqueCounter.add("Table");
        for(int i = 0; i < 5; i++){
            wordsUniqueCounter.add("Bowl");
        }

        wordsUniqueCounter.countUniqueWords();

        phoneBook.add("Иванов", "123-456");
        phoneBook.add("Иванов", "987-654");
        phoneBook.add("Петров", "111-222");

        System.out.println("***PhoneBook****");
        System.out.println(phoneBook.get("Иванов"));
        System.out.println(phoneBook.get("Петров"));

    }
}
