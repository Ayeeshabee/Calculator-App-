package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService; // Injecting service

    @RequestMapping("/")
    public String home() {
        return "home"; // Make sure home.html is in templates folder
    }

    @PostMapping("/calculate")
    public String calculate(
            @RequestParam("num1") double n1,
            @RequestParam("num2") double n2,
            @RequestParam("operation") String operation,
            Model model) {

        double result = 0.0;

        switch (operation) {
            case "add":
                result = calculatorService.add(n1, n2);
                break;
            case "sub":
                result = calculatorService.sub(n1, n2);
                break;
            case "mul":
                result = calculatorService.mul(n1, n2);
                break;
            case "div":
                if (n2 == 0) {
                    model.addAttribute("error", "Cannot divide by zero.");
                    return "home"; // Redirects back to home with error
                }
                result = calculatorService.div(n1, n2);
                break;
            default:
                model.addAttribute("error", "Invalid operation.");
                return "home";
        }

        model.addAttribute("num1", n1);
        model.addAttribute("num2", n2);
        model.addAttribute("operation", operation);
        model.addAttribute("result", result);

        return "result"; // Displays result.html
    }
}
