import java.util.Arrays;
import java.util.Scanner;

public class Massive {
    /*public String[][] createMassive(int a, int b) throws MyArraySizeException {
        Scanner = new Scanner(System.in);
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
    }*/

    public int sumElementsOfMassive(String[][] twoDimensionalMassive) throws MyArraySizeException, MyArrayDataException {
        int parseNumber, summary = 0, i = 0, j = 0;
        if(twoDimensionalMassive.length !=4 || twoDimensionalMassive[0].length != 4) {
            throw new MyArraySizeException("Incorrect massive size");
        }
        for(String[] row: twoDimensionalMassive)
        {
            j = 0;
            for(String element: row) {
                try {
                    parseNumber = Integer.parseInt(element);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(STR."Parsing element incorrect. Massive \{i + 1}, element \{j + 1}", e);
                }
                j++;
                summary += parseNumber;
            }
            i++;
        }
        return summary;
    }

    public void displayMassive(String[][] twoDimensionalMassive){
        System.out.println(Arrays.deepToString(twoDimensionalMassive));
    }
}
