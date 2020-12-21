package com.satelite54.translator.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.satelite54.translator.CSingleton;
import com.satelite54.translator.R;
import com.satelite54.translator.RegisterActivity;
import com.satelite54.translator.ui.Ctranslator;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Disposable backgroundtask;
    private static String clientId = "oZqswaDIvHfIzdNNpKIY"; // 애플리케이션 클라이언트 id 값
    private static String clientSecret = "5mHRY_NuV4"; // 애플리케이션 클라이언트 secret 넘버
    private static String apiURL = "https://openapi.naver.com/v1/papago/n2mt"; // 파파고 API 호출 주소
    public  static String DBsqlRerult = "";

    // RxJava를 사용하기 위해 추가
    //https://dev-daddy.tistory.com/26 참고자료    //https://blog.yena.io/studynote/2020/10/11/Android-RxJava(1).html
//    RxAndroid의 스케줄러
//    스케쥴러	설명
//    newThread()	새로운 스레드 생성
//    single()	단일 스레드 생성 후 사용
//    computation()	계산용 스레드
//    io()	네트워크, 파일 입출력 스레드
//    trampoline()	현제 스레드에 대기행렬 생성
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Spinner spinner = getView().findViewById(R.id.spinner2);
        EditText Korean = getView().findViewById(R.id.editTextTextMultiLine);
        EditText result = getView().findViewById(R.id.editTextTextMultiLine2);
        ArrayList<String> AryList = new ArrayList<>();
        AryList.add("한국어 -> 영어");
        AryList.add("한국어 -> 중국어 간체");
        AryList.add("한국어 -> 중국어 번체");
        AryList.add("한국어 -> 스페인어");
        AryList.add("한국어 -> 프랑스어");
        AryList.add("한국어 -> 베트남어");
        AryList.add("한국어 -> 태국어");
        AryList.add("한국어 -> 인도네시아어");
        AryList.add("영어 -> 일본어");
        AryList.add("영어 -> 프랑스어");

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_spinner_dropdown_item,AryList);
        spinner.setAdapter(arrayAdapter);

        // fragment에서 뷰의 아이디를 얻는 방법
        Button translator = getView().findViewById(R.id.button);

        translator.setOnClickListener(ViewOnClickListener -> {
               String text;
               try {
                   if(Korean.getText().toString().equals("")) {
                       Toast.makeText(getActivity(), "번역내용을 입력해주세요.", Toast.LENGTH_LONG).show();
                       return;
                   }
                   text = URLEncoder.encode(Korean.getText().toString(), "UTF-8");
               } catch (UnsupportedEncodingException e) {
                   throw new RuntimeException("인코딩 실패", e);
               }

               Map<String, String> requestHeaders = new HashMap<>();
               requestHeaders.put("X-Naver-Client-Id", clientId);
               requestHeaders.put("X-Naver-Client-Secret", clientSecret);

               String[] tempstrAry = new String[1];
               String responseBody = tempstrAry[0];

               BackgroundTask(apiURL, requestHeaders, text, responseBody, spinner.getSelectedItemPosition());
//                Ctranslator trslt = new Ctranslator();
//                trslt.post(apiURL, requestHeaders, text);


//                result.setText(responseBody);

           });

        Button DBSave = getView().findViewById(R.id.button2);

        DBSave.setOnClickListener(ViewOnClickListener -> {
            try {

                String target = result.getText().toString();
                String Korea = Korean.getText().toString();


                RegisterActivity task = new RegisterActivity();
                DBsqlRerult = task.execute(Korea, target).get();
            } catch (Exception e) {
                Log.i("DBtest", ".....ERROR.....!");
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void BackgroundTask(String apiURL, Map<String, String> requestHeaders, String text, String responseBody, int translatoritem) {
//onPreExecute
        final String[] tempstr = {responseBody};
        backgroundtask = Observable.fromCallable(() -> {
//doInBackground
            Ctranslator trslt = new Ctranslator();
            Spinner spinner = getView().findViewById(R.id.spinner2);
            tempstr[0] = trslt.post(apiURL, requestHeaders, text, translatoritem);

            String str = tempstr[0];//여기까지 변역 내용이 들어 온것 까지 확인했다!!!!

            String resultjson = str.toString();
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(resultjson);
            String resultstrin = element.getAsJsonObject().get("message").getAsJsonObject().get("result").getAsJsonObject()
                    .getAsJsonObject().get("translatedText").getAsString();
            CSingleton cSingleton = CSingleton.getInstance();
            cSingleton.setText(resultstrin);
            return false;
        })
                .subscribeOn(Schedulers.io()) // ObserVable은 IO 스레드에서 동작할 것이다.
                .observeOn(AndroidSchedulers.mainThread()) // Observer는 메인스레드에서 동작
                .subscribe((resulto) -> {
//onPostExecute
                    final EditText result = getView().findViewById(R.id.editTextTextMultiLine2);
                    CSingleton cSingleton = CSingleton.getInstance();
                    result.setText(cSingleton.getText());
                    backgroundtask.dispose();
                });
    }
}