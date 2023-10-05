package com.example.sofe4640u_assignment_1;

// Import necessary libraries and classes
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

// Define the main activity class that extends AppCompatActivity
public class MainActivity extends AppCompatActivity {

    // This method is called when the activity is first created
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view for this activity from a layout resource file (activity_main.xml)
        setContentView(R.layout.activity_main);

        // Set the title of the activity
        setTitle("EMI Calculator");

        // Initialize UI elements by finding their respective views in the layout
        EditText etPrincipalAmount = findViewById(R.id.etPrincipalAmount);
        EditText etInterestRate = findViewById(R.id.etInterestRate);
        EditText etAmortizationPeriod = findViewById(R.id.etAmortizationPeriod);
        Button calculateButton = findViewById(R.id.calculateButton);
        Button clearButton = findViewById(R.id.clearButton);

        // Define a click listener for the "Clear" button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear the text fields
                etPrincipalAmount.setText("");
                etInterestRate.setText("");
                etAmortizationPeriod.setText("");
            }
        });

        // Define a click listener for the "Calculate" button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // Parse the input values from text fields
                    double principalAmount = Double.parseDouble(etPrincipalAmount.getText().toString());
                    double interestRate = Double.parseDouble(etInterestRate.getText().toString());
                    int amortizationPeriod = Integer.parseInt(etAmortizationPeriod.getText().toString());

                    // Check if any of the input fields are empty or zero
                    if (principalAmount == 0 || interestRate == 0 || amortizationPeriod == 0) {
                        // Display a toast message if any field is empty or zero
                        Toast.makeText(getApplicationContext(), "Please fill in all required fields", Toast.LENGTH_SHORT).show();
                    } else {
                        // Create an intent to start the ResultsActivity and pass data as extras
                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        intent.putExtra("principalAmount", principalAmount);
                        intent.putExtra("interestRate", interestRate);
                        intent.putExtra("amortizationPeriod", amortizationPeriod);
                        // Start the ResultsActivity
                        startActivity(intent);
                    }
                } catch (NumberFormatException e) {
                    // Display a toast message if input fields contain invalid data
                    Toast.makeText(getApplicationContext(), "Please enter valid integers in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
