import java.util.Arrays;

public class Methods {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(checkIsSumInBorder(-10, 20));
        System.out.println(checkPosOrNegNum(-1));
        System.out.println(checkIsPosOrNegNum(-1));
        printString("AQA", 5);
        System.out.println(checkIsYearLeap(2023));
        changeMassElememts();
        fillMass();
        doubleElUnderSix();
        printTwoDimensionalMass();
        System.out.println(Arrays.toString(returnMass(5,1)));
    }

    public static void printThreeWords(){
        System.out.println("Метод 1:");
        System.out.println("Orange\nBanana\nApple");
    }

    public static void checkSumSign() {
        System.out.println("\nМетод 2:");
        int a = 0, b = 5;
        int sum = a + b;
        if(sum >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor() {
        System.out.println("\nМетод 3:");
        int value = 0;
        if (value <= 0) {
            System.out.println("Красный");
        }
        else if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        else{
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        System.out.println("\nМетод 4:");
        int a = -10, b = 5;
        String result = a >= b ? "a >= b" : "a < b";
        System.out.println(result);
    }

    public static boolean checkIsSumInBorder(int a, int b){
        System.out.println("\nМетод 5:");
        int sum = a + b;
        boolean result = sum >= 10 && sum <= 20;
        return result;
    }

    public static String checkPosOrNegNum(int a) {
        System.out.println("\nМетод 6:");
        String result = a >= 0 ? "Положительое" : "Отрицательное";
        return result;
    }

    public static boolean checkIsPosOrNegNum (int a) {
        System.out.println("\nМетод 7:");
        boolean result = a < 0;
        return  result;
    }

    public static void printString(String str, int n) {
        System.out.println("\nМетод 8:");
        for (int i = 0; i < n; i++){
            System.out.println(str);
        }
    }

    public static boolean checkIsYearLeap(int year) {
        System.out.println("\nМетод 9:");
        boolean result = year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
        return result;
    }

    public static void changeMassElememts() {
        System.out.println("\nМетод 10:");
        int[] array1= {1,0,0,1};
        for(int i = 0; i < array1.length; i++){
            if (array1[i] == 1) {
                array1[i] = 0;
            }
            else {
                array1[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array1));
    }

    public static void fillMass(){
        System.out.println("\nМетод 11:");
        int[] array2 = new int[100];
        int element = 0;
        for(int i = 0; i < array2.length; i++){
            element++;
            array2[i] = element;
        }
        System.out.println(Arrays.toString(array2));
    }

    public static void doubleElUnderSix() {
        System.out.println("\nМетод 12:");
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for(int i = 0; i < array3.length; i++){
            if (array3[i] < 6) {
                array3[i] = array3[i] * 2;
            }
        }
        System.out.println(Arrays.toString(array3));
    }

    public static void printTwoDimensionalMass() {
        System.out.println("\nМетод 13:");
        int[][] array4 = new int[6][6];
        for (int i = 0; i < array4.length; i++) {
            for (int j = 0; j < array4.length; j++){
                if (i == j){
                    array4[i][j] = 1;
                }
                else if (i + j == array4.length - 1){
                    array4[i][j] = 1;
                }
                else {
                    array4[i][j] = 0;
                }
                System.out.print(array4[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] returnMass(int len, int initialValue) {
        System.out.println("\nМетод 14:");
        int[] array5 = new int[len];
        for(int i = 0; i < array5.length; i++){
            array5[i] = initialValue;
        }
        return array5;
    }
}
