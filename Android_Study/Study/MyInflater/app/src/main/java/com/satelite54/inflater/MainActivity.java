package com.satelite54.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main); // View나 레이아웃들을 메모리에 올려준다. 이 행위를 인플레이션이라고 함.

        Button button = findViewById(R.id.button); // 실제 버튼의 메모리를 가르키게 한다.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}