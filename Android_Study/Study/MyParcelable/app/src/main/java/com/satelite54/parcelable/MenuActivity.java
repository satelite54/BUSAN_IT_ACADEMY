package com.satelite54.parcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent intent = getIntent();
        processIntent(getIntent());
    }

    public  void processIntent(Intent intent) {
        if(intent != null) {
            Bundle bundle = intent.getExtras(); // 인텐트에서 부가데이터를 얻어서 번들에 저장 //인텐트는 데이터를 전달하는 객체 // 번들은 데이터를 받아서 저장하는 객체
            SimpleData data = bundle.getParcelable("data"); //번들에서 제너릭을 가져오면서 자동으로 생성자가 호출되는듯하다?
            if(data != null) {
                Toast.makeText(this, "전달받은 객체 : " + data.code + ", " + data.message, Toast.LENGTH_LONG).show();
            }
        }
    }
}