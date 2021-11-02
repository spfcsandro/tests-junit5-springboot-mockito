package com.trainee.codeplays.calculatorprogram.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {


    @Test
    public void ShouldReturnZeroWhenNoValueWereGiven(){
        Calculator calculator = new Calculator();

        double sum = calculator.sum();

        Assertions.assertEquals(0, sum);
    }

    @Test
    public void ShouldReturnTheSumOfGivenValues(){
        Calculator calculator = new Calculator();

        double sum = calculator.sum(3, 6);

        Assertions.assertEquals(9, sum);
    }

    @Test
    public void ShouldThrowsAnExcecptionWhenTheGivenNumberWereLassThenZero(){
        Calculator calculator = new Calculator();

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.squareRoot(-1));

        Assertions.assertEquals("Não existe raiz quadrada para números negativos", exception.getMessage());
    }

    @Test
    public void ShouldReturnTheSquareRootOfGivenNumber(){
        Calculator calculator = new Calculator();

        double result = calculator.squareRoot(4);

        Assertions.assertEquals(2, result);

    }

    @Test
    public void ShouldReturnTrueWhenTheGivenNumberIsOdd(){
        Calculator calculator = new Calculator();

        boolean isOdd = calculator.isOdd(3);

        Assertions.assertTrue(isOdd);
    }

    @Test
    public void ShouldReturnFalseWhenTheGivenNumberIsEven(){
        Calculator calculator = new Calculator();

        boolean isOdd = calculator.isOdd(2);

        Assertions.assertFalse(isOdd);
    }


}
