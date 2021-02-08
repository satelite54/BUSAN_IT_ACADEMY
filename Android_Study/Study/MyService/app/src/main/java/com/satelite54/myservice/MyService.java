package com.satelite54.myservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    private static final  String TAG = "MyService";
    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG, "onCreate 호출됨");
   }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy 호출됨");
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand 호출됨");
        //인텐트는 널체크 해주는게 좋다.
        if(intent != null) {
            processCommand(intent);
        }
        return super.onStartCommand(intent, flags, startId);
    }

    public void processCommand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(TAG, "command : " + command + ", name : " + name);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class);
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | //화면이 없는 상태에서 화면을 만들려면 테스크라는 것을 사용해야함
                Intent.FLAG_ACTIVITY_SINGLE_TOP |//
                Intent.FLAG_ACTIVITY_CLEAR_TOP); // 여러개 쌓여 있으면 그 위에꺼 없에 줘라
        showIntent.putExtra("command", "show");
        showIntent.putExtra("name", name + " from Service");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
