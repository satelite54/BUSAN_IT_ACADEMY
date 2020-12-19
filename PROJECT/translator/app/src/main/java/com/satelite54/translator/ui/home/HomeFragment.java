package com.satelite54.translator.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

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
import com.satelite54.translator.ui.Ctranslator;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Disposable backgroundtask;
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        final EditText Korean = getView().findViewById(R.id.editTextTextMultiLine);
        // fragment에서 뷰의 아이디를 얻는 방법
        Button translator = getView().findViewById(R.id.button);
        translator.setOnClickListener(new View.OnClickListener() {
         // 버튼 리스너를 만듬.. 뭐이리 기냐 코드가
         // 간단하게 하는 방법 없나..
        // 일단 테스트니까 빠르게 만들자.
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View V) {
                String clientId = "oZqswaDIvHfIzdNNpKIY";//애플리케이션 클라이언트 아이디값";
                String clientSecret = "5mHRY_NuV4";//애플리케이션 클라이언트 시크릿값";

                String apiURL = "https://openapi.naver.com/v1/papago/n2mt";
                String text;
                try {
                    text = URLEncoder.encode(Korean.getText().toString(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException("인코딩 실패", e);
                }

                Map<String, String> requestHeaders = new HashMap<>();
                requestHeaders.put("X-Naver-Client-Id", clientId);
                requestHeaders.put("X-Naver-Client-Secret", clientSecret);

                String[] tempstrAry = new String[1];
                String responseBody = tempstrAry[0];

                BackgroundTask(apiURL, requestHeaders, text, responseBody);
//                Ctranslator trslt = new Ctranslator();
//                trslt.post(apiURL, requestHeaders, text);


//                result.setText(responseBody);

            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    void BackgroundTask(String apiURL, Map<String, String> requestHeaders, String text, String responseBody) {
//onPreExecute
        final String[] tempstr = {responseBody};
        backgroundtask = Observable.fromCallable(() -> {
//doInBackground
            Ctranslator trslt = new Ctranslator();
            tempstr[0] = trslt.post(apiURL, requestHeaders, text);

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