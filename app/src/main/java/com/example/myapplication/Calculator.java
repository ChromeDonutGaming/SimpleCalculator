package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.myapplication.R;


import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    EditText editText1, editText2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSubtract = findViewById(R.id.btn_subtract);
        buttonMultiply = findViewById(R.id.btn_multiply);
        buttonDivide = findViewById(R.id.btn_divide);
        editText1 = findViewById(R.id.number1);
        editText2 = findViewById(R.id.number2);
        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSubtract.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return Integer.parseInt(editText.getText().toString());
        }
    }

    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editText1);
        num2 = getIntFromEditText(editText2);

        if (num1 == -1 || num2 == -1) {
            return; // Don't proceed with the calculation if an input is invalid
        }

        int id = view.getId();
        if (id == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (id == R.id.btn_subtract) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (id == R.id.btn_multiply) {
            textView.setText("Answer = " + (num1 * num2));
        } else if (id == R.id.btn_divide) {
            if (num2 != 0) {
                textView.setText("Answer = " + ((float)num1 / (float)num2));
            } else {
                textView.setText("Cannot divide by zero");
            }
        }
    }


}
