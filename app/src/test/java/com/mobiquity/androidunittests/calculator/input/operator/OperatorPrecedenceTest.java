package com.mobiquity.androidunittests.calculator.input.operator;

import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

public class OperatorPrecedenceTest {

    @Test
    public void testOperatorPrecedenceEqual_AdditionAndSubtraction() {
        assertThat(Operator.Precedence.ADDITION_PRECEDENCE.getValue())
                .isEqualTo(Operator.Precedence.SUBTRACTION_PRECEDENCE.getValue());
    }

    @Test
    public void testOperatorPrecedenceEqual_MultiplyAndDivide() {
        assertThat(Operator.Precedence.MULTIPLICATION_PRECEDENCE.getValue())
                .isEqualTo(Operator.Precedence.DIVISION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_MultiplicationOverAddition() {
        assertThat(Operator.Precedence.MULTIPLICATION_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.ADDITION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_DivisionOverAddition() {
        assertThat(Operator.Precedence.DIVISION_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.ADDITION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_MultiplicationOverSubtraction() {
        assertThat(Operator.Precedence.MULTIPLICATION_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.SUBTRACTION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_DivisionOverSubtraction() {
        assertThat(Operator.Precedence.DIVISION_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.SUBTRACTION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_PowerOverMultiplication() {
        assertThat(Operator.Precedence.POWER_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.MULTIPLICATION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_PowerOverDivision() {
        assertThat(Operator.Precedence.POWER_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.DIVISION_PRECEDENCE.getValue());
    }

    @Test
    public void testOrderOfOperations_SQRTOverMultiplication() {
        assertThat(Operator.Precedence.SQRT_PRECEDENCE.getValue())
                .isGreaterThan(Operator.Precedence.MULTIPLICATION_PRECEDENCE.getValue());
    }
}