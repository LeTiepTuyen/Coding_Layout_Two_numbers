package com.example.coding_layout_two_numbers;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText editTextA;
    private EditText editTextB;
    private Button addButton;
    private Button subtractButton;
    private Button multiplyButton;
    private Button divideButton;
    private ListView resultList;

    private ArrayList<String> resultsList;
    private ArrayAdapter<String> resultsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        editTextA = findViewById(R.id.edit_text_a);
        editTextB = findViewById(R.id.edit_text_b);
        addButton = findViewById(R.id.button_add);
        subtractButton = findViewById(R.id.button_subtract);
        multiplyButton = findViewById(R.id.button_multiply);
        divideButton = findViewById(R.id.button_divide);
        resultList = findViewById(R.id.list_results);

        // Initialize results list and adapter
        resultsList = new ArrayList<>();
        resultsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, resultsList);
        resultList.setAdapter(resultsAdapter);

        // Set click listeners for buttons
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('+');
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('-');
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('*');
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation('/');
            }
        });
    }

    // Method to perform arithmetic operations
    private void performOperation(char operation) {
        // Get values from EditText fields
        double a = Double.parseDouble(editTextA.getText().toString());
        double b = Double.parseDouble(editTextB.getText().toString());

        double result;
        String operator;

        // Perform operation based on the selected button
        switch (operation) {
            case '+':
                result = a + b;
                operator = "+";
                break;
            case '-':
                result = a - b;
                operator = "-";
                break;
            case '*':
                result = a * b;
                operator = "*";
                break;
            case '/':
                if (b != 0) {
                    result = a / b;
                    operator = "/";
                } else {
                    // Handle division by zero case
                    result = Double.NaN;
                    operator = "Undefined";
                }
                break;
            default:
                result = 0;
                operator = "";
        }

        // Display the result in ListView
        String calculation = a + " " + operator + " " + b + " = " + result;
        resultsList.add(0, calculation);
        resultsAdapter.notifyDataSetChanged();

        // Clear EditText fields after calculation
        editTextA.setText("");
        editTextB.setText("");


    }

}