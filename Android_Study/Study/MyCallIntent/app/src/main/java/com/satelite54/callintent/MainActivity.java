package com.satelite54.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-3484-5022"));
                startActivity(intent);
                //Intent는 엑티비티가 엑티비티 스택에 쌓일 때 옵션을 지정해줄 수 있다. flag를 사용해서
/*                Intent intent = new Intent();
                ComponentName name = new ComponentName("com.satelite54.callintent", "com.satelite54.callintent.MenuActivity"); //문자열을 이용해서 엑티비티를 호출할 수 있다.
                intent.setComponent(name);
                startActivityForResult(intent, 101);*/
            }
        });
    }
}