package com.cognizant.loan.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping("/{number}")
    public Loan getLoanDetails(@PathVariable String number) {
        return new Loan(number, "car", 400000, 3258, 18);
    }

    static class Loan {
        private String number;
        private String type;
        private double loan;
        private double emi;
        private int tenure;

        public Loan(String number, String type, double loan, double emi, int tenure) {
            this.number = number;
            this.type = type;
            this.loan = loan;
            this.emi = emi;
            this.tenure = tenure;
        }

        public String getNumber() { return number; }
        public String getType() { return type; }
        public double getLoan() { return loan; }
        public double getEmi() { return emi; }
        public int getTenure() { return tenure; }
    }
}
