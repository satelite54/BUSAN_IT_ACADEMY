package com.satelite54.intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent는 애플리케이션 구성요소간의 데이터 전달을 담당함. 아주 중요한 객체이다.
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class); //컨텍스트는 버튼이면 버튼이 포함되어있는 그 주변정보를 가지고 있는것을 컨택스트라고 한다.
                // MenuActivity 클래스를 지정
                //startActivity();
                startActivityForResult(intent, 101);
            }
        });
    }

    @Override //onActivityResult는 다른 엑티비티에서 현재 엑티비티로 넘어왔을 때 바로 호출
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { //requestCode는 엑티비티를 띄울때 쓴 코드가 그대로 온다.
        // resultCode는 다른 엑티비티에서 써준 코드가 날아온다.
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 101) {
            if(data != null) { // 인텐트는 보통 널 체크 하는게 좋다.
                String name = data.getStringExtra("name");
                if(name != null) {
                    Toast.makeText(this, "응답으로 받은데이터" + name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}