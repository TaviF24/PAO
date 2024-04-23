package org.task2.calculatorResult;

import org.junit.jupiter.api.Test;
import org.task2.CalculationRequest;

import static org.junit.jupiter.api.Assertions.*;

class IntegerCalculationResultTest {

    @Test
    void testAdd() {
        CalculationRequest calculationRequest = new CalculationRequest(2,2,"+");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculationRequest);

        assertEquals(4, integerCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testSubtract() {
        CalculationRequest calculatorRequest = new CalculationRequest(4,-5,"-");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertEquals(9, integerCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testMultiply() {
        CalculationRequest calculatorRequest = new CalculationRequest(-1,-5,"*");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertEquals(5, integerCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testDivide() {
        CalculationRequest calculatorRequest = new CalculationRequest(-6,3,"/");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertEquals(-2,integerCalculationResult.computeResult());
    }

    @Test
    void testDivideByZero() {
        CalculationRequest calculatorRequest = new CalculationRequest(-6,0,"/");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertThrows(ArithmeticException.class, ()->{ integerCalculationResult.computeResult(); }, "It should throw ArithmeticException");
    }

    @Test
    void testInvalidOperator() {
        CalculationRequest calculatorRequest = new CalculationRequest(-6,3,"{");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertThrows(IllegalArgumentException.class, ()->{ integerCalculationResult.computeResult(); }, "It should throw IllegalArgumentException");
    }

    @Test
    void testInvalidOperand() {
        CalculationRequest calculatorRequest = new CalculationRequest("a",4,"+");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertThrows(ClassCastException.class, ()->{ integerCalculationResult.computeResult(); }, "It should throw ClassCastException");
    }

    @Test
    void testDoubleValues() {
        CalculationRequest calculatorRequest = new CalculationRequest(4.0,4,"+");
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(calculatorRequest);

        assertThrows(ClassCastException.class, ()->{ integerCalculationResult.computeResult(); }, "It should throw ClassCastException");
    }

    @Test
    void testNull() {
        IntegerCalculationResult integerCalculationResult = new IntegerCalculationResult(null);

        assertThrows(NullPointerException.class, ()->{ integerCalculationResult.computeResult(); }, "It should throw NullPointerException");
    }
}