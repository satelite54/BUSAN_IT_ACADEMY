package com.satelite54.doit_09;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment1 fragment1 = new Fragment1();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();
    }
}