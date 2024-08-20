import java.util.Arrays;
import java.util.Scanner;

public class Massive {
    public String[][] createMassive(int a, int b) throws MyArraySizeException {
        Scanner scanner = new Scanner(System.in);
        if(a != 4 || b != 4) {
            throw new MyArraySizeException("Incorrect massive size");
        }
        String[][] twoDimensionalMassive = new String[a][b];
        for(int i = 0; i < a; i++){
            System.out.printf("Введите 4-е числа для заполнения %d-ого массива:\n", i + 1);
            for(int j = 0; j < b; j++){
                twoDimensionalMassive[i][j] = scanner.nextLine();
            }
        }
        return twoDimensionalMassive;
    }

    public int sumElementsOfMassive(String[][] twoDimensionalMassive) throws MyArraySizeException, MyArrayDataException {
        int parseNumber;
        int summary = 0;
        if(twoDimensionalMassive.length !=4 || twoDimensionalMassive[0].length != 4) {
            throw new MyArraySizeException("Incorrect massive size");
        }
        for(String[] row: twoDimensionalMassive)
        {
            for(String element: row) {
                try {
                    parseNumber = Integer.parseInt(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Parsing element incorrect", e);
                }
                summary += parseNumber;
            }
        }
        return summary;
    }

    public void displayMassive(String[][] twoDimensionalMassive){
        System.out.println(Arrays.deepToString(twoDimensionalMassive));
    }
}
