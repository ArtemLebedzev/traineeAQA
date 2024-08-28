import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class WordsUniqueCounter {
    private List<String> list;

    // Конструктор инициализирует список
    public WordsUniqueCounter() {
        this.list = new ArrayList<>();
    }

    // Метод для добавления слов в список
    public void add(String word) {
        list.add(word);
    }
    public void countUniqueWords(){
        LinkedHashSet<String> setList = new LinkedHashSet<>();
        int counter;
        for(int i = 0; i < list.size(); i++){
            counter = 1;
            for(int j = i + 1; j < list.size(); j++){
                if ((list.get(j).equals(list.get(i)) && !setList.contains(list.get(i)))){
                    counter++;
                }
            }
            if(!setList.contains(list.get(i))){
                System.out.printf("the word \"%s\" counter is %d\n", list.get(i), counter);
            }
            setList.add(list.get(i));
        }
    }
}
