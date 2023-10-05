package com.example.sofe4640u_assignment_1;

// Import necessary libraries and classes
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

// Define the ResultsActivity class that extends AppCompatActivity
public class ResultsActivity extends AppCompatActivity {

    // This method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view for this activity from a layout resource file (activity_results.xml)
        setContentView(R.layout.activity_results);

        // Set the title of the activity
        setTitle("EMI Results");

        // Enable the "Up" button in the action bar for navigation
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Retrieve data passed from the MainActivity through an intent
        Intent intent = getIntent();
        double principalAmount = intent.getDoubleExtra("principalAmount", 0);
        double interestRate = intent.getDoubleExtra("interestRate", 0);
        int amortizationPeriod = intent.getIntExtra("amortizationPeriod", 0);

        // Initialize TextView elements by finding their respective views in the layout
        TextView tvPaymentAmount = findViewById(R.id.tvPaymentAmount);
        TextView tvTotalPayments = findViewById(R.id.tvTotalPayments);
        TextView tvTotalInterestPaid = findViewById(R.id.tvTotalInterestPaid);
        TextView tvPrincipalPaid = findViewById(R.id.tvPrincipalPaid);

        TextView tvMortgage = findViewById(R.id.tvMortgage);
        TextView tvInterestRate = findViewById(R.id.tvInterestRate);
        TextView tvAmortizationPeriod = findViewById(R.id.tvAmortizationPeriod);

        // Calculate EMI and related values using the calculateEMI method
        EMICalculationResult result = calculateEMI(principalAmount, interestRate, amortizationPeriod);

        // Display calculated values in TextViews
        tvPaymentAmount.setText("$" + String.format("%.2f", result.getEmi()) + " / Monthly");
        tvTotalPayments.setText("$" + String.format("%.2f", result.getTotalPayments()));
        tvTotalInterestPaid.setText("$" + String.format("%.2f", result.getTotalInterestPaid()));
        tvPrincipalPaid.setText("$" + String.format("%.2f", result.getPrincipalPaid()));

        tvMortgage.setText("$" + String.format("%.2f", principalAmount));
        tvInterestRate.setText("" + String.format("%.2f", interestRate) + "%");
        tvAmortizationPeriod.setText(Integer.toString(amortizationPeriod) + " Years");
    }

    // Calculate EMI and related values based on principal, interest rate, and amortization period
    public static EMICalculationResult calculateEMI(double principalAmount, double interestRate, int amortizationPeriod) {
        // Calculate the monthly interest rate
        double monthlyInterestRate = (interestRate / 12) / 100;

        // Calculate the total number of monthly installments (tenure in months)
        int totalMonths = amortizationPeriod * 12;

        // Calculate the monthly EMI using the formula
        double emi = principalAmount * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, totalMonths) / (Math.pow(1 + monthlyInterestRate, totalMonths) - 1);

        // Calculate total payments over the term
        double totalPayments = emi * totalMonths;

        // Calculate total interest paid
        double totalInterestPaid = totalPayments - principalAmount;

        // Calculate principal paid
        double principalPaid = totalPayments - totalInterestPaid;

        // Create and return an EMICalculationResult object
        return new EMICalculationResult(emi, totalPayments, totalInterestPaid, principalPaid);
    }

    // Handle the "Up" button press in the action bar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate back to the previous activity (MainActivity)
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
