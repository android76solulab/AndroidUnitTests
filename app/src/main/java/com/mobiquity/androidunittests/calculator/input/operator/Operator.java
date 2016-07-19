package com.mobiquity.androidunittests.calculator.input.operator;

import com.mobiquity.androidunittests.calculator.input.Input;
import com.mobiquity.androidunittests.calculator.input.InputType;

public abstract class Operator extends Input {
    public Operator(String value, InputType type) {
        super(value, type);
    }

    public abstract double execute(double param1, double param2);
    public abstract int getPrecedence();
    public abstract boolean isLeftAssociative();

    public enum Precedence {
        ADDITION_PRECEDENCE(2),
        SUBTRACTION_PRECEDENCE(2),
        MULTIPLICATION_PRECEDENCE(3),
        DIVISION_PRECEDENCE(3),
        POWER_PRECEDENCE(4),
        SQRT_PRECEDENCE(4);

        private int value;

        Precedence(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
