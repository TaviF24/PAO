package org.task2.calculatorResult;

import org.junit.jupiter.api.Test;
import org.task2.CalculationRequest;

import static org.junit.jupiter.api.Assertions.*;

class BooleanCalculationResultTest {

    @Test
    void TestAnd(){
        CalculationRequest calculationRequest = new CalculationRequest(true, false, "&&");
        BooleanCalculationResult booleanCalculationResult = new BooleanCalculationResult(calculationRequest);

        assertEquals(false, booleanCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void TestOr(){
        CalculationRequest calculationRequest = new CalculationRequest(true, false, "||");
        BooleanCalculationResult booleanCalculationResult = new BooleanCalculationResult(calculationRequest);

        assertEquals(true, booleanCalculationResult.computeResult(), "Results should be equal");
    }

    @Test
    void testInvalidOperator() {
        CalculationRequest calculatorRequest = new CalculationRequest(true,false,"{");
        BooleanCalculationResult booleanCalculationResult = new BooleanCalculationResult(calculatorRequest);

        assertThrows(IllegalArgumentException.class, ()->{ booleanCalculationResult.computeResult(); }, "It should throw IllegalArgumentException");
    }

    @Test
    void testInvalidOperand() {
        CalculationRequest calculatorRequest = new CalculationRequest(1,false,"&&");
        BooleanCalculationResult booleanCalculationResult = new BooleanCalculationResult(calculatorRequest);

        assertThrows(ClassCastException.class, ()->{ booleanCalculationResult.computeResult(); }, "It should throw ClassCastException");
    }

    @Test
    void testNull() {
        BooleanCalculationResult booleanCalculationResult = new BooleanCalculationResult(null);

        assertThrows(NullPointerException.class, ()->{ booleanCalculationResult.computeResult(); }, "It should throw NullPointerException");
    }

}