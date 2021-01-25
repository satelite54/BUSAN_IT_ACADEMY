package com.satelite54.fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback { // 메인 액티비티에서 인터페이스 구현

    ListFragment listFragment;
    ViewerFragment viewerFragment;

    int[] images = {R.drawable.inje, R.drawable.ic_launcher, R.drawable.ic_launcher_foreground}; // 이미지들의 id 값 지정

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manger = getSupportFragmentManager();
        listFragment =(ListFragment) manger.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manger.findFragmentById(R.id.viewerFragment);
    }

    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}