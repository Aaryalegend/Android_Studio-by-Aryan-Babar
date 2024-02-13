package com.example.myapplicationbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText weightEditText;
    private EditText heightEditText;
    private Button calculateButton;
    private TextView resultTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightEditText = findViewById(R.id.weightEditText);
        heightEditText = findViewById(R.id.heightEditText);
        calculateButton = findViewById(R.id.calculateButton);
        resultTextView = findViewById(R.id.resultTextView);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String weightString = weightEditText.getText().toString();
        String heightString = heightEditText.getText().toString();

        if (!weightString.isEmpty() && !heightString.isEmpty()) {
            float weight = Float.parseFloat(weightString);
            float height = Float.parseFloat(heightString);

            float bmi = calculateBMIValue(weight, height);
            displayResult(bmi);
        } else {
            resultTextView.setText("Invalid input. Please enter valid values for weight and height.");
        }
    }

    // BMI Calculate Formula
    private float calculateBMIValue(float weight, float height) {
        return weight / ((height/100) * (height/100));
    }

    private void displayResult(float bmi) {
        String resultText;
        if (bmi < 18.50) {
            resultText = "Underweight";
        } else if (bmi < 24.99) {
            resultText = "Normal Weight";
        } else if (bmi < 29.99) {
            resultText = "Overweight";
        } else {
            resultText = "Obese";
        }

        resultTextView.setText(String.format("BMI: %.2f\nCategory: %s", bmi, resultText));
    }
}