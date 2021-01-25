package com.satelite54.fargment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    // 프레그먼트 생명주기
    // onAttach() → onCreate() → onCreateView() → onActivityCreated() → onStart → onResume() 프레그먼트 활성화
            // Back stack에서 복구 시  ↑
    // onPause() → onStop → onDestoryView() → onDestroy() → onDetach() 액티비티에서 프레그먼트 제거

    MainFragment mainFragment;
    MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.mainFragment);
        menuFragment = new MenuFragment();
    }

    public void onFragmentChanged(int index) {
        if(index == 0) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, mainFragment).commit(); // 트렌젝션은 여러개의 명령을 한꺼번에 할 수 있는 사용방법?
        } else if(index == 1) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, menuFragment).commit();
        }
    }
}