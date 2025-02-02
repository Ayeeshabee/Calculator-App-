package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public double add(double num1, double num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(double num1, double num2) {
        return num1 * num2;
    }

    public double div(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed");
        }
        return num1 / num2;
    }
}
