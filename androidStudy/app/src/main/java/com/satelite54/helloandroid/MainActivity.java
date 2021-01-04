package com.satelite54.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        ;
    }

    public void onButton1Clicked(View V) { // 사용자 버튼 클릭 메소드
        Toast.makeText(this, "확인1 버튼이 눌렸어요!", Toast.LENGTH_LONG).show();
    }
    public void onButton2Clicked(View V) { // 사용자 버튼 클릭 메소드
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(intent);
    }
    public void onButton3Clicked(View V) { // 사용자 버튼 클릭 메소드
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-3484-5022"));
        startActivity(intent);
    }
}