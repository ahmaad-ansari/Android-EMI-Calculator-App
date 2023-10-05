package com.example.sofe4640u_assignment_1;

// Define the EMICalculationResult class
public class EMICalculationResult {
    // Private member variables to store EMI and related values
    private double emi;
    private double totalPayments;
    private double totalInterestPaid;
    private double principalPaid;

    // Constructor to initialize the result object with calculated values
    public EMICalculationResult(double emi, double totalPayments, double totalInterestPaid, double principalPaid) {
        this.emi = emi;
        this.totalPayments = totalPayments;
        this.totalInterestPaid = totalInterestPaid;
        this.principalPaid = principalPaid;
    }

    // Getter methods to access the private member variables
    public double getEmi() {
        return emi;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public double getTotalInterestPaid() {
        return totalInterestPaid;
    }

    public double getPrincipalPaid() {
        return principalPaid;
    }
}
