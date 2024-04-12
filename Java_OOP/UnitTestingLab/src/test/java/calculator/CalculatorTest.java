package calculator;

import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testSumWithPositiveNumbers(){
        Calculator calculator = new Calculator();

        int sum = calculator.sum(5, 6);

        Assert.assertEquals(11, sum);
    }

    @Test
    public void testMultiplicationWithNegativeNumbers(){
        int result = Calculator.multiplication(-5, -3);

        Assert.assertEquals(15, result);
    }
}