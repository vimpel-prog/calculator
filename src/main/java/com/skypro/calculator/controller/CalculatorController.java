package com.skypro.calculator.controller;

import com.skypro.calculator.service.CalculatorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String welcome(){
    return "Добро пожаловать в калькулятор";
}
    @GetMapping("/plus")
    public String doPlus(@RequestParam("num1")int num1,@RequestParam("num2") int num2){
        return String.format("%d + %d = %d",num1,num2,calculatorService.getSum(num1,num2));
    }
    @GetMapping("/minus")
    public String doMinus(@RequestParam("num1")int num1,@RequestParam("num2") int num2){
        return String.format("%d - %d = %d",num1,num2,calculatorService.getMinus(num1,num2));
    }
    @GetMapping("/multiply")
    public String doMultiply(@RequestParam("num1")int num1,@RequestParam("num2") int num2){
        return String.format("%d * %d = %d",num1,num2,calculatorService.getMultiply(num1,num2));
    }
    @GetMapping("/divide")
    public String doDivide(@RequestParam("num1")int num1,@RequestParam("num2") int num2){
        return String.format("%d / %d = %d",num1,num2,calculatorService.getDivide(num1,num2));
    }

}
