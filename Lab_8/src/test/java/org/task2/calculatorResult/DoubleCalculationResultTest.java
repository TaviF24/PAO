package org.task2.calculatorResult;

import org.junit.jupiter.api.Test;
import org.task2.CalculationRequest;

import static org.junit.jupiter.api.Assertions.*;

class DoubleCalculationResultTest {

    @Test
    void testAdd() {
        CalculationRequest calculationRequest = new CalculationRequest(2.0,0.0,"+");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculationRequest);

        assertEquals(2.0, doubleCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testSubtract() {
        CalculationRequest calculatorRequest = new CalculationRequest(-4.5,-5.5,"-");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertEquals(1.0, doubleCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testMultiply() {
        CalculationRequest calculatorRequest = new CalculationRequest(2.0,-5.0,"*");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertEquals(-10.0, doubleCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testDivide() {
        CalculationRequest calculatorRequest = new CalculationRequest(-6.0,3.0,"/");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertEquals(-2.0, doubleCalculationResult.computeResult());
    }

    @Test
    void testDivideByZero() {
        CalculationRequest calculatorRequest = new CalculationRequest(1.0,0.0,"/");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertEquals(Double.POSITIVE_INFINITY, doubleCalculationResult.computeResult());
    }

    @Test
    void testDivideZeroByZero() {
        CalculationRequest calculatorRequest = new CalculationRequest(-0.0,0.0,"/");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

            assertEquals(Double.NaN, doubleCalculationResult.computeResult());
    }

    @Test
    void testInvalidOperator() {
        CalculationRequest calculatorRequest = new CalculationRequest(-6.0,3.0,"{");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertThrows(IllegalArgumentException.class, ()->{ doubleCalculationResult.computeResult(); }, "It should throw IllegalArgumentException");
    }

    @Test
    void testInvalidOperand() {
        CalculationRequest calculatorRequest = new CalculationRequest("a",4.0,"+");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertThrows(ClassCastException.class, ()->{ doubleCalculationResult.computeResult(); }, "It should throw ClassCastException");
    }

    @Test
    void testIntegerValues() {
        CalculationRequest calculatorRequest = new CalculationRequest(4.0,4,"+");
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(calculatorRequest);

        assertThrows(ClassCastException.class, ()->{ doubleCalculationResult.computeResult(); }, "It should throw ClassCastException");
    }

    @Test
    void testNull() {
        DoubleCalculationResult doubleCalculationResult = new DoubleCalculationResult(null);

        assertThrows(NullPointerException.class, ()->{ doubleCalculationResult.computeResult(); }, "It should throw NullPointerException");
    }

}