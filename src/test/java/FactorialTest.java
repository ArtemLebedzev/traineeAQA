import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.management.ConstructorParameters;
import java.time.Duration;

public class FactorialTest {
    Factorial factorial = new Factorial();

    @DisplayName("Factorial of negative number")
    @Test
    public void testFactorialOfNegativeNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> factorial.countFactorial(-1));
    }

    @DisplayName("Factorial of zero")
    @Test
    public void testFactorialOfZero(){
        Assertions.assertEquals(1,factorial.countFactorial(0));
    }

    @DisplayName("Factorial of positive number")
    @ParameterizedTest
    @ValueSource(ints={5})
    public void testFactorialOfPositiveNumber(int n){
        Assertions.assertEquals(120, factorial.countFactorial(n));
    }

    @DisplayName("Factorial of 12 (max int)")
    @Test
    void testFactorialOfMaxNumber() {
        Assertions.assertEquals(479001600, factorial.countFactorial(12));
    }

    @DisplayName("Factorial of number > 12")
    @Test
    public void testFactorialOfTooLargeNumber(){
        Assertions.assertThrows(ArithmeticException.class, ()-> factorial.countFactorial(13));
    }
}
