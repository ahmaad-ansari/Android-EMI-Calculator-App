# Android EMI Calculator App

## Introduction

The Android EMI Calculator App is a simple yet effective tool for calculating Equated Monthly Installments (EMI) for mortgage payments. This app allows users to input essential details such as the mortgage principal amount, interest rate, and amortization period, and it provides them with a breakdown of their monthly payments, including total interest paid and principal paid.

## Screenshots

Below are side-by-side screenshots of the Android EMI Calculator app in action:

<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/ahmaad-ansari/SOFE4640U-Assignment-1/assets/88805493/5a535c00-c292-4a2b-b5f7-5afaccb8a804" alt="First Screenshot" width="300">
  <img src="https://github.com/ahmaad-ansari/SOFE4640U-Assignment-1/assets/88805493/7b6c1deb-e6c5-42c5-92d4-040e4c48ee76" alt="Second Screenshot" width="300">
</div>

## Features

- User-friendly interface for inputting mortgage details.
- Supports calculation based on monthly payment frequency.
- Accurate EMI calculation following the standard formula.
- Clear presentation of calculated EMI details in a results screen.

## Source Code Structure

The source code for this app is organized into two main activities:

1. **MainActivity**: This activity handles user input, including mortgage principal amount, interest rate, amortization period, and payment frequency. It validates user input and initiates the EMI calculation process.

2. **ResultsActivity**: This activity displays the calculated EMI details, including the monthly payment amount, total payments over the term, total interest paid, and principal paid. It also handles navigation back to the main activity.

## How the App Works

- Users enter their mortgage details in the `MainActivity`.
- Input is validated to ensure it's not empty and contains valid numbers.
- The app creates an `Intent` and passes user data as extras to the `ResultsActivity`. The intent facilitates the transfer of data between activities.
- In the `ResultsActivity`, the EMI calculation is performed based on user input. The results are calculated using the formula and encapsulated in an `EMICalculationResult` object.
- The calculated EMI and related details are displayed in an organized manner using TextViews in the results screen.

## Working with Intents

Intents are used to enable communication between different activities within the app. The `MainActivity` creates an intent and attaches user input data as extras. This intent is then used to start the `ResultsActivity`, passing along the necessary information for EMI calculation.

## Using the EMI Object

The EMI calculation results, including the EMI amount, total payments, total interest paid, and principal paid, are encapsulated in an `EMICalculationResult` object. This object is created in the `ResultsActivity` after performing the calculation and is then used to populate the TextViews in the results screen. It provides a structured representation of the EMI details, enhancing code modularity and readability.

## Input Validation and Error Handling

The Android EMI Calculator App incorporates robust input validation and error handling mechanisms to ensure a seamless user experience and prevent unexpected issues. Here are some key aspects of the error checking and validation:

- **Empty Fields**: The app checks for empty fields in the input form (principal amount, interest rate, amortization period) and prompts the user to fill in all required fields if any are left empty.
- **Invalid Data**: To prevent invalid data entry, the app verifies that the user inputs are valid numbers. If the input is not a valid number, it displays an error message and guides the user to enter a valid numerical value.
- **Zero Values**: The app also ensures that the principal amount, interest rate, and amortization period are not set to zero. If any of these values are zero, the user is prompted to provide valid non-zero values.

These comprehensive error checks and input validations contribute to a reliable and user-friendly EMI calculator, ensuring that users receive accurate results while minimizing the risk of data entry errors.

## Getting Started

To use this app and examine the source code:

1. Clone or download the repository to your local machine.
2. Open the project in Android Studio.
3. Build and run the app on an Android emulator or physical device.
