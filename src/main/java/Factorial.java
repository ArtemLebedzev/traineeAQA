public class Factorial {
    public int countFactorial(int n){
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        else if (n == 0 || n == 1) {
            return 1;
        }
        else if (n > 12) {
            throw new ArithmeticException("Factorial result is too large for int type");
        }
        return n * countFactorial(n - 1);
    }
}
