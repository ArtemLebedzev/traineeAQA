import org.junit.jupiter.api.Assertions;
/*import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;*/
import org.testng.annotations.*;

public class FactorialTest {
    Factorial factorial = new Factorial();
    @DataProvider(name = "positiveData")
    Object[][] positiveNumberDataProvider(){
        return new Object[][]{
                {1,1},
                {2,2},
                {3,6},
                {4,24},
                {5,120}
        };
    }

    @DataProvider(name = "negativeData")
    Object[][] negativeNumberDataProvider(){
        return new Object[][]{
                {-1},
                {-10},
                {-100}
        };
    }

    @Test(dataProvider = "negativeData", groups = "negativeTests", description ="Factorial of negative number",
            dependsOnGroups = "positiveTests")
    public void testFactorialOfNegativeNumber(int actual){
        Assertions.assertThrows(IllegalArgumentException.class, ()-> factorial.countFactorial(actual));
    }

    @Test(groups = "positiveTests", description = "Factorial of zero")
    public void testFactorialOfZero(){
        Assertions.assertEquals(1,factorial.countFactorial(0));
    }

    @Test(dataProvider = "positiveData", groups = "positiveTests", description = "Factorial of positive number")
    public void testFactorialOfPositiveNumber(int actual, int expected){
        Assertions.assertEquals(expected, factorial.countFactorial(actual));
    }

    @Test(groups = "boundaryTests", description = "Factorial of 12 (max int)",
            dependsOnGroups = {"positiveTests", "negativeTests"})
    void testFactorialOfMaxNumber() {
        Assertions.assertEquals(479001600, factorial.countFactorial(12));
    }

    @Test(groups = "boundaryTests", description = "Factorial of 12 (max int)",
            dependsOnMethods = "testFactorialOfMaxNumber")
    public void testFactorialOfTooLargeNumber(){
        Assertions.assertThrows(ArithmeticException.class, ()-> factorial.countFactorial(13));
    }
}
