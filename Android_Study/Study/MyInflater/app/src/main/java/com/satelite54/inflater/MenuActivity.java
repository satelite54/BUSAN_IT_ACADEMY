package com.satelite54.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button2 = findViewById(R.id.button2);
        container = findViewById(R.id.container);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addlayout();
            }
        });


    }
    public void addlayout() {
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE); // 단말이 동작하면 단말내부에서 계속 동작하고 있을걸 시스템 서비스라고 한다.
        // 레이아웃 인플레이터라는 놈이 계속 동작 중이기 때문에 그걸 참조하겠다.
        inflater.inflate(R.layout.sub1, container, true); //layout sub1,을 container가지고 있는 xml영역에 넣어달라, 메모리에 올리고 바로 container 변수에 붙여줘

        Toast.makeText(this, "부분화면이 추가되었습니다.", Toast.LENGTH_LONG).show();
    }
}