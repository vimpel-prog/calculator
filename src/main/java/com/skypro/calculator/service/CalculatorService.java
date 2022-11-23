package com.skypro.calculator.service;

import com.skypro.calculator.Exception.IllegalNumberException;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int getSum(int num1 , int num2) {
        return num1+num2;
    }

    public int getMinus(int num1, int num2) {
        return num1-num2;
    }

    public int getMultiply(int num1, int num2) {
        return num1*num2;
    }

    public int getDivide(int num1, int num2) {
        if(num2==0) throw new IllegalNumberException("Делить на 0 нельзя");
        return num1/num2;
    }
}
