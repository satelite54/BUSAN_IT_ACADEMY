package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_02_cal);

        editText1 = findViewById(R.id.EditView);
        editText2 = findViewById(R.id.EditView2);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);

        textView = findViewById(R.id.textView3);

        button1.setOnClickListener(v -> {
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                makeToast("EditBox 안에 값 입력 안했다!");
                return;
            }
            textView.setText("계산 결과: " + calculate(editText1.getText().toString(), editText2.getText().toString(), '+'));
        });
        button2.setOnClickListener(v -> {
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                makeToast("EditBox 안에 값 입력 안했다!");
                return;
            }
            textView.setText("계산 결과: " + calculate(editText1.getText().toString(), editText2.getText().toString(), '-'));
        });
        button3.setOnClickListener(v -> {
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                makeToast("EditBox 안에 값 입력 안했다!");
                return;
            }
            textView.setText("계산 결과: " + calculate(editText1.getText().toString(), editText2.getText().toString(), '*'));
        });
        button4.setOnClickListener(v -> {
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                makeToast("EditBox 안에 값 입력 안했다!");
                return;
            }
            textView.setText("계산 결과: " + calculate(editText1.getText().toString(), editText2.getText().toString(), '/'));
        });
        button5.setOnClickListener(v -> {
            if(editText1.getText().toString().equals("") || editText2.getText().toString().equals("")) {
                makeToast("EditBox 안에 값 입력 안했다!");
                return;
            }
            textView.setText("계산 결과: " + calculate(editText1.getText().toString(), editText2.getText().toString(), '%'));
        });
    }

        private void makeToast(String str) {
            Toast.makeText(this, str, Toast.LENGTH_LONG).show();
        }

        private String calculate(String a, String b, char c) {
            int nTemp = 0;
            switch (c) {
                case '+': {
                    nTemp = Integer.parseInt(a) + Integer.parseInt(b);
                    break;
                }
                case '-': {
                    nTemp = Integer.parseInt(a) - Integer.parseInt(b);
                    break;
                }
                case '*': {
                    nTemp = Integer.parseInt(a) * Integer.parseInt(b);
                    break;
                }
                case '/': {
                    nTemp = Integer.parseInt(a) / Integer.parseInt(b);
                    break;
                }
                case '%': {
                    nTemp = Integer.parseInt(a) % Integer.parseInt(b);
                    break;
                }
                default: {
                    break;
                }
            }
            return String.valueOf(nTemp);
        }
    }