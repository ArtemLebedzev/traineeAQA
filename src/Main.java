import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Massive massive = new Massive();
        String[][] massive0 = {{"1","2"},{"1","2"}};
        String[][] massive1 = {{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
        /*try {
            massive1 = massive.createMassive(4,4);
        } catch (MyArraySizeException e) {
            throw new RuntimeException(e);
        }*/
        try {
            System.out.println(massive.sumElementsOfMassive(massive1));
        } catch (MyArraySizeException | MyArrayDataException e) {
            throw new RuntimeException(e);
        }
        massive.displayMassive(massive1);
    }
}
